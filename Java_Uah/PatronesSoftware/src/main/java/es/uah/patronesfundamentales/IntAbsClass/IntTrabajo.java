package es.uah.patronesfundamentales.IntAbsClass;

/**
 * Interfaz con los métodos comunes a distintos tipos de trabajador.
 */
public interface IntTrabajo {

    /**
     * Devuelve el nombre de la empresa.
     *
     * @return Cadena con el nombre de la empresa.
     */
    String getEmpresa();

    /**
     * Establece el nombre de la empresa.
     *
     * @param nueva Cadena con el nombre de la empresa.
     */
    void setEmpresa(String nueva);

    /**
     * Devuelve el sueldo.
     *
     * @return Sueldo.
     */
    double getSueldo();

    /**
     * Establece el sueldo.
     *
     * @param euros Sueldo.
     */
    void setSueldo(double euros);

    /**
     * Devuelve el sueldo calculado en función de las horas.
     *
     * @param horas Horas sobre las que se calcula el sueldo a pagar.
     * @return Sueldo calculado.
     */
    double pagarSueldo(double horas);
}
