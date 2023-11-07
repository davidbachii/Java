package es.uah.patronesestructurales.Composite;

/**
 * Cliente. Prueba del patrón composite.
 */
public class PruebaEmpleados {

    /**
     * Método de arranque del programa.
     *
     * @param args
     */
    public static void main(String args[]) {
        Empleado e1 = new Empleado("programador1", 800);
        Empleado e2 = new Empleado("programador2", 1200);
        Empleado e3 = new Empleado("programador3", 900);
        Empleado e4 = new Empleado("programador4", 1100);
        Jefe j1 = new Jefe("analista1", 1500);
        Jefe j2 = new Jefe("analista2", 1500);
        Jefe j3 = new Jefe("jefe proyecto", 2000);

        j1.añadirSubordinado(e1);
        j1.añadirSubordinado(e2);
        j2.añadirSubordinado(e3);
        j2.añadirSubordinado(e4);
        j3.añadirSubordinado(j1);
        j3.añadirSubordinado(j2);

        System.out.println("Empleados:\n" + j3.getDescripcion());
        System.out.println("\nSalarios: " + j3.getSalarios());
    }
}
