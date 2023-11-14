package es.uah.patronescomportamiento.Memento;

import java.util.ArrayList;

/**
 * Es el responsable de la custodia de los recuerdos. Nunca opera o examina el
 * contenido de un recuerdo.
 *
 * @author Salvador Oton
 */
public class Conserje {

    // Lista de recuerdos.
    private ArrayList<Recuerdo> recuerdos = new ArrayList<>();

    /**
     * Añade un recuerdo a la lista de recuerdos.
     *
     * @param recuerdo Recuerdo a añadir.
     */
    public void setRecuerdo(Recuerdo recuerdo) {
        recuerdos.add(recuerdo);
    }

    /**
     * Recupera un recuerdo a partir del índice pasado como argumento.
     *
     * @param indice Índice del recuerdo.
     * @return Recuerdo.
     */
    public Recuerdo getRecuerdo(int indice) {
        if (indice < recuerdos.size()) {
            Recuerdo r = recuerdos.get(indice);
            return r;
        } else {
            return null;
        }
    }
}
