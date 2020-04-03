package com.Catalog;

public class Motorcycle extends Vehicle
{
    private String sideCar;

    public Motorcycle(int eId, int model, String plate, String color, String sideCar) {
        super(eId, model, plate, color);
        this.sideCar = sideCar;
    }

    public String getSideCar() {
        return sideCar;
    }
    public void setSideCar(String sideCar) {
        this.sideCar = sideCar;
    }
}
