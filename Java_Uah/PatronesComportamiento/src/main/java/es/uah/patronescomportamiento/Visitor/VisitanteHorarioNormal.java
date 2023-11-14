package es.uah.patronescomportamiento.Visitor;

/**
 * VisitanteHorarioNormal: Implementa la interfaz Visitante para una operación o
 * algoritmo específico.
 *
 * @author Salvador Oton
 */
public class VisitanteHorarioNormal implements Visitante {

    @Override
    public double visitar(LlamadaMetropolitana metropoli) {
        return metropoli.getDuracion() * 0.0240;
    }

    @Override
    public double visitar(LlamadaProvincial prov) {
        return prov.getDuracion() * 0.0384;
    }

    @Override
    public double visitar(LlamadaInterprovincial intprov) {
        return intprov.getDuracion() * 0.0645;
    }
}
