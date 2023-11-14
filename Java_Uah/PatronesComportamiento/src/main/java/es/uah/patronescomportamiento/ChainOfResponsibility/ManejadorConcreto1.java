package es.uah.patronescomportamiento.ChainOfResponsibility;

/**
 * Manejador concreto para el cálculo del coste de envío de un paquete en Madrid
 * capital.
 *
 * @author Salvador Oton
 */
public class ManejadorConcreto1 extends Manejador {

    @Override
    public double calculaCosteEnvio(Paquete p) {
        System.out.println("\tManejadorConcreto1");
        if (p.getDestino().equals("Madrid Capital")) {
            return p.getPeso() * 1.5 + 3;
        } else if (super.getSucesor() != null) {
            return getSucesor().calculaCosteEnvio(p);
        }

        return 0;
    }
}
