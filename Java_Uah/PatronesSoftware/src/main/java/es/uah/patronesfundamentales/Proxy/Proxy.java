package es.uah.patronesfundamentales.Proxy;

/**
 * Clase proxy o representante
 */
public class Proxy implements ServicioInt {

    /**
     * Servicio real en el que se delega.
     */
    private Servidor serv;

    /**
     * Constructor.
     *
     * @param serv Servicio real en el que se delega.
     */
    public Proxy(Servidor serv) {
        this.serv = serv;
    }

    /**
     * Estable el servicio real en el que se delega.
     *
     * @param serv Servicio real en el que se delega.
     */
    public void setServidor(Servidor serv) {
        this.serv = serv;
    }

    /**
     * Devuelve el servicio real en el que se delega.
     *
     * @return Servicio real en el que se delega.
     */
    public Servidor getServidor() {
        return serv;
    }

    @Override
    public String servicio() {
        //delegación
        return "Llamando al servidor desde el Proxy para que ejecute el servicio:\n" + serv.servicio();
    }
}
