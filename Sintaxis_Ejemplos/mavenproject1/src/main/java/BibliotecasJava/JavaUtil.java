/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BibliotecasJava;

/**
 *
 * @author david
 */
import java.util.ArrayList;
import java.util.List;
/*Esta es una de las bibliotecas más fundamentales en Java y proporciona clases 
y utilidades para manipulación de colecciones, fechas, y otras estructuras de datos.*/
public class JavaUtil {

    public static void main(String[] args) {
        List<String> listaNombres = new ArrayList<>();
        listaNombres.add("Juan");
        listaNombres.add("María");
        listaNombres.add("Carlos");

        for (String nombre : listaNombres) {
            System.out.println(nombre);
        }
    }
}

