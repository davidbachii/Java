package es.uah.patronescreacion.AbstractFactory;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

/**
 * Clase concreta (producto concreto) que representa una fecha de tipo numérico
 * para España.
 */
public class SPFechaNum extends FechaNum {

    @Override
    public String presentaFN() {
        Locale local = new Locale("es", "ES");
        Date hoy = new Date();
        String hoystr = DateFormat.getDateTimeInstance(DateFormat.SHORT, DateFormat.SHORT, local).format(hoy);
        return hoystr;
    }
}
