/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BibliotecasJava;

/**
 *
 * @author david
 */
import java.io.*;
/*Esta biblioteca proporciona clases para entrada y salida de datos, lo que 
significa que puedes leer y escribir archivos*/

public class JavaIO {

    public static void main(String[] args) {
        try {
            FileWriter escritor = new FileWriter("archivo.txt");
            escritor.write("Hola, este es un ejemplo de escritura en archivo.");
            escritor.close();

            FileReader lector = new FileReader("archivo.txt");
            BufferedReader buffer = new BufferedReader(lector);
            String linea;
            while ((linea = buffer.readLine()) != null) {
                System.out.println(linea);
            }
            lector.close();
        } catch (IOException e) {
        }
    }
}

