/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.model;

/**
 *
 * @author david
 */
public class Comentario {
    
    private String texto;
    private int valoracion;
    private Fecha fecha;
    private String email_user;
    private String nombrePelicula;

    public Comentario(String texto, int valoracion, Fecha fecha, String email_user, String nombrePelicula) {
        this.texto = texto;
        this.valoracion = valoracion;
        this.fecha = fecha;
        this.email_user = email_user;
        this.nombrePelicula = nombrePelicula;
    }

    public String getTexto() {
        return texto;
    }

    public void setTexto(String texto) {
        this.texto = texto;
    }

    public int getValoracion() {
        return valoracion;
    }

    public void setValoracion(int valoracion) {
        this.valoracion = valoracion;
    }

    public Fecha getFecha() {
        return fecha;
    }

    public void setFecha(Fecha fecha) {
        this.fecha = fecha;
    }

    public String getEmail_user() {
        return email_user;
    }

    public void setEmail_user(String email_user) {
        this.email_user = email_user;
    }

    public String getNombrePelicula() {
        return nombrePelicula;
    }

    public void setNombrePelicula(String nombrePelicula) {
        this.nombrePelicula = nombrePelicula;
    }

    @Override
    public String toString() {
        return "Comentario{" + "texto=" + texto + ", valoracion=" + valoracion + ", fecha=" + fecha + ", email_user=" + email_user + ", nombrePelicula=" + nombrePelicula + '}';
    }
    
    
    

   
    
    
}
