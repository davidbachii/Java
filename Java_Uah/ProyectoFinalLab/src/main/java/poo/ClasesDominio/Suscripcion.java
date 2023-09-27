package poo.ClasesDominio;

import java.io.Serializable;
import java.time.LocalDate;


public class Suscripcion implements Serializable{
    
    //ATRIBUTOS

    private LocalDate fechaSuscripcion;
    
    private double precioSuscripcion;

    public Cliente cliente;
    
    //CONSTRUCTOR
    public Suscripcion( LocalDate fechaSuscripcion, Cliente cliente, double precioSuscripcion) {
        this.precioSuscripcion = precioSuscripcion;
        this.fechaSuscripcion = fechaSuscripcion;
        this.cliente = cliente;
    }

    public Suscripcion() {
    }
    
    //METODOS
    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public LocalDate getFechaSuscripcion() {
        return fechaSuscripcion;
    }

    public void setFechaSuscripcion(LocalDate fechaSuscripcion) {
        this.fechaSuscripcion = fechaSuscripcion;
    }

    public double getPrecioSuscripcion() {
        return precioSuscripcion;
    }

    public void setPrecioSuscripcion(double precioSuscripcion) {
        this.precioSuscripcion = precioSuscripcion;
    }    

    public void validarTarjeta() {
        
    }

    public void guardarSuscipcion() {
        
    }

}
