package es.uah.patronescreacion.AbstractFactory;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Clase para probar el patrón de fechas (cliente).
 */
public class PruebaPatron {

    /**
     * Método de arranque del programa.
     *
     * @param args
     * @throws IOException
     */


    public static void main(String args[]) throws IOException {
        BufferedReader entrada = new BufferedReader(new InputStreamReader(System.in));
        FechaFactory factory;
        FechaTexto ft;
        FechaNum fn;
        String formato, pais;

        // Leemos de la entrada estándar el formato de la fecha.
        System.out.println("Selecciona formato fecha (T/N): ");
        System.out.println("(T - formato de texto, N - formato numérico)");
        formato = entrada.readLine().toUpperCase();
        // Leemos de la entrada estándar el formato de la fecha.
        System.out.println("Selecciona pais fecha (E/U): ");
        System.out.println("(E: España, U: USA)");
        pais = entrada.readLine().toUpperCase();
        // Creamos en cada caso la factoría concreta de fechas correspondiente al país.
        switch (pais) {
            case "E": // País España
                factory = new SPFechaFactory();// Creamos factoría concreta para España.
                switch (formato) {
                    case "T": // Formato texto.
                        ft = factory.creaFechaTexto(); // Creamos fecha concreta de tipo texto.
                        System.out.println(ft.presentaFT());
                        break;
                    case "N": // Formato numérico.
                        fn = factory.creaFechaNum(); // Creamos fecha concreta de tipo numérico.
                        System.out.println(fn.presentaFN());
                        break;
                    default: // Formato incorrecto.
                        System.out.println("Formato incorrecto.");
                        System.exit(0);
                }
                break;
            case "U": // País USA
                factory = new USFechaFactory(); // Creamos factoría concreta para USA.
                switch (formato) {
                    case "T": // Formato texto.
                        ft = factory.creaFechaTexto(); // Creamos fecha concreta de tipo texto.
                        System.out.println(ft.presentaFT());
                        break;
                    case "N": // Formato numérico.
                        fn = factory.creaFechaNum(); // Creamos fecha concreta de tipo numérico.
                        System.out.println(fn.presentaFN());
                        break;
                    default: // Formato incorrecto.
                        System.out.println("Formato incorrecto.");
                        System.exit(0);
                }
                break;
            default: // País incorrecto.
                System.out.println("Pais incorrecto.");
                System.exit(0);
        }
    }
}
