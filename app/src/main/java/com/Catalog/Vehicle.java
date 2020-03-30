package com.Catalog;

public class Vehicle {
    private int model;
    private String plate;
    private String color;
    public int getModel() {
        return model;
    }
    public void setModel(int model) {
        this.model = model;
    }
    public String getPlate() {
        return plate;
    }
    public void setPlate(String plate) {
        this.plate = plate;
    }
    public String getColor() {
        return color;
    }
    public void setColor(String color) {
        this.color = color;
    }
    public Vehicle(int model, String plate, String color) {
        super();
        this.model = model;
        this.plate = plate;
        this.color = color;
    }
}
