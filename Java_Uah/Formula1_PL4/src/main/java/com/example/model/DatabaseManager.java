package com.example.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DatabaseManager {
    private static final String DB_URL = "jdbc:derby://localhost:1527/sample;user=app;password=app";
    private static Connection connection;

    public static void abrirConexion() {
        try {
            Class.forName("org.apache.derby.jdbc.ClientDriver");
            connection = DriverManager.getConnection(DB_URL);
            System.out.println("Se ha conectado");
        } catch (Exception e) {
            System.out.println("No se ha conectado");
            e.printStackTrace();
        }
    }

    public static void cerrarConexion() {
        try {
            if (connection != null && !connection.isClosed()) {
                connection.close();
                System.out.println("Se ha cerrado la conexión");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void saveCircuit(Circuit circuit) throws SQLException {
        abrirConexion();
        try {
            String sql = "INSERT INTO circuits (name, city, country, laps, lapLength, curves) VALUES (?, ?, ?, ?, ?, ?)";
            try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
                preparedStatement.setString(1, circuit.getName());
                preparedStatement.setString(2, circuit.getCity());
                preparedStatement.setString(3, circuit.getCountry());
                preparedStatement.setInt(4, circuit.getLaps());
                preparedStatement.setDouble(5, circuit.getLapLength());
                preparedStatement.setInt(6, circuit.getCurves());
                preparedStatement.executeUpdate();
            }
        } finally {
            cerrarConexion();
        }
    }

    public static void saveCar(Car car) throws SQLException {
        abrirConexion();
        try {
            String sql = "INSERT INTO cars (name, powerPerCurve) VALUES (?, ?)";
            try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
                preparedStatement.setString(1, car.getName());
                preparedStatement.setInt(2, car.getPowerPerCurve());
                preparedStatement.executeUpdate();
            }
        } finally {
            cerrarConexion();
        }
    }

    public static List<Circuit> getAllCircuits() throws SQLException {
        abrirConexion();
        List<Circuit> circuits = new ArrayList<>();
        try {
            String sql = "SELECT * FROM circuits";
            try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
                try (ResultSet resultSet = preparedStatement.executeQuery()) {
                    while (resultSet.next()) {
                        Circuit circuit = new Circuit(
                                resultSet.getString("name"),
                                resultSet.getString("city"),
                                resultSet.getString("country"),
                                resultSet.getInt("laps"),
                                resultSet.getDouble("lapLength"),
                                resultSet.getInt("curves")
                        );
                        circuits.add(circuit);
                    }
                }
            }
        } finally {
            cerrarConexion();
        }
        return circuits;
    }

    public static List<Car> getAllCars() throws SQLException {
        abrirConexion();
        List<Car> cars = new ArrayList<>();
        try {
            String sql = "SELECT * FROM cars";
            try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
                try (ResultSet resultSet = preparedStatement.executeQuery()) {
                    while (resultSet.next()) {
                        Car car = new Car(
                                resultSet.getString("name"),
                                resultSet.getInt("powerPerCurve")
                        );
                        cars.add(car);
                    }
                }
            }
        } finally {
            cerrarConexion();
        }
        return cars;
    }

    // Métodos para obtener un circuito por ID
    public static Circuit getCircuitById(String circuitId) throws SQLException {
        abrirConexion();
        try {
            String sql = "SELECT * FROM circuits WHERE id = ?";
            try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
                preparedStatement.setString(1, circuitId);
                try (ResultSet resultSet = preparedStatement.executeQuery()) {
                    if (resultSet.next()) {
                        return new Circuit(
                                resultSet.getString("name"),
                                resultSet.getString("city"),
                                resultSet.getString("country"),
                                resultSet.getInt("laps"),
                                resultSet.getDouble("lapLength"),
                                resultSet.getInt("curves")
                        );
                    }
                }
            }
        } finally {
            cerrarConexion();
        }
        return null;
    }

    // Métodos para obtener un coche por ID
    public static Car getCarById(String carId) throws SQLException {
        abrirConexion();
        try {
            String sql = "SELECT * FROM cars WHERE id = ?";
            try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
                preparedStatement.setString(1, carId);
                try (ResultSet resultSet = preparedStatement.executeQuery()) {
                    if (resultSet.next()) {
                        return new Car(
                                resultSet.getString("name"),
                                resultSet.getInt("powerPerCurve")
                        );
                    }
                }
            }
        } finally {
            cerrarConexion();
        }
        return null;
    }


}
