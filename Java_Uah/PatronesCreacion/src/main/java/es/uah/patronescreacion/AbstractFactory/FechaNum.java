package es.uah.patronescreacion.AbstractFactory;

/**
 * Clase abstracta (producto abstracto) que representa una fecha de tipo
 * numérico
 */
public abstract class FechaNum {

    /**
     * Entero que representa el día.
     */
    private int dia;
    /**
     * Entero que representa el mes.
     */
    private int mes;
    /**
     * Entero que representa el año.
     */
    private int año;

    /**
     * Método abstracto que devuelve una cadena con la fecha en un formato
     * determinado.
     *
     * @return Cadena con la fecha
     */
    public abstract String presentaFN();

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
}
