package es.uah.patronescreacion.AbstractFactory;

/**
 * Clase abstracta (producto abstracto) que representa una fecha de tipo texto
 */
public abstract class FechaTexto {

    /**
     * Cadena que representa el día.
     */
    private String dia;
    /**
     * Cadena que representa el mes.
     */
    private String mes;
    /**
     * Cadena que representa el año.
     */
    private String año;

    /**
     * Método abstracto que devuelve una cadena con la fecha en un formato
     * determinado.
     *
     * @return Cadena con la fecha
     */
    public abstract String presentaFT();

    /**
     * Devuelve el año.
     *
     * @return Cadena que representa el año.
     */
    public String getAño() {
        return this.año;
    }

    /**
     * Establece el año.
     *
     * @param año Cadena que representa el año.
     */
    public void setAño(String año) {
        this.año = año;
    }

    /**
     * Devuelve el día.
     *
     * @return Cadena que representa el día.
     */
    public String getDia() {
        return this.dia;
    }

    /**
     * Establece el día.
     *
     * @param dia Cadena que representa el día.
     */
    public void setDia(String dia) {
        this.dia = dia;
    }

    /**
     * Devuelve el mes.
     *
     * @return Cadena que representa el mes.
     */
    public String getMes() {
        return this.mes;
    }

    /**
     * Establece el mes.
     *
     * @param mes Cadena que representa el mes.
     */
    public void setMes(String mes) {
        this.mes = mes;
    }
}
