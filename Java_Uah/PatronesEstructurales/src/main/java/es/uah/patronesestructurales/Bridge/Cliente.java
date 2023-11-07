package es.uah.patronesestructurales.Bridge;

/**
 * Cliente para probar el patrón Bridge.
 */
public class Cliente {

    /**
     * Método de arranque del programa.
     *
     * @param args
     */
    public static void main(String args[]) {

        //**** Lista Ofertas Empleo por Ocupación ****
        OfertasAbst abst = new OfertasAbst();
        OfertasImp imp = new OfertasImpOcupacion();
        //Inicializamos las ofertas
        Datos.inicializaLista();
        //Establecemos el implementador
        abst.setImplementador(imp);
        //Ordenamos la lista de ofertas por el atributo Ocupación        
        //Presentamos las ofertas por ocupación
        System.out.println("\nOfertas ordenadas por Ocupación en orden ascendente:");
        System.out.println(abst.ordena("asc"));

        //**** Lista Ofertas Empleo por Salario ****
        imp = new OfertasImpSalario();
        //Establecemos el implementador
        abst.setImplementador(imp);
        //Ordenamos la lista de ofertas por el atributo Salario        
        //Presentamos las ofertas por salario
        System.out.println("\nOfertas ordenadas por Salario en orden descendente:");
        System.out.println(abst.ordena("des"));

        //Con abstracción refinada
        OfertasAbst abstRef = new OfertasAbstRef();
        abstRef.setImplementador(imp);
        //Presentamos las ofertas por salario
        System.out.println("\nOfertas ordenadas por Salario concreto (salario >=1500) en orden descendente:");
        System.out.println(abstRef.ordena("des,salario,1500"));
    }
}
