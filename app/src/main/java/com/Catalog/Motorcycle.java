package com.Catalog;

public class Motorcycle extends Vehicle
{
    private String sideCar;

    public Motorcycle(int eId,String sideCar,String vType, String model, String plate, String color) {
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
