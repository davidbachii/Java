package es.uah.patronescreacion.AbstractFactory;

/**
 * Factoría concreta de fechas para España.
 */
public class SPFechaFactory implements FechaFactory {

    @Override
    public FechaTexto creaFechaTexto() {
        return new SPFechaTexto();
    }

    @Override
    public FechaNum creaFechaNum() {
        return new SPFechaNum();
    }
}
