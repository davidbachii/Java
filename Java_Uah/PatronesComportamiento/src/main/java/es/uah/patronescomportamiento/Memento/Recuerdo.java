package es.uah.patronescomportamiento.Memento;

/**
 * Almacena el estado interno de un objeto Originador.
 *
 * @author Salvador Oton
 */
public class Recuerdo {

    // Partida que se va a recordar.
    private Partida partida = null;

    /**
     * Constructor.
     *
     * @param partida Partida que se va a recordar.
     */
    public Recuerdo(Partida partida) {
        this.partida = partida;
    }

    /**
     * Devuelve la partida que se va a recordar.
     *
     * @return Partida que se va a recordar.
     */
    public Partida getPartida() {
        return partida;
    }

    /**
     * Establece la partida que se va a recordar.
     *
     * @param partida Partida que se va a recordar.
     */
    public void setPartida(Partida partida) {
        this.partida = partida;
    }
}
