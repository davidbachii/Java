package es.uah.patronesfundamentales.IntAbsClass;

/**
 * Clase cliente.
 */
public class Cliente {

    /**
     * Método de arranque del programa.
     *
     * @param args
     */
    public static void main(String[] args) {
        //Creamos informáticos
        IntTrabajo inf1 = new Analista("IBM", "BBDD");
        IntTrabajo inf2 = new Programador("Indra", "Java");

        //Pagamos los sueldos utilizando polimorfismo
        inf1.setSueldo(inf1.pagarSueldo(160));
        inf2.setSueldo(inf2.pagarSueldo(180));

        System.out.println("Sueldo analista: " + inf1.getSueldo());
        System.out.println("Sueldo programador: " + inf2.getSueldo());
    }
}
