package es.uah.patronescomportamiento.Strategy;

import java.util.ArrayList;

/**
 * Clase que utiliza las diferentes estrategias para las distintas tareas.
 * Mantiene una referencia a la instancia Estrategia que usa, y tiene un método
 * para reemplazar la actual instancia de Estrategia.
 *
 * @author Salvador Oton
 */
public class Contexto {

    private Estrategia estrategia; // Estrategia que se usa.
    private ArrayList<Universitario> alumnos; // Lista de alumnos.

    /**
     * Constructor.
     *
     * @param e Estrategia que se usa.
     * @param u Lista de alumnos.
     */
    public Contexto(Estrategia e, ArrayList<Universitario> u) {
        this.estrategia = e;
        this.alumnos = u;
    }

    /**
     * Establece la estrategia a usar.
     *
     * @param e Estrategia a usar.
     */
    public void setEstrategia(Estrategia e) {
        this.estrategia = e;
    }

    /**
     * Ejecuta la estrategia.
     */
    public void ejecutaEstrategia() {
        estrategia.ordena(alumnos);
        for (Universitario alumno : alumnos) {
            System.out.println(alumno.toString());
        }
    }
}
