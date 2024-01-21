/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.model;

/**
 *
 * @author david
 */
// Decorador Concreto para Películas de Adolescentes
public class PeliculaAdolescentesDecorator extends DecoradorPelicula {

    private String nombrePelicula;

    public PeliculaAdolescentesDecorator(PeliculaComponente peliculaDecorada, String nombrePelicula) {
        super(peliculaDecorada);
        this.nombrePelicula = nombrePelicula;
    }

    @Override
    public void mostrarInformacion() {
        super.mostrarInformacion();
        System.out.println("La película '" + nombrePelicula + "' es apta para adolescentes.");
    }
}
