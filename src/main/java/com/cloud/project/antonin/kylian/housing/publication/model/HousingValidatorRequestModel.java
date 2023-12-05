package com.cloud.project.antonin.kylian.housing.publication.model;

import com.cloud.project.antonin.kylian.housing.publication.entity.City;
import com.cloud.project.antonin.kylian.housing.publication.entity.Equipment;
import com.cloud.project.antonin.kylian.housing.publication.entity.Owner;
import com.cloud.project.antonin.kylian.housing.publication.entity.Type;

import java.util.Set;

public record HousingValidatorRequestModel(
        Long id,
        String title,
        String description,
        int price,
        int size,
        int nbBedrooms,
        City city,
        Type type,
        Owner owner,
        Set<Equipment> equipments,
        String status
) {}
