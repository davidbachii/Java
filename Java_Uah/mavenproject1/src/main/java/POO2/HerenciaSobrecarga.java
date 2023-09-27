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
public class HerenciaSobrecarga {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        int largo = 5;
        int ancho = 7;
        
        Figura figura = new Figura();
        //objecto hijo class cuadrado
        Cuadrado cuadrado = new Cuadrado();
        //objecto hijo class rectangulo
        Rectangulo rectangulo = new Rectangulo();
        // objecto hijo class circulo
        Circulo circulo = new Circulo();
        //llamar a los métodos de área de todas las clases
        //secundarias para obtener el área de diferentes objetos
        
        figura.area();
        cuadrado.area(largo);
        rectangulo.area(largo, ancho);
        circulo.area(largo);

    }
    
}
