<%-- 
    Document   : gestionPeliculas
    Created on : 16 ene 2024, 14:18:31
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
        <form action="GestionPelicula" method="post">
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
            <span id="mensajeErrorGenero"></span><br>

            <label for="nacionalidad">Nacionalidad</label>
            <input type="text" id="nacionalidad" name="nacionalidad" required><br>
            <span id="mensajeErrorNacionalidad"></span><br>

            <label for="duracion">Duración (minutos)</label>
            <input type="number" id="duracion" name="duracion" required><br>
            <span id="mensajeErrorDuracion"></span><br>

            <label for="anho">Año:</label>
            <input type="number" id="anho" name="anho" required><br>
            <span id="mensajeErrorAnho"></span><br>

            <label for="distribuidora">Distribuidora</label>
            <input type="text" id="distribuidora" name="distribuidora" required><br>

            <label for="director">Director</label>
            <input type="text" id="director" name="director" required><br>

            <label for="clasificacionEdad">ClasificacionEdad</label>
            <input type="number" id="clasificacionEdad" name="clasificacionEdad" required><br>
            <span id="mensajeErrorClasificacionEdad"></span><br>

            <label for="otrosDatos">Otros Datos</label>
            <input type="text" id="otrosDatos" name="otrosDatos" required><br> 

            <label for="actores">Actores</label>
            <input type="text" id="actores" name="actores" required><br> 

            <label for="imagen">Url imagen</label>
            <input type="text" id="imagen" name="imagen" required><br>

            <label for="video">Url video</label>
            <input type="text" id="video" name="video" required><br>


            <!-- Campos que esta ocultos para saber que accion esta realizando el servlet y no crear un servlet exclusivo para cada accion de 
            boorar de insertar, modificar o mostrar contenido-->
            <input type="hidden" name="accion" value="crear">

            <button type="submit" id="botonCrearPelicula">Guardar Película</button>
        </form>


        <form action="GestionPelicula" method="post">
            <h2>Borrar Película</h2>
            <label>Selecciona una película para borrar:</label>
            <select name="peliculaABorrar">
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

            <input type="hidden" name="accion" value="borrar">

            <button type="submit">Borrar Película</button>
        </form>  



        <form action="GestionPelicula" method="post">
            <h2>Modificar Película</h2>
            <select name="peliculaAModificar">
                <% List<Pelicula> peliculas2 = new ArrayList<>();
                    try {
                        peliculas2 = DatabaseManager.getAllPeliculas();
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    for (Pelicula pelicula2 : peliculas2) { %>
                <option value="<%= pelicula2.getNombre() %>"><%= pelicula2.getNombre() %></option>
                <% } %>
            </select><br>

            <label>Nuevo nombre:</label>
            <input type="text" name="nuevoNombre" required><br>

            <label>Nueva sinopsis:</label>
            <textarea name="nuevaSinopsis" required></textarea><br>

            <label>Nueva página oficial:</label>
            <input type="text" name="nuevaPaginaOficial" required><br>

            <label for="tituloOriginal">Nuevo Título Original</label>
            <input type="text" id="nuevoTituloOriginal" name="nuevoTituloOriginal" required><br>

            <label for="genero">Nuevo Género</label>
            <input type="text" id="nuevoGenero" name="nuevoGenero" required><br>
            <span id="mensajeErrorNuevoGenero"></span><br>

            <label for="nacionalidad">Nueva Nacionalidad</label>
            <input type="text" id="nuevaNacionalidad" name="nuevaNacionalidad" required><br>
            <span id="mensajeErrorNuevaNacionalidad"></span><br>

            <label for="duracion">Nueva Duración (minutos)</label>
            <input type="number" id="nuevaDuracion" name="nuevaDuracion" required><br>
            <span id="mensajeErrorNuevaDuracion"></span><br>

            <label for="nuevoAnho">Nuevo Año:</label>
            <input type="number" id="nuevoAnho" name="nuevoAnho" required><br>
            <span id="mensajeErrorNuevoAnho"></span><br>

            <label for="distribuidora">Nueva Distribuidora</label>
            <input type="text" id="nuevaDistribuidora" name="nuevaDistribuidora" required><br>

            <label for="director">Nuevo Director</label>
            <input type="text" id="nuevoDirector" name="nuevoDirector" required><br>

            <label for="clasificacionEdad">Nueva Clasificación de Edad</label>
            <input type="number" id="nuevaClasificacionEdad" name="nuevaClasificacionEdad" required><br>
            <span id="mensajeErrorNuevaClasificacionEdad"></span><br>

            <label for="nuevosDatos">Nuevos Datos</label>
            <input type="text" id="nuevosDatos" name="nuevosDatos" required><br>

            <label for="nuevosActores">Nuevos Actores</label>
            <input type="text" id="nuevosActores" name="nuevosActores" required><br>

            <label for="nuevaImagen">Nuevos url de la imagen</label>
            <input type="text" id="nuevaImagen" name="nuevaImagen" required><br>

            <label for="nuevoVideo">URL del video en YouTube</label>
            <input type="text" id="nuevoVideo" name="nuevoVideo" required><br>

            <input type="hidden" name="accion" value="modificar">
            <button type="submit" id="botonModificarPelicula">Modificar Película</button>
        </form>     

        <form action="GestionPelicula" method="post">
            <h2>Consultar Película</h2>
            <select name="peliculaAConsultar">
                <% List<Pelicula> peliculas3 = new ArrayList<>();
                    try {
                        peliculas3 = DatabaseManager.getAllPeliculas();
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    for (Pelicula pelicula3 : peliculas3) { %>
                <option value="<%= pelicula3.getNombre() %>"><%= pelicula3.getNombre() %></option>
                <% } %>
            </select><br>

            <!-- Campos para mostrar la información de la película -->
            <label>Nombre</label>
            <input type="text" id="nombreConsultar" name="nombreConsultar" value="${nombreConsultar}" ><br>

            <label>Sinopsis</label>
            <textarea id="sinopsisConsultar" name="sinopsisConsultar" >${sinopsisConsultar}</textarea><br>

            <label>Página oficial</label>
            <input type="text" id="paginaOficialConsultar" name="paginaOficialConsultar" value="${paginaOficialConsultar}" ><br>

            <label for="nuevoTituloOriginal">Título Original</label>
            <input type="text" id="tituloOriginalConsultar" name="tituloOriginalConsultar" value="${tituloOriginalConsultar}" ><br>

            <label for="nuevoGenero">Género</label>
            <input type="text" id="generoConsultar" name="generoConsultar" value="${generoConsultar}" ><br>

            <label for="nuevaNacionalidad">Nacionalidad</label>
            <input type="text" id="nacionalidadConsultar" name="nacionalidadConsultar" value="${nacionalidadConsultar}" ><br>

            <label for="nuevaDuracion">Duración (minutos)</label>
            <input type="number" id="duracionConsultar" name="duracionConsultar" value="${duracionConsultar}" ><br>

            <label for="nuevoAnho">Año</label>
            <input type="number" id="AnhoConsultar" name="AnhoConsultar" value="${AnhoConsultar}" ><br>

            <label for="nuevaDistribuidora">Distribuidora</label>
            <input type="text" id="distribuidoraConsultar" name="distribuidoraConsultar" value="${distribuidoraConsultar}" ><br>

            <label for="nuevoDirector">Director</label>
            <input type="text" id="directorConsultar" name="directorConsultar" value="${directorConsultar}" ><br>

            <label for="nuevaClasificacionEdad">Clasificación de Edad</label>
            <input type="number" id="clasificacionEdadConsultar" name="clasificacionEdadConsultar" value="${clasificacionEdadConsultar}" ><br>

            <label for="nuevosDatos">Datos</label>
            <input type="text" id="datos" name="datosConsultar" value="${datosConsultar}" ><br>

            <label for="nuevosActores">Actores</label>
            <input type="text" id="actoresConsultar" name="actoresConsultar" value="${actoresConsultar}" ><br>

            <label for="nuevaImagen">URL de la imagen</label>
            <input type="text" id="ImagenConsultar" name="ImagenConsultar" value="${ImagenConsultar}" ><br>

            <label for="nuevoVideo">URL del video en YouTube</label>
            <input type="text" id="VideoConsultar" name="VideoConsultar" value="${VideoConsultar}" ><br>

            <input type="hidden" name="accion" value="Consultar">
            <button type="submit">Consultar Película</button><br><br>
        </form>
        <script src="estilos/checking.js"></script>

        <% } else { %>
        <p>Acesso restringido.</p>
        <% } %>

    </body>
</html>
