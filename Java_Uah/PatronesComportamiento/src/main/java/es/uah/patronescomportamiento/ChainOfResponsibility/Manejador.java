package es.uah.patronescomportamiento.ChainOfResponsibility;

/**
 * Manejador abstracto para el cálculo del coste de envío de un paquete.
 *
 * @author Salvador Oton
 */
public abstract class Manejador {

    // Sucesor en la cadena de responsabilidad.
    private Manejador sucesor;

    /**
     * Establece el sucesor en la cadena de responsabilidad.
     *
     * @param sucesor Sucesor en la cadena de responsabilidad.
     */
    public void setSucesor(Manejador sucesor) {
        this.sucesor = sucesor;
    }

    /**
     * Devuelve el sucesor en la cadena de responsabilidad.
     *
     * @return Sucesor en la cadena de responsabilidad.
     */
    public Manejador getSucesor() {
        return sucesor;
    }

    /**
     * Método para tratar las peticiones. Calcula el coste de envío de un
     * paquete.
     *
     * @param p Paquete cuyo coste de envío se calcula.
     * @return Coste del envío.
     */
    public abstract double calculaCosteEnvio(Paquete p);
}
