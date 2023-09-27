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
public class Circulo extends FiguraGeometrica {
    private double radio;

    /**
     * Construye un círculo con los valores pasados como argumento.
     *
     * @param posicion Coordenadas x,y del círculo.
     * @param color Color del círculo.
     * @param radio Valor del radio del círculo.
     */
    public Circulo(Punto posicion, String color, double radio) {
        super(posicion, color);
        this.radio = radio;
    }

    /**
     * Obtiene el rádio del círculo.
     *
     * @return valor del rádio del círculo.
     */
    public double getRadio() {
        return radio;
    }

    /**
     * Establece un nuevo rádio para el círculo.
     *
     * @param radio Valor del nuevo rádio.
     */
    public void setRadio(double radio) {
        this.radio = radio;
    }

    @Override
    public double area() {
        return 3.14 * Math.pow(radio, 2.0);
    }

    @Override
    public void dibujar() {
        System.out.println("Soy un círculo de color: " + super.getColor() + " con posición:" + super.getPosicion().toString());
    }
    
}
