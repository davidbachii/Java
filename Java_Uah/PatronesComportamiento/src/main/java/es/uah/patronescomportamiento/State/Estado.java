package es.uah.patronescomportamiento.State;

/**
 * Interfaz que define los métodos que dependen del estado del objeto.
 *
 * @author Salvador Oton
 */
public interface Estado {

    /**
     * Modifica el estado del objeto
     *
     * @param t Contexto
     */
    public void ejecutar(Tamagotchi t);
}
