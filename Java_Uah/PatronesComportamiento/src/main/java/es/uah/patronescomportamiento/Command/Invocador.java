package es.uah.patronescomportamiento.Command;

/**
 * El que llama al método ejecutar del objeto Comando.
 *
 * @author Salvador Oton
 */
public class Invocador {

    //Comando al que le pediremos que ejecute la petición.
    private ComandoDeshacer comando;

    /**
     * Establece el comando.
     *
     * @param comando
     */
    public void setComando(ComandoDeshacer comando) {
        this.comando = comando;
    }

    /**
     * Ejecuta el comando.
     *
     * @param param
     */
    public void ejecutaComando(String param) {
        comando.ejecutar(param);
    }

    /**
     * Deshace el comando.
     */
    public void deshacerComando() {
        comando.deshacer();
    }

    /**
     * Rehace el comando.
     */
    public void rehacerComando() {
        comando.rehacer();
    }
}
