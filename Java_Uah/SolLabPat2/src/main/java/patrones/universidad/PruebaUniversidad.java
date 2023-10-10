package patrones.universidad;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class PruebaUniversidad {

    public static void main(String[] args) throws IOException {

        BufferedReader entrada = new BufferedReader(new InputStreamReader(System.in));
        Universidad miUniversidad;
        MenuUniversidad menu;
        boolean salir = false;                

        System.out.println("\nIntroduce nombre universidad: ");
        String nombre = entrada.readLine();

        miUniversidad = new Universidad(nombre);
        menu = new MenuUniversidad(miUniversidad);
        while (!salir) {
            salir = menu.menuPrincipal();
        }

    }
}