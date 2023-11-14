package es.uah.patronescomportamiento.Visitor;

/**
 * Clase que prueba el patrón Visitor.
 *
 * @author Salvador Oton
 */
public class Cliente {

    public static void main(String args[]) {
        try {
            //Importes parciales y totales de la factura
            double parcial = 0, total = 0;

            //Las llamadas
            Llamada l1 = new LlamadaMetropolitana(20, 10, 'L');
            Llamada l2 = new LlamadaMetropolitana(15, 22, 'M');
            Llamada l3 = new LlamadaProvincial(10, 16, 'X');
            Llamada l4 = new LlamadaProvincial(22, 19, 'J');
            Llamada l5 = new LlamadaInterprovincial(40, 23, 'S');
            Llamada l6 = new LlamadaInterprovincial(35, 12, 'V');

            Llamadas llamadas = new Llamadas();
            llamadas.añadirLlamada(l1);
            llamadas.añadirLlamada(l2);
            llamadas.añadirLlamada(l3);
            llamadas.añadirLlamada(l4);
            llamadas.añadirLlamada(l5);
            llamadas.añadirLlamada(l6);

            //Los  visitantes
            Visitante vn = new VisitanteHorarioNormal();
            Visitante vr = new VisitanteHorarioReducido();

            System.out.println("### FACTURA DE TELEFONO ###\n");
            System.out.println("\n## LLAMADAS HORARIO NORMAL ##");
            for (int i = 0; i < llamadas.getLlamadasHorarioNormal().size(); ++i) {
                Llamada ll = llamadas.getLlamadasHorarioNormal().get(i);
                parcial = ll.aceptar(vn);
                System.out.println(ll.toString() + "\nImporte: " + parcial);
                total += parcial;
            }

            System.out.println("\n## LLAMADAS HORARIO REDUCIDO ##");
            for (int i = 0; i < llamadas.getLlamadasHorarioReducido().size(); ++i) {
                Llamada ll = llamadas.getLlamadasHorarioReducido().get(i);
                parcial = ll.aceptar(vr);
                System.out.println(ll.toString() + "\nImporte: " + parcial);
                total += parcial;
            }

            System.out.println("\n\n *** Importe Total: " + total + " ***");

        } catch (Exception e) {
            e.toString();
        }
    }
}
