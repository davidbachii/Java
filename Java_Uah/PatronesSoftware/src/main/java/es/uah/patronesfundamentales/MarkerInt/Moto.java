package es.uah.patronesfundamentales.MarkerInt;

/**
 * Clase marcada.
 */
public class Moto implements MotorInt {

    /**
     * Cilindrada de la moto.
     */
    private int cilindrada;

    /**
     * Constructor.
     *
     * @param cilindrada Cilindrada de la moto.
     */
    public Moto(int cilindrada) {
        this.cilindrada = cilindrada;
    }

    /**
     * Devuelve la cilindrada de la moto.
     *
     * @return Cilindrada de la moto.
     */
    public int getCilindrada() {
        return cilindrada;
    }

    /**
     * Establece la cilindrada de la moto.
     *
     * @param cilindrada Cilindrada de la moto.
     */
    public void setCilindrada(int cilindrada) {
        this.cilindrada = cilindrada;
    }

    @Override
    public String toString() {
        return "Moto: " + this.cilindrada;
    }

}
