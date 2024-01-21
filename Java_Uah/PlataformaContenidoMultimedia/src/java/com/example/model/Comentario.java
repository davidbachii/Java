package com.example.model;

import java.util.HashMap;
import java.util.Map;

public class Comentario implements Cloneable {

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

    @Override
    public Comentario clone() {
        try {
            return (Comentario) super.clone();
        } catch (CloneNotSupportedException e) {
            // Manejar la excepción, por ejemplo, imprimir el error
            e.printStackTrace();
            return null;
        }
    }

    public String reemplazarPalabrasOfensivas(String texto) {
        // Definir un mapa de palabras ofensivas y sus reemplazos
        Map<String, String> reemplazos = new HashMap<>();
        reemplazos.put("mierda", "maravilla");
        reemplazos.put("estupido", "asombroso");
        reemplazos.put("estupida", "asombrosa");
        reemplazos.put("idiota", "inteligente");
        reemplazos.put("odio", "amo");
        // Agregar más palabras ofensivas y sus reemplazos según sea necesario

        // Realizar reemplazos en el texto
        for (Map.Entry<String, String> entry : reemplazos.entrySet()) {
            String palabraOfensiva = entry.getKey();
            String reemplazo = entry.getValue();
            texto = texto.replaceAll("\\b" + palabraOfensiva + "\\b", reemplazo);
        }

        return texto;
    }

}
