/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package POO3;

/**
 *
 * @author david
 */
public class Activos {
    
    String nombreActivo;
    double valorInicial;
    double valorFinal;

    public Activos(String nombreActivo, double valorInicial, double valorFinal) {
        this.nombreActivo = nombreActivo;
        this.valorInicial = valorInicial;
        this.valorFinal = valorFinal;
    }

    public String getNombreActivo() {
        return nombreActivo;
    }

    public void setNombreActivo(String nombreActivo) {
        this.nombreActivo = nombreActivo;
    }

    public double getValorInicial() {
        return valorInicial;
    }

    public void setValorInicial(double valorInicial) {
        this.valorInicial = valorInicial;
    }

    public double getValorFinal() {
        return valorFinal;
    }

    public void setValorFinal(double valorFinal) {
        this.valorFinal = valorFinal;
    }
    
    
   
    
    
}
