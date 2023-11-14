package es.uah.patronescomportamiento.Mediator;

/**
 * Interfaz en la que se definen los métodos para que un mediador pueda informar
 * a los colegas. Cada Colega conoce a su mediador.
 *
 * @author Salvador Oton
 */
public abstract class Colega {

    private Mediador mediador;		//Referencia al mediador concreto.
    private int id; 			//Identificador del colega.
    private static int contador = 0; 	//Secuencia para el id.

    /**
     * Constructor.
     *
     * @param mediador Mediador concreto.
     */
    public Colega(Mediador mediador) {
        this.mediador = mediador;
        mediador.setColega(this);
        this.id = getContador();
    }

    /**
     * Devuelve secuencia para el id
     *
     * @return Secuencia para el id
     */
    private static int getContador() {
        return contador++;
    }

    /**
     * Devuelve el mediador concreto.
     *
     * @return Mediador concreto.
     */
    public Mediador getMediador() {
        return mediador;
    }

    /**
     * Establece el mediador concreto.
     *
     * @param mediador Mediador concreto.
     */
    public void setMediador(Mediador mediador) {
        this.mediador = mediador;
    }

    /**
     * Devuelve el identificador del colega.
     *
     * @return Identificador del colega.
     */
    public int getId() {
        return this.id;
    }

    /**
     * Envía un mensaje al colega cuyo identificador se pasa como argumento.
     *
     * @param mensaje Mensaje a enviar.
     * @param id Identificador del colega al que se le envía el mensaje.
     */
    public abstract void enviar(String mensaje, int id);

    /**
     * Recibe un mensaje.
     *
     * @param mensaje Mensaje recibido.
     */
    public abstract void recibir(String mensaje);
}
