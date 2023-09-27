package es.uah.patronesfundamentales.AbstractSuperClass;

/**
 * Clase que representa un punto a través de coordenadas x e y.
 */
public class Punto {

    private int x; // Coordenada x
    private int y; // Coordenada y

    /**
     * Construye un punto con las coordenadas x,y pasadas como argumentos.
     *
     * @param x Coordenada x.
     * @param y Coordenada y.
     */
    public Punto(int x, int y) {
        this.x = x;
        this.y = y;
    }

    /**
     * Obtiene la coordenada x.
     *
     * @return Coordenada x.
     */
    public int getX() {
        return x;
    }

    /**
     * Establece la coordenada x con el valor pasado como argumento.
     *
     * @param x Nuevo valor de la coordenada x.
     */
    public void setX(int x) {
        this.x = x;
    }

    /**
     * Obtiene la coordenada y.
     *
     * @return Coordenada y.
     */
    public int getY() {
        return y;
    }

    /**
     * Establece la coordenada y con el valor pasado como argumento.
     *
     * @param y Nuevo valor de la coordenada y.
     */
    public void setY(int y) {
        this.y = y;
    }

    @Override
    public String toString() {
        return " x: " + this.x + " y: " + this.y;
    }
}
