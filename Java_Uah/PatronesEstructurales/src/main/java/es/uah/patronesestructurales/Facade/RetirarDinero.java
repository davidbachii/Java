package es.uah.patronesestructurales.Facade;

/**
 * Subsistema de retirada de dinero.
 */
public class RetirarDinero {

    /**
     * Retira dinero.
     *
     * @return Descripción de los pasos de la operación.
     */
    public String retirar() {
        String res;
        res = "\n### Retirar Dinero:"
                + "\n\tComprobación del saldo..."
                + "\n\tsacando el dinero..."
                + "\n\tactualizando el saldo...";
        return res;
    }
}
