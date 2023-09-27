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
public class PruebaAbstract {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Punto p1 = new Punto(15, 20);
        Punto p2 = new Punto(50, 80);
        Punto p3 = new Punto(100, 150);

        FiguraGeometrica fig1 = new Circulo(p1, "rojo", 5);
        FiguraGeometrica fig2 = new Cuadrado(p2, "verde", 10);

        fig1.dibujar(); //polimorfismo
        fig2.dibujar();
        System.out.println("Área fig1: " + fig1.area());
        System.out.println("Área fig2: " + fig2.area());
        fig2.mover(p3);
    }
}
