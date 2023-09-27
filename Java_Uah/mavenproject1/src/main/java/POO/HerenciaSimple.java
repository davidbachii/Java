/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package POO;

/**
 *
 * @author david
 */
public class HerenciaSimple {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        ClaseA objA = new ClaseA();
        ClaseB objB = new ClaseB ();
        // La superclase puede usarse sola
        objA.i = 10;
        objA.j = 20;
        System.out.println("Contenido de objA: ");
        objA. muestraij();
        System.out.println();
        // La subclase puede acceder a todos los miembros publicos de su superclase
        objB.i = 7;
        objB.j = 8;
        objB.k = 9;
        System.out.println("Contenido de objB: ");
        objB.muestraij();
        objB.muestrak();
        System.out.println();
        System.out.println("Suma de i, j y k en objB:");
        objB.sum();
    }
    
}
