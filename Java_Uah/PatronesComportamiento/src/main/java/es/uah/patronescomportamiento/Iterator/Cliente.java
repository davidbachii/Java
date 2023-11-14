package es.uah.patronescomportamiento.Iterator;

import java.util.ArrayList;

/**
 * Cliente que prueba el patrón iterador.
 *
 * @author Salvador Oton
 */
public class Cliente {

    public static void main(String arg[]) {
        try {
            // Crea la lista. 
            ArrayList aux = new ArrayList();
            Universitario uni1 = new Universitario("12345678", "Pepe", "Informática", "Alcalá");
            Universitario uni2 = new Universitario("48438979", "Cristina", "Farmacia", "Complutense");
            Universitario uni3 = new Universitario("62654698", "David", "Medicina", "Alcalá");
            Universitario uni4 = new Universitario("75542987", "Laura", "Derecho", "Carlos III");
            aux.add(uni1);
            aux.add(uni2);
            aux.add(uni3);
            aux.add(uni4);

            // Crea el agregado.
            Agregado agregado = new AgregadoConcreto(aux);
            // Crea el iterador.
            Iterador iterador = agregado.crearIterador();

            // Recorre la lista con el iterador.
            while (iterador.hayMas()) {
                Universitario uni = (Universitario) iterador.elementoActual();
                System.out.println(uni.toString());
                iterador.siguiente();
            }
        } catch (IndexOutOfBoundsException e) {
            System.out.println("Error: " + e.toString());
        }
    }
}
