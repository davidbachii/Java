/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DeclaracionDeCondicionales;

/**
 *
 * @author david
 */
public class Bucles {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
       
       //FOR Repite el código un número específico de veces hasta que la condición es verdadera.
       for(int i=0;i <= 5;i++){
            System.out.println("*");
       }
       //WHILE Si la condición en el es verdadera, el programa entra en el ciclo de iteración.
       int a = 1;
       while(a <= 10){
           System.out.println(a);
           a++;
       }
       
       /*
       DO-WHILE El programa entra en el ciclo de iteración al menos una vez, independiente de 
       que la condición ‘while’ sea verdadera. Para más  iteraciones, depende de que la condición ‘while’ sea verdadera.
       */
       int x = 10;
       do{
           System.out.println(x);
           x--;
       }while(x>=1);
       
       
      
    }
    
}
