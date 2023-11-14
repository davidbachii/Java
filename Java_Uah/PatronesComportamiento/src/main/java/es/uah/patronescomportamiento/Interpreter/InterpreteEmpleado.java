package es.uah.patronescomportamiento.Interpreter;

import java.util.ArrayList;
import java.util.ListIterator;

/**
 * Muestra los empleados
 *
 * @author Salvador Oton
 */
public class InterpreteEmpleado implements Interprete {

    @Override
    public void interpretar(Contexto contexto) {
        ArrayList<String> empleados = contexto.getEmpleados();      //empleados
        ListIterator iteradorEmpleados = empleados.listIterator();  //iterador
        System.out.print("Empleados: ");
        while (iteradorEmpleados.hasNext()) {
            System.out.print((String) iteradorEmpleados.next() + ", ");
        }
        System.out.println("");
        System.out.println("");
    }
}
