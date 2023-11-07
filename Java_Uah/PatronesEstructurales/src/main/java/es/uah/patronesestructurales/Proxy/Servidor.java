package es.uah.patronesestructurales.Proxy;

/**
 * Sujeto: Define la interfaz común para el Proxy y el SujetoReal de forma que
 * se pueda usar un Proxy donde se espere un SujetoReal.
 */
public interface Servidor {

    /**
     * Sube un fichero al servidor.
     *
     * @param nomFich Nombre del fichero.
     * @return Texto con el resultado de la operación.
     */
    public String subir(String nomFich);

    /**
     * Descarga un fichero del servidor.
     *
     * @param id Identificador del fichero.
     * @return Fichero físico.
     */
    public Fichero bajar(String id);

    /**
     * Lista los ficheros del servidor.
     *
     * @return Ficheros del servidor.
     */
    public String listado();
}
