package es.uah.patronescreacion.Singleton;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Clase que maneja el control de entrada de los usuarios.
 */
public class ControlEntrada {

    /**
     * Entrada estándar para lectura de datos.
     */
    private static BufferedReader entrada = new BufferedReader(new InputStreamReader(System.in));
    private static String usuario, res;

    /**
     * Método de arranque del programa.
     *
     * @param args
     */
    public static void main(String args[]) {
        ContadorLogin contador = ContadorLogin.getInstancia();// Obtiene la instancia del contador de login.
        while (true) {
            try {
                do {
                    System.out.println("\n\n--- Operaciones ---");
                    System.out.println(" 1 - Login. ");
                    System.out.println(" 2 - Logout. ");
                    System.out.println(" 3 - Salir. ");
                    System.out.print(" Seleccione la operación: ");
                    res = entrada.readLine();
                } while (!res.equals("1") && !res.equals("2") && !res.equals("3"));

                switch (res) {
                    case "1": //Login.
                        System.out.println("\n -- Login -- ");
                        System.out.print("Introduzca usuario: ");
                        usuario = entrada.readLine();
                        if (contador.estaLogado(usuario)) {
                            System.out.println("Ya se ha logado en el sistema.");
                        } else {
                            contador.addLogin(usuario);
                            System.out.println("Bienvenido al sistema");
                        }
                        break;
                    case "2": //Logout.
                        System.out.println("\n -- Logout -- ");
                        System.out.print("Introduzca usuario: ");
                        usuario = entrada.readLine();
                        if (contador.estaLogado(usuario)) {
                            contador.borrarLogin(usuario);
                            System.out.println("El usuario ha salido del sistema.");
                        } else {
                            System.out.println("El usuario no estaba logado en el sistema.");
                        }
                        break;
                    case "3": //Fin del programa.
                        System.exit(0);
                }
            } catch (IOException ioe) {
                System.out.println("\nError de entrada/salida: " + ioe.toString());
            }
        }
    }
}
