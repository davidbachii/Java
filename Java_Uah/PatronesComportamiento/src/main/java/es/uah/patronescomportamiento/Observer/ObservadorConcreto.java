package es.uah.patronescomportamiento.Observer;

/**
 * Mantiene una referencia a un objeto SujetoConcreto Implementa la interfaz
 * Observador y define los métodos para responder a los mensajes recibidos del
 * sujeto.
 *
 * @author Salvador Oton
 */
public class ObservadorConcreto implements Observador {

    private String nombre;			//Nombre del observador.
    private double precioVentaAccion;           //Precio al que queremos vender.
    private Sujeto sujeto;			//Sujeto (valor) al que observamos.
    private int numAcciones;			//Cantidad de acciones.

    /**
     * Constructor.
     *
     * @param nombre Nombre del observador
     * @param precio Precio al que queremos vender
     * @param numAcciones Cantidad de acciones.
     * @param sujeto Sujeto (valor) al que observamos.
     */
    public ObservadorConcreto(String nombre, double precio, int numAcciones, Sujeto sujeto) {
        this.nombre = nombre;
        this.precioVentaAccion = precio;
        this.sujeto = sujeto;
        this.numAcciones = numAcciones;
        sujeto.añadirObservador(this);
    }

    @Override
    public String actualizar() {
        double cot = sujeto.getValor().getCotizacion();
        String res = "Actualizando con cotización a: " + cot + ", y precio venta a:" + precioVentaAccion;

        if (cot >= precioVentaAccion) {
            double total = cot * numAcciones;
            res += "\nEl observador " + nombre
                    + " ha vendido sus " + numAcciones
                    + " acciones a " + total + " euros.";
            sujeto.eliminarObservador(this);
        } else {
            res += "\nEl observador " + nombre + " no vende sus acciones.";
        }

        return res;
    }
}
