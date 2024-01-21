/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.model;

import java.util.Date;
import java.time.LocalTime;

/**
 *
 * @author david
 */


public class Entrada {
    private String idEntrada;
    private Fecha fecha;
    private LocalTime hora;
    private int fila;
    private int columna;
    private String nombreSala; 

    public Entrada(String idEntrada, Fecha fecha, LocalTime hora, int fila, int columna, String nombreSala) {
        this.idEntrada = idEntrada;
        this.fecha = fecha;
        this.hora = hora;
        this.fila = fila;
        this.columna = columna;
        this.nombreSala = nombreSala;
    }

    public String getIdEntrada() {
        return idEntrada;
    }

    public void setIdEntrada(String idEntrada) {
        this.idEntrada = idEntrada;
    }

    public Fecha getFecha() {
        return fecha;
    }

    public void setFecha(Fecha fecha) {
        this.fecha = fecha;
    }

    public LocalTime getHora() {
        return hora;
    }

    public void setHora(LocalTime hora) {
        this.hora = hora;
    }

    public int getFila() {
        return fila;
    }

    public void setFila(int fila) {
        this.fila = fila;
    }

    public int getColumna() {
        return columna;
    }

    public void setColumna(int columna) {
        this.columna = columna;
    }

    public String getNombreSala() {
        return nombreSala;
    }

    public void setNombreSala(String nombreSala) {
        this.nombreSala = nombreSala;
    }

    @Override
    public String toString() {
        return "Entrada{" + "idEntrada=" + idEntrada + ", fecha=" + fecha + ", hora=" + hora + ", fila=" + fila + ", columna=" + columna + ", nombreSala=" + nombreSala + '}';
    }

    
 
    
    
    
    
    
}
