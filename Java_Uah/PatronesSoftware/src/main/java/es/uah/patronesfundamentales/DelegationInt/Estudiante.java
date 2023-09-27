package es.uah.patronesfundamentales.DelegationInt;

/**
 * Clase que representa a un estudiante.
 */
public class Estudiante implements Descripcion { //PATRON DE INTERFAZ se usa implements no extends

    /**
     * Nombre de la universidad a la que pertenece el estudiante.
     */
    private String universidad;
    /**
     * Nombre de la titulación que cursa el estudiante.
     */
    private String titulacion;

    /**
     * Constructor.
     *
     * @param universidad Nombre de la universidad a la que pertenece el
     * estudiante.
     * @param titulacion Nombre de la titulación que cursa el estudiante.
     */
    public Estudiante(String universidad, String titulacion) {
        this.universidad = universidad;
        this.titulacion = titulacion;
    }

    /**
     * Devuelve una cadena con el nombre de la universidad a la que pertenece el
     * estudiante.
     *
     * @return Nombre de la universidad a la que pertenece el estudiante.
     */
    public String getUniversidad() {
        return universidad;
    }

    /**
     * Establece el nombre de la universidad a la que pertenece el estudiante.
     *
     * @param universidad Nombre de la universidad a la que pertenece el
     * estudiante.
     */
    public void setUniversidad(String universidad) {
        this.universidad = universidad;
    }

    /**
     * Devuelve una cadena con el nombre de la titulación que cursa el
     * estudiante.
     *
     * @return Nombre de la titulación que cursa el estudiante.
     */
    public String getTitulacion() {
        return titulacion;
    }

    /**
     * Establece el nombre de la titulación que cursa el estudiante.
     *
     * @param titulacion Nombre de la titulación que cursa el estudiante.
     */
    public void setTitulacion(String titulacion) {
        this.titulacion = titulacion;
    }

    @Override
    public String descripcion() { //PATRON DE INTERFAZ
        return this.getUniversidad() + " - " + this.getTitulacion();
    }
}
