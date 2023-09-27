/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TiposClases;

/**
 *
 * @author david
 */
public abstract class FiguraGeometrica {
    /**
     * Posición de la figura: coordenadas x,y.
     */
    private Punto posicion;
    /**
     * Color de la figura.
     */
    private String color;

    /**
     * Crea una figura con la posición y color pasados como argumentos.
     *
     * @param posicion Posición de la figura.
     * @param color Color de la figura.
     */
    public FiguraGeometrica(Punto posicion, String color) {
        this.posicion = posicion;
        this.color = color;
    }

    /**
     * Mueve una figura a la posición pasada como argumento.
     *
     * @param nuevaPos Nueva posición de la figura.
     */
    public void mover(Punto nuevaPos) {
        posicion = nuevaPos;
        dibujar();
    }

    /**
     * Devuelve una cadena que representa el color de la figura.
     *
     * @return Cadena.
     */
    public String getColor() {
        return color;
    }

    /**
     * Establece el color pasado como argumento.
     *
     * @param color Nuevo color de la figura.
     */
    public void setColor(String color) {
        this.color = color;
    }

    /**
     * Obtiene la posición de la figura.
     *
     * @return Posición de la figura.
     */
    public Punto getPosicion() {
        return posicion;
    }

    /**
     * Método abstracto que dibuja una figura y que deberá ser implementado por
     * las clases hija.
     */
    abstract public void dibujar();

    /**
     * Método abstracto que calcula el área de una figura y que deberá ser
     * implementado por las clases hija.
     *
     * @return Valor del área.
     */
    abstract double area();
}
