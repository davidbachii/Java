/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package poo.ClasesDominio;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

/**
 *
 * @author RiCh_LiKe
 */
public class GuardarLeerFicheros {
    private static ArrayList <Cliente> clientes = new ArrayList<>();
    private static ArrayList <Pelicula> peliculas = new ArrayList<>();
    private static ArrayList <Pelicula> peliculasFav = new ArrayList<>();
    private static ArrayList <Serie> series = new ArrayList<>();
    private static ArrayList <Serie> seriesFav = new ArrayList<>();
    private static Suscripcion sus = new Suscripcion();
    
    public static ArrayList <Cliente> obtenerArrayClientes() {
        return clientes;
    }
    public static ArrayList <Pelicula> obtenerArrayPeliculas() {
        return peliculas;
    }
    public static ArrayList <Serie> obtenerArraySeries() {
        return series;
    }
    public static Suscripcion obtenerSuscripcion() {
        return sus;
    }
    
    public static ArrayList <Serie> obtenerArraySeriesFav() {
        return seriesFav;
    }
    
    public static ArrayList <Pelicula> obtenerArrayPeliculasFav() {
        return peliculasFav;
    }
    
    public static void guardarPeliculaListaFav(String dni) {
        
        try {
            //Si hay datos los guardamos...
            if (!peliculasFav.isEmpty()) {
                
                try ( //Serialización
                        FileOutputStream fosPer = new FileOutputStream("ficheros/listaFav/listaPeliculasFav"+dni+".dat")) {
                    ObjectOutputStream oosPer = new ObjectOutputStream(fosPer);
                    oosPer.writeObject(peliculasFav);
                }
                System.out.println("Datos de peliculas favoritas guardados correctamente");
            } else {
                System.out.println("Error: No hay datos...");
            }

        } catch (IOException ioe) {
            System.out.println("Error de IO: " + ioe.getMessage());
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
    
    public static void cargarPeliculasListaFav(String dni) {
        
        try (FileInputStream fisPer = new FileInputStream("ficheros/listaFav/listaPeliculasFav"+dni+".dat");
            ObjectInputStream oisPer = new ObjectInputStream(fisPer)) {

            peliculasFav = (ArrayList<Pelicula>) oisPer.readObject();
            System.out.println("listaPeliculasFav leida");
            

        } catch (IOException ioe) {
            System.out.println("Error de IO: no hay datos guardados, " + ioe.getMessage());
        } catch (ClassNotFoundException cnfe) {
            System.out.println("Error de clase no encontrada: " + cnfe.getMessage());
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
    
    public static void guardarSerieListaFav(String dni) {
        
        try {
            //Si hay datos los guardamos...
            if (!seriesFav.isEmpty()) {
                
                try ( //Serialización
                        FileOutputStream fosPer = new FileOutputStream("ficheros/listaFav/listaSeriesFav"+dni+".dat")) {
                    ObjectOutputStream oosPer = new ObjectOutputStream(fosPer);
                    oosPer.writeObject(seriesFav);
                }
                System.out.println("Datos de series favoritas guardados correctamente");
            } else {
                System.out.println("Error: No hay datos...");
            }

        } catch (IOException ioe) {
            System.out.println("Error de IO: " + ioe.getMessage());
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
    
    public static void cargarSeriesListaFav(String dni) {
        
        try (FileInputStream fisPer = new FileInputStream("ficheros/listaFav/listaSeriesFav"+dni+".dat");
            ObjectInputStream oisPer = new ObjectInputStream(fisPer)) {

            seriesFav = (ArrayList<Serie>) oisPer.readObject();
            System.out.println("listaSeriesFav leida");
            

        } catch (IOException ioe) {
            System.out.println("Error de IO: no hay datos guardados, " + ioe.getMessage());
        } catch (ClassNotFoundException cnfe) {
            System.out.println("Error de clase no encontrada: " + cnfe.getMessage());
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
    
    
    
    public static void cargarDatosSuscripcion(String dni) {
        
        try (FileInputStream fisSus = new FileInputStream("ficheros/suscripciones/"+dni+".dat");
            ObjectInputStream oisSus = new ObjectInputStream(fisSus)) {

            sus = (Suscripcion) oisSus.readObject();
            System.out.println("Fichero leido");
            

        } catch (IOException ioe) {
            System.out.println("Error de IO: no hay datos guardados, " + ioe.getMessage());
        } catch (ClassNotFoundException cnfe) {
            System.out.println("Error de clase no encontrada: " + cnfe.getMessage());
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
    
    public static void guardarDatosSuscripcion(String dni, Suscripcion sus) {
        try (FileOutputStream fosPer = new FileOutputStream("ficheros/suscripciones/"+dni+".dat");
            ObjectOutputStream oosPer = new ObjectOutputStream(fosPer)){
            
            oosPer.writeObject(sus);
            System.out.println("Suscripcion guardada correctamente");
            

        } catch (IOException ioe) {
            System.out.println("Error de IO: " + ioe.getMessage());
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
    
    public static void guardarDatosClientes() {
        
        try {
            //Si hay datos los guardamos...
            if (!clientes.isEmpty()) {
                
                //Serialización
                FileOutputStream fosPer = new FileOutputStream("ficheros/listaClientes.dat");
                ObjectOutputStream oosPer = new ObjectOutputStream(fosPer);
                oosPer.writeObject(clientes);
                fosPer.close();
                System.out.println("Datos registro guardados correctamente");
            } else {
                System.out.println("Error: No hay datos...");
            }

        } catch (IOException ioe) {
            System.out.println("Error de IO: " + ioe.getMessage());
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
        
    }
    
    public static void cargarDatosClientes() {
        
        try (FileInputStream fisPer = new FileInputStream("ficheros/listaClientes.dat");
            ObjectInputStream oisPer = new ObjectInputStream(fisPer)) {

            clientes = (ArrayList<Cliente>) oisPer.readObject();
            System.out.println("Fichero leido");
            

        } catch (IOException ioe) {
            System.out.println("Error de IO: no hay datos guardados, " + ioe.getMessage());
        } catch (ClassNotFoundException cnfe) {
            System.out.println("Error de clase no encontrada: " + cnfe.getMessage());
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
    
    public static void guardarDatosPeliculas() {
        
        try {
            //Si hay datos los guardamos...
            if (!peliculas.isEmpty()) {
                
                try ( //Serialización
                        FileOutputStream fosPer = new FileOutputStream("ficheros/listaPeliculas.dat")) {
                    ObjectOutputStream oosPer = new ObjectOutputStream(fosPer);
                    oosPer.writeObject(peliculas);
                }
                System.out.println("Datos de peliculas guardados correctamente");
            } else {
                System.out.println("Error: No hay datos...");
            }

        } catch (IOException ioe) {
            System.out.println("Error de IO: " + ioe.getMessage());
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
    
    public static void cargarDatosPeliculas() {
        
        try (FileInputStream fisPer = new FileInputStream("ficheros/listaPeliculas.dat");
            ObjectInputStream oisPer = new ObjectInputStream(fisPer)) {

            peliculas = (ArrayList<Pelicula>) oisPer.readObject();
            System.out.println("listaPeliculas leida");
            

        } catch (IOException ioe) {
            System.out.println("Error de IO: no hay datos guardados, " + ioe.getMessage());
        } catch (ClassNotFoundException cnfe) {
            System.out.println("Error de clase no encontrada: " + cnfe.getMessage());
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
    
    public static void guardarDatosSeries() {
        
        try {
            //Si hay datos los guardamos...
            if (!series.isEmpty()) {
                
                try ( //Serialización
                        FileOutputStream fosPer = new FileOutputStream("ficheros/listaSeries.dat")) {
                    ObjectOutputStream oosPer = new ObjectOutputStream(fosPer);
                    oosPer.writeObject(series);
                }
                System.out.println("Datos series guardados correctamente");
            } else {
                System.out.println("Error: No hay datos...");
            }

        } catch (IOException ioe) {
            System.out.println("Error de IO: " + ioe.getMessage());
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
    
    public static void cargarDatosSeries() {
        
        try (FileInputStream fisPer = new FileInputStream("ficheros/listaSeries.dat");
            ObjectInputStream oisPer = new ObjectInputStream(fisPer)) {

            series = (ArrayList<Serie>) oisPer.readObject();
            System.out.println("listaSeries leida");
            

        } catch (IOException ioe) {
            System.out.println("Error de IO: no hay datos guardados, " + ioe.getMessage());
        } catch (ClassNotFoundException cnfe) {
            System.out.println("Error de clase no encontrada: " + cnfe.getMessage());
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
