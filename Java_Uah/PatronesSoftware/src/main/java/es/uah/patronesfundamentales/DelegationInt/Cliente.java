package es.uah.patronesfundamentales.DelegationInt;

/**
 * Clase cliente
 */
public class Cliente {

    /**
     * Método de arranque del programa.
     *
     * @param args
     */
    public static void main(String[] args) {
        //Creamos distintos roles
        Descripcion d1 = new Profesor("CC", 1600);
        Descripcion d2 = new Estudiante("Alcala", "Informática");
        Descripcion d3 = new Estudiante("Alcala", "Doctorado en Informática");

        //Creamos dos personas
        PersonalUniversitario pu1 = new PersonalUniversitario("1", "Pepe", "dir1");
        PersonalUniversitario pu2 = new PersonalUniversitario("2", "Sonia", "dir2");

        //asignamos los roles
        pu1.setRol(d1);
        pu1.setRol(d3);
        pu2.setRol(d2);
        //pu1.borraRol(d3);

        System.out.println(pu1.descripcion());
        System.out.println(pu2.descripcion());
    }
}
