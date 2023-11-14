package es.uah.patronescomportamiento.Command;

/**
 * Crea la reunión, el comando y el invocador
 *
 * @author Salvador Oton
 */
public class Cliente {

    public static void main(String args[]) {
        try {
            // Fecha de la reunión
            FechaHora fh = new FechaHora(1, 6, 2021, 10, 30);
            // Reunión
            Reunion r = new Reunion("Proyecto", "Roberto, María, Javier", "Sala reunión 1", fh);
            System.out.println("\n- Antes de ejecutar los comandos:" + r.toString());

            // Comando para cambiar la localización
            ComandoDeshacer comando = new ComandoCambiarLocalizacion();
            comando.setReunion(r);
            // Invocador
            Invocador inv = new Invocador();
            // Establece y ejecuta el comando
            inv.setComando(comando);
            inv.ejecutaComando("Sala reunión 2");
            System.out.println("\n- Después de ejecutar el comando localización:" + r.toString());
            // Deshace el comando
            inv.deshacerComando();
            System.out.println("\n- Deshacer:" + r.toString());
            // Rehace el comando
            inv.rehacerComando();
            System.out.println("\n- Rehacer:" + r.toString());

            // Comando para cambiar la fecha
            comando = new ComandoCambiarFecha();
            comando.setReunion(r);
            // Establece y ejecuta el comando
            inv.setComando(comando);
            inv.ejecutaComando("5/6/2021/12:30");
            System.out.println("\n- Después de ejecutar el comando fecha:" + r.toString());
            // Deshace el comando
            inv.deshacerComando();
            System.out.println("\n- Deshacer:" + r.toString());
            // Rehace el comando
            inv.rehacerComando();
            System.out.println("\n- Rehacer:" + r.toString());
        } catch (Exception e) {
            System.out.println(e.toString());
        }
    }
}
