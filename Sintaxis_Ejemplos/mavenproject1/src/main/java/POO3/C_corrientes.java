/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package POO3;

import java.util.Date;

/**
 *
 * @author david
 */
public class C_corrientes extends Cuentas {
    
    TarjetaCredito tarjetaCredito;

    public C_corrientes(TarjetaCredito tarjetaCredito, String mumeroCuenta, Date fecha_apertura, double saldo, double tipoInteres, Cliente cliente) {
        super(mumeroCuenta, fecha_apertura, saldo, tipoInteres, cliente);
        this.tarjetaCredito = tarjetaCredito;
    }

    public TarjetaCredito getTarjetaCredito() {
        return tarjetaCredito;
    }

    public void setTarjetaCredito(TarjetaCredito tarjetaCredito) {
        this.tarjetaCredito = tarjetaCredito;
    }

    public String getMumeroCuenta() {
        return mumeroCuenta;
    }

    public void setMumeroCuenta(String mumeroCuenta) {
        this.mumeroCuenta = mumeroCuenta;
    }

    public Date getFecha_apertura() {
        return fecha_apertura;
    }

    public void setFecha_apertura(Date fecha_apertura) {
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
