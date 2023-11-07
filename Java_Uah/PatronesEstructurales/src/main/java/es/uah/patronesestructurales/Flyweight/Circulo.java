package es.uah.patronesestructurales.Flyweight;

import java.awt.Color;
import java.awt.Graphics;

/**
 * Peso ligero concreto.
 */
public class Circulo extends Figura {

    /**
     * Constructor.
     *
     * @param color Color de la figura.
     */
    public Circulo(Color color) {
        super(color);
    }

    @Override
    public void dibujar(Graphics g, int x, int y, int lado) {
        g.setColor(color);
        g.drawArc(x, y, lado, lado, 0, 360);
    }
}
