package es.uah.patronesfundamentales.MarkerInt;

/**
 * Clase marcada.
 */
public class Coche implements MotorInt {

    /**
     * Número de plazas del coche.
     */
    private int plazas;

    /**
     * Constructor.
     *
     * @param plazas Número de plazas del coche.
     */
    public Coche(int plazas) {
        this.plazas = plazas;
    }

    /**
     * Devuelve el número de plazas del coche.
     *
     * @return Número de plazas del coche.
     */
    public int getPlazas() {
        return plazas;
    }

    /**
     * Establece el número de plazas del coche.
     *
     * @param plazas Número de plazas del coche.
     */
    public void setPlazas(int plazas) {
        this.plazas = plazas;
    }

    @Override
    public String toString() {
        return "Coche: " + this.plazas;
    }

}
