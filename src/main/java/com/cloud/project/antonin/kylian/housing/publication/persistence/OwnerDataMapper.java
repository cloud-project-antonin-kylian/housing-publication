package com.cloud.project.antonin.kylian.housing.publication.persistence;

public class OwnerDataMapper {
    private Long ownerId;

    private String name;

    public OwnerDataMapper(Long ownerId, String name) {
        this.ownerId = ownerId;
        this.name = name;
    }

    public OwnerDataMapper() {
    }

    public void setId(Long ownerId) {
        this.ownerId = ownerId;
    }

    public Long getId() {
        return ownerId;
    }

    public String getName() {
        return name;
    }
}
