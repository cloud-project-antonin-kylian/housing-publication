package com.cloud.project.antonin.kylian.housing.publication.entity;

import java.util.Set;

public record CommonHousing(Long id, String title, String description, int price, int size, int nbBedrooms, City city,
                            Type type, Owner owner, Set<Equipment> equipments, String status) implements Housing {
}
