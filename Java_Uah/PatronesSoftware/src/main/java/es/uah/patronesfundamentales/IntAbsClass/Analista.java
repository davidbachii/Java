package es.uah.patronesfundamentales.IntAbsClass;

/**
 * Clase que representa a un trabajador informático analista.
 */
public class Analista extends InformaticoAbs {

    /**
     * Especialidad del analista.
     */
    String especialidad;

    /**
     * Constructor.
     *
     * @param empresa Nombre de la empresa.
     * @param especialidad Especialidad del analista.
     */
    public Analista(String empresa, String especialidad) {
        super(empresa);
        this.especialidad = especialidad;
    }

    @Override
    public double pagarSueldo(double horas) {
        return horas * 12;
    }
}
