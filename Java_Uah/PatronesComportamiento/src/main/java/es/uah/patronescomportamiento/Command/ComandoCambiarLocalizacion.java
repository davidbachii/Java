package es.uah.patronescomportamiento.Command;

/**
 * Implementa ComandoDeshacer. Proporciona el comportamiento necesario para
 * cambiar el lugar de una reunión
 *
 * @author Salvador Oton
 */
public class ComandoCambiarLocalizacion implements ComandoDeshacer {

    // Referencia al receptor.
    private Reunion reunion;
    // Nueva localización de la reunión (cuando el usuario la cambie).
    private String nuevaLocalizacion;
    // Localización antigua de la reunión.
    private String antiguaLocalizacion;

    @Override
    public Reunion getReunion() {
        return this.reunion;
    }

    @Override
    public void setReunion(Reunion reunion) {
        this.reunion = reunion;
    }

    /**
     * Cambia el lugar de la reunión por otro introducida por el usuario y
     * almacena el valor anterior de la reunión por si luego se quiere
     * recuperar.
     *
     * @param param Nueva localización de la reunión.
     */
    @Override
    public void ejecutar(String param) {
        antiguaLocalizacion = reunion.getLocalizacion();
        nuevaLocalizacion = param;
        reunion.setLocalizacion(nuevaLocalizacion);
    }

    /**
     * Recupera el valor de la Reunion anterior al introducido por el usuario
     */
    @Override
    public void deshacer() {
        reunion.setLocalizacion(antiguaLocalizacion);
    }

    /**
     * Recupera el valor introducido por el usuario después de que se hubiera
     * deshecho
     */
    @Override
    public void rehacer() {
        reunion.setLocalizacion(nuevaLocalizacion);
    }
}
