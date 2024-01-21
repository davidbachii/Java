/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.model;

/**
 *
 * @author david
 */
public class Usuario {
    
    private String nombre;
    private String correo;
    private String contraseña;
    private Fecha fecha;

    public Usuario(String nombre, String correo, String contraseña, Fecha fecha) {
        this.nombre = nombre;
        this.correo = correo;
        this.contraseña = contraseña;
        this.fecha = fecha;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getContraseña() {
        return contraseña;
    }

    public void setContraseña(String contraseña) {
        this.contraseña = contraseña;
    }

    public Fecha getFecha() {
        return fecha;
    }

    public void setFecha(Fecha fecha) {
        this.fecha = fecha;
    }

   public boolean verificarContraseña(String contraseñaIngresada) {
    // Lógica para verificar la contraseña, puede requerir el uso de hashing y salting
    return this.contraseña.equals(contraseñaIngresada);
}

    @Override
    public String toString() {
        return "Usuario{" + "nombre=" + nombre + ", correo=" + correo + ", contrase\u00f1a=" + contraseña + ", fecha=" + fecha + '}';
    }
   
   
    
}
