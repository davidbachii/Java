package es.uah.patronesfundamentales.Proxy;

/**
 * Clase de servicio real.
 */
public class Servidor implements ServicioInt {

    /**
     * Nombre del servidor.
     */
    private String nombre;

    /**
     * Constructor.
     *
     * @param nombre Nombre del servidor.
     */
    public Servidor(String nombre) {
        this.nombre = nombre;
    }

    @Override
    public String servicio() {
        return "Ejecución del servicio desde el Servidor: " + this.nombre;
    }

}
