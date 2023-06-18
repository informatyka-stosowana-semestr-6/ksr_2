package com.ksr2.ksr_2_gui.logic;

import java.util.NoSuchElementException;

public class House {
    // Keys
    private String address;
    private String suburb;
    // Values
    private double price;
    private double landArea;
    private double floorArea;
    private double buildYear;
    private double cbdDistance;
    private double nearestStdDistance;
    private double lastSoldTime;
    private double latitude;
    private double longitude;
    private double neatestSchoolDistance;
///////////////////////////////////
//      DB COLUMNS
///////////////////////////////////
//      ADDRESS TEXT PRIMARY KEY,
//      SUBURB TEXT,
//      PRICE REAL,
//      LAND_AREA REAL,
//      FLOOR_AREA REAL,
//      BUILD_YEAR REAL,
//      CBD_DIST REAL,
//      NEAREST_STN_DIST REAL,
//      DATE_SOLD REAL,
//      LATITUDE REAL,
//      LONGITUDE REAL,
//      NEAREST_SCH_DIST REAL

    public House(String address, String suburb, double price, double landArea, double floorArea, double buildYear,
                 double cbdDistance, double nearestStdDistance, double lastSoldTime, double latitude, double longitude,
                 double neatestSchoolDistance) {
        this.address = address;
        this.suburb = suburb;
        this.price = price;
        this.landArea = landArea;
        this.floorArea = floorArea;
        this.buildYear = buildYear;
        this.cbdDistance = cbdDistance;
        this.nearestStdDistance = nearestStdDistance;
        this.lastSoldTime = lastSoldTime;
        this.latitude = latitude;
        this.longitude = longitude;
        this.neatestSchoolDistance = neatestSchoolDistance;
    }

    public double getByName(String name) {
        return switch (name) {
            case "PRICE" -> this.price;
            case "LAND_AREA" -> this.landArea;
            case "FLOOR_AREA" -> this.floorArea;
            case "BUILD_YEAR" -> this.buildYear;
            case "CBD_DIST" -> this.cbdDistance;
            case "NEAREST_STN_DIST" -> this.nearestStdDistance;
            case "DATE_SOLD" -> this.lastSoldTime;
            case "LATITUDE" -> this.latitude;
            case "LONGITUDE" -> this.longitude;
            case "NEAREST_SCH_DIST" -> this.neatestSchoolDistance;
            default -> throw new NoSuchElementException("There is no name: " + name);
        };
    }

    /////////////////////////////////
    // Getters & Setters
    /////////////////////////////////

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getSuburb() {
        return suburb;
    }

    public void setSuburb(String suburb) {
        this.suburb = suburb;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public double getLandArea() {
        return landArea;
    }

    public void setLandArea(double landArea) {
        this.landArea = landArea;
    }

    public double getFloorArea() {
        return floorArea;
    }

    public void setFloorArea(double floorArea) {
        this.floorArea = floorArea;
    }

    public double getBuildYear() {
        return buildYear;
    }

    public void setBuildYear(double buildYear) {
        this.buildYear = buildYear;
    }

    public double getCbdDistance() {
        return cbdDistance;
    }

    public void setCbdDistance(double cbdDistance) {
        this.cbdDistance = cbdDistance;
    }

    public double getNearestStdDistance() {
        return nearestStdDistance;
    }

    public void setNearestStdDistance(double nearestStdDistance) {
        this.nearestStdDistance = nearestStdDistance;
    }

    public double getLastSoldTime() {
        return lastSoldTime;
    }

    public void setLastSoldTime(double lastSoldTime) {
        this.lastSoldTime = lastSoldTime;
    }

    public double getLatitude() {
        return latitude;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    public double getLongitude() {
        return longitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }

    public double getNeatestSchoolDistance() {
        return neatestSchoolDistance;
    }

    public void setNeatestSchoolDistance(double neatestSchoolDistance) {
        this.neatestSchoolDistance = neatestSchoolDistance;
    }
}
