package es.uah.patronescomportamiento.Strategy;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

/**
 * Clase que implementa la interfaz Estrategia. Ordena una lista de alumnos por
 * universidad.
 *
 * @author Salvador Oton
 */
public class EstrategiaConcretaUniversidad implements Estrategia {

    @Override
    public void ordena(ArrayList<Universitario> alumnos) {
        //Comparador para ordenar los alumnos por universidad
        Comparator NomUniComp = new Comparator() {

            @Override
            public int compare(Object o1, Object o2) {
                Universitario uni1 = (Universitario) o1;
                Universitario uni2 = (Universitario) o2;

                return uni1.getUniversidad().compareTo(uni2.getUniversidad());
            }
        };

        //Ordenamos los objetos del array por el atributo universidad
        Collections.sort(alumnos, NomUniComp);
    }
}
