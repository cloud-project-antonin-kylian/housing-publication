package com.cloud.project.antonin.kylian.housing.publication.persistence;

import com.cloud.project.antonin.kylian.housing.publication.entity.*;
import com.cloud.project.antonin.kylian.housing.publication.model.HousingDbRequestModel;
import com.cloud.project.antonin.kylian.housing.publication.model.HousingDbResponseModel;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.test.util.ReflectionTestUtils;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;

import static org.mockito.Mockito.*;

public class InMemoryHousingTest {
    private static InMemoryHousing inMemoryHousing;

    @Mock
    private static InMemoryHousingRepository inMemoryHousingRepository;

    @BeforeAll
    public static void init() {
        inMemoryHousing = new InMemoryHousing();
        inMemoryHousingRepository = mock(InMemoryHousingRepository.class);

        ReflectionTestUtils.setField(inMemoryHousing, "housingRepository", inMemoryHousingRepository);
    }

    @BeforeEach
    public void resetMocks() {
        reset(inMemoryHousingRepository);
    }

    @Test
    void get() {
        when(inMemoryHousingRepository.getByStatus(anyString())).thenReturn(
                new ArrayList<>(List.of(new HousingDataMapper(
                        1L,
                        "title",
                        "description",
                        100,
                        50,
                        2,
                        new CityDataMapper(1L, "city", new AreaDataMapper(1L, "area")),
                        new TypeDataMapper(1L, "type"),
                        new OwnerDataMapper(1L, "owner"),
                        new HashSet<>(List.of(new EquipmentDataMapper(1L, "equipment 1"))),
                        "STATUS"
                )))
        );

        final HousingDbResponseModel housingDbResponseModel = new HousingDbResponseModel(
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
                "STATUS"
        );
        final List<HousingDbResponseModel> expectedResp = new ArrayList<>(List.of(housingDbResponseModel));

        final List<HousingDbResponseModel> actualResp = inMemoryHousing.get("STATUS");

        verify(inMemoryHousingRepository, times(1)).getByStatus(any());
        Assertions.assertEquals(expectedResp, actualResp);
    }

    @Test
    void saveShouldRegisterInDb() {
        final HousingDbRequestModel housingDbRequestModel = new HousingDbRequestModel(
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
        );

        inMemoryHousing.save(housingDbRequestModel);

        verify(inMemoryHousingRepository, times(1)).save(any());
    }

    @Test
    void updateShouldRegisterInDbAndReturnHousingUpdated() {
        when(inMemoryHousingRepository.findById(anyLong())).thenReturn(
                Optional.of(new HousingDataMapper(
                        1L,
                        "title",
                        "description",
                        100,
                        50,
                        2,
                        new CityDataMapper(1L, "city", new AreaDataMapper(1L, "area")),
                        new TypeDataMapper(1L, "type"),
                        new OwnerDataMapper(1L, "owner"),
                        new HashSet<>(List.of(new EquipmentDataMapper(1L, "equipment 1"))),
                        "WAITING"
                ))
        );

        final HousingDbRequestModel housingDbRequestModel = new HousingDbRequestModel(
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

        HousingDbResponseModel expectedResp = new HousingDbResponseModel(
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

        HousingDbResponseModel actualResp = inMemoryHousing.update(1L, housingDbRequestModel);

        verify(inMemoryHousingRepository, times(1)).save(any());
        Assertions.assertEquals(expectedResp, actualResp);
    }
}
