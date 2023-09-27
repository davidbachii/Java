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
public class Cuadrado extends FiguraGeometrica {
     private double lado;

    /**
     * Construye un cuadrado con los valores pasados como argumento.
     *
     * @param posicion Coordenadas x,y del cuadrado.
     * @param color Color del cuadrado.
     * @param lado Valor del lado del cuadrado.
     */
    public Cuadrado(Punto posicion, String color, double lado) {
        super(posicion, color);
        this.lado = lado;
    }

    /**
     * Obtiene el lado del cuadrado.
     *
     * @return valor del lado del cuadrado.
     */
    public double getLado() {
        return lado;
    }

    /**
     * Establece un nuevo lado para el cuadrado.
     *
     * @param lado Valor del nuevo lado.
     */
    public void setLado(double lado) {
        this.lado = lado;
    }
    //Te obligo a implemnetar los metodos asbtractros de la herencia de la clase figura geometrica, si no da error
    @Override
    public double area() {
        return lado * lado;
    }

    @Override
    public void dibujar() {
        System.out.println("Soy un cuadrado de color: " + super.getColor() + " con posición:" + super.getPosicion().toString());
    }
    
}
