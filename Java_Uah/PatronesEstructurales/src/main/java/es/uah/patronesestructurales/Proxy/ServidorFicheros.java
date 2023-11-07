package es.uah.patronesestructurales.Proxy;

import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;

/**
 * SujetoReal: Es la clase que implementa los servicios reales ofrecidos, puede
 * ser una instancia local o remota.
 */
public class ServidorFicheros implements Servidor {

    /**
     * Nombre del servidor.
     */
    private String nombre;
    /**
     * Tabla hash de ficheros donde se almacenan pares (id, referencia al
     * fichero físico)
     */
    private HashMap<String, Fichero> ficheros;
    /**
     * Fichero
     */
    private Fichero fich;

    /**
     * Constructor.
     *
     * @param nombre Nombre del servidor.
     */
    public ServidorFicheros(String nombre) {
        this.nombre = nombre;
        ficheros = new HashMap<>();
    }

    @Override
    public String subir(String nomFich) {
        fich = new Fichero(nomFich);
        ficheros.put(fich.getId(), fich);
        return "\nFichero subido correctamente.";
    }

    @Override
    public Fichero bajar(String id) {
        return ficheros.get(id);
    }

    @Override
    public String listado() {
        String lis = "\n### Listado del servidor: " + this.nombre + " ###";
        Collection c = ficheros.values();
        Iterator i = c.iterator();
        while (i.hasNext()) {
            fich = (Fichero) i.next();
            lis += "\n\t" + fich.toString();
        }
        return lis;
    }
}
