package es.uah.patronescomportamiento.Interpreter;

import java.util.ArrayList;
import java.util.ListIterator;

/**
 * Muestra los empleados ordenados por empresa
 *
 * @author Salvador Oton
 */
public class InterpreteEmpleadoEmpresa implements Interprete {

    @Override
    public void interpretar(Contexto contexto) {
        //obtenemos las empresas
        ArrayList<String> empresas = contexto.getEmpresas();
        ListIterator iteradorEmpresas = empresas.listIterator();    //iterador
        while (iteradorEmpresas.hasNext()) {
            String empresa = (String) iteradorEmpresas.next();      //empresa actual
            //obtenemos los empleados de la empresa actual
            ArrayList<String> empleadosyempresas = contexto.getEmpleadosPorEmpresa(empresa);
            System.out.println("Empresa:" + empresa);
            ListIterator iteratorEmpleadosyEmpresas = empleadosyempresas.listIterator();
            System.out.print("Empleados: ");
            while (iteratorEmpleadosyEmpresas.hasNext()) {
                //mostramos los empleados
                System.out.print((String) iteratorEmpleadosyEmpresas.next() + " ");
            }
            System.out.println("");
        }
        System.out.println("");
    }
}
