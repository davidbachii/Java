package es.uah.patronesestructurales.Proxy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Cliente: Utiliza la interfaz de la clase proxy para hacer uso de la clase
 * real.
 */
public class Cliente {

    private static BufferedReader entrada = new BufferedReader(new InputStreamReader(System.in));
    /**
     * Instancia el proxy pasándole en la construcción la referencia al servidor
     * real.
     */
    private static Servidor proxy = new Proxy(new ServidorFicheros("MiServidor"));

    /**
     * Método de arranque del programa.
     *
     * @param args
     */
    public static void main(String args[]) {
        String res, nom, id;

        while (true) {
            try {
                do {
                    System.out.println("\n\n--- Operaciones del Servidor ---");
                    System.out.println(" 1 - Subir fichero. ");
                    System.out.println(" 2 - Bajar fichero. ");
                    System.out.println(" 3 - Listado ficheros. ");
                    System.out.println(" 4 - Salir. ");
                    System.out.print(" Seleccione la operación: ");
                    res = entrada.readLine();
                } while (!res.equals("1") && !res.equals("2")
                        && !res.equals("3") && !res.equals("4"));

                // subir
                switch (res) {
                    case "1":
                        System.out.println("\n -- Subir fichero -- ");
                        System.out.print("Introduzca nombre fichero: ");
                        nom = entrada.readLine();
                        System.out.println(proxy.subir(nom));
                        break;
                    case "2":
                        System.out.println("\n -- Bajar fichero -- ");
                        System.out.println(proxy.listado());
                        System.out.print("Introduzca id del fichero: ");
                        id = entrada.readLine();
                        Fichero fich = proxy.bajar(id);
                        System.out.println((fich != null) ? "Fichero bajado: " + fich.toString() : "El fichero no existe.");
                        break;
                    case "3":
                        System.out.println("\n -- Listado ficheros -- ");
                        System.out.println(proxy.listado());
                        break;
                    case "4":
                        System.exit(0);
                }
            } catch (NumberFormatException nfe) {
                System.out.println("\nError de formato numérico: " + nfe.toString());
            } catch (IOException ioe) {
                System.out.println("\nError de entrada/salida: " + ioe.toString());
            }
        }
    }
}
