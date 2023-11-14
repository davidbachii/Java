package es.uah.patronescomportamiento.ObserverBean;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

/**
 * Java Bean que gestiona a sus observadores. Notifica cambios en la cotización de una acción.
 *
 * @author Salvador Oton
 */
public class SujetoConcreto {
    
    //Valor monitorizado
    private Valor valor;
    
    /** 
     * PropertyChangeSupport es una clase de utilidad que pueden utilizar los beans que admiten propiedades enlazadas. 
     * Gestiona una lista de oyentes y les envía PropertyChangeEvents cuando cambia una propiedad.     
     * PropertyChangeListener se puede registrar para todas las propiedades o para una propiedad especificada por nombre.
    */
    private final PropertyChangeSupport pcs = new  PropertyChangeSupport(this);
          
    /**
     * Registra nuevos observadores
     * 
     * @param pcl Interfaz de escucha para recibir eventos de cambio de propiedad, cada vez que un bean cambia una propiedad vinculada.
     */
    public void addObserver(PropertyChangeListener pcl) {
	this.pcs.addPropertyChangeListener(pcl);
    }
    
    /**
     * Elimina observadores
     * 
     * @param pcl Interfaz de escucha para recibir eventos de cambio de propiedad, cada vez que un bean cambia una propiedad vinculada.
     */
    public void deleteObserver(PropertyChangeListener pcl) {
        this.pcs.removePropertyChangeListener(pcl);
    }
    
    /**
     * Establece el valor al que monitorizar su cotización.
     *
     * @param v Valor al que monitorizar su cotización.
     */
    public void setValor(Valor v) {
        this.valor = v;
    }
    
    /**
     * Devuelve el valor al que monitorizar su cotización.
     *
     * @return Valor al que monitorizar su cotización.
     */
    public Valor getValor() {
        return this.valor;
    }
    
    /**
     * Modifica cotización.
     * Utiliza PropertyChangeEvent cada vez que un bean cambia una propiedad 
     *
     * @param cotizacion Nueva cotización.
     */
    public void cambiaValor(double cotizacion) {
        double cotizacionAntigua = valor.getCotizacion();
        valor.setCotizacion(cotizacion);        
        PropertyChangeEvent pce = new PropertyChangeEvent( this, "cotEvent", cotizacionAntigua, cotizacion);        
        pcs.firePropertyChange(pce);
    }
}
