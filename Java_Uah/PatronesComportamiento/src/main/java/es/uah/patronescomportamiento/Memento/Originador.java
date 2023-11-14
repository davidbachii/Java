package es.uah.patronescomportamiento.Memento;

/**
 * Clase que crea el objeto recuerdo y lo utiliza para recuperar su estado. Crea
 * un Recuerdo que contiene una instantánea de su estado interno actual. Usa el
 * Recuerdo para restaurar su estado interno.
 *
 * @author Salvador Oton
 */
public class Originador {

    // Referencia a la partida.
    private Partida partida;

    /**
     * Devuelve la partida.
     *
     * @return Partida.
     */
    public Partida getPartida() {
        return this.partida;
    }

    /**
     * Establece la partida.
     *
     * @param partida
     */
    public void setPartida(Partida partida) {
        this.partida = partida;
    }

    /**
     * Asigna un recuerdo a la partida.
     *
     * @param recuerdo
     */
    public void setRecuerdo(Recuerdo recuerdo) {
        partida = recuerdo.getPartida();
    }

    /**
     * Devuelve un recuerdo creado a partir de la partida actual.
     *
     * @return
     */
    public Recuerdo crearRecuerdo() {
        return new Recuerdo(partida);
    }
}
