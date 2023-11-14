package es.uah.patronescomportamiento.Interpreter;

import java.util.ArrayList;
import java.util.ListIterator;

/**
 * Muestra las empresas
 *
 * @author Salvador Oton
 */
public class InterpreteEmpresa implements Interprete {

    @Override
    public void interpretar(Contexto contexto) {
        ArrayList<String> empresas = contexto.getEmpresas();		//empresas
        ListIterator iteradorEmpresas = empresas.listIterator();	//iterador
        System.out.print("Empresas: ");
        while (iteradorEmpresas.hasNext()) {
            System.out.print((String) iteradorEmpresas.next() + ", ");
        }
        System.out.println("");
        System.out.println("");
    }
}
