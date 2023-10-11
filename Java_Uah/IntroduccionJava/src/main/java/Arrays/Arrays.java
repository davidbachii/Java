/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Arrays;

import java.util.ArrayList;
import java.util.List;
/**
 *
 * @author david
 */
public class Arrays {
    
    /*En Java, no puedes usar tipos primitivos como argumentos genéricos en colecciones (ArrayList, LinkedList, etc.). 
     Debes usar las clases envoltorios para esos tipos primitivos. Aquí está una lista de tipos primitivos junto con sus equivalentes en clases envoltorios:

        byte: Byte
        short: Short
        int: Integer
        long: Long
        float: Float
        double: Double
        char: Character
        boolean: Boolean
    */
    
    
 //   private ArrayList<Character> alfabeto = new ArrayList<Character>();    No vale da error 
    
    private ArrayList<Character> alfabeto = new ArrayList<Character>();
    private ArrayList<Integer> estados = new ArrayList<Integer>();
    
    
    public void cargarAlfabeto(){
        List<Character> letrasDadas = List.of('b', 'a', 'c', 'h', 'i', 'l', 'e', 'r');
        for (Character letra : letrasDadas) {
            alfabeto.add(letra);
        }
    }
    
    public void cargarEstados(){
       for(int i = 0; i< 11; i++){
           estados.add(i);
       }
    }


    

    
}
