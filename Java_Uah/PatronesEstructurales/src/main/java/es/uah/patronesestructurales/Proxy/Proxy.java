package es.uah.patronesestructurales.Proxy;

/**
 * Proxy: Ofrece una interfaz equivalente al de la clase SujetoReal, y redirige
 * las llamadas de los métodos al objeto real. Puede realizar un
 * pre-procesamiento y un post-procesamiento sobre los servicios ofrecidos por
 * la clase real.
 */
public class Proxy implements Servidor {

    /**
     * Referencia al servidor real.
     */
    private Servidor serv;

    /**
     * Constructor.
     *
     * @param serv Servidor real.
     */
    public Proxy(Servidor serv) {
        this.serv = serv;
    }

    /**
     * Establece el servidor real.
     *
     * @param serv Servidor real.
     */
    public void setServidor(Servidor serv) {
        this.serv = serv;
    }

    /**
     * Devuelve el servidor real.
     *
     * @return Servidor real.
     */
    public Servidor getServidor() {
        return serv;
    }

    @Override
    public String subir(String nomFich) {
        return "\n(Subiendo desde el proxy...)" + serv.subir(nomFich);
    }

    @Override
    public Fichero bajar(String id) {
        return serv.bajar(id);
    }

    @Override
    public String listado() {
        return "\n(Listando desde el proxy...)" + serv.listado();
    }
}
