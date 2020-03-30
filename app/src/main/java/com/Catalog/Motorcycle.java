package com.Catalog;

public class Motorcycle extends Vehicle
{
    private String sideCar;
    public Motorcycle(int model, String plate, String color, String sideCar)
    {
        super(model, plate, color);
        this.sideCar = sideCar;
    }
    public String getSideCar() {
        return sideCar;
    }
    public void setSideCar(String sideCar) {
        this.sideCar = sideCar;
    }
}
