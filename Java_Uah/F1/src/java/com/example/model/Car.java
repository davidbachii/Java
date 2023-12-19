/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.model;

public class Car {
    private String name;
    private int powerPerCurve;

    public Car(String name, int powerPerCurve) {
        this.name = name;
        setPowerPerCurve(powerPerCurve);
    }

    // getters and setters

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPowerPerCurve() {
        return powerPerCurve;
    }

    public void setPowerPerCurve(int powerPerCurve) {
        if (powerPerCurve >= 4 && powerPerCurve <= 10) {
            this.powerPerCurve = powerPerCurve;
        } else {
            throw new IllegalArgumentException("Power per curve must be between 4 and 10 kW.");
        }
    }
}