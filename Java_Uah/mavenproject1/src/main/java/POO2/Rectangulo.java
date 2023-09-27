/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package POO2;

/**
 *
 * @author david
 */
public class Rectangulo extends Figura {
    public void area(int largo, int ancho){
        int area = largo * ancho;
        System.out.println("El area del Rectangulo es: "+area);
        
    }
}
