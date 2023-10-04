package es.uah.patronescreacion.Builder;

/**
 * Clase que representa el producto complejo en construcción: la pizza.
 */
public class Pizza {

    /**
     * Nombre de la pizza.
     */
    private String nombre;
    /**
     * Tipo de masa de la pizza.
     */
    private String masa;
    /**
     * Salsa de la pizza.
     */
    private String salsa;
    /**
     * Ingredientes de la pizza
     */
    private String ingredientes;

    /**
     * Constructor por defecto
     */
    public Pizza() {
    }

    /**
     * Devuelve el nombre de la pizza.
     *
     * @return Cadena con el nombre de la pizza.
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * Estable el nombre de la pizza.
     *
     * @param nombre Cadena con el nombre de la pizza.
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * Devuelve el tipo de masa de la pizza.
     *
     * @return Cadena con el tipo de masa de la pizza.
     */
    public String getMasa() {
        return masa;
    }

    /**
     * Establece el tipo de masa de la pizza.
     *
     * @param masa Cadena con el tipo de masa de la pizza.
     */
    public void setMasa(String masa) {
        this.masa = masa;
    }

    /**
     * Devuelve el tipo de salsa de la pizza.
     *
     * @return Cadena con el tipo de salsa de la pizza.
     */
    public String getSalsa() {
        return salsa;
    }

    /**
     * Establece el tipo de salsa de la pizza.
     *
     * @param salsa Cadena con el tipo de salsa de la pizza.
     */
    public void setSalsa(String salsa) {
        this.salsa = salsa;
    }

    /**
     * Devuelve los ingredientes de la pizza.
     *
     * @return Cadena con los ingredientes de la pizza.
     */
    public String getIngredientes() {
        return ingredientes;
    }

    /**
     * Establece los ingredientes de la pizza.
     *
     * @param ingredientes Cadena con los ingredientes de la pizza.
     */
    public void setIngredientes(String ingredientes) {
        this.ingredientes = ingredientes;
    }

    /**
     * Devuelve una cadena con todas las partes que componen la pizza.
     *
     * @return Cadena que describe la pizza.
     */
    @Override
    public String toString() {
        return "Pizza: " + this.getNombre() + " - " + this.getMasa() + " - " + this.getSalsa() + " - " + this.getIngredientes();
    }
}
