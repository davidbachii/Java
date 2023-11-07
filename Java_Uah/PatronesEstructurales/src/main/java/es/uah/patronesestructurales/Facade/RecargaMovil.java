package es.uah.patronesestructurales.Facade;

/**
 * Subsistema de regarga de móvil.
 */
public class RecargaMovil {

    /**
     * Recarga el móvil.
     *
     * @return Descripción de los pasos de la operación.
     */
    public String recarga() {
        String res;
        res = "\n### Recarga Móvil:"
                + "\n\tComprobación del saldo..."
                + "\n\tpidiendo el número de teléfono móvil..."
                + "\n\trecargando el movil..."
                + "\n\tactualizando el saldo...";
        return res;
    }
}
