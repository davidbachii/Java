package es.uah.patronescomportamiento.TemplateMethod;

/**
 * Clase Juego, extiende de Producto. Representa un Producto de tipo juego.
 *
 * @author Salvador Oton
 */
public class Juego extends Producto {

    //Además del atributo título de la clase padre se añaden el género y el idioma del juego
    private String genero; // Género del juego.
    private String idioma; // Idioma del juego.

    /**
     * Constructor
     *
     * @param titulo Título del juego.
     * @param genero Género del juego.
     * @param idioma Idioma del juego.
     */
    public Juego(String titulo, String genero, String idioma) {
        this.setNombreTitulo(titulo);	//método de la clase padre
        this.genero = genero;
        this.idioma = idioma;
    }

    /**
     * Establece el género del juego.
     *
     * @param gen Género del juego.
     */
    public void setGenero(String gen) {
        this.genero = gen;
    }

    /**
     * Devuelve el género del juego.
     *
     * @return Género del juego.
     */
    public String getGenero() {
        return this.genero;
    }

    /**
     * Establece el idioma del juego.
     *
     * @param id Idioma del juego.
     */
    public void setIdioma(String id) {
        this.idioma = id;
    }

    /**
     * Devuelve el idioma del juego.
     *
     * @return Idioma del juego.
     */
    public String getIdioma() {
        return this.idioma;
    }

    //Implementación de los métodos abstractos de la clase padre.
    @Override
    public String getPresentacionProducto() {
        return ("Juego: " + this.getNombreTitulo() + "; género: "
                + this.getGenero() + "; idioma: " + this.idioma);
    }

    @Override
    public String getPrecio(int horas) {
        return "Precio del alquiler: " + horas * 0.75;
    }
}
