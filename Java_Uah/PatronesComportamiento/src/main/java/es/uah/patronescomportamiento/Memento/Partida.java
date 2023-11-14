package es.uah.patronescomportamiento.Memento;

/**
 * Clase que representa una partida de juego.
 *
 * @author Salvador Oton
 */
public class Partida {

    private String nombre; // Nombre de la partida.
    private String fase; // Fase en la que se encuentra la partida.
    private FechaHora fecha; // Fecha en que se salva la partida.

    /**
     * Constructor.
     *
     * @param nombre Nombre de la partida.
     * @param fase Fase en la que se encuentra la partida.
     */
    public Partida(String nombre, String fase) {
        this.nombre = nombre;
        this.fase = fase;
        this.fecha = new FechaHora();
    }

    /**
     * Devuelve el nombre de la partida.
     *
     * @return Nombre de la partida.
     */
    public String getNombre() {
        return this.nombre;
    }

    /**
     * Devuelve la fase en la que se encuentra la partida.
     *
     * @return Fase en la que se encuentra la partida.
     */
    public String getFase() {
        return this.fase;
    }

    /**
     * Devuelve la fecha en que se salva la partida.
     *
     * @return Fecha en que se salva la partida.
     */
    public String getFecha() {
        return this.fecha.toString();
    }

    /**
     * Devuelve la descripción de la partida.
     *
     * @return Descripción de la partida.
     */
    @Override
    public String toString() {
        return "- Partida salvada:\n" + nombre + " # " + fase + " # " + fecha.toString();
    }
}
