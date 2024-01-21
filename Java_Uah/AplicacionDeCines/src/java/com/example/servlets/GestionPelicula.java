/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package com.example.servlets;

import com.example.model.DatabaseManager;
import com.example.model.Pelicula;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet("/GestionPelicula")
public class GestionPelicula extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {

        // Obtén el parámetro de acción desde el formulario
        String accion = request.getParameter("accion");

        // Realiza diferentes acciones según el valor de 'accion'
        if ("crear".equals(accion)) {
            // Obtén los parámetros del formulario de registro
            String nombre = request.getParameter("nombre");
            String sinopsis = request.getParameter("sinopsis");
            String pagina_oficial = request.getParameter("paginaOficial");
            String titulo_original = request.getParameter("tituloOriginal");

            String genero = request.getParameter("genero");
            String nacionalidad = request.getParameter("nacionalidad");
            int duracion = Integer.parseInt(request.getParameter("duracion"));
            int año = Integer.parseInt(request.getParameter("año"));

            String distribuidora = request.getParameter("distribuidora");
            String director = request.getParameter("director");
            String actores = request.getParameter("actores");
            int clasificacionEdad = Integer.parseInt(request.getParameter("clasificacionEdad"));

            try {

                Pelicula pelicula = new Pelicula(nombre, sinopsis, pagina_oficial, titulo_original, genero, nacionalidad, duracion, año, distribuidora, director, actores, clasificacionEdad);

                // Guardar el usuario en la base de datos
                DatabaseManager.getInstance().guardarPelicula(pelicula);
                response.sendRedirect("gestionPeliculas.jsp"); // Redirigir a la página principal
            } catch (SQLException e) {
                response.getWriter().println("Error al crear la pelicula en el servlet.");
            }

        } else if ("borrar".equals(accion)) {
            // Obten el nombre de la película a borrar desde la solicitud
            String nombrePeliculaABorrar = request.getParameter("peliculaABorrar");

            try {
                // Obtén la película por su nombre
                Pelicula pelicula = DatabaseManager.getPeliculaPorNombre(nombrePeliculaABorrar);

                if (pelicula != null) {
                    // Borra la película de la base de datos
                    DatabaseManager.borrarPelicula(pelicula);

                    response.getWriter().println("Película borrada exitosamente.");
                } else {
                    response.getWriter().println("No se encontró la película a borrar.");
                }
            } catch (SQLException e) {
                e.printStackTrace();
                response.getWriter().println("Error al borrar la película.");
            }

        } else if ("moddicar".equals(accion)) {
// Obtén el nombre de la película a modificar desde la solicitud
            String nombrePeliculaAModificar = request.getParameter("peliculaAModificar");

            try {
                // Obtén la película por su nombre
                Pelicula pelicula = DatabaseManager.getPeliculaPorNombre(nombrePeliculaAModificar);

                if (pelicula != null) {
                    // Modifica la película con los nuevos valores
                    pelicula.setNombre(request.getParameter("nuevoNombre"));
                    pelicula.setSinopsis(request.getParameter("nuevaSinopsis"));
                    pelicula.setPaginaOficial(request.getParameter("nuevaPaginaOficial"));
                    pelicula.setTituloOriginal(request.getParameter("nuevoTituloOriginal"));
                    pelicula.setGenero(request.getParameter("nuevoGenero"));
                    pelicula.setNacionalidad(request.getParameter("nuevaNacionalidad"));
                    pelicula.setDuracion(Integer.parseInt(request.getParameter("nuevaDuracion")));
                    pelicula.setAño(Integer.parseInt(request.getParameter("nuevoAño")));
                    pelicula.setDistribuidora(request.getParameter("nuevaDistribuidora"));
                    pelicula.setDirector(request.getParameter("nuevoDirector"));
                    pelicula.setActores(request.getParameter("nuevosActores"));
                    pelicula.setClasificacionEdad(Integer.parseInt(request.getParameter("nuevaClasificacionEdad")));

                    // Guarda la película modificada en la base de datos
                    DatabaseManager.modificarPelicula(nombrePeliculaAModificar, pelicula);

                    response.sendRedirect("gestionPeliculas.jsp");

                    
                } else {
                    response.getWriter().println("No se encontró la película a modificar.");
                }
            } catch (SQLException e) {
                e.printStackTrace();
                response.getWriter().println("Error al modificar la película.");
            }
        } else {
            response.getWriter().println("Acción no reconocida");
        }

    }

}
