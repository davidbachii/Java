/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author david
 */
public class DatabaseManager {

    private static final String DB_URL = "jdbc:derby://localhost:1527/Peliculas;user=app;password=app";
    private static Connection connection;

    private static DatabaseManager instance;

    private DatabaseManager() {
        // Constructor privado para evitar instancias múltiples
        /*
        Vamos a aplicar el patrón Singleton a tu clase DatabaseManager para asegurar que solo 
        haya una instancia de la conexión en toda la aplicación. Esto ayuda a evitar problemas
        relacionados con múltiples conexiones innecesarias.
         */
    }

    public static synchronized DatabaseManager getInstance() {
        if (instance == null) {
            instance = new DatabaseManager();
        }
        return instance;
    }

    public static void abrirConexion() {
        try {
            Class.forName("org.apache.derby.jdbc.ClientDriver");
            DriverManager.registerDriver(new org.apache.derby.jdbc.ClientDriver());
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

    public static void guardarUsuario(Usuario user) throws SQLException {
        abrirConexion();
        try {
            if (user != null && user.getFecha() != null) {
                String sql = "INSERT INTO usuario (nombre, apellidos, contrasenha, email, fechanacimiento) VALUES (?, ?, ?, ?, ?)";
                try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
                    preparedStatement.setString(1, user.getNombre());
                    preparedStatement.setString(2, user.getApellidos());
                    preparedStatement.setString(3, user.getContraseña());
                    preparedStatement.setString(4, user.getCorreo());
                    // Obtén la fecha del usuario y conviértela a java.sql.Date
                    LocalDate localDate = user.getFecha().toLocalDate();
                    java.sql.Date fechaSQL = java.sql.Date.valueOf(localDate);

                    preparedStatement.setDate(5, fechaSQL);
                    preparedStatement.executeUpdate();
                }
            } else {
                System.out.println("Error: Usuario o fecha es nulo.");
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            cerrarConexion();
        }
    }

    public static Usuario getUsuarioPorCorreo(String correo) throws SQLException {
        abrirConexion();
        try {
            String sql = "SELECT * FROM usuario WHERE email = ?";
            try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
                preparedStatement.setString(1, correo);

                try (ResultSet resultSet = preparedStatement.executeQuery()) {

                    if (resultSet.next()) {

                        // Aquí estás creando un nuevo objeto Usuario y asignando los valores desde el ResultSet
                        Usuario usuario = new Usuario(
                                resultSet.getString("nombre"),
                                resultSet.getString("apellidos"),
                                resultSet.getString("contrasenha"),
                                resultSet.getString("email"),
                                new Fecha(resultSet.getString("fechanacimiento"))
                        );
                        System.out.println(usuario.toString());
                        return usuario;
                    } else {
                        System.out.println("No se encontraron resultados para el correo electrónico proporcionado.");
                        return null;
                    }
                }
            }
        } finally {
            cerrarConexion();
        }

    }

    public static void guardarPelicula(Pelicula pelicula) throws SQLException {
        abrirConexion();
        System.out.println("GuardarPelicula");
        try {
            if (pelicula != null) {
                String sql = "INSERT INTO pelicula (nombrepelicula, sinopsis, paginaoficial, titulooriginal, genero, nacionalidad, duracion, anho, distribuidora, director, clasificacionEdad, otrosdatos, actores, url_image, url_video) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
                try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
                    preparedStatement.setString(1, pelicula.getNombre());
                    preparedStatement.setString(2, pelicula.getSinopsis());
                    preparedStatement.setString(3, pelicula.getPaginaOficial());
                    preparedStatement.setString(4, pelicula.getTituloOriginal());
                    preparedStatement.setString(5, pelicula.getGenero());
                    preparedStatement.setString(6, pelicula.getNacionalidad());
                    preparedStatement.setInt(7, pelicula.getDuracion());
                    preparedStatement.setInt(8, pelicula.getAño());
                    preparedStatement.setString(9, pelicula.getDistribuidora());
                    preparedStatement.setString(10, pelicula.getDirector());
                    preparedStatement.setInt(11, pelicula.getClasificacionEdad());
                    preparedStatement.setString(12, pelicula.getOtrosDatos());
                    preparedStatement.setString(13, pelicula.getActores());
                    preparedStatement.setString(14, pelicula.getUrl_image());
                    preparedStatement.setString(15, pelicula.getUrl_video());

                    preparedStatement.executeUpdate();
                }
            } else {
                System.out.println("Error: Pelicula es nula.");
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            cerrarConexion();
        }
    }

    public static List<Pelicula> getAllPeliculas() throws SQLException {
        abrirConexion();
        List<Pelicula> peliculas = new ArrayList<>();
        try {
            String sql = "SELECT * FROM pelicula";
            try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
                try (ResultSet resultSet = preparedStatement.executeQuery()) {
                    while (resultSet.next()) {
                        Pelicula pelicula = new Pelicula(
                                resultSet.getString("nombrepelicula"),
                                resultSet.getString("sinopsis"),
                                resultSet.getString("paginaOficial"),
                                resultSet.getString("titulooriginal"),
                                resultSet.getString("genero"),
                                resultSet.getString("nacionalidad"),
                                resultSet.getInt("duracion"),
                                resultSet.getInt("anho"),
                                resultSet.getString("distribuidora"),
                                resultSet.getString("director"),
                                resultSet.getInt("clasificacionEdad"),
                                resultSet.getString("otrosdatos"),
                                resultSet.getString("actores"),
                                resultSet.getString("url_image"),
                                resultSet.getString("url_video")
                        );
                        peliculas.add(pelicula);
                    }
                }
            }
        } finally {
            cerrarConexion();
        }
        return peliculas;
    }

    public static Pelicula getPeliculaPorNombre(String nombre) throws SQLException {
        abrirConexion();
        try {
            String sql = "SELECT * FROM pelicula WHERE nombrepelicula = ?";
            try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
                preparedStatement.setString(1, nombre);
                try (ResultSet resultSet = preparedStatement.executeQuery()) {
                    if (resultSet.next()) {
                        return new Pelicula(
                                resultSet.getString("nombrepelicula"),
                                resultSet.getString("sinopsis"),
                                resultSet.getString("paginaOficial"),
                                resultSet.getString("titulooriginal"),
                                resultSet.getString("genero"),
                                resultSet.getString("nacionalidad"),
                                resultSet.getInt("duracion"),
                                resultSet.getInt("anho"),
                                resultSet.getString("distribuidora"),
                                resultSet.getString("director"),
                                resultSet.getInt("clasificacionEdad"),
                                resultSet.getString("otrosdatos"),
                                resultSet.getString("actores"),
                                resultSet.getString("url_image"),
                                resultSet.getString("url_video")
                                
                        );
                    }
                }
            }
        } finally {
            cerrarConexion();
        }
        return null;
    }

    public static void borrarPelicula(Pelicula pelicula) throws SQLException {
        abrirConexion();
        try {
            String sql = "DELETE FROM pelicula WHERE nombrepelicula = ?";
            try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
                preparedStatement.setString(1, pelicula.getNombre());
                preparedStatement.executeUpdate();
            }
        } finally {
            cerrarConexion();
        }
    }

    public static void modificarPelicula(String nombreActual, Pelicula nuevaPelicula) throws SQLException {
        abrirConexion();
        try {
            String sql = "UPDATE pelicula SET nombrepelicula=?, sinopsis=?, paginaoficial=?, titulooriginal=?, genero=?, nacionalidad=?, duracion=?, anho=?, distribuidora=?, director=?, clasificacionedad=?, otrosdatos=?, actores=?, url_image=?, url_video=?  WHERE nombrepelicula=?";
            try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
                preparedStatement.setString(1, nuevaPelicula.getNombre());
                preparedStatement.setString(2, nuevaPelicula.getSinopsis());
                preparedStatement.setString(3, nuevaPelicula.getPaginaOficial());
                preparedStatement.setString(4, nuevaPelicula.getTituloOriginal());
                preparedStatement.setString(5, nuevaPelicula.getGenero());
                preparedStatement.setString(6, nuevaPelicula.getNacionalidad());
                preparedStatement.setInt(7, nuevaPelicula.getDuracion());
                preparedStatement.setInt(8, nuevaPelicula.getAño());
                preparedStatement.setString(9, nuevaPelicula.getDistribuidora());
                preparedStatement.setString(10, nuevaPelicula.getDirector());
                preparedStatement.setInt(11, nuevaPelicula.getClasificacionEdad());
                preparedStatement.setString(12, nuevaPelicula.getOtrosDatos());
                preparedStatement.setString(13, nuevaPelicula.getActores());
                preparedStatement.setString(14, nuevaPelicula.getUrl_image());
                preparedStatement.setString(15, nuevaPelicula.getUrl_video());

                preparedStatement.setString(16, nombreActual); // Condición para actualizar la película específica

                preparedStatement.executeUpdate();
            }
        } finally {
            cerrarConexion();
        }
    }

    public static void guardarSala(Sala sala) throws SQLException {
        abrirConexion();
        System.out.println("GuardarSala");
        try {
            if (sala != null) {
                String sql = "INSERT INTO Sala (nombreSala, filas, columnas, nombrePelicula_Pelicula) VALUES (?, ?, ?, ?)";
                try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
                    preparedStatement.setString(1, sala.getNombreSala());
                    preparedStatement.setInt(2, sala.getFilas());
                    preparedStatement.setInt(3, sala.getColumnas());
                    preparedStatement.setString(4, sala.getNombre_pelicula());

                    preparedStatement.executeUpdate();
                    System.out.println("Sala guardada correctamente.");
                }
            } else {
                System.out.println("Error: Sala es nula.");
            }
        } catch (SQLException e) {
            System.err.println("Error al guardar la sala: " + e.getMessage());
        } finally {
            cerrarConexion();
        }
    }

    public static List<Sala> getAllSalas() throws SQLException {
        abrirConexion();
        List<Sala> salas = new ArrayList<>();
        try {
            String sql = "SELECT * FROM sala";
            try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
                try (ResultSet resultSet = preparedStatement.executeQuery()) {
                    while (resultSet.next()) {
                        Sala sala = new Sala(
                                resultSet.getString("nombresala"),
                                resultSet.getInt("filas"),
                                resultSet.getInt("columnas"),
                                resultSet.getString("nombrepelicula_pelicula")
                        );
                        salas.add(sala);
                    }
                }
            }
        } finally {
            cerrarConexion();
        }
        return salas;
    }

    public static Sala getSalaPorNombre(String nombre) throws SQLException {
        abrirConexion();
        try {
            String sql = "SELECT * FROM sala WHERE nombresala = ?";
            try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
                preparedStatement.setString(1, nombre);
                try (ResultSet resultSet = preparedStatement.executeQuery()) {
                    if (resultSet.next()) {
                        return new Sala(
                                resultSet.getString("nombresala"),
                                resultSet.getInt("filas"),
                                resultSet.getInt("columnas"),
                                resultSet.getString("nombrepelicula_pelicula")
                        );
                    }
                }
            }
        } finally {
            cerrarConexion();
        }
        return null;
    }

    public static void borrarSala(Sala sala) throws SQLException {
        abrirConexion();
        try {
            String sql = "DELETE FROM sala WHERE nombresala = ?";
            try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
                preparedStatement.setString(1, sala.getNombreSala());
                preparedStatement.executeUpdate();
            }
        } finally {
            cerrarConexion();
        }
    }

    public static void modificarSala(String nombreActual, Sala sala) throws SQLException {
        abrirConexion();
        try {
            String sql = "UPDATE sala SET nombresala=?, filas=?, columnas=?, nombrepelicula_pelicula=? WHERE nombresala=?";
            try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
                preparedStatement.setString(1, sala.getNombreSala());
                preparedStatement.setInt(2, sala.getFilas());
                preparedStatement.setInt(3, sala.getColumnas());
                preparedStatement.setString(4, sala.getNombre_pelicula());
                preparedStatement.setString(5, nombreActual); // Condición para actualizar la película específica

                preparedStatement.executeUpdate();
            }
        } finally {
            cerrarConexion();
        }
    }

    public static void guardarEntrada(Entrada entrada) throws SQLException {
        abrirConexion();
        try {
            if (entrada != null) {
                String sql = "INSERT INTO Entrada (idEntrada, fecha, hora, fila, columna, nombreSala_Sala) VALUES (?, ?, ?, ?, ?, ?)";
                try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
                    preparedStatement.setString(1, entrada.getIdEntrada());
                    LocalDate localDate = entrada.getFecha().toLocalDate();
                    java.sql.Date fechaSQL = java.sql.Date.valueOf(localDate);

                    preparedStatement.setDate(2, fechaSQL);
                    preparedStatement.setString(3, entrada.getHora().toString()); // Almacenar LocalTime como String
                    preparedStatement.setInt(4, entrada.getFila());
                    preparedStatement.setInt(5, entrada.getColumna());
                    preparedStatement.setString(6, entrada.getNombreSala());

                    preparedStatement.executeUpdate();
                    System.out.println("La entrada se ha guarado correctmante");
                }
            } else {
                System.out.println("Error: Entrada es nula.");
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            cerrarConexion();
        }
    }

    public static List<Entrada> getAllEntradas() throws SQLException {
        abrirConexion();
        List<Entrada> entradas = new ArrayList<>();
        try {
            String sql = "SELECT * FROM Entrada";
            try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
                try (ResultSet resultSet = preparedStatement.executeQuery()) {
                    while (resultSet.next()) {
                        Entrada entrada = new Entrada(
                                resultSet.getString("idEntrada"),
                                new Fecha(resultSet.getString("fecha")),
                                resultSet.getTime("hora").toLocalTime(),
                                resultSet.getInt("fila"),
                                resultSet.getInt("columna"),
                                resultSet.getString("nombreSala_Sala")
                        );
                        entradas.add(entrada);
                    }
                }
            }
        } finally {
            cerrarConexion();
        }
        return entradas;
    }

    public static Entrada getEntradaPorId(String idEntrada) throws SQLException {
        abrirConexion();
        try {
            String sql = "SELECT * FROM Entrada WHERE idEntrada = ?";
            try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
                preparedStatement.setString(1, idEntrada);
                try (ResultSet resultSet = preparedStatement.executeQuery()) {
                    if (resultSet.next()) {
                        return new Entrada(
                                resultSet.getString("idEntrada"),
                                new Fecha(resultSet.getString("fecha")),
                                resultSet.getTime("hora").toLocalTime(),
                                resultSet.getInt("fila"),
                                resultSet.getInt("columna"),
                                resultSet.getString("nombreSala_Sala")
                        );
                    }
                }
            }
        } finally {
            cerrarConexion();
        }
        return null;
    }

    public static void borrarEntrada(Entrada entrada) throws SQLException {
        abrirConexion();
        try {
            String sql = "DELETE FROM Entrada WHERE idEntrada = ?";
            try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
                preparedStatement.setString(1, entrada.getIdEntrada());
                preparedStatement.executeUpdate();
            }
        } finally {
            cerrarConexion();
        }
    }

    public static void modificarEntrada(String idEntradaActual, Entrada nuevaEntrada) throws SQLException {
        abrirConexion();
        try {
            String sql = "UPDATE Entrada SET idEntrada=?, fecha=?, hora=?, fila=?, columna=?, nombreSala_Sala=? WHERE idEntrada=?";
            try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
                preparedStatement.setString(1, nuevaEntrada.getIdEntrada());
                LocalDate localDate = nuevaEntrada.getFecha().toLocalDate();
                java.sql.Date fechaSQL = java.sql.Date.valueOf(localDate);

                preparedStatement.setDate(2, fechaSQL);
                preparedStatement.setString(3, nuevaEntrada.getHora().toString()); // Almacenar LocalTime como String
                preparedStatement.setInt(4, nuevaEntrada.getFila());
                preparedStatement.setInt(5, nuevaEntrada.getColumna());
                preparedStatement.setString(6, nuevaEntrada.getNombreSala());

                preparedStatement.setString(7, idEntradaActual);

                preparedStatement.executeUpdate();
            }
        } finally {
            cerrarConexion();
        }
    }

    public static void guardarReserva(Reserva reserva) throws SQLException {
        abrirConexion();
        System.out.println("GuardarSala");
        try {
            if (reserva != null) {
                String sql = "INSERT INTO reserva (numeroref, email_usuario, identrada_entrada, fila_entrada, columna_entrada) VALUES (?, ?, ?, ?)";
                try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
                    preparedStatement.setString(1, reserva.getNumeroRef());
                    preparedStatement.setString(2, reserva.getEmail_usuario());
                    preparedStatement.setString(3, reserva.getId_entrada());
                    preparedStatement.setInt(4, reserva.getFila_entrada());
                    preparedStatement.setInt(5, reserva.getColumna_entrada());

                    preparedStatement.executeUpdate();
                    System.out.println("Reserva guardada correctamente.");
                }
            } else {
                System.out.println("Error: Reserva es nula.");
            }
        } catch (SQLException e) {
            System.err.println("Error al guardar la reserva: " + e.getMessage());
        } finally {
            cerrarConexion();
        }
    }

    public static List<Reserva> getAllReservas() throws SQLException {
        abrirConexion();
        List<Reserva> reservas = new ArrayList<>();
        try {
            String sql = "SELECT * FROM reserva";
            try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
                try (ResultSet resultSet = preparedStatement.executeQuery()) {
                    while (resultSet.next()) {
                        Reserva reserva = new Reserva(
                                resultSet.getString("numeroref"),
                                resultSet.getString("email_usuario"),
                                resultSet.getString("identrada_entrada"),
                                resultSet.getInt("fila_entrada"),
                                resultSet.getInt("columna_entrada")
                        );
                        reservas.add(reserva);
                    }
                }
            }
        } finally {
            cerrarConexion();
        }
        return reservas;
    }

    public static Reserva getReservaPorNumeroDeRef(String nombre) throws SQLException {
        abrirConexion();
        try {
            String sql = "SELECT * FROM reserva WHERE numeroref = ?";
            try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
                preparedStatement.setString(1, nombre);
                try (ResultSet resultSet = preparedStatement.executeQuery()) {
                    if (resultSet.next()) {
                        return new Reserva(
                                resultSet.getString("numeroref"),
                                resultSet.getString("email_usuario"),
                                resultSet.getString("identrada_entrada"),
                                resultSet.getInt("fila_entrada"),
                                resultSet.getInt("columna_entrada")
                        );
                    }
                }
            }
        } finally {
            cerrarConexion();
        }
        return null;
    }

    public static void borrarReserva(Reserva reserva) throws SQLException {
        abrirConexion();
        try {
            String sql = "DELETE FROM reserva WHERE numeroref = ?";
            try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
                preparedStatement.setString(1, reserva.getNumeroRef());
                preparedStatement.executeUpdate();
            }
        } finally {
            cerrarConexion();
        }
    }

    public static void modificarSala(String nombreActual, Reserva reserva) throws SQLException {
        abrirConexion();
        try {
            String sql = "UPDATE reserva SET numeroref=?, email_usuario=?, identrada_entrada=?, fila_entrada=?, columna_entrada=?  WHERE numeroref=?";
            try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
                preparedStatement.setString(1, reserva.getNumeroRef());
                preparedStatement.setString(2, reserva.getEmail_usuario());
                preparedStatement.setString(3, reserva.getId_entrada());
                preparedStatement.setInt(4, reserva.getFila_entrada());
                preparedStatement.setInt(5, reserva.getColumna_entrada());

                preparedStatement.setString(6, nombreActual); // Condición para actualizar la película específica

                preparedStatement.executeUpdate();
            }
        } finally {
            cerrarConexion();
        }
    }

    public static void guardarComentario(Comentario comentario) throws SQLException {
        abrirConexion();

        try {
            if (comentario != null) {
                String sql = "INSERT INTO comentario (texto, valoracion, fechacomentario, email_usuario, nombrepelicula_pelicula) VALUES (?, ?, ?, ?, ?)";
                try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
                    preparedStatement.setString(1, comentario.getTexto());
                    preparedStatement.setInt(2, comentario.getValoracion());
                    LocalDate localDate = comentario.getFecha().toLocalDate();
                    java.sql.Date fechaSQL = java.sql.Date.valueOf(localDate);
                    preparedStatement.setDate(3, fechaSQL);
                    preparedStatement.setString(4, comentario.getEmail_user());
                    preparedStatement.setString(5, comentario.getNombrePelicula());

                    preparedStatement.executeUpdate();
                    System.out.println("Comentario guardada correctamente.");
                }
            } else {
                System.out.println("Error: El comentario es nula.");
            }
        } catch (SQLException e) {
            System.err.println("Error al guardar el comentario: " + e.getMessage());
        } finally {
            cerrarConexion();
        }
    }

    public static List<Comentario> getAllComentario() throws SQLException {
        abrirConexion();
        List<Comentario> comentarios = new ArrayList<>();
        try {
            String sql = "SELECT * FROM comentario";
            try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
                try (ResultSet resultSet = preparedStatement.executeQuery()) {
                    while (resultSet.next()) {
                        Comentario comentario = new Comentario(
                                resultSet.getString("texto"),
                                resultSet.getInt("valoracion"),
                                new Fecha(resultSet.getString("fechacomentario")),
                                resultSet.getString("email_usuario"),
                                resultSet.getString("nombrepelicula_pelicula")
                        );
                        comentarios.add(comentario);
                    }
                }
            }
        } finally {
            cerrarConexion();
        }
        return comentarios;
    }

    public static List<Comentario> getComentariosPorNombrePelicula(String nombre) throws SQLException {
        abrirConexion();
        List<Comentario> comentarios = new ArrayList<>();
        try {
            String sql = "SELECT * FROM comentario WHERE nombrepelicula_pelicula = ?";
            try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
                preparedStatement.setString(1, nombre);
                try (ResultSet resultSet = preparedStatement.executeQuery()) {
                    while (resultSet.next()) {
                        Comentario comentario = new Comentario(
                                resultSet.getString("texto"),
                                resultSet.getInt("valoracion"),
                                new Fecha(resultSet.getString("fechacomentario")),
                                resultSet.getString("email_usuario"),
                                resultSet.getString("nombrepelicula_pelicula")
                        );
                        comentarios.add(comentario);
                    }
                }
            }
        } finally {
            cerrarConexion();
        }
        return comentarios;
    }

    public static void borrarComentarioDePelicula(Comentario comentario) throws SQLException {
        abrirConexion();
        try {
            String sql = "DELETE FROM comentario WHERE nombrepelicula_pelicula = ?";
            try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
                preparedStatement.setString(1, comentario.getNombrePelicula());
                preparedStatement.executeUpdate();
            }
        } finally {
            cerrarConexion();
        }
    }

    public static void modificarComentario(String nombreActual, Comentario comentario) throws SQLException {
        abrirConexion();
        try {
            String sql = "UPDATE comentario SET texto=?, valoracion=?, fechacomentario=?, email_usuario=?, nombrepelicula_pelicula= ?  WHERE nombrepelicula_pelicula=?";
            try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
                preparedStatement.setString(1, comentario.getTexto());
                preparedStatement.setInt(2, comentario.getValoracion());
                LocalDate localDate = comentario.getFecha().toLocalDate();
                java.sql.Date fechaSQL = java.sql.Date.valueOf(localDate);

                preparedStatement.setDate(3, fechaSQL);
                preparedStatement.setString(4, comentario.getEmail_user());
                preparedStatement.setString(5, comentario.getNombrePelicula());

                preparedStatement.setString(6, nombreActual); // Condición para actualizar la película específica

                preparedStatement.executeUpdate();
            }
        } finally {
            cerrarConexion();
        }
    }

    public static void guardarTarjeta(TarjetaCredito tarjeta) throws SQLException {
        abrirConexion();

        try {
            if (tarjeta != null) {
                String sql = "INSERT INTO tarjeta (numerotarjeta, nombretitular, fechaexpiracion, codigoseguridad, email_usuario) VALUES (?, ?, ?, ?, ?)";
                try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
                    preparedStatement.setString(1, tarjeta.getNumeroTarjeta());
                    preparedStatement.setString(2, tarjeta.getNombreTitular());
                    LocalDate localDate = tarjeta.getFecha().toLocalDate();
                    java.sql.Date fechaSQL = java.sql.Date.valueOf(localDate);
                    preparedStatement.setDate(3, fechaSQL);
                    preparedStatement.setString(4, tarjeta.getCodigoSeguridad());
                    preparedStatement.setString(5, tarjeta.getEmail_user());

                    preparedStatement.executeUpdate();
                    System.out.println("Comentario guardada correctamente.");
                }
            } else {
                System.out.println("Error: El comentario es nula.");
            }
        } catch (SQLException e) {
            System.err.println("Error al guardar el comentario: " + e.getMessage());
        } finally {
            cerrarConexion();
        }
    }

    public boolean validarTarjeta(String email, String numeroTarjeta, Fecha fechaExpiracion, String codigoSeguridad)
            throws ClassNotFoundException, SQLException {
        abrirConexion();
        // Establecer la conexión con la base de datos
        try {
            // Consulta SQL para verificar la tarjeta del usuario
            String sql = "SELECT * FROM tarjeta WHERE email_usuario = ? AND numerotarjeta = ? AND fechaexpiracion = ? AND codigoseguridad = ?";
            try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {

                LocalDate localDate = fechaExpiracion.toLocalDate();
                java.sql.Date fechaSQL = java.sql.Date.valueOf(localDate);

                preparedStatement.setString(1, email);
                preparedStatement.setString(2, numeroTarjeta);
                preparedStatement.setDate(3, fechaSQL);
                preparedStatement.setString(4, codigoSeguridad);

                try (ResultSet resultSet = preparedStatement.executeQuery()) {
                    // Si hay resultados, la tarjeta es válida
                    return resultSet.next();
                }
            }
        } finally {
            cerrarConexion();
        }
    }
}
