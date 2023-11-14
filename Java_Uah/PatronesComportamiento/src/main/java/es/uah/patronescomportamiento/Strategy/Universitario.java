package es.uah.patronescomportamiento.Strategy;

/**
 * Clase que representa a un alumno de la universidad.
 *
 * @author Salvador Oton
 */
public class Universitario {

    private String dni; // DNI del alumno.
    private String nombre; // Nombre del alumno.
    private String carrera; // Carrera que estudia el alumno.
    private String universidad; // Universidad a la que pertenece el alumno.

    /**
     * Constructor.
     *
     * @param dni DNI del alumno.
     * @param nombre Nombre del alumno.
     * @param carrera Carrera que estudia el alumno.
     * @param universidad Universidad a la que pertenece el alumno.
     */
    public Universitario(String dni, String nombre, String carrera, String universidad) {
        this.dni = dni;
        this.nombre = nombre;
        this.carrera = carrera;
        this.universidad = universidad;
    }

    /**
     * Devuelve el DNI del alumno.
     *
     * @return DNI del alumno.
     */
    public String getDni() {
        return this.dni;
    }

    /**
     * Establece el DNI del alumno.
     *
     * @param dni DNI del alumno.
     */
    public void setDni(String dni) {
        this.dni = dni;
    }

    /**
     * Devuelve el nombre del alumno.
     *
     * @return Nombre del alumno.
     */
    public String getNombre() {
        return this.nombre;
    }

    /**
     * Establece el nombre del alumno.
     *
     * @param nombre Nombre del alumno.
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * Devuelve la carrera que estudia el alumno.
     *
     * @return Carrera que estudia el alumno.
     */
    public String getCarrera() {
        return this.carrera;
    }

    /**
     * Establece la carrera que estudia el alumno.
     *
     * @param carrera Carrera que estudia el alumno.
     */
    public void setCarrera(String carrera) {
        this.carrera = carrera;
    }

    /**
     * Devuelve la universidad a la que pertenece el alumno.
     *
     * @return Universidad a la que pertenece el alumno.
     */
    public String getUniversidad() {
        return this.universidad;
    }

    /**
     * Establece la universidad a la que pertenece el alumno.
     *
     * @param universidad Universidad a la que pertenece el alumno.
     */
    public void setUniversidad(String universidad) {
        this.universidad = universidad;
    }

    /**
     * Devuelve la descripción del alumno.
     *
     * @return Descripción del alumno.
     */
    @Override
    public String toString() {
        return dni + " " + nombre + " # Carrera: " + carrera + " # Universidad: " + universidad;
    }
}
