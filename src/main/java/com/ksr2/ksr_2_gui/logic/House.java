package com.ksr2.ksr_2_gui.logic;

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
        if (name.equals("PRICE")) {
            return this.price;
        } else if (name.equals("LAND_AREA")) {
            return this.landArea;
        } else if (name.equals("FLOOR_AREA")) {
            return this.floorArea;
        } else if (name.equals("BUILD_YEAR")) {
            return this.buildYear;
        } else if (name.equals("CBD_DIST")) {
            return this.cbdDistance;
        } else if (name.equals("NEAREST_STN_DIST")) {
            return this.nearestStdDistance;
        } else if (name.equals("DATE_SOLD")) {
            return this.lastSoldTime;
        } else if (name.equals("LATITUDE")) {
            return this.latitude;
        } else if (name.equals("LONGITUDE")) {
            return this.longitude;
        } else if (name.equals("NEAREST_SCH_DIST")) {
            return this.neatestSchoolDistance;
        } else {
            return 0;
        }
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
