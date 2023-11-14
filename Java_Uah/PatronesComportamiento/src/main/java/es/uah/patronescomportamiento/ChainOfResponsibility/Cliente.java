package es.uah.patronescomportamiento.ChainOfResponsibility;

/**
 * Cliente: Inicializa la petición a un objeto ManejadorConcreto de la cadena.
 *
 * @author Salvador Oton
 */
public class Cliente {

    public static void main(String arg[]) {
        try {
            //Los manejadores
            Manejador manejador1 = new ManejadorConcreto1();
            Manejador manejador2 = new ManejadorConcreto2();
            Manejador manejador3 = new ManejadorConcreto3();
            //Los sucesores
            manejador1.setSucesor(manejador2);
            manejador2.setSucesor(manejador3);

            //Calculamos cuanto nos cuesta enviar los paquetes
            Paquete p1 = new Paquete("Bicicleta", "Madrid Capital", 300);
            Paquete p2 = new Paquete("Ordenador", "Comunidad Madrid", 20);
            Paquete p3 = new Paquete("Tablet", "Burgos", 1);
            System.out.println("Coste envío paquete: \n" + p1.toString() + "\n" + manejador1.calculaCosteEnvio(p1) + "\n");
            System.out.println("Coste envío paquete: \n" + p2.toString() + "\n" + manejador1.calculaCosteEnvio(p2) + "\n");
            System.out.println("Coste envío paquete: \n" + p3.toString() + "\n" + manejador1.calculaCosteEnvio(p3) + "\n");
        } catch (Exception e) {
            e.toString();
        }
    }
}
