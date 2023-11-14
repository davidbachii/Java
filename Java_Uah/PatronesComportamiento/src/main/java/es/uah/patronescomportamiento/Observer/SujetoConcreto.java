package es.uah.patronescomportamiento.Observer;

/**
 * SujetoConcreto: Implementa la interfaz Sujeto. Contiene una lista de
 * observadores a los que notifica cambios en la cotización de una acción
 *
 * @author Salvador Oton
 */
import java.util.ArrayList;

public class SujetoConcreto implements Sujeto {

    // Lista de observadores de un valor.
    private ArrayList<Observador> observadores = new ArrayList<>();
    //Valor monitorizado.
    private Valor valor;

    @Override
    public void setValor(Valor v) {
        this.valor = v;
    }

    @Override
    public Valor getValor() {
        return this.valor;
    }

    @Override
    public void añadirObservador(Observador o) {
        if (observadores.contains(o) == false) {
            observadores.add(o);
        }
    }

    @Override
    public void eliminarObservador(Observador o) {
        observadores.remove(o);
    }

    @Override
    public void notificarObservadores() {
        //Pasamos el vector a un array para evitar la eliminación
        //de los observadores en tiempo de ejecución
        Object[] obArray = observadores.toArray();

        for (int i = 0; i < obArray.length; ++i) {
            Observador o = (Observador) obArray[i];
            System.out.println(o.actualizar());
        }
    }
}
