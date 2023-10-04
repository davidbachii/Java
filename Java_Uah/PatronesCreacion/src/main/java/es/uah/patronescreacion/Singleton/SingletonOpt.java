package es.uah.patronescreacion.Singleton;

/**
 * Inplementación del patrón Singleton.
 */
public class SingletonOpt {

    /**
     * Instancia de la clase. Es privada: solo accesible por la propia clase. Es
     * estática: propia de la clase (compartida por los objetos).
     */
    private static SingletonOpt instancia = new SingletonOpt(); // Inicialización inline.

    /**
     * Constructor privado. No se permite crear instancias de la clase Singleton
     * usando new.
     */
    private SingletonOpt() {
    }

    /**
     * Devuelve la instancia de la clase. Acceso controlado a la única
     * instancia. Otras clases que quieran una referencia a la única instancia
     * de la clase Singleton conseguirán esa instancia llamando al método
     * estático getInstancia de la clase.
     *
     * @return Instancia de la clase.
     */
    public static SingletonOpt getInstancia() {
        return instancia;
    }
}
