package com.example.servlets;

import com.example.model.ContextoBusqueda;
import com.example.model.EstrategiaBusquedaPorGenero;
import com.example.model.EstrategiaBusquedaPorNacionalidad;
import com.example.model.EstrategiaBusquedaPorNombre;
import com.example.model.Pelicula;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

@WebServlet("/InformeServlet")
public class InformeServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String estrategia = request.getParameter("estrategia");
        System.out.println(estrategia);
        String parametro = request.getParameter("parametro");

        // Crear el contexto con la estrategia seleccionada
        ContextoBusqueda contexto = null;

        switch (estrategia) {
            case "nombre":
                contexto = new ContextoBusqueda(new EstrategiaBusquedaPorNombre());
                break;
            case "genero":
                contexto = new ContextoBusqueda(new EstrategiaBusquedaPorGenero());
                break;
            case "nacionalidad":
                contexto = new ContextoBusqueda(new EstrategiaBusquedaPorNacionalidad());
                break;
            default:
                 response.getWriter().println("<p>Estrategia no válido.</p>");
                break;
        }

// Validar que contexto no sea null
        if (contexto != null) {
            // Realizar la búsqueda con la estrategia seleccionada
            try {
                List<Pelicula> peliculas = contexto.buscarPeliculas(parametro);

                // Puedes mostrar los resultados de la búsqueda en la respuesta
                response.getWriter().println("<h2>Resultados de la búsqueda:</h2>");
                for (Pelicula pelicula : peliculas) {
                    response.getWriter().println("<p>" + pelicula.toString() + "</p>");
                }
            } catch (SQLException e) {
                e.printStackTrace(); // Manejar la excepción adecuadamente
                response.getWriter().println("<p>Error en la búsqueda.</p>");
            }
        } else {
            // Manejar el caso donde contexto es null
            response.getWriter().println("<p>Contexto no válido.</p>");
        }
    }
}
