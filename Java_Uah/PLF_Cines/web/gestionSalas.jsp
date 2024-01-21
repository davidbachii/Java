<%-- 
    Document   : gestionSalas
    Created on : 28 dic 2023, 14:05:09
    Author     : david
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ page import="java.util.List" %>
<%@ page import="com.example.model.Pelicula" %>
<%@ page import="com.example.model.Sala" %>
<%@ page import="com.example.model.DatabaseManager" %>
<%@ page import="java.util.ArrayList" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Gestion de salas</title>
        <link rel="stylesheet" type="text/css" href="./estilos/panelAdmin.css">

    </head>
    <body>
        
        
        
         <header>
            <div class="navbar">
            <a href="gestionPeliculas.jsp">Gestión de Películas</a>
            <a href="gestionSalas.jsp">Gestión de Salas</a>
            <a href="gestionEntradas.jsp">Gestión de Entradas</a>
            <a href="gestionReservas.jsp">Gestión de Reservas</a>
            <a href="gestionInformes.jsp">Gestión de Informes</a>
        </div>
        </header>
        <form action="GestionSala" method="post">
            <h2>Crear Sala</h2>

            <label for="nombre">Nombre de la Sala</label>
            <input type="text" id="nombreSala" name="nombreSala" required><br>


            <label for="duracion">Numero de Filas</label>
            <input type="number" id="filas" name="filas" required><br>

            <label for="anho">Numero de Columnas</label>
            <input type="number" id="columnas" name="columnas" required><br>


            <label for="nombrepelicula">Nombre de la pelicula</label>
            <select name="peliculaSeleccionar">
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


            <!-- Campos que esta ocultos para saber que accion esta realizando el servlet y no crear un servlet exclusivo para cada accion de 
            boorar de insertar, modificar o mostrar contenido-->
            <input type="hidden" name="accion" value="crear">

            <button type="submit">Guardar Sala</button>
        </form>


        <form action="GestionSala" method="post">
            <h2>Borrar Sala</h2>
            <label>Selecciona una Sala para borrar:</label>
            <select name="salaBorrar">
                <% List<Sala> salas = new ArrayList<>();
                    try {
                        salas = DatabaseManager.getAllSalas(); // Asume que tienes un método para obtener todas las películas
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    for (Sala sala : salas) { %>
                <option value="<%= sala.getNombreSala() %>"><%= sala.getNombreSala() %></option>
                <% } %>
            </select><br>
            <!-- Campos que esta ocultos para saber que accion esta realizando el servlet y no crear un servlet exclusivo para cada accion de 
            boorar de insertar, modificar o mostrar contenido-->
            <input type="hidden" name="accion" value="borrar">

            <button type="submit">Borrar Sala</button>
        </form>  



        <form action="GestionSala" method="post">
            <h2>Modificar Sala</h2>
            <select name="salaAModificar">
                <% List<Sala> salas2 = new ArrayList<>();
                    try {
                        salas2 = DatabaseManager.getAllSalas(); // Asume que tienes un método para obtener todas las películas
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    for (Sala sala2 : salas2) { %>
                <option value="<%= sala2.getNombreSala() %>"><%= sala2.getNombreSala() %></option>
                <% } %>
            </select><br>

            <label>Nuevo nombre Sala</label>
            <input type="text" id="nuevoNombreSala" name="nuevoNombreSala" required><br>

            <label for="duracion">Nuevo Numero de Filas</label>
            <input type="number" id="nuevoFilas" name="nuevoFilas" required><br>

            <label for="nuevoAnho">Nuevo Numero de columnas</label>
            <input type="number" id="nuevoColumnas" name="nuevoColumnas" required><br>

            <label for="peliculaCambioSala">Nueva Pelicula en la sala</label>
            <select name="peliculaCambioSala">
                <% List<Pelicula> peliculas3 = new ArrayList<>();
                    try {
                        peliculas3 = DatabaseManager.getAllPeliculas(); // Asume que tienes un método para obtener todas las películas
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    for (Pelicula pelicula3 : peliculas3) { %>
                <option value="<%= pelicula3.getNombre() %>"><%= pelicula3.getNombre() %></option>
                <% } %>
            </select><br>


            <!-- Agrega otros campos para los nuevos valores -->

            <input type="hidden" name="accion" value="modificar">
            <button type="submit">Modificar Sala</button>
        </form>     



        <form action="GestionSala" method="post">
            <h2>Consultar Sala</h2>
            <select name="salaAConsultar">
                <% List<Sala> salas3 = new ArrayList<>();
                    try {
                        salas3 = DatabaseManager.getAllSalas(); // Asume que tienes un método para obtener todas las películas
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    for (Sala sala3 : salas3) { %>
                <option value="<%= sala3.getNombreSala() %>"><%= sala3.getNombreSala() %></option>
                <% } %>
            </select><br>

            <!-- Campos para mostrar la información de la sala -->
            <label>Nombre de la Sala</label>
            <input type="text" id="nuevoNombreSala" name="nuevoNombreSala" value="${nuevoNombreSala}" ><br>

            <label for="filasConsultar">Numero de Filas</label>
            <input type="number" id="filasConsultar" name="filasConsultar" value="${filasConsultar}" ><br>

            <label for="ColumnasConsultar">Numero de columnas</label>
            <input type="number" id="ColumnasConsultar" name="ColumnasConsultar" value="${ColumnasConsultar}" ><br>

            <label for="peliculaEnSala">Pelicula en la sala</label>
            <input type="text" id="peliculaEnSala" name="peliculaEnSala" value="${peliculaEnSala}" ><br>

            <input type="hidden" name="accion" value="Consultar">
            <button type="submit">Consultar Sala</button><br><br>


        </form>     



    </body>
</html>
