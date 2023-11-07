package es.uah.patronesestructurales.Facade;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Prueba del patrón Fachada.
 */
public class PruebaPatron {

    /**
     * Método de arranque del programa.
     *
     * @param args
     * @throws java.io.IOException
     */
    public static void main(String args[]) throws IOException {
        BufferedReader entrada = new BufferedReader(new InputStreamReader(System.in));

        FachadaCajero fachada = new FachadaCajero();
        System.out.println("Introduce operación cajero \n1- Sacar Dinero \n2- Pago Recibo \n3- Recarga Móvil \nOpción:");
        int opcion = Integer.parseInt(entrada.readLine());
        switch (opcion) {
            case 1:
                System.out.println(fachada.sacarDinero());
                break;
            case 2:
                System.out.println(fachada.pagarRecibo());
                break;
            case 3:
                System.out.println(fachada.recargaMovil());
                break;
            default:
                System.out.println("Opción errónea.");
                break;
        }
    }
}
