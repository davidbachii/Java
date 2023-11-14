package es.uah.patronescomportamiento.Mediator;

import java.util.ArrayList;

/**
 * Implementa comportamiento del Mediador coordinando todos los colegas.
 *
 * @author Salvador Oton
 */
public class MediadorConcreto implements Mediador {

    // Lista de colegas
    private ArrayList<Colega> colegas = new ArrayList<>();

    @Override
    public void setColega(Colega colega) {
        colegas.add(colega);
    }

    @Override
    public Colega getColega(int indice) {
        return colegas.get(indice);
    }

    /**
     * Envía un mensaje al colega cuyo identificador se pasa como argumento. Si
     * el identificador es -1, el mensaje se envía a todos los colegas. En otro
     * caso, solo se envía al colega concreto.
     *
     * @param mensaje Mensaje a enviar.
     * @param id Identificador del colega al que se le envía el mensaje.
     */
    @Override
    public void enviar(String mensaje, int id) {
        if (id == -1) {
            for (int i = 0; i < colegas.size(); i++) {
                getColega(i).recibir(mensaje);
            }
        } else {
            getColega(id).recibir(mensaje);
        }
    }
}
