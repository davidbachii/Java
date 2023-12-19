package com.example.servlet;

import com.example.model.Car;
import com.example.model.DatabaseManager;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/CreateCarServlet")
public class CreateCarServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String name = request.getParameter("name");
        int powerPerCurve = Integer.parseInt(request.getParameter("powerPerCurve"));

        Car car = new Car(name, powerPerCurve);

        try {
            // Guardar el coche en la base de datos
            DatabaseManager.saveCar(car);
            response.sendRedirect("index.jsp"); // Redirigir a la página principal
        } catch (Exception e) {
            e.printStackTrace();
            response.getWriter().println("Error al crear el coche.");
        }
    }
}
