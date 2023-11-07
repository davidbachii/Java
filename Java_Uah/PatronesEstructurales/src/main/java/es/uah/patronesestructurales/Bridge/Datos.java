package es.uah.patronesestructurales.Bridge;

import java.time.LocalDate;
import java.time.Month;
import java.util.ArrayList;


//Clase singleton con ofertas de empleo
public class Datos {

    /**
     * Instancia de la clase.
     */
    private static Datos instancia = new Datos();

    /**
     * Constructor privado.
     */
    private Datos() {
    }

    /**
     * Devuelve la instancia de la clase.
     *
     * @return Instancia de la clase.
     */
    public static Datos getInstancia() {
        return instancia;
    }

    /**
     * Lista de ofertas de empleo.
     */
    private static ArrayList<OfertaEmp> ofertas = new ArrayList<>();

    /**
     * Devuelve la lista de ofertas de empleo.
     *
     * @return Lista de ofertas de empleo.
     */
    public static ArrayList<OfertaEmp> getOfertas() {
        return ofertas;
    }

    /**
     * Establece la lista de ofertas de empleo.
     *
     * @param ofertas Lista de ofertas de empleo.
     */
    public static void setOfertas(ArrayList<OfertaEmp> ofertas) {
        Datos.ofertas = ofertas;
    }

    /**
     * Devuelve una oferta de empleo.
     *
     * @param index Índice de la oferta de empleo a devolver.
     * @return Oferta de empleo.
     */
    public OfertaEmp getOferta(int index) {
        return ofertas.get(index);
    }

    /**
     * Añade una oferta de empleo a la lista de ofertas de empleo.
     *
     * @param oe Oferta de empleo.
     */
    public static void altaOferta(OfertaEmp oe) {
        if (!ofertas.contains(oe)) {
            ofertas.add(oe);
        }
    }

    /**
     * Elimina una oferta de empleo a la lista de ofertas de empleo.
     *
     * @param index Índice de la oferta de empleo a eliminar.
     * @return true si la ofeta se eliminó, false si la oferta a eliminar no
     * existe
     */
    public static boolean bajaOferta(int index) {
        if (index < ofertas.size()) {
            ofertas.remove(index);
            return true;
        } else {
            return false;
        }
    }

    /**
     * Elimina todos los elementos de la lista de ofertas de empleo.
     */
    public static void borraLista() {
        ofertas.clear();
    }

    /**
     * Devuelve el número de ofertas de empleo.
     *
     * @return Número de ofertas de empleo.
     */
    public static int numeroOfertas() {
        return ofertas.size();
    }

    /**
     * Devuelve una cadena con el contenido de todas las ofertas de empleo.
     *
     * @return Cadena con el contenido de todas las ofertas de empleo.
     */
    public static String listadoOfertas() {
        StringBuilder lista = new StringBuilder();
        int i = 1;
        for (OfertaEmp oe : ofertas) {
            lista.append(i++).append(" - ");
            lista.append(oe.toString()).append("\n");
        }
        return lista.toString();
    }

    /**
     * Inicializa la lista de ofertas de empleo.
     */
    public static void inicializaLista() {
        LocalDate f1 = LocalDate.of(2021, Month.FEBRUARY, 15);
        LocalDate f2 = LocalDate.of(2021, Month.APRIL, 5);
        LocalDate f3 = LocalDate.of(2021, Month.JUNE, 20);
        OfertaEmp oe1 = new OfertaEmp("Indra", "programador junior", 900, "Madrid", f1);
        OfertaEmp oe2 = new OfertaEmp("Indra", "programador senior", 1200, "Madrid", f1);
        OfertaEmp oe3 = new OfertaEmp("Coritel", "analista", 1500, "Madrid", f2);
        OfertaEmp oe4 = new OfertaEmp("Coritel", "jefe proyecto", 1800, "Madrid", f2);
        OfertaEmp oe5 = new OfertaEmp("BBVA", "interventor", 1600, "Murcia", f3);
        OfertaEmp oe6 = new OfertaEmp("BBVA", "director oficina", 2000, "Murcia", f3);
        ofertas.add(oe1);
        ofertas.add(oe2);
        ofertas.add(oe3);
        ofertas.add(oe4);
        ofertas.add(oe5);
        ofertas.add(oe6);
    }
}
