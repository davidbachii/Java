package es.uah.patronescreacion.Singleton.ObjectPool;

/**
 * Excepcion que maneja el caso en que alcancemos el tamaño máximo de conexiones
 * en la piscina.
 */
public class ErrorPiscina extends Exception {

    /**
     * Constructor.
     */
    public ErrorPiscina() {
        super("Superado el número máximo de conexiones a la BD");
    }

    /**
     * Constructor.
     *
     * @param s Descripción del error.
     */
    public ErrorPiscina(String s) {
        super(s);
    }
}
