package es.uah.patronescomportamiento.ObserverBean;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

/**
 * Mantiene una referencia a un objeto SujetoConcreto Implementa la interfaz
 * PropertyChangeListener y define los métodos para responder a los mensajes recibidos del
 * sujeto.
 *
 * @author Salvador Oton
 */
public class ObservadorConcreto implements PropertyChangeListener {

    private String nombre;			//Nombre del observador.
    private double precioVentaAccion;           //Precio al que queremos vender.
    private int numAcciones;			//Cantidad de acciones.
    private SujetoConcreto sujeto;		//Sujeto al que observamos.

    /**
     * Constructor.
     *
     * @param nombre Nombre del observador.
     * @param precio Precio al que queremos vender.
     * @param numAcciones Cantidad de acciones.
     * @param sujeto Sujeto al que observamos.
     */
    public ObservadorConcreto(String nombre, double precio, int numAcciones, SujetoConcreto sujeto) {
        this.nombre = nombre;
        this.precioVentaAccion = precio;
        this.numAcciones = numAcciones;
        this.sujeto = sujeto;
        sujeto.addObserver(this);
    }

    /**
     * Método de la interfaz PropertyChangeListener, se llama cuando se cambia la propiedad enlazada.
     * 
     * @param evt Contiene información sobre la fuente del evento y la propiedad que ha cambiado (nombre de la propiedad, valor anterior y el valor modificado)
     */
    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        //sujeto = (SujetoConcreto) obs;        
        //double cot = sujeto.getValor().getCotizacion();
        double cot = (double) evt.getNewValue();
        String res = "Actualizando con cotización a: " + cot + ", y precio venta a:" + precioVentaAccion;

        if (cot >= precioVentaAccion) {
            double total = cot * numAcciones;
            res += "\nEl observador " + nombre
                    + " ha vendido sus " + numAcciones
                    + " acciones a " + total + " euros.";
            System.out.println(res);
            sujeto.deleteObserver(this);
        } else {
            res += "\nEl observador " + nombre + " no vende sus acciones.";
            System.out.println(res);
        }
    }
}
