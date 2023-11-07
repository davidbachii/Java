package es.uah.patronesestructurales.Bridge;

/**
 * Abstracción: Define la interfaz de la abstracción y mantiene una referencia
 * al objeto Implementador.
 */
public class OfertasAbst {

    /**
     * Referencia al objeto Implementador.
     */
    private OfertasImp imp;

    /**
     * Ordena las ofertas de empleo según el criterio pasado como arguumento.
     *
     * @param criterio Criterio de ordenación.
     * @return Cadena con las ofertas ordenadas.
     */
    public String ordena(String criterio) {
        return imp.ordena(criterio);
    }

    /**
     * Establece un implementador concreto.
     *
     * @param oi Implementador concreto.
     */
    public void setImplementador(OfertasImp oi) {
        this.imp = oi;
    }

    /**
     * Devuelve el implementador concreto.
     *
     * @return Implementador concreto.
     */
    public OfertasImp getImplementador() {
        return this.imp;
    }

}
