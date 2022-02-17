package com.acme.cache.service.databasing.model;

import java.util.Objects;

public class BuildingFromDB {

    private Long id;
    private BuildingType buildingType;
    private String city;
    private String street;
    private String buildingNumber;

    public BuildingFromDB() {
    }

    public BuildingFromDB(Long id, BuildingType buildingType, String city, String street, String buildingNumber) {
        this.id = id;
        this.buildingType = buildingType;
        this.city = city;
        this.street = street;
        this.buildingNumber = buildingNumber;
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

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getBuildingNumber() {
        return buildingNumber;
    }

    public void setBuildingNumber(String buildingNumber) {
        this.buildingNumber = buildingNumber;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BuildingFromDB that = (BuildingFromDB) o;
        return Objects.equals(id, that.id) &&
                buildingType == that.buildingType &&
                Objects.equals(city, that.city) &&
                Objects.equals(street, that.street) &&
                Objects.equals(buildingNumber, that.buildingNumber);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, buildingType, city, street, buildingNumber);
    }

    @Override
    public String toString() {
        return "BuildingFromDB{" +
                "id=" + id +
                ", buildingType=" + buildingType +
                ", city='" + city + '\'' +
                ", street='" + street + '\'' +
                ", buildingNumber='" + buildingNumber + '\'' +
                '}';
    }
}
