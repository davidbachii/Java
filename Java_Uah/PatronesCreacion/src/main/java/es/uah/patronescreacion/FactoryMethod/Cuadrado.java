package es.uah.patronescreacion.FactoryMethod;

import java.awt.Color;
import java.awt.Graphics;

/**
 * Producto concreto.
 */
public class Cuadrado extends Figura {

    /**
     * Constructor.
     *
     * @param lado Lado del cuadrado en pixels.
     */
    public Cuadrado(int lado) {
        super(lado);
    }

    @Override
    public double getArea() {
        return (lado * lado);
    }

    @Override
    public void dibujar(Graphics g, int x, int y) {
        g.setColor(Color.black);
        g.drawRect(x, y, lado, lado);
    }
}
