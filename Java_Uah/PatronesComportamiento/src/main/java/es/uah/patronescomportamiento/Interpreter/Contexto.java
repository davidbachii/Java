package es.uah.patronescomportamiento.Interpreter;

import java.util.ArrayList;
import java.util.ListIterator;

/**
 * Almacena los empleados, empresas y sus relaciones
 *
 * @author Salvador Oton
 */
public class Contexto {

    private ArrayList<String> empresas = new ArrayList<>(); // Lista de empresas.
    private ArrayList<String> empleados = new ArrayList<>(); // Lista de empleados.
    private ArrayList<EmpresayEmpleado> empresasyempleados = new ArrayList<>(); // Lista de relaciones empresa-empleado.

    /**
     * Añade una empresa a la lista de empresas.
     *
     * @param empresa Empresa a añadir.
     */
    public void añadirEmpresa(String empresa) {
        empresas.add(empresa);
    }

    /**
     * Añade un empleado a la lista de empleados.
     *
     * @param empleado Empleado a añadir.
     */
    public void añadirEmpleado(String empleado) {
        empleados.add(empleado);
    }

    /**
     * Añade una relacion entre empleado y empresa a la lista de relaciones.
     *
     * @param empresayempleado Relaciones empresa-empleado a añadir.
     */
    public void añadirEmpresayEmpleado(EmpresayEmpleado empresayempleado) {
        empresasyempleados.add(empresayempleado);
    }

    /**
     * Devuelve las empresas.
     *
     * @return Lista de empresas.
     */
    public ArrayList<String> getEmpresas() {
        return empresas;
    }

    /**
     * Devuelve los empleados.
     *
     * @return Lista de empleados.
     */
    public ArrayList<String> getEmpleados() {
        return empleados;
    }

    /**
     * Devuelve una lista con los empleados que pertenecen a la empresa que se
     * pasa como parámetro.
     *
     * @param empresaEn
     * @return Lista de empleados de una empresa.
     */
    public ArrayList<String> getEmpleadosPorEmpresa(String empresaEn) {
        ArrayList<String> empleadosPorEmpresa = new ArrayList<>();
        EmpresayEmpleado tempempresayempleado;
        ListIterator iteradorEmpresasyEmpleados = empresasyempleados.listIterator();
        while (iteradorEmpresasyEmpleados.hasNext()) {
            tempempresayempleado = (EmpresayEmpleado) iteradorEmpresasyEmpleados.next();
            if (empresaEn.equals(tempempresayempleado.getEmpresa())) {
                empleadosPorEmpresa.add(tempempresayempleado.getEmpleado());
            }
        }
        return empleadosPorEmpresa;
    }

    /**
     * Devuelve una lista con las empresas en las que ha trabajado el empleado
     * que se pasa como parámetro.
     *
     * @param empleadoEn
     * @return Lista de empresas.
     */
    public ArrayList<String> getEmpresasPorEmpleado(String empleadoEn) {
        ArrayList<String> empresasPorEmpleado = new ArrayList<>();
        EmpresayEmpleado tempempresayempleado;
        ListIterator iteradorEmpleadosyEmpresas = empresasyempleados.listIterator();
        while (iteradorEmpleadosyEmpresas.hasNext()) {
            tempempresayempleado = (EmpresayEmpleado) iteradorEmpleadosyEmpresas.next();
            if (empleadoEn.equals(tempempresayempleado.getEmpleado())) {
                empresasPorEmpleado.add(tempempresayempleado.getEmpresa());
            }
        }
        return empresasPorEmpleado;
    }
}
