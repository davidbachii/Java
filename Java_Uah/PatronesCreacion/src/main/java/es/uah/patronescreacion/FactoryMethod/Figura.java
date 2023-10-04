package es.uah.patronescreacion.FactoryMethod;

import java.awt.Graphics;

/**
 * Producto abstracto.
 */
public abstract class Figura {

    /**
     * Entero que representa la longitud del lado de la figura en pixels.
     */
    int lado = 0;

    /**
     * Constructor.
     *
     * @param lado Longitud del lado de la figura en pixels.
     */
    public Figura(int lado) {
        this.lado = lado;
    }

    /**
     * Devuelve el área de la figura.
     *
     * @return Área de la figura.
     */
    public abstract double getArea();

    /**
     * Dibuja la figura.
     *
     * @param g Objeto gráfico para dibujar la figura.
     * @param x Coordenada x en la que se dibujará la figura.
     * @param y Coordenada y en la que se dibujará la figura.
     */
    public abstract void dibujar(Graphics g, int x, int y);
}
