package es.uah.patronescomportamiento.Iterator;

import java.util.ArrayList;

/**
 * AgregadoConcreto: Implementa la interfaz Agregado y crea los iteradores
 * concretos según se necesiten.
 *
 * @author Salvador Oton
 */
public class AgregadoConcreto implements Agregado {

    // Lista de elementos a recorrer.
    public ArrayList elementos;

    /**
     * Constructor.
     *
     * @param vec Lista de elementos a recorrer.
     */
    public AgregadoConcreto(ArrayList vec) {
        elementos = vec;
    }

    @Override
    public Iterador crearIterador() {
        return new IteradorConcreto(this);
    }
}
