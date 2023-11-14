package es.uah.patronescomportamiento.ObserverJava;

import java.util.Observable;
import java.util.Observer;

/**
 * Mantiene una referencia a un objeto SujetoConcreto Implementa la interfaz
 * Observer y define los métodos para responder a los mensajes recibidos del
 * sujeto.
 *
 * @author Salvador Oton
 */
public class ObservadorConcreto implements Observer {

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

    @Override
    public void update(Observable obs, Object arg) {
        sujeto = (SujetoConcreto) obs;
        double cot = sujeto.getValor().getCotizacion();
        String res = "Actualizando con cotización a: " + cot + ", y precio venta a:" + precioVentaAccion;

        if (cot >= precioVentaAccion) {
            double total = cot * numAcciones;
            res += "\nEl observador " + nombre
                    + " ha vendido sus " + numAcciones
                    + " acciones a " + total + " euros.";
            sujeto.deleteObserver(this);
        } else {
            res += "\nEl observador " + nombre + " no vende sus acciones.";
        }
        System.out.println(res);
    }
}
