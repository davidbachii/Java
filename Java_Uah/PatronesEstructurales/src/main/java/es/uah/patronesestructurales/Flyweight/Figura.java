package es.uah.patronesestructurales.Flyweight;

import java.awt.Color;
import java.awt.Graphics;

/**
 * Peso ligero.
 */
public abstract class Figura {

    /**
     * Color de la figura.
     */
    protected Color color;

    /**
     * Constructor.
     *
     * @param color Color de la figura.
     */
    public Figura(Color color) {
        this.color = color;
    }

    /**
     * Devuelve el color de la figura.
     *
     * @return Color de la figura.
     */
    public Color getColor() {
        return this.color;
    }

    /**
     * Dibuja la figura. Método abstracto.
     *
     * @param g Objeto gráfico para dibujar la figura.
     * @param x Coordenada x.
     * @param y Coordenada y.
     * @param lado Lado de la figura.
     */
    public abstract void dibujar(Graphics g, int x, int y, int lado);
}
