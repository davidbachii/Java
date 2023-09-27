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
public class If_Else {

    static int numero = 50; //Dentro del main no se puede definir una varibale static
    
    public static void main(String[] args) {
        // TODO code application logic here
        if(numero >= 50) {
        System.out.println("Aprobado ");
        }
        else {
        System.out.println("Intente de nuevo!");
        }
    }
    
}
