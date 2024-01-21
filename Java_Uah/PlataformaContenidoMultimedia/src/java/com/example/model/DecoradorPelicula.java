/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.model;

/**
 *
 * @author david
 */
public abstract class DecoradorPelicula implements PeliculaComponente{
    
    private PeliculaComponente peliculaDecorada;

    public DecoradorPelicula(PeliculaComponente peliculaDecorada) {
        this.peliculaDecorada = peliculaDecorada;
    }

    @Override
    public void mostrarInformacion() {
        peliculaDecorada.mostrarInformacion();
    }
    
}
