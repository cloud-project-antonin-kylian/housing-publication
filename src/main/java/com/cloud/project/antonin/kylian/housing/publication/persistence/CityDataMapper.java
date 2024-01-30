package com.cloud.project.antonin.kylian.housing.publication.persistence;

import jakarta.persistence.*;

@Entity
@Table(name = "Cities")
public class CityDataMapper {
    @Id
    @GeneratedValue
    private Long cityId;

    private String name;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "areaId")
    private AreaDataMapper area;

    public CityDataMapper(Long cityId, String name, AreaDataMapper area) {
        this.cityId = cityId;
        this.name = name;
        this.area = area;
    }

    public CityDataMapper() {
    }

    public void setId(Long cityId) {
        this.cityId = cityId;
    }

    public Long getId() {
        return cityId;
    }

    public AreaDataMapper getArea() {
        return area;
    }

    public String getName() {
        return name;
    }
}
