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
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.*;
//Esta biblioteca proporciona clases para trabajar con redes, como crear y gestionar conexiones.



public class JavaNet {

    public static void main(String[] args) {
        try {
            // Crear un objeto URL que representa la dirección web
            URL url = new URL("https://github.com/davidbachii");

            // Abrir una conexión HTTP a la URL
            HttpURLConnection con = (HttpURLConnection) url.openConnection();

            // Configurar el método de solicitud como GET
            con.setRequestMethod("GET");

            // Crear un lector de flujo de entrada para leer la respuesta del servidor
            BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));

            String inputLine;

            // Leer cada línea de la respuesta y mostrarla en la consola
            while ((inputLine = in.readLine()) != null) {
                System.out.println(inputLine);
            }

            // Cerrar el lector
            in.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

