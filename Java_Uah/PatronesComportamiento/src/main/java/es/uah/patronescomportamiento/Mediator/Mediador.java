package es.uah.patronescomportamiento.Mediator;

/**
 * Mediador: Interfaz en la que se definen los métodos que pueden ser invocados
 * por los clientes. Define una interface para comunicarse con los colegas.
 *
 * @author Salvador Oton
 */
public interface Mediador {

    /**
     * Añade un colega a la lista de colegas.
     *
     * @param colega Colega a añadir.
     */
    public void setColega(Colega colega);

    /**
     * Devuelve el colega de la lista de la posición pasada como argumento.
     *
     * @param indice Índice o posición del colega.
     * @return
     */
    public Colega getColega(int indice);

    /**
     * Envía un mensaje al colega cuyo identificador se pasa como argumento.
     *
     * @param mensaje Mensaje a enviar.
     * @param id Identificador del colega al que se le envía el mensaje.
     */
    public void enviar(String mensaje, int id);
}
