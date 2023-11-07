package es.uah.patronesestructurales.Flyweight;

import java.awt.Color;
import java.awt.Graphics;

/**
 * Peso ligero concreto.
 */
public class Cuadrado extends Figura {

    /**
     * Constructor.
     *
     * @param color Color de la figura.
     */
    public Cuadrado(Color color) {
        super(color);
    }

    @Override
    public void dibujar(Graphics g, int x, int y, int lado) {
        g.setColor(color);
        g.drawRect(x, y, lado, lado);
    }
}
