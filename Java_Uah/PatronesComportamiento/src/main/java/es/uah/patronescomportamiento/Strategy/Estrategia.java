package es.uah.patronescomportamiento.Strategy;

import java.util.ArrayList;

/**
 * Interfaz en la que se definen todos los métodos disponibles para ser
 * manejados por Contexto.
 *
 * @author Salvador Oton
 */
public interface Estrategia {

    /**
     * Ordena lista de alumnos pasada como argumento
     *
     * @param alumnos Lista de alumnos
     */
    public void ordena(ArrayList<Universitario> alumnos);
}
