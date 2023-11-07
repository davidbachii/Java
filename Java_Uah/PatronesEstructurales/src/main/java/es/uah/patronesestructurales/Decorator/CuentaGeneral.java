package es.uah.patronesestructurales.Decorator;

/**
 * Componente concreto.
 */
public class CuentaGeneral implements Cuenta {

    /**
     * Saldo de la cuenta.
     */
    private double saldo;
    /**
     * Titular de la cuenta.
     */
    private Cliente cliente;
    /**
     * Fecha de apertura de la cuenta.
     */
    private Fecha fecApertura;

    /**
     * Constructor.
     *
     * @param saldoini Saldo inicial de la cuenta.
     * @param cliente Titular de la cuenta.
     */
    public CuentaGeneral(double saldoini, Cliente cliente) {
        this.saldo = saldoini;
        this.cliente = cliente;
        this.fecApertura = new Fecha();
    }

    @Override
    public double saldo() {
        return this.saldo;
    }

    @Override
    public void ingresar(double cantidad) {
        this.saldo += cantidad;
    }

    @Override
    public void retirar(double cantidad) {
        this.saldo -= cantidad;
    }

    @Override
    public Cliente getCliente() {
        return this.cliente;
    }

    @Override
    public Fecha getFecApe() {
        return this.fecApertura;
    }

    @Override
    public String toString() {
        return "\n### Información cuenta:\n Cliente: \n" + cliente.toString()
                + "\n Fecha apertura: " + this.fecApertura;
    }

    @Override
    public void aplicaIntereses() {
    }
}
