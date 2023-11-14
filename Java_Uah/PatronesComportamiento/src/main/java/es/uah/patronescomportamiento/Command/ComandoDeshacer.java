package es.uah.patronescomportamiento.Command;

/**
 * Amplía la interfaz Comando añadiendo los métodos deshacer y rehacer
 *
 * @author Salvador Oton
 */
public interface ComandoDeshacer extends Comando {

    /**
     * Deshace comando.
     */
    public void deshacer();

    /**
     * Rehace comando.
     */
    public void rehacer();
}
