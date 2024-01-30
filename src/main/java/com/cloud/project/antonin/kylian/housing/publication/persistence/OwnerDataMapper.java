package com.cloud.project.antonin.kylian.housing.publication.persistence;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "Owners")
public class OwnerDataMapper {
    @Id
    @GeneratedValue
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
