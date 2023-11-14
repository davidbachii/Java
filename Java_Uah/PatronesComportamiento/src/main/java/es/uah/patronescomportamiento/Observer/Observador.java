package es.uah.patronescomportamiento.Observer;

/**
 * Observador: Interfaz para actualizar los objetos ante cambios en un sujeto.
 *
 * @author Salvador Oton
 */
public interface Observador {

    /**
     * Actualiza los objetos ante cambios en un sujeto.
     *
     * @return
     */
    public String actualizar();
}
