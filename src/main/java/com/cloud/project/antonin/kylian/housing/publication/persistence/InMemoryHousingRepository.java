package com.cloud.project.antonin.kylian.housing.publication.persistence;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Repository;

@Repository
public class InMemoryHousingRepository {
    private List<HousingDataMapper> housings = new ArrayList<>();

    public List<HousingDataMapper> getByStatus(final String status) {
        return housings.stream().filter(housing -> housing.getStatus().equals(status)).toList();
    }

    public Optional<HousingDataMapper> findById(final Long id) {
        return housings.stream().filter(housing -> housing.getId().equals(id)).findFirst();
    }

    public HousingDataMapper save(final HousingDataMapper housingDataMapper) {
        housings.add(housingDataMapper);
        return housingDataMapper;
    }
}
