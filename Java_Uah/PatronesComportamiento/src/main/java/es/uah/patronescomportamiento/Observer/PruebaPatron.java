package es.uah.patronescomportamiento.Observer;

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
            Sujeto sujeto = new SujetoConcreto();
            sujeto.setValor(v1);

            //Observadores.
            Observador o1 = new ObservadorConcreto("o1", 8.6, 200, sujeto);
            Observador o2 = new ObservadorConcreto("o2", 8.8, 400, sujeto);

            //Notificamos a los observadores para que actualicen.
            System.out.println("Notificamos...");
            sujeto.notificarObservadores();

            v1.setCotizacion(8.65); //Cambiamos la cotización.
            System.out.println("Notificamos...");
            sujeto.notificarObservadores();
            
        } catch (Exception e) {
            System.out.println("Error: " + e.toString());
        }
    }
}
