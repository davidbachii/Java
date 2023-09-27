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
public class C_plazos extends Cuentas{
    
    int plazo; 

    public C_plazos(int plazo, String mumeroCuenta, LocalDate fecha_apertura, double saldo, double tipoInteres, Cliente cliente) {
        super(mumeroCuenta, fecha_apertura, saldo, tipoInteres, cliente);
        this.plazo = plazo;
    }

    public int getPlazo() {
        return plazo;
    }

    public void setPlazo(int plazo) {
        this.plazo = plazo;
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
