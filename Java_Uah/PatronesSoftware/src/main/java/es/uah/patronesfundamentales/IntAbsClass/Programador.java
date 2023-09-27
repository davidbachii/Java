package es.uah.patronesfundamentales.IntAbsClass;

/**
 * Clase que representa a un trabajador informático programador.
 */
public class Programador extends InformaticoAbs {

    /**
     * Lenguaje de programación.
     */
    String lenguaje;

    /**
     * Constructor.
     *
     * @param empresa Nombre de la empresa.
     * @param lenguaje Lenguaje de programación.
     */
    public Programador(String empresa, String lenguaje) {
        super(empresa);
        this.lenguaje = lenguaje;
    }

    @Override
    public double pagarSueldo(double horas) {
        return horas * 6;
    }
}
