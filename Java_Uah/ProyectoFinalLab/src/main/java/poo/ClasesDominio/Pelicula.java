package poo.ClasesDominio;

import java.io.Serializable;
import javax.swing.ImageIcon;


public class Pelicula extends Contenido implements Serializable{
    
    //ATRIBUTOS
    private String duracion;

    private String director;
    
    //CONSTRUCTOR

    public Pelicula(String duracion, String director, String titulo, String sinopsis, String genero, String anno, String actores, ImageIcon imagen, String puntuacion) {
        super(titulo, sinopsis, genero, anno, actores, imagen, puntuacion);
        this.duracion = duracion;
        this.director = director;
    }
    
    //METODOS

    public String getDuracion() {
        return duracion;
    }

    public void setDuracion(String duracion) {
        this.duracion = duracion;
    }

    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;
    }
    
    
    

}
