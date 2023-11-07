package es.uah.patronesestructurales.Facade;

/**
 * Facade o fachada: simplifica el acceso a cada uno de los subsistemas de un
 * sistema bancario a través del cajero.
 */
public class FachadaCajero {
     /*
    La clave de este patron es muy sencilla , simplemente delegamos los metodos de las otras clases en esta , para que en un futuro 
    cuando queramos usar esos motodos no vayamos creando cacada clase y cada metodo si no que en esta misma clase invocamos todos 
    esos metodos asi para acceder a ellos solo vamos a tener que acceder a esta clase y ya. Un ejemplo de un fachada es en la practica
    de concurrencia la clase donde tenemos todos los arrays ya que en una clase recogemos todos los metodos de los diferentes arrays
    y ya con esa clase invocamos todos
    */
    /**
     * Subsistema de validación de usuario.
     */
    
    //Invocamos todas estas clases en vez de hacerlo en el main y asi en el main solo tenemos que invocar uno
    //METER ESTO EN EL PROYECTO FINAL MUY FACIL
    private ValidacionUsuario val = new ValidacionUsuario();
    /**
     * Subsistema de retirada de dinero.
     */
    private RetirarDinero ret = new RetirarDinero();
    /**
     * Subsistema de pago de recibos.
     */
    private PagoRecibo pr = new PagoRecibo();    
    /**
     * Subsistema de regarga de móvil.
     */
    private RecargaMovil rec = new RecargaMovil();
        
    /**
     * Saca dinero.
     *
     * @return Descripción de los pasos de la operación.
     */
    public String sacarDinero() {
        return val.valida() + ret.retirar();
    }

    /**
     * Pagar recibo.
     *
     * @return Descripción de los pasos de la operación.
     */
    public String pagarRecibo() {
        return val.valida() + pr.pagar();
    }
    
    /**
     * Recarga el móvil.
     *
     * @return Descripción de los pasos de la operación.
     */
    public String recargaMovil() {
        return val.valida() + rec.recarga();
    }
}
