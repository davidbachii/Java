<%-- 
    Document   : panelAdmin
    Created on : 16 ene 2024, 14:17:05
    Author     : david
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="es">
    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>Panel Administrador</title>
        <style>
            body {
                font-family: Arial, sans-serif;
                background-color: #f4f4f4;
                text-align: center;
                margin: 0;
                padding: 0;
            }

            h1 {
                color: #333;
            }

            .options-container {
                display: flex;
                flex-direction: column;
                align-items: center;
                margin-top: 20px;
            }

            .option-button {
                width: 200px; /* Puedes ajustar este valor según tus preferencias */
                margin: 10px;
                padding: 10px;
                font-size: 16px;
                cursor: pointer;
                background-color: #3498db;
                color: #fff;
                border: none;
                border-radius: 5px;
            }

            .option-button:hover {
                background-color: #2980b9;
            }
        </style>
    </head>
    <body>

        <% if (session.getAttribute("usuario") != null) { %>

        <h1>Panel Administrador</h1>


        <div class="options-container">
            <input class="option-button" type="button" value="Gestión de Películas" onclick="location.href = 'gestionPeliculas.jsp'">
            <input class="option-button" type="button" value="Gestion de Informes" onclick="location.href = 'buscarPeliculas.jsp'">

            <input class="option-button" type="button" value="Volver" onclick="location.href = 'index.jsp'">
        </div>

        <% } else { %>
        <p>Acceso no autorizado, sesion administrador perdida.</p>
        <% } %> 

    </body>
</html>


