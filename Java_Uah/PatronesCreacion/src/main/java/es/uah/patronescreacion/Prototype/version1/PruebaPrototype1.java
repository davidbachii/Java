package es.uah.patronescreacion.Prototype.version1;

import java.util.ArrayList;

/**
 * EJEMPLO DE PROTOTYPE PATTERN 1: constructor copia
 */
public class PruebaPrototype1 {

    Persona juan, luis;
    ArrayList tfnos = new ArrayList();

    /**
     * Constructor.
     */
    public PruebaPrototype1() {
        Fecha f1 = new Fecha(15, 3, 1965);
        tfnos.add("918885566");
        tfnos.add("606997755");
        // Crea persona juan
        juan = new Persona("15664386T", "Juan", f1, "calle", tfnos);

        // Crea persona luis con constructor copia.
        luis = new Persona(juan); //Creamos a Luis clonando los metodo de juan
        luis.setDni("22879654X");// Modifica DNI. ya que ahora mismo tienen los mismos 
        luis.getTfnos().add("968559977"); // Añade teléfono.
        luis.getTfnos().add("626776644"); // Añade teléfono.
        luis.setFechaNac(new Fecha(1, 1, 1971)); // Modifica fecha de nacimiento.
    }

    /**
     * Test que comprueba que el objeto que se ha creado con constructor copia
     * se ha copiado usando copia profunda.
     */
    public void test() {
        System.out.print("Objeto juan - ");
        System.out.println(juan.toString());
        System.out.print("Objeto luis - ");
        System.out.println(luis.toString());
        System.out.println("--------------------COPIA PROFUNDA---------------\n"
                + "    juan == luis      : " + (juan == luis) + "\n"
                + "    juan.equals(luis) : " + juan.equals(luis));
        System.out.println("-------------------------------------------------");
        System.out.print("Objeto juan - Teléfonos: ");
        System.out.println(juan.getTfnos().toString());
        System.out.print("Objeto luis - Teléfonos: ");
        System.out.println(luis.getTfnos().toString());
        System.out.print("Objeto juan - Fecha de nacimiento: ");
        System.out.println(juan.getFechaNac().toString());
        System.out.print("Objeto luis - Fecha de nacimiento: ");
        System.out.println(luis.getFechaNac().toString());
    }

    /**
     * Método de arranque del programa.
     *
     * @param args
     */
    public static void main(String[] args) {
        PruebaPrototype1 prueba = new PruebaPrototype1();
        prueba.test();
    }
}
