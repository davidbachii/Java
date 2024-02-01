<%-- 
    Document   : buscarPeliculas
    Created on : 17 ene 2024, 15:53:17
    Author     : david
--%>

<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8">
        <title>Buscar Películas</title>
        <link rel="stylesheet" type="text/css" href="estilos/panelAdmin.css">
    </head>
    <body>

        <% if (session.getAttribute("usuario") != null) { %>
        <header>
            <div class="navbar">
                <a href="gestionPeliculas.jsp">Gestión de Películas</a>
                <a href="buscarPeliculas.jsp">Gestión de Informes</a>
                <a href="index.jsp">Volver</a>
            </div>
        </header>

        <form action="InformeServlet" method="post">
            <h2>Gestion de Informes</h2>
            <label for="estrategia">Selecciona la estrategia:</label>
            <select name="estrategia" id="estrategia">
                <option value="nombre">Nombre</option>
                <option value="genero">Genero</option>
                <option value="nacionalidad">Nacionalidad</option>
            </select>

            <br>

            <label for="parametro">Introduce el parámetro de búsqueda:</label>
            <input type="text" name="parametro" id="parametro">

            <br>

            <input type="submit" value="Buscar">
        </form>

        <% } else { %>
        <p>Acesso restringido.</p>
        <% } %>
    </body>
</html>
