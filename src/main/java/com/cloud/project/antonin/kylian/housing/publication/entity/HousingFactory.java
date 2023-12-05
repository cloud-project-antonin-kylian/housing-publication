package com.cloud.project.antonin.kylian.housing.publication.entity;

import java.util.Set;

public interface HousingFactory {
    Housing create(final Long id,
                   final String title,
                   final String description,
                   final int price,
                   final int size,
                   final int nbBedrooms,
                   final City city,
                   final Type type,
                   final Owner owner,
                   final Set<Equipment> equipments,
                   final String status);
}
