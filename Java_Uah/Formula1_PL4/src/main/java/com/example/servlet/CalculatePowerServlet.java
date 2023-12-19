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
        String carId = (request.getParameter("carId"));

        try {
            Circuit circuit = DatabaseManager.getCircuitById(circuitId);
            Car car = DatabaseManager.getCarById(carId);

            int totalPower = CalculatePower.calculateTotalPower(circuit, car);

            response.getWriter().println("Total Power for the selected circuit and car: " + totalPower + " kW");
        } catch (Exception e) {
            e.printStackTrace();
            response.getWriter().println("Error al calcular la potencia.");
        }
    }
}
