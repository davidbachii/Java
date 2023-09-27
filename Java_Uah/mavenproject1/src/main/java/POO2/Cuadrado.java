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
public class Cuadrado extends Figura{
    
    public void area(int lado){
        int area = lado * lado;
        System.out.println("El area del cuadrado es: "+area);
    }
    
}
