package es.uah.patronescomportamiento.Visitor;

/**
 * Interfaz Visitante. Define un método visitar para cada una de las clases
 * concretas a visitar
 *
 * @author Salvador Oton
 */
public interface Visitante {

    /**
     * Visitar para llamada metropolitana.
     *
     * @param metropoli Llamada metropolitana.
     * @return Coste de la llamada.
     */
    public double visitar(LlamadaMetropolitana metropoli);

    /**
     * Visitar para llamada provincial.
     *
     * @param prov Llamada provincial
     * @return Coste de la llamada.
     */
    public double visitar(LlamadaProvincial prov);

    /**
     * Visitar para llamada interprovincial.
     *
     * @param intprov Llamada interprovincial
     * @return Coste de la llamada.
     */
    public double visitar(LlamadaInterprovincial intprov);
}
