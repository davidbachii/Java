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

public class DatabaseManager {

    private static final String DB_URL = "jdbc:derby://localhost:1527/ContenidoMultimedia;user=app;password=app";
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
                    preparedStatement.setString(5, user.getFecha().toString());
                    // Obtén la fecha del usuario y conviértela a java.sql.Date

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
        Usuario user = null;
        try {
            String sql = "SELECT email, contrasenha FROM usuario WHERE email = ?";
            try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
                preparedStatement.setString(1, correo);
                try (ResultSet resultSet = preparedStatement.executeQuery()) {
                    if (resultSet.next()) {
                        String email = resultSet.getString("email");
                        String contraseña = resultSet.getString("contrasenha");
                        user = new Usuario(null, null, contraseña, correo, null);
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            cerrarConexion();
        }
        return user;
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

    public static ArrayList<Pelicula> getPeliculasPorNombre(String nombre) throws SQLException {
        abrirConexion();
        try {
            String sql = "SELECT * FROM pelicula WHERE nombrepelicula = ?";
            try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
                preparedStatement.setString(1, nombre);
                try (ResultSet resultSet = preparedStatement.executeQuery()) {
                    ArrayList<Pelicula> peliculas = new ArrayList<>();
                    while (resultSet.next()) {
                        peliculas.add(new Pelicula(
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
                        ));
                    }
                    return peliculas;
                }
            }
        } finally {
            cerrarConexion();
        }
    }

    public static ArrayList<Pelicula> getPeliculasPorGenero(String genero) throws SQLException {
        abrirConexion();
        try {
            String sql = "SELECT * FROM pelicula WHERE genero = ?";
            try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
                preparedStatement.setString(1, genero);
                try (ResultSet resultSet = preparedStatement.executeQuery()) {
                    ArrayList<Pelicula> peliculas = new ArrayList<>();
                    while (resultSet.next()) {
                        peliculas.add(new Pelicula(
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
                        ));
                    }
                    return peliculas;
                }
            }
        } finally {
            cerrarConexion();
        }
    }

    public static ArrayList<Pelicula> getPeliculasPorNacionalidad(String nacionalidad) throws SQLException {
        abrirConexion();
        try {
            String sql = "SELECT * FROM pelicula WHERE nacionalidad = ?";
            try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
                preparedStatement.setString(1, nacionalidad);
                try (ResultSet resultSet = preparedStatement.executeQuery()) {
                    ArrayList<Pelicula> peliculas = new ArrayList<>();
                    while (resultSet.next()) {
                        peliculas.add(new Pelicula(
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
                        ));
                    }
                    return peliculas;
                }
            }
        } finally {
            cerrarConexion();
        }
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

    public static void guardarComentario(Comentario comentario) throws SQLException {
        abrirConexion();

        try {
            if (comentario != null) {
                String sql = "INSERT INTO comentario (texto, valoracion, fechacomentario, email_usuario, nombrepelicula_pelicula) VALUES (?, ?, ?, ?, ?)";
                try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
                    preparedStatement.setString(1, comentario.getTexto());
                    preparedStatement.setInt(2, comentario.getValoracion());

                    preparedStatement.setString(3, comentario.getFecha().toString());
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
            String sql = "SELECT texto, valoracion, email_usuario FROM comentario";
            try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
                try (ResultSet resultSet = preparedStatement.executeQuery()) {
                    while (resultSet.next()) {
                        Comentario comentario = new Comentario(
                                resultSet.getString("texto"),
                                resultSet.getInt("valoracion"),
                                null, // Fecha del comentario
                                resultSet.getString("email_usuario"),
                                null // Nombre de la película
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
                                null, // Fecha del comentario
                                resultSet.getString("email_usuario"),
                                null // Nombre de la película
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

    public static void borrarComentarioDePelicula(String nombrePelicula) throws SQLException {
        abrirConexion();
        try {
            String sql = "DELETE FROM comentario WHERE nombrepelicula_pelicula = ?";
            try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
                preparedStatement.setString(1, nombrePelicula);
                preparedStatement.executeUpdate();
            }
        } finally {
            cerrarConexion();
        }
    }

}
