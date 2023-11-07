package es.uah.patronesestructurales.Decorator;

/**
 * Decorador.
 */
public abstract class Decorador implements Cuenta {

    /**
     * Referencia a la cuenta.
     */
    private Cuenta cuenta;

    /**
     * Constructor.
     *
     * @param cuenta Cuenta concreta.
     */
    public Decorador(Cuenta cuenta) {
        this.cuenta = cuenta;
    }

    /**
     * Estable la cuenta concreta.
     *
     * @param cuenta Cuenta concreta.
     */
    public void setCuenta(Cuenta cuenta) {
        this.cuenta = cuenta;
    }

    /**
     * Devuelve la cuenta concreta.
     *
     * @return Cuenta concreta.
     */
    public Cuenta getCuenta() {
        return cuenta;
    }

    @Override
    public double saldo() {
        return cuenta.saldo();
    }

    @Override
    public void ingresar(double cantidad) {
        cuenta.ingresar(cantidad);
    }

    @Override
    public void retirar(double cantidad) {
        cuenta.retirar(cantidad);
    }

    @Override
    public Cliente getCliente() {
        return cuenta.getCliente();
    }

    @Override
    public Fecha getFecApe() {
        return cuenta.getFecApe();
    }

    @Override
    public String toString() {
        return cuenta.toString();
    }

    @Override
    public abstract void aplicaIntereses();
}
