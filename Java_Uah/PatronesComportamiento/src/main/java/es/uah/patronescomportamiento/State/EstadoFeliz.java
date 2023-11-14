package es.uah.patronescomportamiento.State;

/**
 * Estado concreto: Implementa la interfaz Estado. Implementa el comportamiento
 * específico de un estado.
 *
 * @author Salvador Oton
 */
public class EstadoFeliz implements Estado {

    @Override
    public void ejecutar(Tamagotchi t) {
        System.out.println("¡Estoy feliz!");
    }
}
