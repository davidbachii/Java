package es.uah.patronescomportamiento.Visitor;

/**
 * LlamadaProvincial: Implementa la interfaz Llamada. Implementa el método
 * aceptar invocando el método visitar apropiado definido en Visitante.
 *
 * @author Salvador Oton
 */
public class LlamadaProvincial extends Llamada {

    // Coste del establecimiento de llamada.
    private final double establecimiento = 0.0833;

    /**
     * Constructor.
     *
     * @param minutos Duración de la llamada en minutos.
     * @param hora Hora a la que se hizo la llamada.
     * @param dia Día de la semana en que se hizo la llamada (L,M,X,..,D)
     */
    public LlamadaProvincial(int minutos, int hora, char dia) {
        super(minutos, hora, dia);
    }

    /* Implementación del método aceptar de la clase Llamada. Acepta la
     * visita de un visitante concreto e invoca al método visitar del mismo
     * para que realice la acción que deba. Se envía como parámetro el
     * propio objeto, que es el elemento visitado*/
    @Override
    public double aceptar(Visitante visitante) {
        return this.establecimiento + visitante.visitar(this);
    }
}
