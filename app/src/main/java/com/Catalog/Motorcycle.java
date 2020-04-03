package com.Catalog;

public class Motorcycle extends Vehicle
{
    private String sideCar;

    public Motorcycle(int eId, String plate, int model, String color, String vType, String sideCar) {
        super(eId, plate, model, color, vType);
        this.sideCar = sideCar;
    }

    public String getSideCar() {
        return sideCar;
    }
    public void setSideCar(String sideCar) {
        this.sideCar = sideCar;
    }
}
