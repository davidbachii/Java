package poo.ClasesDominio;

import java.io.Serializable;
import java.util.ArrayList;
import javax.swing.ImageIcon;


public class Serie extends Contenido implements Serializable{
    
    //ATRIBUTOS
    private String temporadas;

    private ArrayList <Capitulo> capitulos;
    
    //CONSTRUCTOR

    public Serie(String temporadas, ArrayList<Capitulo> capitulos, String titulo, String sinopsis, String genero, String anno, String actores, ImageIcon imagen, String puntuacion) {
        super(titulo, sinopsis, genero, anno, actores, imagen, puntuacion);
        this.temporadas = temporadas;
        this.capitulos = capitulos;
    }
    
    
    //METODOS
    public String getTemporadas() {
        return temporadas;
    }

    public void setTemporadas(String temporadas) {
        this.temporadas = temporadas;
    }

    public ArrayList<Capitulo> getCapitulos() {
        return capitulos;
    }

    public void setCapitulos(ArrayList<Capitulo> capitulos) {
        this.capitulos = capitulos;
    }
}
