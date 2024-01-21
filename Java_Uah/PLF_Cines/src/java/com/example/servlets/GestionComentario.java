/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package com.example.servlets;

import com.example.model.Comentario;
import com.example.model.DatabaseManager;
import com.example.model.Fecha;
import com.example.model.Pelicula;
import com.example.model.Reserva;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author david
 */
@WebServlet("/GestionComentarios")
public class GestionComentario extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String accion = request.getParameter("accion");

        if ("escribirComentario".equals(accion)) {
            guardarComentario(request, response);
        } else {
            response.getWriter().println("Acción no reconocida");
        }
    }

    private void guardarComentario(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        // Obtén los parámetros del formulario de comentarios
        String texto = request.getParameter("textoComentario");
        System.out.println(texto);
        int valoracion = Integer.parseInt(request.getParameter("valoracionComentario"));
        System.out.println(valoracion);
        String fechaNacimiento = request.getParameter("fecha");
        Fecha fecha = new Fecha(fechaNacimiento);
        System.out.println(fecha);
        String emailUsuario = request.getParameter("emailDelUsuario");
        System.out.println(emailUsuario);
        String nombrePelicula = request.getParameter("nombrePelicula");
        System.out.println(nombrePelicula);

        try {
            Comentario comentario = new Comentario(texto, valoracion, fecha, emailUsuario, nombrePelicula);
            DatabaseManager.getInstance().guardarComentario(comentario);
            response.sendRedirect("indexDetallado.jsp?id=" + nombrePelicula);
        } catch (SQLException e) {
            e.printStackTrace();
            response.getWriter().println("Error al guardar el comentario en el servlet.");
        }
    }
    
    /*

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String nombrePelicula = request.getParameter("id");
        System.out.println("Nombre de la película: " + nombrePelicula);

        try {
            Pelicula pelicula = DatabaseManager.getPeliculaPorNombre(nombrePelicula);
            System.out.println("Película obtenida: " + pelicula);

            List<Comentario> comentarios = DatabaseManager.getComentariosPorNombrePelicula(nombrePelicula);
            System.out.println("Comentarios obtenidos: " + comentarios);

            request.setAttribute("pelicula", pelicula);
            request.setAttribute("comentarios", comentarios);

            RequestDispatcher dispatcher = request.getRequestDispatcher("indexDetallado.jsp");
            dispatcher.forward(request, response);
        } catch (SQLException e) {
            e.printStackTrace();
            response.getWriter().println("Error al obtener la película o los comentarios en el servlet.");
        }
    }

*/
}
