package com.Catalog;

public class Car extends Vehicle
{
    private String type;
    public String getType() {
        return type;
    }
    public void setType(String type) {
        this.type = type;
    }

    public Car(int model, String plate, String color, String type)
    {
        super(model, plate, color);
        this.type = type;

    }
}
