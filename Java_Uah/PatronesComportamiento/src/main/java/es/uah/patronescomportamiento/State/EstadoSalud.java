package es.uah.patronescomportamiento.State;

/**
 * Estado concreto: Implementa la interfaz Estado. Implementa el comportamiento
 * específico de un estado.
 *
 * @author Salvador Oton
 */
public class EstadoSalud implements Estado {

    @Override
    public void ejecutar(Tamagotchi t) {
        Estado feliz = new EstadoFeliz();
        Estado triste = new EstadoTriste();
        System.out.println("Estado Salud: " + t.toString());
        if (t.getSalud() >= 50 && t.getSalud() <= 100) {
            System.out.println("¡Tengo una buena salud!");
            t.setEstadoActual(feliz);
        } else if (t.getSalud() >= 0 && t.getSalud() < 50) {
            System.out.println("¡Estoy enfermo!");
            t.setEstadoActual(triste);
        }
    }
}
