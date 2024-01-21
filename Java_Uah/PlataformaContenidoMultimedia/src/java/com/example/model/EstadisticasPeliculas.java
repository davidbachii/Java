/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.model;

/**
 *
 * @author david
 */
public class EstadisticasPeliculas implements PeliculaObservador {
    // Implementamos el método actualizar para realizar acciones cuando se crea una película

    /*
    La creación de una clase de estadísticas es útil para recopilar y presentar datos estadísticos 
    relacionados con las películas en tu aplicación. Algunos ejemplos de estadísticas que se podrian incluir son:

Número total de películas, Promedio de duración de películas, Número de películas por género, Año con más películas
Clasificación de edad más común
    
    
    
     */
    @Override
    public void actualizarCreacion(Pelicula pelicula) {
        System.out.println("Se ha creado la película: " + pelicula.getNombre());
        // Realizar acciones adicionales, si es necesario...
    }

    @Override
    public void actualizarBorrado(Pelicula pelicula) {
        System.out.println("Se ha borrado la película: " + pelicula.getNombre());
        // Realizar acciones adicionales, si es necesario...
    }
}
