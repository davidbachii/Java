<%-- 
    Document   : index
    Created on : 19 dic 2023, 17:41:57
    Author     : david
--%>

<%--
  Created by IntelliJ IDEA.
  User: david
  Date: 13/12/2023
  Time: 13:48
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="java.util.List" %>
<%@ page import="com.example.model.Circuit" %>
<%@ page import="com.example.model.Car" %>
<%@ page import="com.example.model.DatabaseManager" %>
<%@ page import="java.util.ArrayList" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <title>F1 Menu</title>
    <link rel="stylesheet" type="text/css"   href="Diseño.css"> 
</head>


<body>
<form action="CreateCircuitServlet" method="post">
    <h2>Crear Circuito</h2>
    Name: <input type="text" name="name" required><br>
    City: <input type="text" name="city" required><br>
    Country: <input type="text" name="country" required><br>
    Laps: <input type="number" name="laps" min="40" max="80" required><br>
    Lap Length (meters): <input type="number" name="lapLength" min="3000" max="9000" required><br>
    Curves per Lap: <input type="number" name="curves" min="6" max="20" required><br>
    <input type="submit" value="Create Circuit">
</form>


<form action="CreateCarServlet" method="post">
    <h2>Crear Coche</h2>
    Name: <input type="text" name="name" required><br>
    Power per Curve (kW): <input type="number" name="powerPerCurve" min="4" max="10" required><br>
    <input type="submit" value="Create Car">
</form>


<form action="CalculatePowerServlet" method="post">
    <h2>Calcular Potencia</h2>
    <label>Select Circuit:</label>
    <select name="circuitId">
        <% List<Circuit> circuits = new ArrayList<>();
            try {
                circuits = DatabaseManager.getAllCircuits();
            } catch (Exception e) {
                e.printStackTrace();
            }
            for (Circuit circuit : circuits) { %>
        <option value="<%= circuit.getName() %>"><%= circuit.getName() %></option>
        <% } %>
    </select><br>

    <label>Select Car:</label>
    <select name="carId">
        <% List<Car> cars = new ArrayList<>();
            try {
                cars = DatabaseManager.getAllCars();
            } catch (Exception e) {
                e.printStackTrace();
            }
            for (Car car : cars) { %>
        <option value="<%= car.getName() %>"><%= car.getName() %></option>
        <% } %>
    </select><br>

    <input type="submit" value="Calculate Power">
</form>
</body>
</html>



