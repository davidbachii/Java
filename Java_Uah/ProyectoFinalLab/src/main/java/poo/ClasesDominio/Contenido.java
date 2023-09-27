package poo.ClasesDominio;

import java.io.Serializable;
import javax.swing.ImageIcon;

public class Contenido implements Serializable{
    
    //ATRIBUTOS
    private String titulo;

    private String sinopsis;

    private String genero;

    private String anno;

    private String actores;

    private ImageIcon imagen;
    
    private String puntuacion;
    
    //CONSTRUCTOR
    public Contenido(String titulo, String sinopsis, String genero, String anno, String actores, ImageIcon imagen, String puntuacion) {
        this.titulo = titulo;
        this.sinopsis = sinopsis;
        this.genero = genero;
        this.anno = anno;
        this.actores = actores;
        this.imagen = imagen;
        this.puntuacion = puntuacion;
    }
    
    //METODOS

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getSinopsis() {
        return sinopsis;
    }

    public void setSinopsis(String sinopsis) {
        this.sinopsis = sinopsis;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public String getAnno() {
        return anno;
    }

    public void setAño(String anno) {
        this.anno = anno;
    }

    public String getActores() {
        return actores;
    }

    public void setActores(String actores) {
        this.actores = actores;
    }

    public ImageIcon getImagen() {
        return imagen;
    }

    public void setImagen(ImageIcon imagen) {
        this.imagen = imagen;
    }

    public String getPuntuacion() {
        return puntuacion;
    }

    public void setPuntuacion(String puntuacion) {
        this.puntuacion = puntuacion;
    }

}
