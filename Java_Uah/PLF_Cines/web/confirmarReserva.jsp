<%@ page contentType="text/html; charset=UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Formulario de Tarjeta de Crédito</title>
</head>
<body>
    <h2>Introduce la Información de la Tarjeta de Crédito</h2>
    <form action="ProcesarPagoServlet" method="post">
        <label for="numeroTarjeta">Número de Tarjeta:</label>
        <input type="text" id="numeroTarjeta" name="numeroTarjeta" required><br>

        <label for="fechaExpiracion">Fecha de Expiración (MM/AA):</label>
        <input type="date" id="fechaExpiracion" name="fechaExpiracion" required><br>

        <label for="codigoSeguridad">Código de Seguridad:</label>
        <input type="text" id="codigoSeguridad" name="codigoSeguridad" pattern="\d{3}" placeholder="###" required><br>

        <label for="nombreTitular">Nombre del Titular:</label>
        <input type="text" id="nombreTitular" name="nombreTitular" required><br>

        <button type="submit">Procesar Pago</button>
    </form>
</body>
</html>