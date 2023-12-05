package com.cloud.project.antonin.kylian.housing.publication.usecase;

import com.cloud.project.antonin.kylian.housing.publication.entity.*;
import com.cloud.project.antonin.kylian.housing.publication.model.*;
import com.cloud.project.antonin.kylian.housing.publication.persistence.HousingFetcherByStatusDbGateway;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.test.util.ReflectionTestUtils;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.*;

public class HousingFetcherByStatusUseCaseTest {
    private static HousingFetcherByStatusUseCase housingFetcherByStatusUseCase;

    @Mock
    private static HousingFetcherByStatusDbGateway housingDbGateway;

    @BeforeAll
    public static void init() {
        housingFetcherByStatusUseCase = new HousingFetcherByStatusUseCase();
        housingDbGateway = mock(HousingFetcherByStatusDbGateway.class);

        ReflectionTestUtils.setField(housingFetcherByStatusUseCase, "housingDbGateway", housingDbGateway);
    }

    @Test
    void executeShouldUpdateStatusAndReturnIt() {
        final List<HousingDbResponseModel> dbResp = new ArrayList<>();
        dbResp.add(new HousingDbResponseModel(
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
        when(housingDbGateway.get(anyString())).thenReturn(dbResp);

        final List<HousingResponseModel> expectedResp = new ArrayList<>();
        expectedResp.add(new HousingResponseModel(
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
        final List<HousingResponseModel> actualResp = housingFetcherByStatusUseCase.execute("WAITING");

        verify(housingDbGateway, times(1)).get(anyString());
        Assertions.assertEquals(expectedResp, actualResp);
    }
}
