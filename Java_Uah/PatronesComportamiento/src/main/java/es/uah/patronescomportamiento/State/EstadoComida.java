package es.uah.patronescomportamiento.State;

/**
 * Estado concreto: Implementa la interfaz Estado. Implementa el comportamiento
 * específico de un estado.
 *
 * @author Salvador Oton
 */
public class EstadoComida implements Estado {

    @Override
    public void ejecutar(Tamagotchi t) {
        Estado feliz = new EstadoFeliz();
        Estado triste = new EstadoTriste();
        System.out.println("Estado Comida: " + t.toString());
        if (t.getComida() >= 50 && t.getComida() <= 100) {
            System.out.println("¡No tengo hambre!");
            t.setEstadoActual(feliz);
        } else if (t.getComida() >= 0 && t.getComida() < 50) {
            System.out.println("¡Tengo hambre!");
            t.setEstadoActual(triste);
        }
    }
}
