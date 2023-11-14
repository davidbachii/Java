package es.uah.patronescomportamiento.Visitor;

/**
 * Llamada. Representa un elemento que será visitado. Define el método aceptar,
 * que acepta a un visitante para que realice las acciones oportunas
 *
 * @author Salvador Oton
 */
public abstract class Llamada {

    private int duracion;	//Duración de la llamada en minutos.
    private int hora;		//Hora a la que se hizo la llamada.
    private char dia;		//Día de la semana en que se hizo la llamada (L,M,X,..,D)

    /**
     * Constructor.
     *
     * @param minutos Duración de la llamada en minutos.
     * @param hora Hora a la que se hizo la llamada.
     * @param dia Día de la semana en que se hizo la llamada (L,M,X,..,D)
     */
    public Llamada(int minutos, int hora, char dia) {
        this.duracion = minutos;
        this.hora = hora;
        this.dia = dia;
    }

    /**
     * Establece la duración de la llamada en minutos.
     *
     * @param minutos
     */
    public void setDuracion(int minutos) {
        this.duracion = minutos;
    }

    /**
     * Devuelve la duración de la llamada en minutos.
     *
     * @return Duración de la llamada en minutos.
     */
    public int getDuracion() {
        return this.duracion;
    }

    /**
     * Establece la hora a la que se hizo la llamada.
     *
     * @param hora Hora a la que se hizo la llamada.
     */
    public void setHora(int hora) {
        this.hora = hora;
    }

    /**
     * Devuelve la hora a la que se hizo la llamada.
     *
     * @return Hora a la que se hizo la llamada.
     */
    public int getHora() {
        return this.hora;
    }

    /**
     * Establece el día de la semana en que se hizo la llamada (L,M,X,..,D)
     *
     * @param dia Día de la semana en que se hizo la llamada (L,M,X,..,D)
     */
    public void setDia(char dia) {
        this.dia = dia;
    }

    /**
     * Devuelve el día de la semana en que se hizo la llamada (L,M,X,..,D)
     *
     * @return Día de la semana en que se hizo la llamada (L,M,X,..,D)
     */
    public int getDia() {
        return this.dia;
    }

    /**
     * Devuelve la descripción de la llamada telefónica.
     *
     * @return
     */
    @Override
    public String toString() {
        return "# Llamada realizada el día " + dia + " a las " + hora
                + " horas, con una duración de " + duracion + " minutos.";
    }

    /**
     * Método aceptar que recibe un visitante como argumento.
     *
     * @param visitante
     * @return Coste d ela llamada.
     */
    public abstract double aceptar(Visitante visitante);
}
