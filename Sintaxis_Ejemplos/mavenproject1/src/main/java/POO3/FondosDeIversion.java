/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package POO3;

import java.util.Date;
import java.util.List;

/**
 *
 * @author david
 */
public class FondosDeIversion {
    String nombreFondo;
    Date fechaSuscripcion;
    Date fechaReembolso;
    List<Activos> activos;

    public FondosDeIversion(String nombreFondo, Date fechaSuscripcion, Date fechaReembolso, List<Activos> activos) {
        this.nombreFondo = nombreFondo;
        this.fechaSuscripcion = fechaSuscripcion;
        this.fechaReembolso = fechaReembolso;
        this.activos = activos;
    }

    public String getNombreFondo() {
        return nombreFondo;
    }

    public void setNombreFondo(String nombreFondo) {
        this.nombreFondo = nombreFondo;
    }

    public Date getFechaSuscripcion() {
        return fechaSuscripcion;
    }

    public void setFechaSuscripcion(Date fechaSuscripcion) {
        this.fechaSuscripcion = fechaSuscripcion;
    }

    public Date getFechaReembolso() {
        return fechaReembolso;
    }

    public void setFechaReembolso(Date fechaReembolso) {
        this.fechaReembolso = fechaReembolso;
    }

    public List<Activos> getActivos() {
        return activos;
    }

    public void setActivos(List<Activos> activos) {
        this.activos = activos;
    }

    
    
    
    public double rentabilidadAcumulado(){
        
       double rentabilidadAcumulada = 0.0;
       
        for (Activos activo : activos) {
            double valorInicial = activo.getValorInicial();
            double valorFinal = activo.getValorFinal();
            rentabilidadAcumulada += ((valorFinal - valorInicial) / valorInicial) * 100;
        }

        return rentabilidadAcumulada;
        
    }
    
    
}
