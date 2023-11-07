package es.uah.patronesestructurales.Bridge;

import java.util.Collections;

/**
 * Implementa la interfaz OfertasImp y define su implementación concreta.
 */
public class OfertasImpCiudad extends OfertasImp {

    @Override
    public String ordena(String criterio) {
        //Ordenamos los objetos del array por el atributo ciudad y por el criterio indicado: ascendente o descendente
        // Para ordenar usamos el comparador.
        Collections.sort(Datos.getOfertas(), CiudadComp);
        if (criterio.equals("des")) {
            Collections.reverse(Datos.getOfertas());
        }
        //Componemos la cadena
        return Datos.listadoOfertas();
    }
}
