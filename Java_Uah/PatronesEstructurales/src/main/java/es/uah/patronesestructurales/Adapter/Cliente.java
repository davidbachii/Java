package es.uah.patronesestructurales.Adapter;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Clase que prueba el adaptador de fechas.
 */
public class Cliente {

    /**
     * Método de arranque del programa.
     *
     * @param args
     * @throws java.io.IOException Excepción que provee información de errores
     * de entrada/salida de datos.
     */
    public static void main(String args[]) throws IOException {
        BufferedReader entrada = new BufferedReader(new InputStreamReader(System.in));

        Fecha fecha;

        String f;

        System.out.println("Introduce fecha en formato de USA (MM,DD,AAAA): ");
        f = entrada.readLine();
        fecha = new AdaptadorFecha(new FechaUS(f));
        System.out.println("Fecha adaptada en formato ES:");
        System.out.println(fecha.toString());
    }
}
