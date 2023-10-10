package patrones.universidad;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class MenuUniversidad {

    private Universidad _universidad;
    private BufferedReader _entrada = new BufferedReader(new InputStreamReader(System.in));

    public MenuUniversidad(Universidad universidad) {
        _universidad = universidad;        
    }

    public void mostrarMenuPrincipal() {
        System.out.println();
        System.out.println("Universidad " + _universidad.getNombre());
        System.out.println("1 - Gestion de PAS");
        System.out.println("2 - Gestion de PDI");
        System.out.println("3 - Generar nóminas");
        System.out.println("4 - Mostrar personal");
        System.out.println("5 - Salir");
        System.out.println();
        System.out.println("Seleccione una opcion...");
    }

    public void mostrarMenuPAS() {
        System.out.println();
        System.out.println("Gestion de PAS");
        System.out.println("1 - Contratar PAS");
        System.out.println("2 - Jubilar PAS");
        System.out.println("3 - Modificar PAS");
        System.out.println("4 - Mostrar todos los PAS");
        System.out.println("5 - Salir");
        System.out.println();
        System.out.println("Seleccione una opcion...");
    }

    public void mostrarMenuPDI() {
        System.out.println();
        System.out.println("Gestión de PDI");
        System.out.println("1 - Contratar PDI");
        System.out.println("2 - Jubilar PDI");
        System.out.println("3 - Modificar PDI");
        System.out.println("4 - Mostrar todos los PDI");
        System.out.println("5 - Salir");
        System.out.println();
        System.out.println("Seleccione una opcion...");
    }

    public boolean menuPrincipal() throws IOException {
        char opcion;
        boolean correcta, salir;

        salir = false;
        correcta = false;
        opcion = ' ';
        mostrarMenuPrincipal();
        while (!correcta) {
            opcion = _entrada.readLine().charAt(0);           
            if ((opcion >= '1') && (opcion <= '5')) {
                correcta = true;
            } else {
                System.out.println();
                System.out.println("ERROR: Opcion incorrecta");
                System.out.println();
                mostrarMenuPrincipal();
            }
        }

        switch (opcion) {
            case '1':
                while (!salir) {
                    salir = menuPAS();
                }
                salir = false;
                break;
            case '2':
                while (!salir) {
                    salir = menuPDI();
                }
                salir = false;
                break;
            case '3':
                _universidad.generarNominas();
                break;
            case '4':
                _universidad.mostrar();
                break;
            case '5':
                salir = true;
        }

        return salir;
    }

    public boolean menuPAS() throws IOException {
        char opcion;
        boolean correcta, salir;

        salir = false;
        correcta = false;
        opcion = ' ';
        mostrarMenuPAS();
        while (!correcta) {
            opcion = _entrada.readLine().charAt(0);            
            if ((opcion >= '1') && (opcion <= '5')) {
                correcta = true;
            } else {
                System.out.println();
                System.out.println("ERROR: Opcion incorrecta");
                System.out.println();
                mostrarMenuPAS();
            }
        }

        switch (opcion) {
            case '1':
                _universidad.contratarPAS();
                break;
            case '2':
                _universidad.jubilarPAS();
                break;
            case '3':
                _universidad.modificarPAS();
                break;
            case '4':
                _universidad.mostrarPASs();
                break;
            case '5':
                salir = true;
        }

        return salir;
    }

    public boolean menuPDI() throws IOException {
        char opcion;
        boolean correcta, salir;

        salir = false;
        correcta = false;
        opcion = ' ';
        mostrarMenuPDI();
        while (!correcta) {
            opcion = _entrada.readLine().charAt(0);             
            if ((opcion >= '1') && (opcion <= '5')) {
                correcta = true;
            } else {
                System.out.println();
                System.out.println("ERROR: Opcion incorrecta");
                System.out.println();
                mostrarMenuPDI();
            }
        }

        switch (opcion) {
            case '1':
                _universidad.contratarPDI();
                break;
            case '2':
                _universidad.jubilarPDI();
                break;
            case '3':
                _universidad.modificarPDI();
                break;
            case '4':
                _universidad.mostrarPDIs();
                break;
            case '5':
                salir = true;
        }

        return salir;
    }
}
