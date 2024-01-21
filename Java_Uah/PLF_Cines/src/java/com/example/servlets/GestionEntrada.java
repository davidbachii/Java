/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package com.example.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import com.example.model.DatabaseManager;
import com.example.model.Entrada;
import com.example.model.Fecha;
import com.example.model.Pelicula;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.sql.Time;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author david
 */
@WebServlet("/GestionEntrada")
public class GestionEntrada extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Obtén el parámetro de acción desde el formulario
        String accion = request.getParameter("accion");

        // Realiza diferentes acciones según el valor de 'accion'
        if ("crear".equals(accion)) {
            // Obtén los parámetros del formulario de registro
            String idEntrada = request.getParameter("idEntrada");
            // Parsea la fecha y la hora desde los parámetros del formulario
            String fechaStr = request.getParameter("fecha");
            System.out.println("");
            LocalTime hora = LocalTime.parse(request.getParameter("hora"));
            int fila = Integer.parseInt(request.getParameter("fila"));
            int columna = Integer.parseInt(request.getParameter("columna"));
            String nombreSala = request.getParameter("nombreSala");

            try {

                Fecha fecha = new Fecha(fechaStr);
                Entrada entrada = new Entrada(idEntrada, fecha, hora, fila, columna, nombreSala);
                System.out.println(entrada.toString());

                // Guardar la entrada en la base de datos
                DatabaseManager.getInstance().guardarEntrada(entrada);
                response.sendRedirect("gestionEntradas.jsp"); // Redirigir a la página principal
            } catch (SQLException e) {
                response.getWriter().println("Error al crear la entrada en el servlet.");
            }

        } else if ("borrar".equals(accion)) {
            // Obten el ID de la entrada a borrar desde la solicitud
            String idEntradaABorrar = request.getParameter("entradaABorrar");

            try {
                // Obtén la entrada por su ID
                Entrada entrada = DatabaseManager.getEntradaPorId(idEntradaABorrar);

                if (entrada != null) {
                    // Borra la entrada de la base de datos
                    DatabaseManager.getInstance().borrarEntrada(entrada);
                    response.sendRedirect("gestionEntradas.jsp"); // Redirigir a la página principal
                    System.out.println("Entrada borrada con éxito");
                } else {
                    response.getWriter().println("No se encontró la entrada a borrar.");
                }
            } catch (SQLException e) {
                e.printStackTrace();
                response.getWriter().println("Error al borrar la entrada.");
            }

        } else if ("modificar".equals(accion)) {
            // Obtén el ID de la entrada a modificar desde la solicitud
            String idEntradaAModificar = request.getParameter("entradaAModificar");

            try {
                // Obtén la entrada por su ID
                Entrada entrada = DatabaseManager.getEntradaPorId(idEntradaAModificar);

                if (entrada != null) {
                    // Modifica la entrada con los nuevos valores
                    entrada.setIdEntrada(request.getParameter("nuevoIdEntrada"));
                    // Parsea la nueva fecha y hora desde los parámetros del formulario
                    String nuevaFechaStr = request.getParameter("nuevaFecha");
                    Fecha fecha = new Fecha(nuevaFechaStr);
                    entrada.setFecha(fecha);
                    LocalTime nuevaHora = LocalTime.parse(request.getParameter("nuevaHora"));
                    entrada.setHora(nuevaHora);
                    entrada.setFila(Integer.parseInt(request.getParameter("nuevaFila")));
                    entrada.setColumna(Integer.parseInt(request.getParameter("nuevaColumna")));
                    entrada.setNombreSala(request.getParameter("nuevaNombreSala"));

                    // Guarda la entrada modificada en la base de datos
                    DatabaseManager.modificarEntrada(idEntradaAModificar, entrada);

                    response.sendRedirect("gestionEntradas.jsp");

                } else {
                    response.getWriter().println("No se encontró la entrada a modificar.");
                }
            } catch (SQLException e) {
                e.printStackTrace();
                response.getWriter().println("Error al modificar la entrada.");
            }
        } else if ("Consultar".equals(accion)) {

            String idEntradaAConsultar = request.getParameter("idEntradaAConsultar");

            try {
                // Obtén la entrada por su ID
                Entrada entrada = DatabaseManager.getEntradaPorId(idEntradaAConsultar);

                if (entrada != null) {
                    // Setea los atributos de la entrada en el request para que puedan ser accesibles en el JSP
                    request.setAttribute("idEntradaConsultar", entrada.getIdEntrada());
                    LocalDate localDate = entrada.getFecha().toLocalDate();
                    request.setAttribute("fechaConsultar", localDate);
                    request.setAttribute("horaConsultar", entrada.getHora());
                    request.setAttribute("filaConsultar", entrada.getFila());
                    request.setAttribute("columnaConsultar", entrada.getColumna());
                    request.setAttribute("nombreSalaAconsultar", entrada.getNombreSala());

                    // Redirige a la página del formulario con los campos ya populados
                    request.getRequestDispatcher("gestionEntradas.jsp").forward(request, response);
                } else {
                    response.getWriter().println("No se encontró la entrada a Consultar.");
                }
            } catch (SQLException e) {
                e.printStackTrace();
                response.getWriter().println("Error al consultar la entrada.");
            }

        } else {
            response.getWriter().println("Acción no reconocida");
        }
    }
}
