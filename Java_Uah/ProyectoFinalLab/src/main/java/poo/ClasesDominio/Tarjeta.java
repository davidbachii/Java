package poo.ClasesDominio;

import java.io.Serializable;
import java.time.LocalDate;

public class Tarjeta implements Serializable{
    
    //ATRIBUTOS
    private String numero;

    private LocalDate fechaCaducidad;

    private double saldo;
    
    //CONSTRUCTOR
    public Tarjeta(String numero, LocalDate fechaCaducidad, double saldo) {
        this.numero = numero;
        this.fechaCaducidad = fechaCaducidad;
        this.saldo = saldo;
    }
    
    //METODOS

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public LocalDate getFechaCaducidad() {
        return fechaCaducidad;
    }

    public void setFechaCaducidad(LocalDate fechaCaducidad) {
        this.fechaCaducidad = fechaCaducidad;
    }

    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }
    
    @Override
    public String toString() {
        return "";
    }
    

}
