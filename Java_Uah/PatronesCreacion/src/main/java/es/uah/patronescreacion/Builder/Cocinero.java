package es.uah.patronescreacion.Builder;

/**
 * Director: Construye un objeto complejo Pizza usando la clase abstracta
 * PizzaBuilder.
 */
public class Cocinero {

    /**
     * Clase abstracta para construir el producto.
     */
    private PizzaBuilder pizzaBuilder;

    /**
     * Establece el constructor concreto.
     *
     * @param pb Constructor concreto.
     */
    public void setPizzaBuilder(PizzaBuilder pb) {
        pizzaBuilder = pb;
    }

    /**
     * Devuelve el producto complejo creado.
     *
     * @return producto Pizza
     */
    public Pizza getPizza() {
        return pizzaBuilder.getPizza();
    }

    /**
     * Construye el producto Pizza paso a paso.
     */
    public void crearPizza() {
        pizzaBuilder.crearNuevaPizza();
        pizzaBuilder.ponerNombre();
        pizzaBuilder.crearMasa();
        pizzaBuilder.crearSalsa();
        pizzaBuilder.crearIngredientes();
    }
}
