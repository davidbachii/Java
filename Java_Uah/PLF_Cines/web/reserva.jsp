<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ page import="java.util.List" %>
<%@ page import="com.example.model.Pelicula" %>
<%@ page import="com.example.model.Sala" %>
<%@ page import="com.example.model.DatabaseManager" %>
<%@ page import="java.util.ArrayList" %>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8">
        <title>Seleccionar Hora, Fecha y Sala</title>
    </head>
    <body>

        <form action="Reservas" method="post">
            <label for="pelicula">Pelicula:</label>
            <select name="peliculaSeleccionada" onchange="filtrarSalas()">
                <% List<Pelicula> peliculas = new ArrayList<>();
                    try {
                        peliculas = DatabaseManager.getAllPeliculas(); // Asume que tienes un método para obtener todas las películas
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                %>
                <option value="" disabled selected>Selecciona una película</option>
                <% 
                    for (Pelicula pelicula : peliculas) { 
                %>
                <option value="<%= pelicula.getNombre() %>"><%= pelicula.getNombre() %></option>
                <% } %>

            </select><br>

            <label for="fecha">Fecha:</label>
            <input type ="date" name="fecha" required><br>
            <label for="hora">Hora:</label>
            <input type="time" name="hora" required><br>

            <label for="sala">Sala:</label>
            <select name="salaSeleccionada" id="salaSeleccionada">
                <% List<Sala> salas = new ArrayList<>();
                    try {
                        salas = DatabaseManager.getAllSalas(); // Asume que tienes un método para obtener todas las películas
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                %>
                <option value="" disabled selected>Selecciona una película primero</option>
                <% 
                    for (Sala sala : salas) { 
                %>
                <option value="<%= sala.getNombreSala() %>" data-pelicula="<%= sala.getNombre_pelicula() %>"><%= sala.getNombreSala() %></option>
                <% 
                    } 
                %>
            </select><br>

            <input type="submit" value="Seleccionar Asientos">
        </form>

        
        <script>
            function filtrarSalas() {
                var peliculaSeleccionada = document.querySelector('select[name="peliculaSeleccionada"]').value;
                var salasDropdown = document.querySelector('select[name="salaSeleccionada"]');
                
                // Mostrar todas las opciones
                Array.from(salasDropdown.options).forEach(function(option) {
                    option.style.display = 'block';
                });
                
                // Ocultar las opciones que no pertenecen a la película seleccionada
                Array.from(salasDropdown.options).forEach(function(option) {
                    if (option.dataset.pelicula && option.dataset.pelicula !== peliculaSeleccionada) {
                        option.style.display = 'none';
                    }
                });
                
                // Reiniciar el valor seleccionado
                salasDropdown.value = '';
            }
        </script>
        
    </body>
</html>
</html>