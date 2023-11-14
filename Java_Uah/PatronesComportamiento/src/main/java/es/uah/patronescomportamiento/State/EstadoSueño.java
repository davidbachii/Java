package es.uah.patronescomportamiento.State;

/**
 * Estado concreto: Implementa la interfaz Estado. Implementa el comportamiento
 * específico de un estado.
 *
 * @author Salvador Oton
 */
public class EstadoSueño implements Estado {

    @Override
    public void ejecutar(Tamagotchi t) {
        Estado feliz = new EstadoFeliz();
        Estado triste = new EstadoTriste();
        System.out.println("Estado Sueño: " + t.toString());
        if (t.getSueño() >= 50 && t.getSueño() <= 100) {
            System.out.println("¡Tengo sueño!");
            t.setEstadoActual(triste);
        } else if (t.getSueño() >= 0 && t.getSueño() < 50) {
            System.out.println("¡Estoy despierto!");
            t.setEstadoActual(feliz);
        }
    }
}
