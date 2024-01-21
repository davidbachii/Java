<%-- 
    Document   : gestionPeliculas
    Created on : 22 dic 2023, 20:00:27
    Author     : david
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ page import="java.util.List" %>
<%@ page import="com.example.model.Pelicula" %>
<%@ page import="com.example.model.DatabaseManager" %>
<%@ page import="java.util.ArrayList" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Gestion de peliculas</title>
        <link rel="stylesheet" href="./Estilos/DiseñopPanelAdmin.css">
        <script>
            function validarAño() {
                var año = document.getElementById("año").value;
                var mensajeError = document.getElementById("mensajeErrorAño");

                if (año < 1980 || año > 2024) {
                    mensajeError.innerHTML = "Por favor, introduce un año entre 1980 y 2024.";
                    mensajeError.style.color = "red";
                    return false;
                } else {
                    mensajeError.innerHTML = "";
                    return true;
                }
            }
        </script>
    </head>
    <body>
        <form action="GestionPelicula" method="post"  onsubmit="return validarAño();">
            <h2>Crear Película</h2>

            <label for="nombre">Nombre</label>
            <input type="text" id="nombre" name="nombre" required><br>

            <label for="sinopsis">Sinopsis</label>
            <textarea id="sinopsis" name="sinopsis" required></textarea><br>

            <label for="paginaOficial">Página Oficial</label>
            <input type="text" id="paginaOficial" name="paginaOficial" required><br>

            <label for="tituloOriginal">Título Original</label>
            <input type="text" id="tituloOriginal" name="tituloOriginal" required><br>

            <label for="genero">Género</label>
            <input type="text" id="genero" name="genero" required><br>

            <label for="nacionalidad">Nacionalidad</label>
            <input type="text" id="nacionalidad" name="nacionalidad" required><br>

            <label for="duracion">Duración (minutos)</label>
            <input type="number" id="duracion" name="duracion" required><br>

            <label for="año">Año:</label>
            <input type="number" id="año" name="año" required><br>
            <span id="mensajeErrorAño"></span><br>

            <label for="nacionalidad">Distribuidora</label>
            <input type="text" id="distribuidora" name="distribuidora" required><br>

            <label for="nacionalidad">Director</label>
            <input type="text" id="director" name="director" required><br>

            <label for="nacionalidad">Actores</label>
            <input type="text" id="actores" name="actores" required><br> 

            <label for="duracion">ClasificacionEdad</label>
            <input type="number" id="clasificacionEdad" name="clasificacionEdad" required><br>


            <!-- Campos que esta ocultos para saber que accion esta realizando el servlet y no crear un servlet exclusivo para cada accion de 
            boorar de insertar, modificar o mostrar contenido-->
            <input type="hidden" name="accion" value="crear">

            <button type="submit">Guardar Película</button>
        </form>


        <form action="GestionPelicula" method="post">
            <h2>Borrar Película</h2>
            <label>Selecciona una película para borrar:</label>
            <select name="peliculaABorrar">
                <% List<Pelicula> peliculas = new ArrayList<>();
                    try {
                        peliculas = DatabaseManager.getAllPeliculas(); // Asume que tienes un método para obtener todas las películas
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    for (Pelicula pelicula : peliculas) { %>
                <option value="<%= pelicula.getNombre() %>"><%= pelicula.getNombre() %></option>
                <% } %>
            </select><br>
            <!-- Campos que esta ocultos para saber que accion esta realizando el servlet y no crear un servlet exclusivo para cada accion de 
            boorar de insertar, modificar o mostrar contenido-->
            <input type="hidden" name="accion" value="borrar">

            <input type="submit" value="Borrar Película">
        </form>  



        <form action="GestionPeliculas" method="post">
            <h2>Modificar Película</h2>
            <select name="peliculaAModificar">
                <% List<Pelicula> peliculas = new ArrayList<>();
                    try {
                        peliculas = DatabaseManager.getAllPeliculas();
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    for (Pelicula pelicula : peliculas) { %>
                <option value="<%= pelicula.getNombre() %>"><%= pelicula.getNombre() %></option>
                <% } %>
            </select><br>

            <label>Nuevo nombre:</label>
            <input type="text" name="nuevoNombre" required><br>

            <label>Nueva sinopsis:</label>
            <textarea name="nuevaSinopsis" required></textarea><br>

            <label>Nueva página oficial:</label>
            <input type="text" name="nuevaPaginaOficial" required><br>

            <label for="tituloOriginal">Nuevo Título Original</label>
            <input type="text" id="tituloOriginal" name="nuevoTituloOriginal" required><br>

            <label for="genero">Nuevo Género</label>
            <input type="text" id="genero" name="nuevoGenero" required><br>

            <label for="nacionalidad">Nueva Nacionalidad</label>
            <input type="text" id="nacionalidad" name="nuevaNacionalidad" required><br>

            <label for="duracion">Nueva Duración (minutos)</label>
            <input type="number" id="duracion" name="nuevaDuracion" required><br>

            <label for="año">Nuevo Año:</label>
            <input type="number" id="año" name="nuevoAño" required><br>

            <label for="distribuidora">Nueva Distribuidora</label>
            <input type="text" id="distribuidora" name="nuevaDistribuidora" required><br>

            <label for="director">Nuevo Director</label>
            <input type="text" id="director" name="nuevoDirector" required><br>

            <label for="actores">Nuevos Actores</label>
            <input type="text" id="actores" name="nuevosActores" required><br>

            <label for="clasificacionEdad">Nueva Clasificación de Edad</label>
            <input type="number" id="clasificacionEdad" name="nuevaClasificacionEdad" required><br>

            <!-- Agrega otros campos para los nuevos valores -->

            <input type="hidden" name="accion" value="modificar">
            <button type="submit">Modificar Película</button>
        </form>     



    </body>
</html>
