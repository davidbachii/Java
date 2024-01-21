package com.example.servlets;

import com.example.model.AdaptadorFecha;
import com.example.model.Comentario;
import com.example.model.DatabaseManager;
import com.example.model.Fecha;
import com.example.model.FechaUS;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

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
        String fechaComentario = request.getParameter("fechax");

        Fecha fecha;

        fecha = new AdaptadorFecha(new FechaUS(fechaComentario));
        System.out.println(fecha);

        String emailUsuario = request.getParameter("emailDelUsuario");
        System.out.println(emailUsuario);
        String nombrePelicula = request.getParameter("nombrePelicula");
        System.out.println(nombrePelicula);

        try {
            Comentario comentario = new Comentario(texto, valoracion, fecha, emailUsuario, nombrePelicula);

            //Prueba del patron prototype para mejorar las estadisticas del contenido
            //Clonamos el comentario que ha escrito el usuario 
            Comentario nuevoComentario = comentario.clone();

            //Si el usuario ha puesto una valoracion menor de 5 
            if (valoracion < 5) {
                nuevoComentario.setValoracion(5);
            }

            // Realizamos la modificación del texto para reemplazar palabras ofensivas
            String textoModificado = nuevoComentario.reemplazarPalabrasOfensivas(nuevoComentario.getTexto());
            nuevoComentario.setTexto(textoModificado);

            //Guardamos ese comentario en la base de datos
            DatabaseManager.getInstance().guardarComentario(nuevoComentario);

            response.sendRedirect("indexDetallado.jsp?id=" + nombrePelicula);
        } catch (SQLException e) {
            e.printStackTrace();
            response.getWriter().println("Error al guardar el comentario en el servlet.");
        }
    }

}
