package com.ksr2.ksr_2_gui.logic;
import lombok.Getter;
import lombok.Setter;


@Getter @Setter
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

    public double getByName(String name){
        if (name.equals("PRICE")){
            return this.price;
        }
        else if (name.equals("LAND_AREA")){
            return this.landArea;
        }
        // TODO due to summary
        else {return 0;}
    }
}
