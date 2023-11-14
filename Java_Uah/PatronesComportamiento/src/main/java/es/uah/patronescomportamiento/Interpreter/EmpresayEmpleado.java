package es.uah.patronescomportamiento.Interpreter;

/**
 * Relaciona un empleado con una empresa
 *
 * @author Salvador Oton
 */
public class EmpresayEmpleado {

    private String empresa;
    private String empleado;

    /**
     * Constructor.
     *
     * @param empresa
     * @param empleado
     */
    public EmpresayEmpleado(String empresa, String empleado) {
        this.empresa = empresa;
        this.empleado = empleado;
    }

    /**
     * Devuelve la empresa.
     *
     * @return
     */
    public String getEmpresa() {
        return this.empresa;
    }

    /**
     * Devuelve el empleado.
     *
     * @return
     */
    public String getEmpleado() {
        return this.empleado;
    }
}
