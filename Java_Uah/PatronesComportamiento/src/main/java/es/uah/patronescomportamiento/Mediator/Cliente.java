package es.uah.patronescomportamiento.Mediator;

/**
 * Prueba el patrón Mediator.
 *
 * @author Salvador Oton
 */
public class Cliente {

    public static void main(String args[]) {
        try {
            //El mediador
            Mediador mediador = new MediadorConcreto();

            //Los colegas
            Colega colega0 = new ColegaConcreto(mediador);
            Colega colega1 = new ColegaConcreto(mediador);
            Colega colega2 = new ColegaConcreto(mediador);

            //Enviamos mensajes
            System.out.println("Enviamos mensajes:");
            System.out.println("\nEnviamos mensaje del colega 0 al 2:");
            colega0.enviar("Hola desde el colega 0.", 2);
            System.out.println("\nEnviamos mensaje a todos:");
            colega1.enviar("Hola a todos.", -1);
        } catch (Exception e) {
            System.out.println("Error: " + e.toString());
        }
    }
}
