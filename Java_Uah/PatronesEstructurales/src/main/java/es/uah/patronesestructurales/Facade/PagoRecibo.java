/**
 * Subsistema de pago de recibo.
 */
package es.uah.patronesestructurales.Facade;

public class PagoRecibo {

    /**
     * Retira dinero.
     *
     * @return Descripción de los pasos de la operación.
     */
    public String pagar() {
        String res;
        res = "\n### Pago de Recibo:"
                + "\n\tComprobación del saldo..."
                + "\n\tpagando el recibo..."
                + "\n\tactualizando el saldo...";
        return res;
    }
}
