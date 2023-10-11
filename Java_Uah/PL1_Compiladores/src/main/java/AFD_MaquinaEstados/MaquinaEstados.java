/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AFD_MaquinaEstados;

/**
 *
 * @author david
 */
public class MaquinaEstados {
    
    private int estadoActual;
    private AFD automata;

    public MaquinaEstados(AFD automata) {
        
        this.automata = automata;
        inicializar();
    }
    
    
    
    public void inicializar(){
        estadoActual = automata.getEstadoInicial();
    }
    
    
    public void acepta(Character c){
        int estTemporal = -1; //Creamos un estado temporal con un valor que no concida con los valores que hemos creado
        try{
            estTemporal = automata.getSigienteEstado(estadoActual, c);
        }catch(NullPointerException npe){
            npe.toString();   
        }
         estadoActual= estTemporal;
        
    }
    
    public boolean isFinal(){
        return automata.isFinal(estadoActual);
    }
    
    
    public boolean compruebaCadena(String cadena){
        inicializar();
        boolean esValida= true;
        if(cadena.length()==0){
            esValida = false;
        }else{
            for(int i=0;i< cadena.length();i++){
                acepta(cadena.charAt(i));
                if(estadoActual == -1 || (this.isFinal()==false && i==cadena.length())){ //Si no estoy en el estado final y se han leido todos los caracteres
                    esValida = false;
                    break;
                }
            
            }
        }
        return esValida;
    }
    
}
