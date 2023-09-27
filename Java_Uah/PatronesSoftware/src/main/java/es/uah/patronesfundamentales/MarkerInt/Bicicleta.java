package es.uah.patronesfundamentales.MarkerInt;

/**
 * Clase sin marcar.
 */
public class Bicicleta {

    /**
     * Tipo de bicicleta.
     */
    private String tipo;

    /**
     * Constructor.
     *
     * @param tipo Tipo de bicicleta.
     */
    public Bicicleta(String tipo) {
        this.tipo = tipo;
    }

    /**
     * Devuelve el tipo de bicicleta.
     *
     * @return Tipo de bicicleta.
     */
    public String getTipo() {
        return tipo;
    }

    /**
     * Establece el tipo de bicicleta.
     *
     * @param tipo Tipo de bicicleta.
     */
    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    @Override
    public String toString() {
        return "Bicicleta: " + this.tipo;
    }
}
