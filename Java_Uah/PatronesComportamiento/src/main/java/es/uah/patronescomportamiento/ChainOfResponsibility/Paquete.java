package es.uah.patronescomportamiento.ChainOfResponsibility;

/**
 * Clase que representa un paquete.
 *
 * @author Salvador Oton
 */
public class Paquete {

    private String contenido; // Contenido del paquete.
    private String destino; // Destino del paquete.
    private double peso; // Peso del paquete.

    /**
     * Constructor.
     *
     * @param contenido Contenido del paquete.
     * @param destino Destino del paquete.
     * @param peso Peso del paquete.
     */
    public Paquete(String contenido, String destino, double peso) {
        this.contenido = contenido;
        this.destino = destino;
        this.peso = peso;
    }

    /**
     * Devuelve el contenido del paquete.
     *
     * @return Contenido del paquete.
     */
    public String getContenido() {
        return this.contenido;
    }

    /**
     * Devuelve el destino del paquete.
     *
     * @return Destino del paquete.
     */
    public String getDestino() {
        return this.destino;
    }

    /**
     * Devuelve el peso del paquete.
     *
     * @return Peso del paquete.
     */
    public double getPeso() {
        return this.peso;
    }

    /**
     * Devuelve la descripción del paquete.
     *
     * @return
     */
    @Override
    public String toString() {
        return "### Paquete # Contenido: " + contenido + " # Destino: " + destino + " # Peso: " + peso;
    }
}
