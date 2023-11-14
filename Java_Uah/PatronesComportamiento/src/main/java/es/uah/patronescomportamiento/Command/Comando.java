package es.uah.patronescomportamiento.Command;

/**
 * Interfaz comando. Modela el comportamiento genérico de los comandos.
 *
 * @author Salvador Oton
 */
public interface Comando {

    /**
     * Establece reunión.
     *
     * @param reunion
     */
    public void setReunion(Reunion reunion);

    /**
     * Devuelve reunión.
     *
     * @return
     */
    public Reunion getReunion();

    /**
     * Método con las acciones a realizar.
     *
     * @param param
     */
    public void ejecutar(String param);
}
