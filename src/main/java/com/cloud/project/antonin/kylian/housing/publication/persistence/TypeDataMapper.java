package com.cloud.project.antonin.kylian.housing.publication.persistence;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "Types")
public class TypeDataMapper {
    @Id
    @GeneratedValue
    private Long typeId;

    private String name;

    public TypeDataMapper(Long typeId, String name) {
        this.typeId = typeId;
        this.name = name;
    }

    public TypeDataMapper() {
    }

    public void setId(Long typeId) {
        this.typeId = typeId;
    }

    public Long getId() {
        return typeId;
    }

    public String getName() {
        return name;
    }
}
