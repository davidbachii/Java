package es.uah.patronescomportamiento.Memento;

/**
 * Clase que prueba el patrón Memento.
 *
 * @author Salvador Oton
 */
public class PruebaPatron {

    public static void main(String args[]) {
        try {
            //partidas
            Partida p1 = new Partida("p1", "fase 1");
            Partida p2 = new Partida("p2", "fase 2");
            Partida p3 = new Partida("p3", "fase 3");

            //originador
            Originador originador = new Originador();

            //conserje
            Conserje conserje = new Conserje();

            //establecemos partidas y guardamos sus recuerdos para poder recuperarlos
            originador.setPartida(p1);
            conserje.setRecuerdo(originador.crearRecuerdo());
            System.out.println(originador.getPartida().toString());

            originador.setPartida(p2);
            conserje.setRecuerdo(originador.crearRecuerdo());
            System.out.println(originador.getPartida().toString());

            originador.setPartida(p3);
            conserje.setRecuerdo(originador.crearRecuerdo());
            System.out.println(originador.getPartida().toString());

            //recuperamos la partida 1
            originador.setRecuerdo(conserje.getRecuerdo(0));
            System.out.println(originador.getPartida().toString());
        } catch (Exception e) {
            System.out.println("Error: " + e.toString());
        }
    }
}
