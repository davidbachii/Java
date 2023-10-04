package es.uah.patronescreacion.AbstractFactory;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

/**
 * Clase concreta (producto concreto) que representa una fecha de tipo texto
 * para España.
 */
public class SPFechaTexto extends FechaTexto {

    @Override
    public String presentaFT() {
        Locale local = new Locale("es", "ES");
        Date hoy = new Date();
        String hoystr = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, local).format(hoy);
        return hoystr;
    }
}
