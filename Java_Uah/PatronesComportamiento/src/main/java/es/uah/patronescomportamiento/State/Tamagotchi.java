package es.uah.patronescomportamiento.State;

/**
 * Contexto: Clase que mantiene una referencia al estado actual y es la interfaz
 * que utilizan los clientes. Delega todas las llamadas a los métodos
 * específicos del estado en el objeto Estado actual.
 *
 * @author Salvador Oton
 */
public class Tamagotchi {

    private int comida; // Indicador de la comida que tiene de 0 a 100
    private int salud;  // Indicador de la salud que tiene de 0 a 100
    private int sueño;  // Indicador del sueño que tiene de 0 a 100
    private Estado estadoActual; // Estado actual

    /**
     * Constructor.
     */
    public Tamagotchi() {
        this.comida = 50;
        this.salud = 50;
        this.sueño = 0;
    }

    /**
     * Incrementa el indicador de comida en la cantidad pasada como argumento.
     * Si el resultado es mayor que 100, se establece el indicador a 100. Si el
     * resultado es menor que 0, se establece el indicador a 0.
     *
     * @param cantidad
     */
    public void darComida(int cantidad) {
        comida += cantidad;
        if (comida > 100) {
            comida = 100;
        } else if (comida < 0) {
            comida = 0;
        }
        estadoActual = new EstadoComida();
        estadoActual.ejecutar(this);
        resultado();
    }

    /**
     * Incrementa el indicador de salud en la cantidad pasada como argumento. Si
     * el resultado es mayor que 100, se establece el indicador a 100. Si el
     * resultado es menor que 0, se establece el indicador a 0.
     *
     * @param cantidad
     */
    public void hacerEjercicio(int cantidad) {
        salud += cantidad;
        if (salud > 100) {
            salud = 100;
        } else if (salud < 0) {
            salud = 0;
        }
        estadoActual = new EstadoSalud();
        estadoActual.ejecutar(this);
        resultado();
    }

    /**
     * Decrementa el indicador de sueño en la cantidad pasada como argumento. Si
     * el resultado es mayor que 100, se establece el indicador a 100. Si el
     * resultado es menor que 0, se establece el indicador a 0.
     *
     * @param cantidad
     */
    public void dormir(int cantidad) {
        sueño -= cantidad;
        if (sueño > 100) {
            sueño = 100;
        } else if (sueño < 0) {
            sueño = 0;
        }
        estadoActual = new EstadoSueño();
        estadoActual.ejecutar(this);
        resultado();
    }

    /**
     * Muestra el estado final.
     */
    public void resultado() {
        estadoActual.ejecutar(this); //comprobamos el estado final
    }

    /**
     * Devuelve el estado actual.
     *
     * @return Estado actual.
     */
    public Estado getEstadoActual() {
        return estadoActual;
    }

    /**
     * Establece el estado actual.
     *
     * @param estadoActual Estado actual.
     */
    public void setEstadoActual(Estado estadoActual) {
        this.estadoActual = estadoActual;
    }

    /**
     * Devuelve el indicador de la comida que tiene.
     *
     * @return Indicador de la comida que tiene.
     */
    public int getComida() {
        return comida;
    }

    /**
     * Devuelve el indicador de la salud que tiene.
     *
     * @return Indicador de la salud que tiene.
     */
    public int getSalud() {
        return salud;
    }

    /**
     * Devuelve el indicador del sueño que tiene.
     *
     * @return Indicador del sueño que tiene.
     */
    public int getSueño() {
        return sueño;
    }

    /**
     * Devuelve la descripción con los indicadores del tamagotchi.
     *
     * @return
     */
    @Override
    public String toString() {
        return "Tamagotchi{" + "comida=" + comida + " # sueño=" + sueño + " # salud=" + salud + '}';
    }
}
