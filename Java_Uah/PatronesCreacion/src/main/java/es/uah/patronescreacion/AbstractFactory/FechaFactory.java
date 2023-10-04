package es.uah.patronescreacion.AbstractFactory;

/**
 * Factoría abstracta para crear distintos tipos de objetos fecha.
 */
public interface FechaFactory {

    /**
     * Crea un objeto de tipo FechaTexto.
     *
     * @return Objeto de tipo FechaTexto.
     */
    public FechaTexto creaFechaTexto();

    /**
     * Crea un objeto de tipo FechaNum.
     *
     * @return Objeto de tipo FechaNum.
     */
    public FechaNum creaFechaNum();
}
