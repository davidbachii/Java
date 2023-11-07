package es.uah.patronesestructurales.Bridge;

import java.util.ArrayList;

/**
 * AbstracciónRefinada: Extienden la interfaz definida por Abstracción.
 */
public class OfertasAbstRef extends OfertasAbst {

    final int TIPO_ORDENACION = 0;
    final int ATRIBUTO_ORDENACION = 1;
    final int VALOR_ORDENACION = 2;

    /**
     * Devuelve las ofertas encontradas ordenadas y filtradas por los criterio
     * especificados.
     *
     * @param criterio Cadena separada por comas de la forma "tipoOrdenacion,
     * atributoOrdenacion, valorAtributo" donde tipoOrdenacion puede tomar los
     * valores [asc,desc] atributoOrdenacion puede tomar los valores
     * [empresa,ocupacion,salario,ciudad] valorAtributo puede tomar cualquier
     * valor
     * @return Cadena con las ofertas ordenadas.
     */
    @Override
    public String ordena(String criterio) {
        String parametros[] = criterio.split(",");// Obtiene los criterios de ordenación
        ArrayList<OfertaEmp> aux = new ArrayList<>();
        //Primero: ordenamos ascendente o descendente.
        String listaIni = super.ordena(parametros[TIPO_ORDENACION]);
        //Segundo: filtramos por el atributo y su valor.
        switch (parametros[ATRIBUTO_ORDENACION]) {
            case "empresa":
                for (OfertaEmp oe : Datos.getOfertas()) {
                    if (oe.getEmpresa().equals(parametros[VALOR_ORDENACION])) {
                        aux.add(oe);
                    }
                }
                break;
            case "ocupacion":
                for (OfertaEmp oe : Datos.getOfertas()) {
                    if (oe.getOcupacion().equals(parametros[VALOR_ORDENACION])) {
                        aux.add(oe);
                    }
                }
                break;
            case "salario":
                for (OfertaEmp oe : Datos.getOfertas()) {
                    if (oe.getSalario() >= Integer.parseInt(parametros[VALOR_ORDENACION])) {
                        aux.add(oe);
                    }
                }
                break;
            case "ciudad":
                for (OfertaEmp oe : Datos.getOfertas()) {
                    if (oe.getCiudad().equals(parametros[VALOR_ORDENACION])) {
                        aux.add(oe);
                    }
                }
                break;
        }
        //Componemos la lista
        StringBuilder lista = new StringBuilder();
        int i = 1;
        for (OfertaEmp oe : aux) {
            lista.append(i++).append(" - ");
            lista.append(oe.toString()).append("\n");
        }
        return lista.toString();
    }
}
