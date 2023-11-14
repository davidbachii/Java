package es.uah.patronescomportamiento.ChainOfResponsibility;

/**
 * Manejador concreto para el cálculo del coste de envío de un paquete al resto
 * de las zonas.
 *
 * @author Salvador Oton
 */
public class ManejadorConcreto3 extends Manejador {

    @Override
    public double calculaCosteEnvio(Paquete p) {
        System.out.println("\tManejadorConcreto3");
        return p.getPeso() * 1.5 + 8;
    }
}
