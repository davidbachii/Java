package es.uah.patronescomportamiento.Observer;

/**
 * Valor de cotización.
 *
 * @author Salvador Oton
 */
public class Valor {

    private String titulo; // Nombre del valor.
    private double cotizacion;

    /**
     * Constructor.
     *
     * @param t Nombre del valor.
     * @param c Cotizacion.
     */
    public Valor(String t, double c) {
        this.titulo = t;
        this.cotizacion = c;
    }

    /**
     * Devuelve el nombre del valor.
     *
     * @return Nombre del valor.
     */
    public String getTitulo() {
        return this.titulo;
    }

    /**
     * Establece el nombre del valor.
     *
     * @param nuevo Nombre del valor.
     */
    public void setTitulo(String nuevo) {
        this.titulo = nuevo;
    }

    /**
     * Devuelve cotización.
     *
     * @return Cotización.
     */
    public double getCotizacion() {
        return this.cotizacion;
    }

    /**
     * Establece cotización.
     *
     * @param nuevo Cotización.
     */
    public void setCotizacion(double nuevo) {
        this.cotizacion = nuevo;
    }

    /**
     * Devuelve descripción del valor.
     *
     * @return
     */
    @Override
    public String toString() {
        return "# Valor de " + titulo + " cotiza a " + cotizacion;
    }
}
