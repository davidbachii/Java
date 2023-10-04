package es.uah.patronescreacion.Singleton.ObjectPool;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;

/**
 * Cliente de la piscina de objetos OP (Object Pool)
 */
public class ClienteOP {

    /**
     * Conexión con la base de datos a través del OP
     */
    static JDBCConexion conexion;
    /**
     * Tabla de datos resultado de ejecutar una consulta SQL.
     */
    static ResultSet resultado;
    /**
     * Formato de la tabla de datos
     */
    static ResultSetMetaData tabla;
    /**
     * Entrada estándar para lectura de datos.
     */
    static BufferedReader entrada = new BufferedReader(new InputStreamReader(System.in));
    /**
     * Cadena con la consulta SQL
     */
    static String sqlQuery;

    /**
     * Método de arranque del programa.
     *
     * @param args
     */
    public static void main(String[] args) {
        // Conexión con la base de datos a través de la piscina de objetos (Object Pool)
        conexion = new JDBCConexion("access");

        try {
            do {
                System.out.println("\nIntroduzca una consulta SQL (o salir):\n");
                sqlQuery = entrada.readLine();
                if (sqlQuery.toLowerCase().equals("salir")) {
                    conexion.finalizar(); // Libera la conexión
                    System.out.println("\nConexi�n cerrada.");
                    System.exit(0);
                }
                // Envia petición a la base de datos.
                conexion.enviarPeticion(sqlQuery);

                // Obtenemos resultado de la consulta.
                resultado = conexion.getRs();
                // Obtenemos descripción de las columnas del resultado.
                tabla = resultado.getMetaData();

                // Mostramos los datos por pantalla
                if (resultado != null) {
                    imprimirResultados();
                } else {
                    System.out.println("\nSentencia ejecutada.");
                }

                //Cerramos la conexión liberando recursos.
                conexion.cerrarPeticion();
            } while (true);//fin del do-while
        } catch (IOException | SQLException | ClassNotFoundException | ErrorPiscina e) {
            System.out.println("Error.");
            System.out.println(e.getMessage());
        }//fin del try-catch
    }//fin de la función

    /**
     * Muestra por pantalla el resultado de la consulta.
     *
     * @throws SQLException Excepción que provee información de error en el
     * acceso a base de datos.
     */
    static public void imprimirResultados() throws SQLException {
        int numeroColumnas, i;
        numeroColumnas = tabla.getColumnCount();
        System.out.println("\n\n***** Resultado de la consulta *****");
        for (i = 1; i <= numeroColumnas; i++) {
            System.out.print(tabla.getColumnLabel(i) + "\t");
        }//fin del for
        System.out.println("\n");
        while (resultado.next()) {
            for (i = 1; i <= numeroColumnas; i++) {
                System.out.print(resultado.getString(i) + "\t");
            }//fin del for
            System.out.println("");
        }//fin del while
        System.out.println("\n\n");
    }//fin de  la función
}
