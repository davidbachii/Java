package es.uah.patronescreacion.Builder;

/**
 * Constructor: Clase abstracta que especifica los métodos para crear las partes
 * del producto concreto.
 */
public abstract class PizzaBuilder {

    /**
     * Producto complejo a construir: Pizza.
     */
    protected Pizza pizza;

    /**
     * Devuelve el producto complejo que se construye.
     *
     * @return Producto Pizza.
     */
    public Pizza getPizza() {
        return pizza;
    }

    /**
     * Crea un nuevo producto del tipo complejo Pizza.
     */
    public void crearNuevaPizza() {
        pizza = new Pizza();
    }

    /**
     * Establece el nombre del producto.
     */
    public abstract void ponerNombre();

    /**
     * Crea una parte del producto: la masa.
     */
    public abstract void crearMasa();

    /**
     * Crea una parte del producto: la salsa
     */
    public abstract void crearSalsa();

    /**
     * Crea una parte del producto: los ingredientes
     */
    public abstract void crearIngredientes();
}
