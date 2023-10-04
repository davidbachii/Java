package es.uah.patronescreacion.Singleton.ObjectPool;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * Conexión con la base de datos a través de la piscina de objetos (Object Pool)
 */
public class JDBCConexion {

    /**
     * Nombre de la base de datos.
     */
    private String nombreBD;
    /**
     * Piscina o pool de objetos.
     */
    private JDBCConexionImpl.JDBCPool piscinaConexiones;
    /**
     * Conexión.
     */
    private JDBCConexionImpl impl;
    /**
     * Sentencia SQL.
     */
    private Statement stmt;
    /**
     * Tabla de datos resultado de ejecutar una consulta SQL.
     */
    private ResultSet rs;
    /**
     * Flag para comprobar si hay una petición abierta.
     */
    private boolean enUso;

    /**
     * Constructor
     *
     * @param nombreBD Nombre de la base de datos.
     */
    public JDBCConexion(String nombreBD) {
        this.nombreBD = nombreBD; // Establece el nombre de la base de datos.
        piscinaConexiones = JDBCConexionImpl.JDBCPool.getInstancia();//Obtiene la instancia al pool de conexiones.
        enUso = false;
    }

    /**
     * Envia petición a la base de datos.
     *
     * @param sqlString Sentencia SQL.
     * @throws SQLException Excepción que provee información de error en el
     * acceso a base de datos.
     * @throws ClassNotFoundException Excepción que provee información de error
     * en la carga de una clase.
     * @throws ErrorPiscina Excepción que informa de que no hay conexiones
     * libres.
     */
    void enviarPeticion(String sqlString) throws SQLException, ClassNotFoundException, ErrorPiscina {
        if (enUso) { // Si hay una petición abierta...
            cerrarPeticion(); // Cierra la petición.
        }
        impl = piscinaConexiones.obtenerImpl(nombreBD); // Obtiene conexión de la piscina.
        stmt = impl.getConexion().createStatement(); // Crea sentencia SQL.
        boolean hayResultados = stmt.execute(sqlString); // Ejecuta sentencia SQL.
        if (hayResultados) { // Si hay resultados...
            rs = stmt.getResultSet();// Recupera tabla de resultados.
        } else {
            rs = null;
        }
        enUso = true; // Marca que hay una petición abierta.
    }

    /**
     * Devuelve el ResultSet resultado de la consulta a la BD.
     *
     * @return
     */
    ResultSet getRs() {
        return rs;
    }

    /**
     * Cierra la petición y libera recursos.
     *
     * @throws SQLException Excepción que provee información de error en el
     * acceso a base de datos.
     */
    void cerrarPeticion() throws SQLException {
        rs.close(); //Cierra ResultSet.
        stmt.close(); //Cierra Statement (sentencia SQL).
        piscinaConexiones.devolverImpl(impl); // Libera conexión.
        enUso = false;// Marca petición como cerrada.
    }

    /**
     * Libera los recursos cuando el objeto es destruido.
     *
     * @throws SQLException Excepción que provee información de error en el
     * acceso a base de datos.
     */
    protected void finalizar() throws SQLException {
        if (enUso) {
            cerrarPeticion();
        }
    }
}
