package es.uah.patronescreacion.Prototype.version2;

import java.time.LocalDate;
import java.util.StringTokenizer;

/**
 * Clase para manejar fechas (DD/MM/AAAA).
 */
public class Fecha implements Cloneable {

    /**
     * Entero que representa el año.
     */
    private int año;
    /**
     * Entero que representa el mes.
     */
    private int mes;
    /**
     * Entero que representa el día.
     */
    private int dia;

    /**
     * Constructor
     *
     * @param dia Entero que representa el día.
     * @param mes Entero que representa el mes.
     * @param año Entero que representa el año.
     */
    public Fecha(int dia, int mes, int año) {
        this.dia = dia;
        this.mes = mes;
        this.año = año;
    }

    /**
     * Constructor.
     *
     * @param cadenaFecha Fecha en formato DD/MM/AAAA
     */
    public Fecha(String cadenaFecha) {
        // Separamos los tokens que componen la fecha.
        StringTokenizer st = new StringTokenizer(cadenaFecha, "/");
        String dd = st.nextToken();
        String mm = st.nextToken();
        String aa = st.nextToken();
        // Convertimos los tokens en enteros y asignamos.
        this.dia = Integer.parseInt(dd);
        this.mes = Integer.parseInt(mm);
        this.año = Integer.parseInt(aa);
    }

    /**
     * Constructor.
     */
    public Fecha() {
        LocalDate hoy = LocalDate.now();
        año = hoy.getYear();
        mes = hoy.getMonthValue();
        dia = hoy.getDayOfMonth();
    }

    @Override
    public String toString() {
        // Nota: El código que se devuelve es el código hash del objeto. 
        // Si dos objetos tienen el mismo hash, quiere decir que son iguales.     
        return dia + "/" + mes + "/" + año + " # codigo objeto Fecha: " + this.hashCode();
    }

    /**
     * Devuelve el año.
     *
     * @return Entero que representa el año.
     */
    public int getAño() {
        return this.año;
    }

    /**
     * Establece el año.
     *
     * @param año Entero que representa el año.
     */
    public void setAño(int año) {
        this.año = año;
    }

    /**
     * Devuelve el día.
     *
     * @return Entero que representa el día.
     */
    public int getDia() {
        return this.dia;
    }

    /**
     * Establece el día.
     *
     * @param dia Entero que representa el día.
     */
    public void setDia(int dia) {
        this.dia = dia;
    }

    /**
     * Devuelve el mes.
     *
     * @return Entero que representa el mes.
     */
    public int getMes() {
        return this.mes;
    }

    /**
     * Establece el mes.
     *
     * @param mes Entero que representa el mes.
     */
    public void setMes(int mes) {
        this.mes = mes;
    }

    @Override
    public Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
}
