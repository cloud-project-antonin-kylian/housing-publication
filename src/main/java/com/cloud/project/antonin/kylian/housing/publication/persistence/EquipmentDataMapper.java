package com.cloud.project.antonin.kylian.housing.publication.persistence;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "Equipments")
public class EquipmentDataMapper {
    @Id
    @GeneratedValue
    private Long equipmentId;

    private String name;

    public EquipmentDataMapper(Long equipmentId, String name) {
        this.equipmentId = equipmentId;
        this.name = name;
    }

    public EquipmentDataMapper() {
    }

    public void setId(Long equipmentId) {
        this.equipmentId = equipmentId;
    }

    public Long getId() {
        return equipmentId;
    }

    public String getName() {
        return name;
    }
}
