/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AFD_MaquinaEstados;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 *
 * @author david
 */
public class AFD {
    
    
    //Declaracion de atributos
     private ArrayList<Character> alfabeto;
     private ArrayList<Integer> estados;
     private int estadoInicial;
     private ArrayList<Integer> estadosFinales;
     private HashMap<Integer,HashMap<Character,Integer>> matriz;
     
     

    public AFD() {
        this.alfabeto = new ArrayList<>();
        this.estados = new ArrayList<>();
        this.estadosFinales = new ArrayList<>();
        this.matriz = new HashMap<>();
        arrancarAutomata();
        
    }
     
     
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
    
    public void establecerEstadoInicial(){
        estadoInicial = 3;
    }
     
    public void establecerEstadosFinales(){
        List<Integer> estadosF = List.of(7, 8, 9, 10);
        for (Integer estado : estadosF) {
            estadosFinales.add(estado);
        }
    }
     
    public void iniMatriz(){
        
        for(int x:estados){
            matriz.put(x,new HashMap<Character,Integer>());
        }
    } 
    
    public void cargarMatriz(){
         
        matriz.get(0).put('i',8); //Para cuando este en el estado 0 si viene una I, salta al estado 8
        matriz.get(1).put('l',2); //Para cuando este en el estado 1 si viene una L, salta al estado 2
        matriz.get(2).put('e',6); //Para cuando este en el estado 2 si viene una E, salta al estado 6
        matriz.get(3).put('b',4); //Para cuando este en el estado 3 si viene una B, salta al estado 4
        matriz.get(4).put('a',5); //Para cuando este en el estado 4 si viene una A, salta al estado 5
        matriz.get(5).put('a',5); //Para cuando este en el estado 5 si viene una B, salta al estado 5
        matriz.get(5).put('c',10); //Para cuando este en el estado 5 si viene una C, salta al estado 10
        matriz.get(6).put('r',7); //Para cuando este en el estado 6 si viene una R, salta al estado 7
        matriz.get(8).put('l',1);  //Para cuando este en el estado 8 si viene una L, salta al estado 1
        matriz.get(9).put('l',1); //Para cuando este en el estado 9 si viene una B, salta al estado 1
        matriz.get(9).put('i',9); //Para cuando este en el estado 9 si viene una I, salta al estado 9
        matriz.get(10).put('h',0); //Para cuando este en el estado 10 si viene una H, salta al estado 0
        matriz.get(10).put('i',9); //Para cuando este en el estado 10 si viene una I, salta al estado 9
        matriz.get(10).put('l',1); //Para cuando este en el estado 10 si viene una L, salta al estado 1
       
    }
    
    
     public Integer getSigienteEstado(Integer estado, Character siguiente){
        return matriz.get(estado).get(siguiente);
    }
    
    public boolean isFinal(Integer estado){
        return estadosFinales.contains(estado);
    }

    public int getEstadoInicial() {
        return estadoInicial;
    }
    
    
    
    private void arrancarAutomata(){
        cargarAlfabeto();
        cargarEstados();
        establecerEstadoInicial();
        establecerEstadosFinales();
        iniMatriz();
        cargarMatriz();
    }
    
    
    

    public static void generarCadenas(int bCount, int aCount, int cCount, int hCount, int iCount, int ller, MaquinaEstados me) {
          

        // Generar cadenas válidas según las cantidades proporcionadas
        for (int i = 0; i <= bCount; i++) {
            for (int j = 0; j <= aCount; j++) {
                for (int k = 0; k <= cCount; k++) {
                    for (int l = 0; l <= hCount; l++) {
                        for (int m = 0; m <= iCount; m++) {
                            for (int n = 0; n <= ller; n++) { // 0 representa la ausencia de "ller?", 1 representa su presencia
                                String cadena = generarCadena(i, j, k, l, m, n);
                                if (me.compruebaCadena(cadena)) {
                                    System.out.println("Cadena válida: " + cadena);
                                }
                            }
                        }
                    }
                }
            }
        }
    }
    
    public static String generarCadena(int bCount, int aCount, int cCount, int hCount, int iCount, int ller) {
        StringBuilder cadena = new StringBuilder();

        // Agregar 'b' y 'a'
        for (int i = 0; i < bCount; i++) {
            cadena.append("b");
        }
        for (int i = 0; i < aCount; i++) {
            cadena.append("a");
        }

        // Agregar 'c', 'h' o 'i'
        for (int i = 0; i < cCount; i++) {
            cadena.append("c");
        }
        for (int i = 0; i < hCount; i++) {
            cadena.append("h");
        }
        for (int i = 0; i < iCount; i++) {
            cadena.append("i");
        }

        // Agregar 'l', 'l', 'e', 'r' y '?'
        if (ller == 1) {
            cadena.append("ller?");
        }

        return cadena.toString();
    }
}

    
    

