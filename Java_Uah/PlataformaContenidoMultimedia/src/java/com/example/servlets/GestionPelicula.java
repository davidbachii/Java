/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package com.example.servlets;

import com.example.model.DatabaseManager;
import com.example.model.EstadisticasPeliculas;
import com.example.model.Pelicula;
import com.example.model.PeliculaAdolescentesDecorator;
import com.example.model.PeliculaAdultosDecorator;
import com.example.model.PeliculaBebesDecorator;
import com.example.model.PeliculaComponente;
import com.example.model.PeliculaNinosDecorator;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet("/GestionPelicula")
public class GestionPelicula extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int duracion = 0;
        int año = 0;
        int clasificacionEdad = 0;
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
            try {
                duracion = Integer.parseInt(request.getParameter("duracion"));
            } catch (NumberFormatException e) {
                System.out.println(e);
            }
            try {
                año = Integer.parseInt(request.getParameter("anho"));
            } catch (NumberFormatException e) {
                System.out.println(e);
            }

            String distribuidora = request.getParameter("distribuidora");
            String director = request.getParameter("director");
            try {
                clasificacionEdad = Integer.parseInt(request.getParameter("clasificacionEdad"));
            } catch (NumberFormatException e) {
                System.out.println(e);
            }

            String otrosDatos = request.getParameter("otrosDatos");
            String actores = request.getParameter("actores");
            String url_image = request.getParameter("imagen");
            String url_video = request.getParameter("video");

            try {

                Pelicula pelicula = new Pelicula(nombre, sinopsis, pagina_oficial, titulo_original, genero, nacionalidad, duracion, año, distribuidora, director, clasificacionEdad, otrosDatos, actores, url_image, url_video);

                // Crear instancias de los decoradores según la clasificación de edad
                PeliculaComponente peliculaDecorada = pelicula;
                if (clasificacionEdad >= 0 && clasificacionEdad <= 3) {
                    //Rango de edad entre 0 y 3, luego pensada para bebes
                    peliculaDecorada = new PeliculaBebesDecorator(peliculaDecorada, nombre);

                } else if (clasificacionEdad >= 4 && clasificacionEdad <= 12) {
                    //Rango de edad entre 4 y 12, luego pensada para niños
                    peliculaDecorada = new PeliculaNinosDecorator(peliculaDecorada, nombre);
                } else if (clasificacionEdad >= 13 && clasificacionEdad <= 16) {
                    //Rango de edad entre 13 y 16, luego pensada para adolescentes
                    peliculaDecorada = new PeliculaAdolescentesDecorator(peliculaDecorada, nombre);
                } else if (clasificacionEdad >= 17) {
                    //Rango de edad mayor de 17, luego pensada para adultos
                    peliculaDecorada = new PeliculaAdultosDecorator(peliculaDecorada, nombre);
                } else {
                    System.out.println("Edad no valida");
                }

                // Registra observadores
                pelicula.agregarObservador(new EstadisticasPeliculas());

                // Guardar la pelicula en la base de datos
                DatabaseManager.getInstance().guardarPelicula(pelicula);

                // Notificar a los observadores
                pelicula.notificarObservadoresCreacion(pelicula);

                // Mostrar la información de la película decorada
                peliculaDecorada.mostrarInformacion();

                response.sendRedirect("gestionPeliculas.jsp"); // Redirigir a la página principal
            } catch (SQLException e) {
                response.getWriter().println("Error al crear la pelicula en el servlet.");
            }

        } else if ("borrar".equals(accion)) {
            // Obten el nombre de la película a borrar desde la solicitud
            String nombrePeliculaABorrar = request.getParameter("peliculaABorrar");

            try {
                // Obtén la película por su nombre
                Pelicula pelicula = DatabaseManager.getInstance().getPeliculaPorNombre(nombrePeliculaABorrar);

                if (pelicula != null) {

                    //Registra observadores
                    pelicula.agregarObservador(new EstadisticasPeliculas());
                    
                    
                    DatabaseManager.getInstance().borrarComentarioDePelicula(nombrePeliculaABorrar);
                    // Borra la película de la base de datos
                    DatabaseManager.getInstance().borrarPelicula(pelicula);

                    // Notificar a los observadores de borrado de película
                    pelicula.notificarObservadoresBorrado(pelicula);

                    response.sendRedirect("gestionPeliculas.jsp"); // Redirigir a la página principal
                    System.out.println("Pelicula borrada con exito");
                } else {
                    response.getWriter().println("No se encontró la película a borrar.");
                }
            } catch (SQLException e) {
                e.printStackTrace();
                response.getWriter().println("Error al borrar la película.");
            }

        } else if ("modificar".equals(accion)) {
// Obtén el nombre de la película a modificar desde la solicitud
            String nombrePeliculaAModificar = request.getParameter("peliculaAModificar");

            try {
                // Obtén la película por su nombre
                Pelicula pelicula = DatabaseManager.getInstance().getPeliculaPorNombre(nombrePeliculaAModificar);
                System.out.println(nombrePeliculaAModificar);

                if (pelicula != null) {
                    // Modifica la película con los nuevos valores
                    pelicula.setNombre(request.getParameter("nuevoNombre"));
                    pelicula.setSinopsis(request.getParameter("nuevaSinopsis"));
                    pelicula.setPaginaOficial(request.getParameter("nuevaPaginaOficial"));
                    pelicula.setTituloOriginal(request.getParameter("nuevoTituloOriginal"));
                    pelicula.setGenero(request.getParameter("nuevoGenero"));
                    pelicula.setNacionalidad(request.getParameter("nuevaNacionalidad"));
                    pelicula.setDuracion(Integer.parseInt(request.getParameter("nuevaDuracion")));
                    pelicula.setAño(Integer.parseInt(request.getParameter("nuevoAnho")));
                    pelicula.setDistribuidora(request.getParameter("nuevaDistribuidora"));
                    pelicula.setDirector(request.getParameter("nuevoDirector"));
                    pelicula.setClasificacionEdad(Integer.parseInt(request.getParameter("nuevaClasificacionEdad")));
                    pelicula.setOtrosDatos(request.getParameter("nuevosDatos"));
                    pelicula.setActores(request.getParameter("nuevosActores"));
                    pelicula.setUrl_image(request.getParameter("nuevaImagen"));
                    pelicula.setUrl_video(request.getParameter("nuevoVideo"));

                    // Guarda la película modificada en la base de datos
                    DatabaseManager.getInstance().modificarPelicula(nombrePeliculaAModificar, pelicula);

                    response.sendRedirect("gestionPeliculas.jsp");

                } else {
                    response.getWriter().println("No se encontró la película a modificar.");
                }
            } catch (SQLException e) {
                e.printStackTrace();
                response.getWriter().println("Error al modificar la película.");
            }
        } else if ("Consultar".equals(accion)) {
            String nombrePeliculaAConsultar = request.getParameter("peliculaAConsultar");

            try {
                // Obtén la película por su nombre
                Pelicula pelicula = DatabaseManager.getInstance().getPeliculaPorNombre(nombrePeliculaAConsultar);

                if (pelicula != null) {
                    // Setea los atributos de la película en el request para que puedan ser accesibles en el JSP
                    request.setAttribute("nombreConsultar", pelicula.getNombre());
                    request.setAttribute("sinopsisConsultar", pelicula.getSinopsis());
                    request.setAttribute("paginaOficialConsultar", pelicula.getPaginaOficial());
                    request.setAttribute("tituloOriginalConsultar", pelicula.getTituloOriginal());
                    request.setAttribute("generoConsultar", pelicula.getGenero());
                    request.setAttribute("nacionalidadConsultar", pelicula.getNacionalidad());
                    request.setAttribute("duracionConsultar", pelicula.getDuracion());
                    request.setAttribute("AnhoConsultar", pelicula.getAño());
                    request.setAttribute("distribuidoraConsultar", pelicula.getDistribuidora());
                    request.setAttribute("directorConsultar", pelicula.getDirector());
                    request.setAttribute("clasificacionEdadConsultar", pelicula.getClasificacionEdad());
                    request.setAttribute("datosConsultar", pelicula.getOtrosDatos());
                    request.setAttribute("actoresConsultar", pelicula.getActores());
                    request.setAttribute("ImagenConsultar", pelicula.getUrl_image());
                    request.setAttribute("VideoConsultar", pelicula.getUrl_video());

                    // Redirige a la página del formulario con los campos ya populados
                    request.getRequestDispatcher("gestionPeliculas.jsp").forward(request, response);
                } else {
                    response.getWriter().println("No se encontró la película a Consultar.");
                }
            } catch (SQLException e) {
                e.printStackTrace();
                response.getWriter().println("Error al consultar la película.");
            }

        } else {
            response.getWriter().println("Acción no reconocida");
        }

    }

}
