<%-- 
    Document   : gestionReservas.jsp
    Created on : 30 dic 2023, 13:29:22
    Author     : david
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ page import="java.util.List" %>
<%@ page import="com.example.model.Sala" %>
<%@ page import="com.example.model.Pelicula" %>
<%@ page import="com.example.model.Entrada" %>
<%@ page import="com.example.model.Reserva" %>
<%@ page import="com.example.model.DatabaseManager" %>
<%@ page import="java.util.ArrayList" %>


<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Gestion de Reservas</title>
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
        <form action="GestionReserva" method="post">
            <h2>Consultar Reserva</h2>
            <select name="reservaAConsultar">
                <% List<Reserva> reservas = new ArrayList<>();
                    try {
                        reservas = DatabaseManager.getAllReservas(); 
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    for (Reserva reserva : reservas) { %>
                <option value="<%= reserva.getNumeroRef() %>"><%= reserva.getNumeroRef() %></option>
                <% } %>
            </select><br>
            

            <!-- Campos para mostrar la información de la sala -->
            <label>Numero de Referencia</label>
            <input type="text" id="numeroReferencia" name="numeroReferencia" value="${numeroReferencia}" ><br>

            <label for="emailUser">Email del Usuario</label>
            <input type="text" id="emailUser" name="emailUser" value="${emailUser}" ><br>

            <label for="idEntrada">Id de la entrada</label>
            <input type="text" id="idEntrada" name="idEntrada" value="${idEntrada}" ><br>
            
            <label for="fila_entrada">Fila de la entrada adquirida</label>
            <input type="text" id="fila_entrada" name="fila_entrada" value="${fila_entrada}" ><br>
            
            <label for="columna_entrada">Columna de la entrada adquirida</label>
            <input type="text" id="columna_entrada" name="columna_entrada" value="${columna_entrada}" ><br>


            <input type="hidden" name="accion" value="Consultar">
            <button type="submit">Consultar reserva</button><br><br>


        </form>     



    </body>
</html>
