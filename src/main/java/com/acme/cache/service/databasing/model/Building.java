package com.acme.cache.service.databasing.model;


import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "BUILDINGS")
public class Building {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "BUILDING_TYPE")
    @Enumerated(EnumType.STRING)
    private BuildingType buildingType;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private Address address;

    public Building() {
    }

    public Building(BuildingType buildingType, Address address) {
        this.buildingType = buildingType;
        this.address = address;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public BuildingType getBuildingType() {
        return buildingType;
    }

    public void setBuildingType(BuildingType buildingType) {
        this.buildingType = buildingType;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Building building = (Building) o;
        return id == building.id &&
                buildingType == building.buildingType &&
                Objects.equals(address, building.address);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, buildingType, address);
    }

    @Override
    public String toString() {
        return "Building{" +
                "id=" + id +
                ", buildingType=" + buildingType +
                ", address=" + address +
                '}';
    }
}
