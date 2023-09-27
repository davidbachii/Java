package poo.ClasesDominio;

import java.io.Serializable;


public class Cliente implements Serializable{
    
    //ATRIBUTOS
    private String dni;
    private String nombre;
    private String correo;
    private String clave;
    private Tarjeta tarjetaCredito;
    
    //CONSTRUCTOR

    public Cliente(String dni, String nombre, String correo, String clave, Tarjeta tarjetaCredito) {
        this.dni = dni;
        this.nombre = nombre;
        this.correo = correo;
        this.clave = clave;
        this.tarjetaCredito = tarjetaCredito;
    }

    public Cliente() {
    }

    //METODOS
    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getClave() {
        return clave;
    }

    public void setClave(String clave) {
        this.clave = clave;
    }

    public Tarjeta getTarjetaCredito() {
        return tarjetaCredito;
    }

    public void setTarjetaCredito(Tarjeta tarjetaCredito) {
        this.tarjetaCredito = tarjetaCredito;
    }

    public void calificarCont() {
    }

    public void addListaFavoritos() {
    }

}
