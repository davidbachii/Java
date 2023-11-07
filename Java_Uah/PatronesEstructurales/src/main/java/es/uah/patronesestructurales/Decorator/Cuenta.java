package es.uah.patronesestructurales.Decorator;

/**
 * Componente. Interfaz con las operaciones de una cuenta.
 */
public interface Cuenta {

    /**
     * Devuelve el saldo de la cuenta.
     *
     * @return Saldo de la cuenta.
     */
    public double saldo();

    /**
     * Realiza un ingreso en cuenta. Aumenta el saldo de la cuenta.
     *
     * @param cantidad Cantidad a ingresar.
     */
    public void ingresar(double cantidad);

    /**
     * Realiza una retirada de la cuenta. Decrementa el saldo de la cuenta.
     *
     * @param cantidad Cantidad a retirar.
     */
    public void retirar(double cantidad);

    /**
     * Devuelve el cliente titular al que pertenece la cuenta.
     *
     * @return Cliente al que pertenece la cuenta.
     */
    public Cliente getCliente();

    /**
     * Devuelve la fecha de apertura de la cuenta.
     *
     * @return Fecha de apertura de la cuenta.
     */
    public Fecha getFecApe();

    /**
     * Devuelve una cadena con la descripción de la cuenta.
     *
     * @return Cadena con la descripción de la cuenta.
     */
    @Override
    public String toString();

    /**
     * Realiza la operación de aplicar intereses a la cuenta.
     */
    public void aplicaIntereses();
}
