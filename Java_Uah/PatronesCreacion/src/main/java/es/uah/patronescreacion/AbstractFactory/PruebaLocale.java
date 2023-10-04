package es.uah.patronescreacion.AbstractFactory;

import java.util.*;
import java.text.*;

/**
 * Prueba de la clase java.util.Locale Podemos utilizar la clase
 * java.util.Locale para determinar la configuración regional de nuestro
 * sistema.
 */
public class PruebaLocale {

    /**
     * Método de arranque del programa.
     *
     * @param args
     */
    public static void main(String args[]) {
        Locale local;
        Date hoy = new Date();
        String hoystr;

        // Leemos la configuración regional y mostramos fecha actual con esta configuración.
        local = Locale.getDefault();
        System.out.println("Configuración regional: " + local);
        hoystr = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, local).format(hoy);
        System.out.println("Hoy: " + hoystr);

        // Establecemos configuración de USA y mostramos fecha actual con esta configuración.
        local = new Locale("en", "US");
        System.out.println("Configuración regional: " + local);
        hoystr = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, local).format(hoy);
        System.out.println("Hoy: " + hoystr);
    }
}
