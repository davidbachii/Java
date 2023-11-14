package es.uah.patronescomportamiento.Interpreter;

import java.util.ArrayList;
import java.util.ListIterator;

/**
 * Muestra las empresas por empleado
 *
 * @author Salvador Oton
 */
public class InterpreteEmpresaEmpleado implements Interprete {

    @Override
    public void interpretar(Contexto contexto) {
        //seleccionamos los empleados
        ArrayList<String> empleados = contexto.getEmpleados();
        ListIterator iteradorEmpleados = empleados.listIterator();
        //mientras haya empleadoes...
        while (iteradorEmpleados.hasNext()) {
            String empleado = (String) iteradorEmpleados.next();
            System.out.println("Empleado: " + empleado);
            //obtenemos las empresas en los que ha trabajado
            ArrayList<String> empleadosyempresas = contexto.getEmpresasPorEmpleado(empleado);
            ListIterator iteradorEmpresasyEmpleados = empleadosyempresas.listIterator();
            //los mostramos
            System.out.print("Empresas: ");
            while (iteradorEmpresasyEmpleados.hasNext()) {
                System.out.print((String) iteradorEmpresasyEmpleados.next() + " ");
            }
            System.out.println("");
        }
        System.out.println("");
    }
}
