package es.uah.patronescreacion.FactoryMethod;

import java.awt.Color;
import java.awt.Graphics;

/**
 * Producto concreto.
 */
public class Circulo extends Figura {

    /**
     * Constructor
     *
     * @param lado Radio del círculo en pixels.
     */
    public Circulo(int lado) {
        super(lado);
    }

    @Override
    public double getArea() {
        return (Math.PI * lado * lado);
    }

    @Override
    public void dibujar(Graphics g, int x, int y) {
        g.setColor(Color.black);
        g.drawArc(x, y, lado, lado, 0, 360);
    }
}
