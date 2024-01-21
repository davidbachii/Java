/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.example.model;

/**
 *
 * @author david
 */

/*
Creamos una interfaz llamada PeliculaObservable, 
que define los métodos agregarObservador y notificarObservadores.
*/
public interface PeliculaObservable {
    
    void agregarObservador(PeliculaObservador observador);
    void notificarObservadoresCreacion(Pelicula pelicula);
    void notificarObservadoresBorrado(Pelicula pelicula);
    
}
