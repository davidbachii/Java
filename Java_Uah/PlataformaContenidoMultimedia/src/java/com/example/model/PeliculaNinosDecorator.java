/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.model;

/**
 *
 * @author david
 */
// Decorador Concreto para Películas de Niños
public class PeliculaNinosDecorator extends DecoradorPelicula {

    private String nombrePelicula;

    public PeliculaNinosDecorator(PeliculaComponente peliculaDecorada, String nombrePelicula) {
        super(peliculaDecorada);
        this.nombrePelicula = nombrePelicula;
    }

    @Override
    public void mostrarInformacion() {
        super.mostrarInformacion();
        System.out.println("La película '" + nombrePelicula + "' es apta para niños.");
    }
}
