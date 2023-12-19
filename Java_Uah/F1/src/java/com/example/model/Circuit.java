/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.model;

public class Circuit {
    private String name;
    private String city;
    private String country;
    private int laps;
    private int lapLength;
    private int curves;

    public Circuit(String name, String city, String country, int laps, int lapLength, int curves) {
        this.name = name;
        this.city = city;
        this.country = country;
        setLaps(laps);
        setLapLength(lapLength);
        setCurves(curves);
    }

    // getters and setters

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public int getLaps() {
        return laps;
    }

    public void setLaps(int laps) {
        if (laps >= 40 && laps <= 80) {
            this.laps = laps;
        } else {
            throw new IllegalArgumentException("Number of laps must be between 40 and 80.");
        }
    }

    public int getLapLength() {
        return lapLength;
    }

    public void setLapLength(int lapLength) {
        if (lapLength >= 3000 && lapLength <= 9000) {
            this.lapLength = lapLength;
        } else {
            throw new IllegalArgumentException("Lap length must be between 3000 and 9000 meters.");
        }
    }

    public int getCurves() {
        return curves;
    }

    public void setCurves(int curves) {

        if (curves >= 6 && curves <= 20) {
            this.curves = curves;
        } else {
            throw new IllegalArgumentException("Number of curves must be between 6 and 20.");
        }
    }
}
