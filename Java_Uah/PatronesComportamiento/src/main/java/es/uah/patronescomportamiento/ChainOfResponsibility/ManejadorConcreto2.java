package es.uah.patronescomportamiento.ChainOfResponsibility;

/**
 * Manejador concreto para el cálculo del coste de envío de un paquete en la
 * Comunidad de Madrid.
 *
 * @author Salvador Oton
 */
public class ManejadorConcreto2 extends Manejador {

    @Override
    public double calculaCosteEnvio(Paquete p) {
        System.out.println("\tManejadorConcreto2");
        if (p.getDestino().equals("Comunidad Madrid")) {
            return p.getPeso() * 1.5 + 6;
        } else if (super.getSucesor() != null) {
            return getSucesor().calculaCosteEnvio(p);
        }

        return 0;

    }
}
