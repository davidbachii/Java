package es.uah.patronesestructurales.Adapter;

/**
 * Interface para manejar fechas en formato de España (ES): DD/MM/AAAA.
 */
public interface Fecha {

    /**
     * Devuelve una cadena con la fecha en formato de España (DD/MM/AAAA).
     *
     * @return Fecha en formato de España (DD/MM/AAAA)
     */
    @Override
    public String toString();

    /**
     * Devuelve el año.
     *
     * @return Entero que representa el año.
     */
    public int getAño();

    /**
     * Estable el año.
     *
     * @param año Entero que representa el año.
     */
    public void setAño(int año);

    /**
     * Devuelve el día.
     *
     * @return Entero que representa el día.
     */
    public int getDia();

    /**
     * Establece el día.
     *
     * @param dia Entero que representa el día.
     */
    public void setDia(int dia);

    /**
     * Devuelve el mes.
     *
     * @return Entero que representa el mes.
     */
    public int getMes();

    /**
     * Establece el mes.
     *
     * @param mes Entero que representa el mes.
     */
    public void setMes(int mes);
}
