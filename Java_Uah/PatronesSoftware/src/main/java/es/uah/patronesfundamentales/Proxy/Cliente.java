package es.uah.patronesfundamentales.Proxy;

/**
 * Clase cliente.
 */
public class Cliente {

    /**
     * Creación del proxy.
     */
    private static ServicioInt proxy = new Proxy(new Servidor("MiServidor"));

    /**
     * Método de arranque del programa.
     *
     * @param args
     */
    public static void main(String args[]) {
        System.out.println("Ejcución servicio:\n" + proxy.servicio());
    }
}
