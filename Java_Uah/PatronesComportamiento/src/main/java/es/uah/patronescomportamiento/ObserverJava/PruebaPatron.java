package es.uah.patronescomportamiento.ObserverJava;

import java.util.Observer;

/**
 * Clase que prueba el patrón Observer.
 *
 * @author Salvador Oton
 */
public class PruebaPatron {

    public static void main(String args[]) {
        try {
            //Valor de cotización.
            Valor v1 = new Valor("Telefonica", 8.5);

            //Sujeto para monitorizar el valor.
            SujetoConcreto sujeto = new SujetoConcreto();
            sujeto.setValor(v1);

            //Observadores.
            Observer o1 = new ObservadorConcreto("o1", 8.6, 200, sujeto);
            Observer o2 = new ObservadorConcreto("o2", 8.8, 400, sujeto);

            //Notificamos a los observadores para que actualicen.
            System.out.println("Notificamos...");
            sujeto.cambiaValor(8.55); //Cambiamos la cotización.

            System.out.println("Notificamos...");
            sujeto.cambiaValor(8.7); //Cambiamos la cotización.
            
            System.out.println("Notificamos...");
            sujeto.cambiaValor(8.9); //Cambiamos la cotización.            
        } catch (Exception e) {
            System.out.println("Error: " + e.toString());
        }
    }
}
