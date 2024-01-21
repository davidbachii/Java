<%-- 
    Document   : index
    Created on : 16 ene 2024, 14:24:28
    Author     : david
--%>


<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ page import="java.util.List" %>
<%@ page import="java.time.LocalDate" %>
<%@ page import="com.example.model.Pelicula" %>
<%@ page import="com.example.model.DatabaseManager" %>
<%@ page import="java.util.ArrayList" %>


<!DOCTYPE html>
<html lang="en" dir="ltr">
    <head>
        <script async src="https://www.googletagmanager.com/gtag/js?id=UA-155274620-1"></script>
        <title>Web oficial</title>

        <meta charset="utf-8">

        <link href="estilos/bootstrap.css" rel="stylesheet">
        <link href="estilos/style.css" rel="stylesheet">
        <link href="estilos/fontawesome.min.css" rel="stylesheet"/>
        <link href="estilos/multicines.css" rel="stylesheet" />

    </head>
    <body>
        <div id="wrapper" class="d-flex flex-column">
            <div class="header">
                <nav class="navbar fixed-top navbar-site navbar-light bg-light navbar-expand-lg" role="navigation" >
                    <div class="container">
                        <div class="navbar-identity">

                            <button data-target=".navbar-collapse" data-toggle="collapse" class="navbar-toggler pull-right" type="button">
                                <svg xmlns="https://www.w3.org/2000/svg" viewbox="0 0 30 30" width="30" height="30" focusable="false"><title>Menu</title><path stroke="currentColor" stroke-width="2" stroke-linecap="round" stroke-miterlimit="10" d="M4 7h22M4 15h22M4 23h22"/></svg>
                            </button>
                        </div>
                        <div class="navbar-collapse collapse" style="height: auto;">
                            <ul class="nav navbar-nav ml-auto navbar-right">
                                <li class="nav-item"><a href="index.jsp" class="nav-link">VOLVER AL MENU DE PELICULAS</a></li>
                                <li class="nav-item"><a href="login.jsp" class="nav-link">REGISTRARSE</a></li>
                            </ul>
                        </div>
                    </div>
                </nav>
            </div>
            <div class="main-container inner-page flex-fill " style="padding-top: 30px ">
                <div class="container">
                    <div class="white-box">
                        <h3 class="titulo-cine">ELIGE LA PELICULA</h3>
                        <div class="row">

                            <%  // Llamamos al metodo getAllPeliculas para iterar sobre todas las peliculas
                                List<Pelicula> listaPeliculas = DatabaseManager.getInstance().getAllPeliculas(); %>

                            <% for(Pelicula pelicula : listaPeliculas){ %>
                            <div class="col-6 col-sm-4 col-md-3 col-xl-2dot4 mb20">
                                <div class="card card-event info-overlay">
                                    <div class="img has-background">

                                        <a href="indexDetallado.jsp?id=<%= pelicula.getNombre() %>" class="event-pop-link">
                                            <div class="event-pop-info">
                                                <p class="price" style="font-size:1.1em; padding: 5px;"><button type="submit" style="background: none; border: none; padding: 0; color: inherit; cursor: pointer;"><%= pelicula.getNombre() %></button></p>
                                                <span style="font-size: 0.90em; background-color: #53234f;" class="badge badge-primary">VER FICHA Y PASES</span><br /><br />
                                            </div>
                                        </a>

                                                <a href="indexDetallado.jsp?id=<%= pelicula.getNombre() %>"><img class="img-responsive" src="<%= pelicula.getUrl_image() %>" /></a>
                                        </form>
                                    </div>
                                </div>
                            </div>
                            <% } %>
                        </div>
                    </div>
                </div>
            </div>
    </body>
</html>
