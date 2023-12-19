/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.model;

public class CalculatePower {
    public static int calculateTotalPower(Circuit circuit, Car car) {
        int totalPower = 0;

        try{

            int totalCurves = circuit.getLaps() * circuit.getCurves();
            totalPower = totalCurves * car.getPowerPerCurve();


        }catch(Exception e){
            System.out.println("Error al calcular la potencia");
        }

        return totalPower;

    }
}

