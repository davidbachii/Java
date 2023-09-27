/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package POO3;

import java.time.LocalDate;
import java.util.Date;

/**
 *
 * @author david
 */
public class Cuentas {
    
    String mumeroCuenta;
    LocalDate fecha_apertura;
    double saldo;
    double tipoInteres;
    Cliente cliente;

    public Cuentas(String mumeroCuenta, LocalDate fecha_apertura, double saldo, double tipoInteres, Cliente cliente) {
        this.mumeroCuenta = mumeroCuenta;
        this.fecha_apertura = fecha_apertura;
        this.saldo = saldo;
        this.tipoInteres = tipoInteres;
        this.cliente = cliente;
    }

    public String getMumeroCuenta() {
        return mumeroCuenta;
    }

    public void setMumeroCuenta(String mumeroCuenta) {
        this.mumeroCuenta = mumeroCuenta;
    }

    public LocalDate getFecha_apertura() {
        return fecha_apertura;
    }

    public void setFecha_apertura(LocalDate fecha_apertura) {
        this.fecha_apertura = fecha_apertura;
    }

    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    public double getTipoInteres() {
        return tipoInteres;
    }

    public void setTipoInteres(double tipoInteres) {
        this.tipoInteres = tipoInteres;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

   
   
   
    
    
    
    
    
}
