package es.uah.patronescomportamiento.ObserverJava;

import java.util.Observable;

/**
 * Gestiona a sus observadores. Notifica cambios en la cotización de una acción.
 *
 * @author Salvador Oton
 */
public class SujetoConcreto extends Observable {

    //Valor monitorizado
    private Valor valor;

    /**
     * Establece el valor al que monitorizar su cotización.
     *
     * @param v Valor al que monitorizar su cotización.
     */
    public void setValor(Valor v) {
        this.valor = v;
    }

    /**
     * Modifica cotización.
     *
     * @param cotizacion Nueva cotización.
     */
    public void cambiaValor(double cotizacion) {
        valor.setCotizacion(cotizacion);
        setChanged();
        notifyObservers();
    }

    /**
     * Devuelve el valor al que monitorizar su cotización.
     *
     * @return Valor al que monitorizar su cotización.
     */
    public Valor getValor() {
        return this.valor;
    }
}
