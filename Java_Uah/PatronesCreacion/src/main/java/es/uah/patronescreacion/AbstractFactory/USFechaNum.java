package es.uah.patronescreacion.AbstractFactory;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

/**
 * Clase concreta (producto concreto) que representa una fecha de tipo numérico
 * para USA.
 */
public class USFechaNum extends FechaNum {

    @Override
    public String presentaFN() {
        Locale local = new Locale("en", "US");
        Date hoy = new Date();
        String hoystr = DateFormat.getDateTimeInstance(DateFormat.SHORT, DateFormat.SHORT, local).format(hoy);
        return hoystr;
    }
}
