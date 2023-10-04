package es.uah.patronescreacion.Singleton.ObjectPool;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;

/**
 * Clase en la que se crean los objetos de tipo Connection reusables.
 */
public class JDBCConexionImpl {

    /**
     * Nombre de la de la base de datos que se usa como identificador único para
     * una base de datos en particular.
     */
    private String nombreBD;
    /**
     * Conexion con la base de datos.
     */
    private Connection con;

    /**
     * Constructor privado. Solo accesible desde esta clase.
     *
     * @param nombreBD Nombre de la base de datos.
     * @throws SQLException Excepción que provee información de error en el
     * acceso a base de datos.
     * @throws ClassNotFoundException Excepción que provee información de error
     * en la carga de una clase.
     */
    private JDBCConexionImpl(String nombreBD) throws SQLException, ClassNotFoundException {
        this.nombreBD = nombreBD;

        //Código para crear la conexión a Access.
        if (nombreBD.equals("access")) {
            //Cargamos el driver
            Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
            //Hacemos la conexión
            con = DriverManager.getConnection("jdbc:odbc:AccessODBC", "", "");
            return;
        }

        //Si no se encuentra el driver de la base de datos lanzamos excepción
        throw new ClassNotFoundException();
    }

    /**
     * Devuelve el nombre de la base de datos.
     *
     * @return Nombre de la base de datos.
     */
    String getNombreBD() {
        return nombreBD;
    }

    /**
     * Devuelve el objeto conexion para acceder a la base de datos.
     *
     * @return Conexion con la base de datos.
     */
    Connection getConexion() {
        return con;
    }

    /**
     * Clase interna para el manejo del pool de conexiones. Implementa el patrón
     * Singleton.
     */
    static class JDBCPool {

        /**
         * Diccionario de nombres de base de datos con su correspondiente vector
         * de conexiones. Son pares (clave, valor) de la forma (nombreBD, vector
         * de conexiones).
         */
        private HashMap tablaPiscinas = new HashMap();
        /**
         * Instancia de la clase.
         */
        private static JDBCPool _instancia;
        /**
         * Tamaño máximo del pool o piscina.
         */
        private final int maxTamPiscina = 50;
        /**
         * Contador de objetos en el pool o piscina.
         */
        private static int contObjPiscina = 0;

        /**
         * Constructor privado.
         */
        private JDBCPool() {
        }

        /**
         * Devuelve la instancia de la clase. Singleton.
         *
         * @return Instancia de la clase.
         */
        public static JDBCPool getInstancia() {
            // Bloqueo sobre la clase para evitar problemas de concurrencia: solamente un subproceso puede acceder a JDBCPool.class.
            synchronized (JDBCPool.class) {
                if (_instancia == null) {
                    _instancia = new JDBCPool();
                }
            }
            return _instancia;
        }

        /**
         * Obtiene o extrae una conexión de la piscina.
         *
         * @param nombreBD Nombre de la base de datos.
         * @return Conexión.
         * @throws SQLException Excepción que provee información de error en el
         * acceso a base de datos.
         * @throws ClassNotFoundException Excepción que provee información de
         * error en la carga de una clase.
         * @throws ErrorPiscina Excepción que informa de que no hay conexiones
         * libres.
         */
        public synchronized JDBCConexionImpl obtenerImpl(String nombreBD) throws
                SQLException, ClassNotFoundException, ErrorPiscina {
            // Obtenemos la piscina correspondiente a la base de datos de la tabla de piscinas.
            ArrayList pool = (ArrayList) tablaPiscinas.get(nombreBD);

            if (pool != null) {// Si la piscina de conexiones no está vacía...
                int size = pool.size();// Obtenemos tamaño de la piscina.
                System.out.println("### Tamanio inicial de la piscina:" + size);
                if (size > 0) { // Si hay conexiones...
                    // Obtenemos una conexión de la piscina.
                    JDBCConexionImpl impl = (JDBCConexionImpl) pool.get(size - 1);
                    // Quitamos la conexion de la piscina.
                    pool.remove(size - 1);
                    System.out.println(" * OBTENEMOS UNA CONEXION DE LA PISCINA");
                    System.out.println("###	Tamanio final de la piscina: " + pool.size());
                    return impl;
                }
            }

            // Si la piscina esta vacía...
            if (contObjPiscina < maxTamPiscina) {// Si no se ha alcanzado el máximo de conexiones, creamos una. 
                System.out.println("\n * CREAMOS UNA NUEVA CONEXION");
                contObjPiscina++;
                return new JDBCConexionImpl(nombreBD);
            } else { // Si se ha alcanzado el número máximo de conexiones lanzamos excepción. 
                throw new ErrorPiscina("\nNúmero máximo de conexiones alcanzadas para " + nombreBD);
            }
        }

        /**
         * Retorna una conexión de vuelta a la piscina. La conexión se libera
         * para que pueda ser usada de nuevo.
         *
         * @param impl Conexión
         */
        public synchronized void devolverImpl(JDBCConexionImpl impl) {
            // Obtenemos el nombre de la base de datos de la conexión.
            String nombreBD = impl.getNombreBD();
            // Obtenemos la piscina correspondiente a la base de datos a partir de su nombre.
            ArrayList pool = (ArrayList) tablaPiscinas.get(nombreBD);
            // Si la piscina para la base de datos no existe, la creamos.
            if (pool == null) {
                pool = new ArrayList(); // Crea piscina.
                tablaPiscinas.put(nombreBD, pool); // Añade piscina a tabla de piscinas.
            }
            System.out.println("### Tamanio inicial piscina: " + pool.size());
            pool.add(impl); // Añade conexión a la piscina.
            System.out.println("* GUARDAMOS LA NUEVA CONEXION EN LA PISCINA");
            System.out.println("### Tamanio final piscina: " + pool.size());
        }
    }
}
