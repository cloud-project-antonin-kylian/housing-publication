package com.cloud.project.antonin.kylian.housing.publication.persistence;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface JpaHousingRepository extends JpaRepository<HousingDataMapper, Long> {
    @Query(value = "select h from HousingDataMapper h where h.status = :status")
    List<HousingDataMapper> getByStatus(final String status);
}

