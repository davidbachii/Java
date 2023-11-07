package es.uah.patronesestructurales.Bridge;

import java.util.Collections;

/**
 * Implementa la interfaz OfertasImp y define su implementación concreta.
 */
public class OfertasImpFecha extends OfertasImp {

    @Override
    public String ordena(String criterio) {
        //Ordenamos los objetos del array por el atributo fecha y por el criterio indicado: ascendente o descendente
        // Para ordenar usamos el comparador.
        Collections.sort(Datos.getOfertas(), FechaComp);
        if (criterio.equals("des")) {
            Collections.reverse(Datos.getOfertas());
        }
        //Componemos la cadena
        return Datos.listadoOfertas();
    }
}
