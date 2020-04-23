package com.Catalog;

import java.io.Serializable;

public class Car extends Vehicle implements Serializable
{

    private String type;
    public String getType() {
        return type;
    }
    public void setType(String type) {
        this.type = type;
    }

    public Car(int eId, String plate, String model, String color, String vType, String type) {
        super(eId, plate, model, color, vType);
        this.type = type;
    }
}
