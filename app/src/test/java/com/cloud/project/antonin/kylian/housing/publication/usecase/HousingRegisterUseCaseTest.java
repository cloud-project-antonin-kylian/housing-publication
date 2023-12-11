package com.cloud.project.antonin.kylian.housing.publication.usecase;

import com.cloud.project.antonin.kylian.housing.publication.entity.*;
import com.cloud.project.antonin.kylian.housing.publication.model.*;
import com.cloud.project.antonin.kylian.housing.publication.persistence.HousingRegisterDbGateway;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.test.util.ReflectionTestUtils;

import java.util.HashSet;
import java.util.List;

import static org.mockito.Mockito.*;

public class HousingRegisterUseCaseTest {
    private static HousingRegisterUseCase housingRegisterUseCase;

    @Mock
    private static HousingFactory housingFactory;

    @Mock
    private static HousingRegisterDbGateway housingDbGateway;

    @BeforeAll
    public static void init() {
        housingRegisterUseCase = new HousingRegisterUseCase();
        housingFactory = mock(CommonHousingFactory.class);
        housingDbGateway = mock(HousingRegisterDbGateway.class);

        ReflectionTestUtils.setField(housingRegisterUseCase, "housingFactory", housingFactory);
        ReflectionTestUtils.setField(housingRegisterUseCase, "housingDbGateway", housingDbGateway);
    }

    @Test
    void executeShouldSaveHousingAndReturnIt() {
        when(housingFactory.create(eq(1L), anyString(), anyString(), eq(100), eq(50), eq(2), any(), any(), any(), any(), anyString())).thenReturn(new CommonHousing(
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

        final HousingRegisterRequestModel req = new HousingRegisterRequestModel(1L,
                "title",
                "description",
                100,
                50,
                2,
                new City(1L, "city", new Area(1L, "area")),
                new Type(1L, "type"),
                new Owner(1L, "owner"),
                new HashSet<>(List.of(new Equipment(1L, "equipment 1"))));

        final HousingResponseModel expectedResp = new HousingResponseModel(1L,
                "title",
                "description",
                100,
                50,
                2,
                new City(1L, "city", new Area(1L, "area")),
                new Type(1L, "type"),
                new Owner(1L, "owner"),
                new HashSet<>(List.of(new Equipment(1L, "equipment 1"))),
                "WAITING");

        final HousingResponseModel actualResp = housingRegisterUseCase.execute(req);

        verify(housingDbGateway, times(1)).save(any());
        Assertions.assertEquals(expectedResp, actualResp);
    }
}
