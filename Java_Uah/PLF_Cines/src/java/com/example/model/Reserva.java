/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.model;

/**
 *
 * @author david
 */
public class Reserva {
    
    private String numeroRef;
    private String email_usuario;
    private String id_entrada;
    private int fila_entrada;
    private int columna_entrada;

    public Reserva(String numeroRef, String email_usuario, String id_entrada, int fila_entrada, int columna_entrada) {
        this.numeroRef = numeroRef;
        this.email_usuario = email_usuario;
        this.id_entrada = id_entrada;
        this.fila_entrada = fila_entrada;
        this.columna_entrada = columna_entrada;
    }

    public String getNumeroRef() {
        return numeroRef;
    }

    public void setNumeroRef(String numeroRef) {
        this.numeroRef = numeroRef;
    }

    public String getEmail_usuario() {
        return email_usuario;
    }

    public void setEmail_usuario(String email_usuario) {
        this.email_usuario = email_usuario;
    }

    public String getId_entrada() {
        return id_entrada;
    }

    public void setId_entrada(String id_entrada) {
        this.id_entrada = id_entrada;
    }

    public int getFila_entrada() {
        return fila_entrada;
    }

    public void setFila_entrada(int fila_entrada) {
        this.fila_entrada = fila_entrada;
    }

    public int getColumna_entrada() {
        return columna_entrada;
    }

    public void setColumna_entrada(int columna_entrada) {
        this.columna_entrada = columna_entrada;
    }
    
    
    

   
    

    
    
    
}
