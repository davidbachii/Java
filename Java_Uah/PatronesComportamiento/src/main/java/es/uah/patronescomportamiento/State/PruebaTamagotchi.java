package es.uah.patronescomportamiento.State;

/**
 * Clase que prueba el patrón State.
 *
 * @author Salvador Oton
 */
public class PruebaTamagotchi {

    public static void main(String[] args) {
        Tamagotchi t = new Tamagotchi();
        System.out.println("Valores iniciales: " + t.toString());
        t.darComida(20);
        t.dormir(-60);
        t.hacerEjercicio(-20);
    }
}
