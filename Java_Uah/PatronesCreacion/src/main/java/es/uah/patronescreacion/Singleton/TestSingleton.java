package es.uah.patronescreacion.Singleton;

/**
 * Test del patrón Singleton.
 */
public class TestSingleton {

    /**
     * Atributos
     */
    Singleton s1, s2;

    /**
     * Constructor: Inicializa los atributos.
     */
    public TestSingleton() {
        s1 = Singleton.getInstancia();// Obtiene instancia de la clase.
        s2 = Singleton.getInstancia();// Obtiene instancia de la clase.
    }

    /**
     * Comprueba que las dos instancias obtenidas en el constructor son la misma
     * instancia.
     */
    public void test() {
        System.out.print("s1: ");
        System.out.println(s1.hashCode());
        System.out.print("s2: ");
        System.out.println(s2.hashCode());
        System.out.println("--------------------COMPROBACION---------------\n"
                + "    s1 == s2      : " + (s1 == s2) + "\n");
    }

    /**
     * Método de arranque del programa.
     *
     * @param args
     */
    public static void main(String[] args) {
        TestSingleton prueba = new TestSingleton();
        prueba.test();
    }
}
