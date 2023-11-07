package es.uah.patronesestructurales.Bridge;

import java.util.Comparator;

/**
 * Implementador. Clase general para manejar las ofertas de empleo.
 */
public abstract class OfertasImp {

    /**
     * Ordena las ofertas de empleo por el criterio indicado.
     *
     * @param criterio ascendente (asc) o descendente (des)
     * @return Cadena con las ofertas ordenadas.
     */
    public abstract String ordena(String criterio);

    /**
     * Comparador para ordenar las ofertas por empresa.
     */
    protected Comparator EmpresaComp = new Comparator() {
        @Override
        public int compare(Object o1, Object o2) {
            OfertaEmp oe1 = (OfertaEmp) o1;
            OfertaEmp oe2 = (OfertaEmp) o2;
            return oe1.getEmpresa().compareTo(oe2.getEmpresa());
        }
    };

    /**
     * Comparador para ordenar las ofertas por ocupación.
     */
    protected Comparator OcupacionComp = new Comparator() {
        @Override
        public int compare(Object o1, Object o2) {
            OfertaEmp oe1 = (OfertaEmp) o1;
            OfertaEmp oe2 = (OfertaEmp) o2;
            return oe1.getOcupacion().compareTo(oe2.getOcupacion());
        }
    };

    /**
     * Comparador para ordenar las ofertas por salario.
     */
    protected Comparator SalarioComp = new Comparator() {
        @Override
        public int compare(Object o1, Object o2) {
            OfertaEmp oe1 = (OfertaEmp) o1;
            OfertaEmp oe2 = (OfertaEmp) o2;
            Integer s1 = oe1.getSalario();
            Integer s2 = oe2.getSalario();
            return s1.compareTo(s2);
        }
    };

    /**
     * Comparador para ordenar las ofertas por ciudad.
     */
    protected Comparator CiudadComp = new Comparator() {
        @Override
        public int compare(Object o1, Object o2) {
            OfertaEmp oe1 = (OfertaEmp) o1;
            OfertaEmp oe2 = (OfertaEmp) o2;
            return oe1.getCiudad().compareTo(oe2.getCiudad());
        }
    };

    /**
     * Comparador para ordenar las ofertas por fecha de alta.
     */
    protected Comparator FechaComp = new Comparator() {
        @Override
        public int compare(Object o1, Object o2) {
            OfertaEmp oe1 = (OfertaEmp) o1;
            OfertaEmp oe2 = (OfertaEmp) o2;
            return oe1.getFechaAlta().compareTo(oe2.getFechaAlta());
        }
    };
}
