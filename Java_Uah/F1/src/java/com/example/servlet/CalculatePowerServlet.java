/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package com.example.servlet;

import com.example.model.CalculatePower;
import com.example.model.Car;
import com.example.model.Circuit;
import com.example.model.DatabaseManager;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/CalculatePowerServlet")
public class CalculatePowerServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String circuitId = (request.getParameter("circuitId"));
        System.out.println("El circuito sellecionado es: "+circuitId);
        String carId = (request.getParameter("carId"));
        System.out.println("El coche seleccionado es: "+carId);

        try {
            Circuit circuit = DatabaseManager.getCircuitById(circuitId);
            System.out.println("Cheking"+circuit.getName());
            Car car = DatabaseManager.getCarById(carId);
            System.out.println("Cheking"+car.getName());

            int totalPower = CalculatePower.calculateTotalPower(circuit, car);
            System.out.println(totalPower);

            response.getWriter().println("Total Power for the selected circuit and car: " + totalPower + " kW");
        } catch (Exception e) {
            e.printStackTrace();
            response.getWriter().println("Error al calcular la potencia.");
        }
    }
}
