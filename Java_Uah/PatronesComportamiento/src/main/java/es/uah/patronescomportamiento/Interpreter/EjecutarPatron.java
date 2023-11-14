package es.uah.patronescomportamiento.Interpreter;

/**
 * Clase de prueba del patrón.
 *
 * @author Salvador Oton
 */
public class EjecutarPatron {

    public static void main(String[] args) {
        //creamos un contexto
        Contexto contexto = new Contexto();
        //introducimos las empresas
        contexto.añadirEmpresa("IBM");
        contexto.añadirEmpresa("Indra");
        contexto.añadirEmpresa("ONO");
        //y los empleados
        contexto.añadirEmpleado("Juan");
        contexto.añadirEmpleado("Marta");
        contexto.añadirEmpleado("Javier");
        //relacionamos empresas y empleados
        contexto.añadirEmpresayEmpleado(new EmpresayEmpleado("IBM", "Marta"));
        contexto.añadirEmpresayEmpleado(new EmpresayEmpleado("ONO", "Juan"));
        contexto.añadirEmpresayEmpleado(new EmpresayEmpleado("Indra", "Juan"));
        contexto.añadirEmpresayEmpleado(new EmpresayEmpleado("Indra", "Javier"));
        //creamos un intérprete para el cliente
        InterpreteCliente cliente = new InterpreteCliente(contexto);
        //ponemos casos de prueba
        System.out.println("EJEMPLO DE PATRON INTERPRETE");
        System.out.println();
        System.out.println("Interpretando -> muestra empleados:");
        cliente.interpreta("muestra empleados");
        System.out.println("Interpretando -> muestra empleados por empresas:");
        cliente.interpreta("muestra empleados por empresas");
        System.out.println("Interpretando -> muestra empresas:");
        cliente.interpreta("muestra empresas");
        System.out.println("Interpretando -> muestra empresas por empleados:");
        cliente.interpreta("muestra empresas por empleados");
    }
}
