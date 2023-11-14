package es.uah.patronescomportamiento.TemplateMethod;

/**
 * Clase Pelicula, extiende de Producto. Representa un Producto de tipo película
 *
 * @author Salvador Oton
 */
public class Pelicula extends Producto {

    //Además del atributo título de la clase padre se añaden los protagonistas y la duración
    private String protagonistas; // Protagonistas de la película.
    private int duracion; // Duración de la película.

    /**
     * Constructor
     *
     * @param tit Título de la película.
     * @param protas Protagonistas de la película.
     * @param dur Duración de la película.
     */
    public Pelicula(String tit, String protas, int dur) {
        this.setNombreTitulo(tit);	//método de la clase padre
        this.protagonistas = protas;
        this.duracion = dur;
    }

    /**
     * Establece protagonistas de la película.
     *
     * @param protas Protagonistas de la película.
     */
    public void setProtagonistas(String protas) {
        this.protagonistas = protas;
    }

    /**
     * Devuelve protagonistas de la película.
     *
     * @return Protagonistas de la película.
     */
    public String getProtagonistas() {
        return this.protagonistas;
    }

    /**
     * Establece duración de la película.
     *
     * @param dur Duración de la película.
     */
    public void setDuracion(int dur) {
        this.duracion = dur;
    }

    /**
     * Devuelve duración de la película.
     *
     * @return Duración de la película.
     */
    public int getDuracion() {
        return this.duracion;
    }

    //Implementación de los metodos abstractos de la clase padre.
    @Override
    public String getPresentacionProducto() {
        return ("Película: " + this.getNombreTitulo() + "; protagonistas: "
                + this.getProtagonistas() + "; duración: " + this.getDuracion());
    }

    @Override
    public String getPrecio(int horas) {
        return "Precio del alquiler: " + horas * 0.5;
    }
}
