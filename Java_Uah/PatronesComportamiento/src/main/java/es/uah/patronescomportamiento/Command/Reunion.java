package es.uah.patronescomportamiento.Command;

/**
 * Representa el receptor del patrón.
 *
 * @author Salvador Oton
 */
public class Reunion {

    private String motivo;              //Motivo de la reunión.
    private String participantes; 	//Gente que irá a la reunión.
    private String localizacion; 	//Sitio en que se producira la reunión.
    private FechaHora fecha; 		//Fecha de la reunión.

    /**
     * Constructor.
     *
     * @param motivo Motivo de la reunión.
     * @param participantes Gente que irá a la reunión.
     * @param localizacion Sitio en que se producira la reunión.
     * @param fecha Fecha de la reunión.
     */
    public Reunion(String motivo, String participantes, String localizacion, FechaHora fecha) {
        this.motivo = motivo;
        this.participantes = participantes;
        this.localizacion = localizacion;
        this.fecha = fecha;
    }

    /**
     * Devuelve el motivo de la reunión.
     *
     * @return Motivo de la reunión.
     */
    public String getMotivo() {
        return this.motivo;
    }

    /**
     * Establece el motivo de la reunión.
     *
     * @param nuevo Motivo de la reunión.
     */
    public void setMotivo(String nuevo) {
        this.motivo = nuevo;
    }

    /**
     * Devuelve la gente que irá a la reunión.
     *
     * @return Gente que irá a la reunión.
     */
    public String getParticipantes() {
        return this.participantes;
    }

    /**
     * Establece la gente que irá a la reunión.
     *
     * @param nuevos Gente que irá a la reunión.
     */
    public void setParticipantes(String nuevos) {
        this.participantes = nuevos;
    }

    /**
     * Devuelve el sitio en que se producira la reunión.
     *
     * @return Sitio en que se producira la reunión.
     */
    public String getLocalizacion() {
        return this.localizacion;
    }

    /**
     * Establece el sitio en que se producira la reunión.
     *
     * @param nueva Sitio en que se producira la reunión.
     */
    public void setLocalizacion(String nueva) {
        this.localizacion = nueva;
    }

    /**
     * Devuelve la fecha de la reunión.
     *
     * @return Fecha de la reunión.
     */
    public FechaHora getFecha() {
        return this.fecha;
    }

    /**
     * Establece la fecha de la reunión.
     *
     * @param nueva Fecha de la reunión.
     */
    public void setFecha(FechaHora nueva) {
        this.fecha = nueva;
    }

    /**
     * Devuelve la descripción de la reunión.
     *
     * @return Cadena con la descripción de la reunión.
     */
    @Override
    public String toString() {
        return "\n#### Reunión #### \n# " + motivo + " \n# " + participantes
                + " \n# " + localizacion + " \n# " + fecha.toString();
    }
}
