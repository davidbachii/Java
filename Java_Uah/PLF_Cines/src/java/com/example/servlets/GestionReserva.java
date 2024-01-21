/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package com.example.servlets;

import com.example.model.DatabaseManager;
import com.example.model.Reserva;
import com.example.model.Sala;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

/**
 *
 * @author david
 */
@WebServlet("/GestionReserva")
public class GestionReserva extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        // Obtén el parámetro de acción desde el formulario
        String accion = request.getParameter("accion");

        // Realiza diferentes acciones según el valor de 'accion'
        if ("Consultar".equals(accion)) {
            // Obtén los parámetros del formulario de registro
            String nombreReservaAConsultar = request.getParameter("reservaAConsultar");

            try {
                // Obtén la película por su nombre
                Reserva reserva = DatabaseManager.getInstance().getReservaPorNumeroDeRef(nombreReservaAConsultar);

                if (reserva != null) {
                    // Setea los atributos de la sala en el request para que puedan ser accesibles en el JSP
                    request.setAttribute("numeroReferencia", reserva.getNumeroRef());
                    request.setAttribute("emailUser", reserva.getEmail_usuario());
                    request.setAttribute("idEntrada", reserva.getId_entrada());
                    request.setAttribute("fila_entrada", reserva.getFila_entrada());
                    request.setAttribute("columna_entrada", reserva.getColumna_entrada());

                    // Redirige a la página del formulario con los campos ya populados
                    request.getRequestDispatcher("gestionReservas.jsp").forward(request, response);

                } else {
                    response.getWriter().println("No se encontró la reserva a Consultar.");
                }
            } catch (SQLException e) {
                e.printStackTrace();
                response.getWriter().println("Error al modificar la reserva.");
            }
         
        } else {
            response.getWriter().println("Acción no reconocida");
        }

    }

}
