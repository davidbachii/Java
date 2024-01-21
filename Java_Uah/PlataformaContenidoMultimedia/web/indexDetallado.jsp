<%-- 
    Document   : indexDetallado
    Created on : 16 ene 2024, 14:25:33
    Author     : david
--%>


<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ page import="java.util.List" %>
<%@ page import="java.time.LocalDate" %>
<%@ page import="com.example.model.Pelicula" %>
<%@ page import="com.example.model.DatabaseManager" %>
<%@ page import="com.example.model.Usuario" %>
<%@ page import="com.example.model.Comentario" %>
<%@ page import="java.util.ArrayList" %>

<!DOCTYPE html>
<html lang="en" dir="ltr">
    <head>
        <title>Web oficial</title>
        <meta charset="utf-8">


        <link href="estilos/bootstrap.css" rel="stylesheet">
        <link href="estilos/style.css" rel="stylesheet">
        <link href="estilos/fontawesome.min.css" rel="stylesheet"/>
        <link href="estilos/multicines.css" rel="stylesheet" />

    </head>
    <body>

        <%  String nombrePelicula = request.getParameter("id");
           Pelicula pelicula = DatabaseManager.getInstance().getPeliculaPorNombre(nombrePelicula);
           session.setAttribute("pelicula",pelicula);
        %>
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
            <div class="main-container inner-page flex-fill " style="padding-top: 30px !important;">
                <div class="container">

                    <% if (pelicula != null) { %>
                    <div class="row clearfix">
                        <h1 class="text-center title-1"><%= pelicula.getNombre() %></h1>
                        <hr class="mx-auto small text-hr" style="margin-bottom: 30px !important">

                        <div style="clear:both">
                            <hr>
                        </div>
                    </div>


                    <div class="white-box" style="padding:15px">
                        <h3 class="titulo-cine">FICHA - <%= pelicula.getNombre() %></h3>
                        <div class="row mb20">
                            <div class="col-3 d-none d-md-block">

                                <a href="<%= pelicula.getUrl_image() %>" data-toggle="lightbox"><img class="img-responsive" style="width: 262px;" src="<%= pelicula.getUrl_image() %>" /></a>


                            </div>
                            <div class="col-6 d-none d-md-block"><iframe width="100%" height="350" src="<%= pelicula.getUrl_video() %>" title="YouTube video player" frameborder="0" allow="accelerometer; autoplay; clipboard-write; encrypted-media; gyroscope; picture-in-picture; web-share" allowfullscreen></iframe></div>
                            <div class="col-3 d-none d-md-block" style="padding-left: 10px;">
                                <ul class="list-unstyled">
                                    <li><p class="text-muted">Dirección:<br><strong class="text-dark"> <%= pelicula.getDirector() %></strong></p></li>

                                    <li><p class="text-muted">Duración:<br><strong class="text-dark"><%= pelicula.getDuracion() %> minutos</strong></p></li>

                                    <li><p class="text-muted">Calificación:<br><strong class="text-dark"><%= pelicula.getClasificacionEdad() %> años</strong></p></li>
                                    <li><p class="text-muted">Actores:<br><strong class="text-dark"><%= pelicula.getActores() %></strong></p></li>
                                    <li><p class="text-muted">Otros Datos:<br><strong class="text-dark"><%= pelicula.getOtrosDatos() %></strong></p></li>
                                    <li><p class="text-muted">Año:<br><strong class="text-dark"><%= pelicula.getAño() %></strong></p></li>

                                </ul>
                            </div>
                            <div class="col-4 d-md-none">

                                <span data-toggle="modal" data-target="#trailer" class="btn btn-primary" style="padding-top: 10px; margin-top: 10px; display: block; padding-bottom: 10px;">TRAILER <i class="fa fa-play" style="margin-left: 2px;"></i></span>
                            </div>

                        </div>
                        <div class="row mb30">
                            <div class="col-sm-12">
                                <span class="text-muted">Sinopsis:</span>
                                <p><%= pelicula.getSinopsis() %></p>
                            </div>
                        </div>
                        <h3 class="titulo-cine">COMENTARIOS</h3>


                        <% if (session.getAttribute("usuario") != null) { %>
                        <%
                            // Obtener el usuario de la sesión
                            Usuario usuario = (Usuario) session.getAttribute("usuario");
                            String correoUsuario = (usuario != null) ? usuario.getCorreo() : "";
                        %>

                        <div class="comentarios">
                            <!-- Sección para hacer comentario -->
                            <form action="GestionComentarios" method="post">
                                <!-- Otros campos del formulario -->

                                <label for="textoComentario">Comentario:</label>
                                <textarea id="textoComentario" name="textoComentario" required></textarea>

                                <label for="valoracionComentario">Valoración:</label>
                                <input type="number" id="valoracionComentario" name="valoracionComentario" required>

                                <label for="fechax">Fecha del comentario</label>
                                <input type="date" id="fechax" name="fechax" required><br>

                                <input type="hidden" name="accion" value="escribirComentario">
                                <input type="hidden" name="emailDelUsuario" value="<%= correoUsuario %>">
                                <input type="hidden" name="nombrePelicula" value="<%= nombrePelicula %>">

                                <button type="submit">Enviar Comentario</button>
                            </form>
                        </div>


                        <% } %>

                        <%  
            

                 List<Comentario> comentarios = DatabaseManager.getComentariosPorNombrePelicula(nombrePelicula); %>



                        <% if (comentarios != null) { %>
                        <% for (Comentario comentario : comentarios) { %>
                        <div>
                            <h2>Usuario: <%= comentario.getEmail_user() %></h2>
                            <p>Comentario: <%= comentario.getTexto() %></p>
                            <p>Valoración: <%= comentario.getValoracion() %></p>
                        </div>
                        <% } %>
                        <% } else { %>
                        <p>No hay comentarios para esta película.</p>
                        <% } %>
                    </div>
                    <% } else { %>
                    <p>No se encontró la película.</p>
                    <% } %>    

                </div>
            </div>
        </div>
        <script>
            $(document).ready(function () {
                $("#trailer").on('hidden.bs.modal', function (e) {
                    $("#trailer iframe").attr("src", $("#trailer iframe").attr("src"));
                });
            })
        </script>
    </body>
</html>
