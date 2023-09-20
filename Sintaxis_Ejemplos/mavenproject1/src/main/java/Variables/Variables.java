/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Variables;

/**
 *
 * @author david
 */
public class Variables {

    // Variable de tipo entero, puede almacenar números enteros sin decimales
    int entero;

    // Variable de tipo decimal de precisión simple, puede almacenar números decimales
    float decimalSimple;

    // Variable de tipo decimal de precisión doble, puede almacenar números decimales con mayor precisión que float
    double decimalDoble;

    // Variable de tipo carácter, puede almacenar un solo carácter unicode
    char caracter;

    // Variable de tipo booleano, puede almacenar true o false
    boolean booleano;

    // Variable de tipo cadena de caracteres, puede almacenar texto
    String cadena;

    // Variable de tipo arreglo de enteros, puede almacenar múltiples valores enteros
    int[] arregloEnteros;

    

    // Variable de tipo constante, su valor no puede ser cambiado después de la asignación
    final int CONSTANTE = 10;
    
    //Utilizada para indicar que una variable o un método es un método de clase. Es decir que en otra clase no podemos utilizar esa variable
    static int numero = 10; 

    public static void main(String[] args) {
        // Ejemplo de uso de las variables
        Variables ejemplo = new Variables();
        ejemplo.entero = 5;
        ejemplo.decimalSimple = 3.14f;
        ejemplo.decimalDoble = 2.71828;
        ejemplo.caracter = 'A';
        ejemplo.booleano = true;
        ejemplo.cadena = "Hola";
        ejemplo.arregloEnteros = new int[]{1, 2, 3};
       
        System.out.println(ejemplo.entero);
        // No se puede cambiar el valor de una constante
        // ejemplo.CONSTANTE = 20; // Esto daría un error de compilación
    }
}

