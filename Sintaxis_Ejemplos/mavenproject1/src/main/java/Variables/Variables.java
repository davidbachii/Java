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

  

    

    // Variable de tipo constante, su valor no puede ser cambiado después de la asignación
    final int CONSTANTE = 10;
    // No se puede cambiar el valor de una constante
    // ejemplo.CONSTANTE = 20; // Esto daría un error de compilación
    
    //Utilizada para indicar que una variable o un método es un método de clase. Es decir que en otra clase no podemos utilizar esa variable
    static int numero = 10; 

    public Variables(int entero, float decimalSimple, double decimalDoble, char caracter, boolean booleano, String cadena) {
        this.entero = entero;
        this.decimalSimple = decimalSimple;
        this.decimalDoble = decimalDoble;
        this.caracter = caracter;
        this.booleano = booleano;
        this.cadena = cadena;
        
    }

    

    

    
    public int getEntero() {
        return entero;
    }

    public void setEntero(int entero) {
        this.entero = entero;
    }

    public float getDecimalSimple() {
        return decimalSimple;
    }

    public void setDecimalSimple(float decimalSimple) {
        this.decimalSimple = decimalSimple;
    }

    public double getDecimalDoble() {
        return decimalDoble;
    }

    public void setDecimalDoble(double decimalDoble) {
        this.decimalDoble = decimalDoble;
    }

    public char getCaracter() {
        return caracter;
    }

    public void setCaracter(char caracter) {
        this.caracter = caracter;
    }

    public boolean isBooleano() {
        return booleano;
    }

    public void setBooleano(boolean booleano) {
        this.booleano = booleano;
    }

    public String getCadena() {
        return cadena;
    }

    public void setCadena(String cadena) {
        this.cadena = cadena;
    }

    

    public static int getNumero() {
        return numero;
    }

    public static void setNumero(int numero) {
        Variables.numero = numero;
    }
    
    
   
}

