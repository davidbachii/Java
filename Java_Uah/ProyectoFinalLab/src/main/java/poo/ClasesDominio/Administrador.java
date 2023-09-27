package poo.ClasesDominio;

import java.io.Serializable;



public class Administrador implements Serializable{
    
    //ATRIBUTOS
    private String correo;

    private String clave;
    
    //CONSTRUCTOR

    public Administrador (String correo, String clave) {
        this.correo = correo;
        this.clave = clave;
    }
    
    //METODOS

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
    
    public void crearCont() {
    }

    public void borrarCont() {
    }

    public void modifCont() {
    }

    public void bajaUsuario() {
    }

}
