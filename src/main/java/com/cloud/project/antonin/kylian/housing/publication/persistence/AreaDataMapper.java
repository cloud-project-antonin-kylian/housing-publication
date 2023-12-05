package com.cloud.project.antonin.kylian.housing.publication.persistence;

public class AreaDataMapper {
    private Long areaId;

    private String name;

    public AreaDataMapper(Long areaId, String name) {
        this.areaId = areaId;
        this.name = name;
    }

    public AreaDataMapper() {
    }

    public void setId(Long areaId) {
        this.areaId = areaId;
    }

    public Long getId() {
        return areaId;
    }

    public String getName() {
        return name;
    }
}
