package es.uah.patronescreacion.Builder;

/**
 * Cliente: Crea el objeto Director y lo configura con el objeto Constructor
 * deseado.
 */
public class Cliente {

    /**
     * Método de arranque del programa.
     *
     * @param args
     */
    public static void main(String[] args) {
        Pizza pizza; // Producto complejo a crear.
        Cocinero cocinero = new Cocinero();// Director que construirá el producto complejo.
        PizzaBuilder bpb = new BarbacoaPizzaBuilder();// Constructor concreto para pizza barbacoa.
        PizzaBuilder cpb = new CarbonaraPizzaBuilder();// Constructor concreto para pizza carbonara.

        // Creación de pizza barbacoa.
        cocinero.setPizzaBuilder(bpb);// El director establece/configura el constructor concreto del producto a construir.
        cocinero.crearPizza();// El director crea el producto.
        pizza = cocinero.getPizza(); // El director devuelve el producto.
        System.out.println(pizza.toString()); // Muestra el producto.

        // Creación de pizza carbonara.
        cocinero.setPizzaBuilder(cpb);// El director establece/configura el constructor concreto del producto a construir.
        cocinero.crearPizza();// El director crea el producto.
        pizza = cocinero.getPizza();// El director devuelve el producto.
        System.out.println(pizza.toString());// Muestra el producto.
    }
}
