package com.cloud.project.antonin.kylian.housing.publication.entity;

import org.springframework.stereotype.Component;

import java.util.Set;

@Component
public class CommonHousingFactory implements HousingFactory {
    @Override
    public Housing create(final Long id,
                   final String title,
                   final String description,
                   final int price,
                   final int size,
                   final int nbBedrooms,
                   final City city,
                   final Type type,
                   final Owner owner,
                   final Set<Equipment> equipments,
                   final String status) {
        return new CommonHousing(id, title, description, price, size, nbBedrooms, city, type, owner, equipments, status);
    }
}
