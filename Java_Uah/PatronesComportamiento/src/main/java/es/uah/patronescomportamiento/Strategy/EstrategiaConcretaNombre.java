package es.uah.patronescomportamiento.Strategy;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

/**
 * Clase que implementa la interfaz Estrategia. Ordena una lista de alumnos por
 * nombre.
 *
 * @author Salvador Oton
 */
public class EstrategiaConcretaNombre implements Estrategia {

    @Override
    public void ordena(ArrayList<Universitario> alumnos) {
        //Comparador para ordenar los alumnos por su nombre
        Comparator NomAluComp = new Comparator() {

            @Override
            public int compare(Object o1, Object o2) {
                Universitario uni1 = (Universitario) o1;
                Universitario uni2 = (Universitario) o2;

                return uni1.getNombre().compareTo(uni2.getNombre());
            }
        };

        //Ordenamos los objetos del array por el atributo nombre
        Collections.sort(alumnos, NomAluComp);
    }
}
