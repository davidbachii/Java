package es.uah.patronescreacion.AbstractFactory;

/**
 * Factoría concreta de fechas para USA.
 */
public class USFechaFactory implements FechaFactory {

    @Override
    public FechaTexto creaFechaTexto() {
        return new USFechaTexto();
    }

    @Override
    public FechaNum creaFechaNum() {
        return new USFechaNum();
    }
}
