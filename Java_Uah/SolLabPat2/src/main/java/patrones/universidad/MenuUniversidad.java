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

    public char mostrarMenuPrincipal() throws IOException {
        System.out.println();
        System.out.println("Universidad " + _universidad.getNombre());
        System.out.println("1 - Gestion de PAS");
        System.out.println("2 - Gestion de PDI");
        System.out.println("3 - Generar nóminas");
        System.out.println("4 - Mostrar personal");
        System.out.println("5 - Salir");
        System.out.println();
        System.out.println("Seleccione una opcion...");
        char opcion = ' ';
        while (true) {
            opcion = _entrada.readLine().charAt(0);
            if ((opcion >= '1') && (opcion <= '5')) {
                return opcion;
            } else {
                System.out.println("\nERROR: Opcion incorrecta\n");
                mostrarMenuPrincipal();
            }
        }
    }

    public char mostrarMenuPersonal(String tipo) throws IOException {
        System.out.println();
        System.out.println("Gestion de " + tipo);
        System.out.println("1 - Contratar " + tipo);
        System.out.println("2 - Jubilar " + tipo);
        System.out.println("3 - Modificar " + tipo);
        System.out.println("4 - Mostrar todos los " + tipo);
        System.out.println("5 - Salir");
        System.out.println();
        System.out.println("Seleccione una opcion...");
        char opcion = ' ';
        while (true) {
            opcion = _entrada.readLine().charAt(0);
            if ((opcion >= '1') && (opcion <= '5')) {
                return opcion;
            } else {
                System.out.println();
                System.out.println("ERROR: Opcion incorrecta");
                System.out.println();
                mostrarMenuPersonal(tipo);
            }
        }
    }

    public boolean menuPrincipal() {
        try {
            boolean correcta = false, salir = false;
            char opcion = mostrarMenuPrincipal();

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
                    System.out.println("Nóminas:\n"+_universidad.generarNominas());
                    break;
                case '4':
                    mostrar();
                    break;
                case '5':
                    salir = true;
            }

            return salir;
        } catch (NumberFormatException nfe) {
            System.out.println("\nError de formato numérico: " + nfe.toString());
            return false;
        } catch (IOException ioe) {
            System.out.println("\nError de entrada/salida: " + ioe.toString());
            return false;
        } catch (Exception e) {
            System.out.println("Excepción: " + e.toString());
            return false;
        }
    }
    
    public void mostrar() {
        System.out.println("--------------------------------------------");
        System.out.println("Universidad " + _universidad.getNombre());
        System.out.println("--------------------------------------------");
        System.out.println(_universidad.obtenerPASs().toString());
        System.out.println("--------------------------------------------");
        System.out.println(_universidad.obtenerPDIs().toString());
        System.out.println("--------------------------------------------");
    }

    public boolean menuPAS() throws IOException {
        char opcion = ' ';
        boolean correcta = false, salir = false;
        int identificador;
        String seccion, cargo;

       opcion = mostrarMenuPersonal("PAS");

        switch (opcion) {
            case '1':
                System.out.println("Identificador del nuevo PAS:(numero) ");
                identificador = (Integer.parseInt(_entrada.readLine()));
                System.out.println("Seccion: ");
                seccion = _entrada.readLine();
                System.out.println("Cargo: ");
                cargo = _entrada.readLine();
                _universidad.contratarPAS(identificador, seccion, cargo);
                break;
            case '2':
                System.out.println("Introduzca el numero identificador del PAS a jubilar:");
                identificador = (Integer.parseInt(_entrada.readLine()));
                _universidad.jubilarPAS(identificador);
                break;
            case '3':
                System.out.println("Introduzca el numero identificador del PAS a modificar:");
                identificador = (Integer.parseInt(_entrada.readLine()));
                System.out.println("Nueva Seccion: ");
                seccion = _entrada.readLine();
                System.out.println("Nuevo Cargo: ");
                cargo = _entrada.readLine();
                _universidad.modificarPAS(identificador, seccion, cargo);
                break;
            case '4':
                System.out.println(_universidad.obtenerPASs().toString());
                break;
            case '5':
                salir = true;
        }

        return salir;
    }

    public boolean menuPDI() throws IOException {
        char opcion = ' ';
        boolean salir = false;
        int identificador;
        String departamento, area;
        opcion = mostrarMenuPersonal("PDI");

        switch (opcion) {
            case '1':
                System.out.println("Identificador del nuevo PDI:(numero) ");
                identificador = (Integer.parseInt(_entrada.readLine()));
                System.out.println("Departamento: ");
                departamento = _entrada.readLine();
                System.out.println("Area: ");
                area = _entrada.readLine();
                _universidad.contratarPDI(identificador, departamento, area);
                break;
            case '2':
                System.out.println("Introduzca el numero identificador del PDI a jubilar:");
                identificador = (Integer.parseInt(_entrada.readLine()));
                _universidad.jubilarPDI(identificador);
                break;
            case '3':
                System.out.println("Introduzca el numero identificador del PDI a modificar:");
                identificador = (Integer.parseInt(_entrada.readLine()));
                System.out.println("Nuevo departamento:");
                departamento = _entrada.readLine();
                System.out.println("Nueva area:");
                area = _entrada.readLine();
                _universidad.modificarPDI(identificador, departamento, area);
                break;
            case '4':
                System.out.println(_universidad.obtenerPDIs().toString());
                break;
            case '5':
                salir = true;
        }

        return salir;
    }
}
