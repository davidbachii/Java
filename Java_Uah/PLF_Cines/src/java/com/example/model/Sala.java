/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.model;

/**
 *
 * @author david
 */
public class Sala {
    
    private  String nombreSala;
    private int filas;
    private int columnas;
    private String nombre_pelicula;

    public Sala(String nombreSala, int filas, int columnas, String nombre_pelicula) {
        this.nombreSala = nombreSala;
        this.filas = filas;
        this.columnas = columnas;
        this.nombre_pelicula = nombre_pelicula;
    }

    public String getNombreSala() {
        return nombreSala;
    }

    public void setNombreSala(String nombreSala) {
        this.nombreSala = nombreSala;
    }

    public int getFilas() {
        return filas;
    }

    public void setFilas(int filas) {
        this.filas = filas;
    }

    public int getColumnas() {
        return columnas;
    }

    public void setColumnas(int columnas) {
        this.columnas = columnas;
    }

    public String getNombre_pelicula() {
        return nombre_pelicula;
    }

    public void setNombre_pelicula(String nombre_pelicula) {
        this.nombre_pelicula = nombre_pelicula;
    }

    @Override
    public String toString() {
        return "Sala{" + "nombreSala=" + nombreSala + ", filas=" + filas + ", columnas=" + columnas + ", nombre_pelicula=" + nombre_pelicula + '}';
    }


    
    
    
    
    
}
