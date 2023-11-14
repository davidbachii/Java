package es.uah.patronescomportamiento.Command;

/**
 * Implementa ComandoDeshacer. Proporciona el comportamiento necesario para
 * cambiar la fecha de una reunión.
 *
 * @author Salvador Oton
 */
public class ComandoCambiarFecha implements ComandoDeshacer {

    // Referencia al receptor.
    private Reunion reunion;
    // Nueva fecha de la reunión (cuando el usuario la cambie).
    private FechaHora nuevaFecha;
    // Fecha antigua de la reunión.
    private FechaHora antiguaFecha;

    @Override
    public Reunion getReunion() {
        return this.reunion;
    }

    @Override
    public void setReunion(Reunion reunion) {
        this.reunion = reunion;
    }

    /**
     * Cambia la fecha de la reunión por otra introducida por el usuario y
     * almacena el valor anterior de la reunión por si luego se quiere
     * recuperar.
     *
     * @param param Nueva fecha de la reunión.
     */
    @Override
    public void ejecutar(String param) {
        antiguaFecha = reunion.getFecha();
        nuevaFecha = new FechaHora(param);
        reunion.setFecha(nuevaFecha);
    }

    /**
     * Recupera el valor de la Reunion anterior al introducido por el usuario
     */
    @Override
    public void deshacer() {
        reunion.setFecha(antiguaFecha);
    }

    /**
     * Recupera el valor introducido por el usuario después de que se hubiera
     * deshecho
     */
    @Override
    public void rehacer() {
        reunion.setFecha(nuevaFecha);
    }
}
