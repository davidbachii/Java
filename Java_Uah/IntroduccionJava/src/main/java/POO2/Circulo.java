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
public class Circulo extends Figura {
    public void area(int radio){
        float area = 3.14f * radio * radio;
        System.out.println("Área del circulo : " + area);    
    }
}
