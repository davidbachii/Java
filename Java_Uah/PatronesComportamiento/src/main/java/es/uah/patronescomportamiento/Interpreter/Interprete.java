package es.uah.patronescomportamiento.Interpreter;

/**
 * Interfaz Interprete. Define un método interpretar que cada interprete
 * implementará de un modo distinto
 *
 * @author Salvador Oton
 */
public interface Interprete {

    public void interpretar(Contexto contexto);
}
