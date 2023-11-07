package es.uah.patronesestructurales.Composite;

/**
 * Hoja. Empleado sin subordinados. Deja vacíos los métodos de añadir y eliminar
 * subordinado.
 */
public class Empleado extends Trabajador {

    /**
     * Constructor.
     *
     * @param puesto Puesto que ocupa el trabajador.
     * @param salario Salario del trabajador.
     */
    public Empleado(String puesto, double salario) {
        super(puesto, salario);
    }

    @Override
    public void añadirSubordinado(Trabajador t) {
    }

    @Override
    public void eliminarSubordinado(Trabajador t) {
    }

    @Override
    public double getSalarios() {
        return super.getSalario();
    }

    @Override
    public String getDescripcion() {
        return "### " + super.toString();
    }
}
