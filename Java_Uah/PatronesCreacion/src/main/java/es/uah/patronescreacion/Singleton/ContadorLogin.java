package es.uah.patronescreacion.Singleton;

import java.util.ArrayList;

/**
 * Clase para manejar el login/logout de los usuarios. Implementa el patrón
 * Singleton.
 */
public class ContadorLogin {

    /**
     * Lista de usuarios logados.
     */
    private ArrayList<String> usuarios = new ArrayList<>();
    /**
     * Instancia de la clase.
     */
    private static ContadorLogin instancia;

    /**
     * Constructor privado.
     */
    private ContadorLogin() {
    }

    /**
     * Devuelve la instancia de la clase.
     *
     * @return Instancia de la clase.
     */
    public static ContadorLogin getInstancia() {
        if (instancia == null) {// Si la instancia es null, se crea.
            instancia = new ContadorLogin();
        }
        return instancia;
    }

    /**
     * Comprueba si el usuario está logado.
     *
     * @param userId Identificador del usuario.
     * @return true si el usuario está logado, false en caso contrario.
     */
    public boolean estaLogado(String userId) {
        return usuarios.contains(userId);
    }

    /**
     * Añade al usuario pasado como argumento a la lista de usuarios logados en
     * caso de que no esté logado.
     *
     * @param userId Identificador del usuario.
     */
    public void addLogin(String userId) {
        if (!estaLogado(userId)) {
            usuarios.add(userId);
        }
    }

    /**
     * Elimina al usuario pasado como argumento de la lista de usuarios logados
     * en caso de que esté logado.
     *
     * @param userId Identificador del usuario.
     */
    public void borrarLogin(String userId) {
        if (estaLogado(userId)) {
            usuarios.remove(userId);
        }
    }
}
