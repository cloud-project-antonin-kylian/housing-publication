package com.cloud.project.antonin.kylian.housing.publication.usecase;

import com.cloud.project.antonin.kylian.housing.publication.entity.*;
import com.cloud.project.antonin.kylian.housing.publication.model.*;
import com.cloud.project.antonin.kylian.housing.publication.persistence.HousingValidatorDbGateway;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.test.util.ReflectionTestUtils;

import java.util.HashSet;
import java.util.List;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

public class HousingValidatorUseCaseTest {
    private static HousingValidatorUseCase housingValidatorUseCase;

    @Mock
    private static HousingFactory housingFactory;

    @Mock
    private static HousingValidatorDbGateway housingDbGateway;

    @BeforeAll
    public static void init() {
        housingValidatorUseCase = new HousingValidatorUseCase();
        housingDbGateway = mock(HousingValidatorDbGateway.class);
        housingFactory = mock(CommonHousingFactory.class);

        ReflectionTestUtils.setField(housingValidatorUseCase, "housingDbGateway", housingDbGateway);
        ReflectionTestUtils.setField(housingValidatorUseCase, "housingFactory", housingFactory);
    }

    @Test
    void executeShouldUpdateStatusAndReturnIt() {
        when(housingFactory.create(
                anyLong(),
                anyString(),
                anyString(),
                anyInt(),
                anyInt(),
                anyInt(),
                any(),
                any(),
                any(),
                any(),
                anyString()
        )).thenReturn(new CommonHousing(
                1L,
                "title",
                "description",
                100,
                50,
                2,
                new City(1L, "city", new Area(1L, "area")),
                new Type(1L, "type"),
                new Owner(1L, "owner"),
                new HashSet<>(List.of(new Equipment(1L, "equipment 1"))),
                "WAITING"
        ));

        when(housingDbGateway.update(
                anyLong(),
                any()
        )).thenReturn(new HousingDbResponseModel(
                1L,
                "title",
                "description",
                100,
                50,
                2,
                new City(1L, "city", new Area(1L, "area")),
                new Type(1L, "type"),
                new Owner(1L, "owner"),
                new HashSet<>(List.of(new Equipment(1L, "equipment 1"))),
                "PUBLISHED"
        ));

        final HousingValidatorRequestModel req = new HousingValidatorRequestModel(
                1L,
                "title",
                "description",
                100,
                50,
                2,
                new City(1L, "city", new Area(1L, "area")),
                new Type(1L, "type"),
                new Owner(1L, "owner"),
                new HashSet<>(List.of(new Equipment(1L, "equipment 1"))),
                "PUBLISHED"
        );
        final HousingResponseModel expectedResp = new HousingResponseModel(
                1L,
                "title",
                "description",
                100,
                50,
                2,
                new City(1L, "city", new Area(1L, "area")),
                new Type(1L, "type"),
                new Owner(1L, "owner"),
                new HashSet<>(List.of(new Equipment(1L, "equipment 1"))),
                "PUBLISHED"
        );
        final HousingResponseModel actualResp = housingValidatorUseCase.execute(1L, req);

        verify(housingDbGateway, times(1)).update(eq(1L), any());
        Assertions.assertEquals(expectedResp, actualResp);
    }
}
