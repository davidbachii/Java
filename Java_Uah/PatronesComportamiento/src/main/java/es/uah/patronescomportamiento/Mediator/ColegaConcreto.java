package es.uah.patronescomportamiento.Mediator;

/**
 * Clase que implementa la interfaz Colega.
 *
 * @author Salvador Oton
 */
public class ColegaConcreto extends Colega {

    /**
     * Constructor.
     *
     * @param mediador Mediador concreto.
     */
    public ColegaConcreto(Mediador mediador) {
        super(mediador);
    }

    @Override
    public void enviar(String mensaje, int id) {
        this.getMediador().enviar(mensaje, id);
    }

    @Override
    public void recibir(String mensaje) {
        System.out.println("# ColegaConcreto " + getId() + " ha recibido el mensaje:\n" + mensaje);
    }
}
