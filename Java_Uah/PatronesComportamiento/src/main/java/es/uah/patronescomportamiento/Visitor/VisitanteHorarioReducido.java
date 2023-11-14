package es.uah.patronescomportamiento.Visitor;

/**
 * VisitanteHorarioReducido: Implementa la interfaz Visitante para una operación
 * o algoritmo específico.
 *
 * @author Salvador Oton
 */
public class VisitanteHorarioReducido implements Visitante {

    @Override
    public double visitar(LlamadaMetropolitana metropoli) {
        return metropoli.getDuracion() * 0.0099;
    }

    @Override
    public double visitar(LlamadaProvincial prov) {
        return prov.getDuracion() * 0.0264;
    }

    @Override
    public double visitar(LlamadaInterprovincial intprov) {
        return intprov.getDuracion() * 0.0378;
    }
}
