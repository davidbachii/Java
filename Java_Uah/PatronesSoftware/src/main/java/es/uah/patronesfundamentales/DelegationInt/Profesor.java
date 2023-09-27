package es.uah.patronesfundamentales.DelegationInt;

/**
 * Clase que representa a un profesor.
 */
public class Profesor implements Descripcion {

    /**
     * Nombre del departamento al que pertenece el profesor.
     */
    private String departamento;
    /**
     * Sueldo del profesor.
     */
    private double sueldo;

    /**
     * Constructor
     *
     * @param departamento Nombre del departamento al que pertenece el profesor.
     * @param sueldo Sueldo del profesor.
     */
    public Profesor(String departamento, double sueldo) {
        this.departamento = departamento;
        this.sueldo = sueldo;
    }

    /**
     * Devuelve una cadena con el nombre del departamento al que pertenece el
     * profesor.
     *
     * @return Nombre del departamento al que pertenece el profesor.
     */
    public String getDepartamento() {
        return departamento;
    }

    /**
     * Establece el nombre del departamento al que pertenece el profesor.
     *
     * @param departamento Nombre del departamento al que pertenece el profesor.
     */
    public void setDepartamento(String departamento) {
        this.departamento = departamento;
    }

    /**
     * Devuelve el sueldo del profesor.
     *
     * @return Sueldo del profesor.
     */
    public double getSueldo() {
        return sueldo;
    }

    /**
     * Establece el sueldo del profesor.
     *
     * @param sueldo Sueldo del profesor.
     */
    public void setSueldo(double sueldo) {
        this.sueldo = sueldo;
    }

    @Override
    public String descripcion() {
        return this.getDepartamento() + " - " + this.getSueldo();
    }
}
