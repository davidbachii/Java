package es.uah.patronesestructurales.Decorator;

/**
 * Decorador concreto.
 */
public class CuentaCorriente extends Decorador {

    /**
     * Tarjeta de crédito asociada a la cuenta corriente.
     */
    private String tarjetaCredito;

    /**
     * Constructor.
     *
     * @param c Cuenta concreta.
     * @param tc Tarjeta de crédito asociada a la cuenta corriente.
     */
    public CuentaCorriente(Cuenta c, String tc) {
        super(c);
        this.tarjetaCredito = tc;
    }

    /**
     * Devuelve la tarjeta de crédito asociada a la cuenta corriente.
     *
     * @return Tarjeta de crédito asociada a la cuenta corriente.
     */
    public String getTarjeta() {
        return this.tarjetaCredito;
    }

    /**
     * Incrementa el saldo de la cuenta en un 0.5% sobre el saldo actual de
     * esta.
     */
    @Override
    public void aplicaIntereses() {
        double interes = 0.5; //0.5% de interés para todas las cuentas corrientes
        double saldoActual = super.saldo();
        super.getCuenta().ingresar(saldoActual * (interes / 100));
    }

    @Override
    public String toString() {
        return super.toString() + "\nTarjeta de Crédito: " + tarjetaCredito;
    }
}
