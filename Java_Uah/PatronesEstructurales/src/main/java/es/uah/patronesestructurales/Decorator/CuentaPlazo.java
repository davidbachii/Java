package es.uah.patronesestructurales.Decorator;

/**
 * Decorador concreto.
 */
public class CuentaPlazo extends Decorador {

    /**
     * Interés aplicado a la cuenta a plazo.
     */
    private double interes;
    /**
     * Plazo en años.
     */
    private int plazo;

    /**
     * Constructor.
     *
     * @param c Cuenta concreta.
     * @param interes Interés aplicado a la cuenta a plazo.
     * @param plazo Plazo en años.
     */
    public CuentaPlazo(Cuenta c, double interes, int plazo) {
        super(c);
        this.interes = interes;
        this.plazo = plazo;
    }

    /**
     * Incrementa el saldo de la cuenta en función del interés y el plazo.
     */
    @Override
    public void aplicaIntereses() {
        double saldoActual = super.saldo();
        super.getCuenta().ingresar(saldoActual * (interes / 100) * plazo);
    }

    /**
     * Devuelve el interés aplicado a la cuenta a plazo.
     *
     * @return Interés aplicado a la cuenta a plazo.
     */
    public double getInteres() {
        return this.interes;
    }

    /**
     * Devuelve el plazo en años.
     *
     * @return Plazo en años.
     */
    public int getPlazo() {
        return this.plazo;
    }

    @Override
    public String toString() {
        return super.toString() + "\nInterés: " + interes + " - Plazo: " + plazo;
    }
}
