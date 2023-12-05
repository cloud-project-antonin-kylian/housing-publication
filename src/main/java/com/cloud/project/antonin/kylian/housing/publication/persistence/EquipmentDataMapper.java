package com.cloud.project.antonin.kylian.housing.publication.persistence;

public class EquipmentDataMapper {
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
