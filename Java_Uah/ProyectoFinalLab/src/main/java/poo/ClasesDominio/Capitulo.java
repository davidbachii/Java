package poo.ClasesDominio;

import java.io.Serializable;


public class Capitulo implements Serializable{
    
    //ATRIBUTOS
    private String titulo;

    private String duracion;
    
    
    //CONSTRUCTOR
    public Capitulo(String titulo, String duracion) {
        this.titulo = titulo;
        this.duracion = duracion;
    }
    
    //METODOS

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getDuracion() {
        return duracion;
    }

    public void setDuracion(String duracion) {
        this.duracion = duracion;
    }
    

}
