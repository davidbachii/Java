package es.uah.patronescreacion.Singleton;

/**
 * Inplementación del patrón Singleton.
 */
public class Singleton {

    /**
     * Instancia de la clase. Es privada: solo accesible por la propia clase. Es
     * estática: propia de la clase (compartida por los objetos).
     */
    private static Singleton instancia;

    /**
     * Constructor privado. No se permite crear instancias de la clase Singleton
     * usando new.
     */
    private Singleton() {
    }

    /**
     * Devuelve la instancia de la clase. Acceso controlado a la única
     * instancia. Otras clases que quieran una referencia a la única instancia
     * de la clase Singleton conseguirán esa instancia llamando al método
     * estático getInstancia de la clase.
     *
     * @return Instancia de la clase.
     */
    public static Singleton getInstancia() {
        if (instancia == null) {// Si la instancia es null, se crea.
            instancia = new Singleton();
        }
        return instancia;
    }
}
