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

