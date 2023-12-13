package com.cloud.project.antonin.kylian.housing.publication.persistence;

import java.util.Set;

public class HousingDataMapper {
    private Long housingId;

    private String title;

    private String description;

    private int price;

    private int size;

    private int nbBedrooms;

    private CityDataMapper city;

    private TypeDataMapper type;

    private OwnerDataMapper owner;

    private Set<EquipmentDataMapper> equipments;

    private String status;

    public HousingDataMapper(final Long housingId,
                             final String title,
                             final String description,
                             final int price,
                             final int size,
                             final int nbBedrooms,
                             final CityDataMapper city,
                             final TypeDataMapper type,
                             final OwnerDataMapper owner,
                             final Set<EquipmentDataMapper> equipments,
                             final String status) {
        this.housingId = housingId;
        this.title = title;
        this.description = description;
        this.price = price;
        this.size = size;
        this.nbBedrooms = nbBedrooms;
        this.city = city;
        this.type = type;
        this.owner = owner;
        this.equipments = equipments;
        this.status = status;
    }

    public HousingDataMapper() {}

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public int getPrice() {
        return price;
    }

    public String getStatus() {
        return status;
    }

    public Long getId() {
        return housingId;
    }

    public int getSize() {
        return size;
    }

    public int getNbBedrooms() {
        return nbBedrooms;
    }

    public CityDataMapper getCity() {
        return city;
    }

    public TypeDataMapper getType() {
        return type;
    }

    public OwnerDataMapper getOwner() {
        return owner;
    }

    public Set<EquipmentDataMapper> getEquipments() {
        return equipments;
    }

    public void setStatus(final String newStatus) {
        this.status = newStatus;
    }
}
