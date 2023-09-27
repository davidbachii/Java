package es.uah.patronesfundamentales.IntAbsClass;

/**
 * Clase abstracta con los métodos comunes a distintos tipos de trabajador
 * informático.
 */
public abstract class InformaticoAbs implements IntTrabajo {

    //Atributos
    /**
     * Nombre de la empresa.
     */
    private String empresa;
    /**
     * Sueldo.
     */
    private double sueldo;

    /**
     * Constructor
     *
     * @param empresa Nombre de la empresa.
     */
    public InformaticoAbs(String empresa) {
        this.empresa = empresa;
    }

    //Métodos que se sobrescriben ya que pertenecen a la interfaz IntTrabajo
    @Override
    public String getEmpresa() {
        return this.empresa;
    }

    @Override
    public void setEmpresa(String nueva) {
        this.empresa = nueva;
    }

    @Override
    public double getSueldo() {
        return this.sueldo;
    }

    @Override
    public void setSueldo(double euros) {
        this.sueldo = euros;
    }

    //Método que pertenece a la interfaz IntTrabajo. Se declara abstracto, por lo que serán las clases hija las que lo deberán sobrescribir.
    @Override
    public abstract double pagarSueldo(double horas); //El unico metodop de esta clase que se tiene que utilizar si o si en el resto
    //de clases que extiendan esta clase abstracta, es este ya que es el metodo abstracto
    //Tambiene es obligatorio que haya un metodo abstracto
}
