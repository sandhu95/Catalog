package com.Catalog;

public class Vehicle {
        private int eId;
        private String model;
        private String plate;
        private String color;
        private String vType;
    public String getvType() {
        return vType;
    }

    public void setvType(String vType) {
        this.vType = vType;
    }



    public Vehicle(int eId,String vType, String model,String plate, String color) {
        this.eId = eId;
        this.model=model;
        this.plate=plate;
        this.color=color;
        this.vType=vType;
    }

    public int geteId() {
        return eId;
    }

    public void seteId(int eId) {
        this.eId = eId;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
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


}
