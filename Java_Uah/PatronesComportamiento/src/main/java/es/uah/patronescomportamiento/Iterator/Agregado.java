package es.uah.patronescomportamiento.Iterator;

/**
 * Agregado: Interfaz que define el método de fabricación para crear un
 * iterador.
 *
 * @author Salvador Oton
 */
public interface Agregado {

    /**
     * Método de fabricación para crear un iterador.
     *
     * @return Iterador concreto.
     */
    Iterador crearIterador();
}
