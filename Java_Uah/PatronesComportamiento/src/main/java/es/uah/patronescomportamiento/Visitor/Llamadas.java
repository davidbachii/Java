package es.uah.patronescomportamiento.Visitor;

import java.util.*;

/**
 * EstructuraDeObjetos: Para poder enumerar todos los elementos. Es el
 * responsable de guardar todas las llamadas que se han realizado y
 * clasificarlas.
 *
 * @author Salvador Oton
 */
public class Llamadas {

    // Lista de llamadas en horario reducido.
    private ArrayList<Llamada> llamadasHorarioReducido = new ArrayList<>();
    // Lista de llamadas en horario normal.
    private ArrayList<Llamada> llamadasHorarioNormal = new ArrayList<>();

    /**
     * Añade una llamada a una de las listas dependiendo de su tipo (reducida o
     * normal)
     *
     * @param llamada
     */
    public void añadirLlamada(Llamada llamada) {
        if (llamada.getDia() == 'L' || llamada.getDia() == 'M'
                || llamada.getDia() == 'X' || llamada.getDia() == 'J'
                || llamada.getDia() == 'V') {
            if (llamada.getHora() >= 8 && llamada.getHora() < 18) {
                llamadasHorarioNormal.add(llamada);
            } else {
                llamadasHorarioReducido.add(llamada);
            }
        } else {
            llamadasHorarioReducido.add(llamada);
        }
    }

    /**
     * Devuelve la lista de llamadas en horario reducido.
     *
     * @return Lista de llamadas en horario reducido.
     */
    public ArrayList<Llamada> getLlamadasHorarioReducido() {
        return this.llamadasHorarioReducido;
    }

    /**
     * Devuelve la lista de llamadas en horario normal.
     *
     * @return Lista de llamadas en horario normal.
     */
    public ArrayList<Llamada> getLlamadasHorarioNormal() {
        return this.llamadasHorarioNormal;
    }
}
