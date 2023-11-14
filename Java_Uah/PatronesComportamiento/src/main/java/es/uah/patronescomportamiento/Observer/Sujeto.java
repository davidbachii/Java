package es.uah.patronescomportamiento.Observer;

/**
 * Sujeto (Observado): Interfaz que define como pueden interactuar los
 * observadores con el sujeto. Define métodos para añadir y quitar observadores
 * y avisarles de que se han producido cambios en el sujeto.
 *
 * @author Salvador Oton
 */
public interface Sujeto {

    /**
     * Establece el valor al que monitorizar su cotización.
     *
     * @param v Valor al que monitorizar su cotización.
     */
    public void setValor(Valor v);

    /**
     * Devuelve el valor al que monitorizar su cotización.
     *
     * @return Valor al que monitorizar su cotización.
     */
    public Valor getValor();

    /**
     * Añade un observador a la lista.
     *
     * @param o Observador.
     */
    public void añadirObservador(Observador o);

    /**
     * Elimina un observador de la lista
     *
     * @param o Observador.
     */
    public void eliminarObservador(Observador o);

    /**
     * Notifica a todos los observadores de que se ha producido un cambio
     */
    public void notificarObservadores();
}
