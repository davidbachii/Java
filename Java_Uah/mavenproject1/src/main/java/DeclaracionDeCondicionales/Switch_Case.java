/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DeclaracionDeCondicionales;

import java.util.Random; //Biblioteca para importar numeros random

/**
 *
 * @author david
 */
public class Switch_Case {

   
    
    
    public static void main(String[] args) {
        // TODO code application logic here
         // Crear una instancia de la clase Random
        Random rand = new Random();

        // Generar un número aleatorio entre 0 y 5
        int numeroRandom = rand.nextInt(6);
        
        
        switch(numeroRandom){
        case 0 :
            System.out.println("Soleado");
        break;
        case 1 :
            System.out.println("Lluvioso");
        break;
        case 2 :
            System.out.println("Frio");
        break;
        case 3 :
            System.out.println("Ventoso");
        break;
        case 4 :
            System.out.println("Templado");
        break;
        case 5 :
            System.out.println("Arenoso");
        break;
        default :
            System.out.println("Nevado");

        }
    }
    
}
