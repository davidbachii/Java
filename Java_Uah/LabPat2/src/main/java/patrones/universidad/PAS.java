package patrones.universidad;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class PAS {

    private int _identificador;
    private String _seccion;
    private String _cargo;

    public PAS(int identificador, String seccion, String cargo) {
        _identificador = identificador;
        _seccion = seccion;
        _cargo = cargo;
    }

    public int getIdentificador() {
        return _identificador;
    }

    public String getSeccion() {
        return _seccion;
    }

    public void setSeccion(String _seccion) {
        this._seccion = _seccion;
    }

    public String getCargo() {
        return _cargo;
    }

    public void setCargo(String _cargo) {
        this._cargo = _cargo;
    }   

    public void generarNomina() {
        System.out.println("Generada nómina de PAS " + _identificador);
    }

    public boolean modificar() throws IOException {        
        BufferedReader _entrada = new BufferedReader(new InputStreamReader(System.in));
        String linea;        

        System.out.println("Nueva seccion:[" + _seccion + "]");
        linea = _entrada.readLine();
        if (linea.length() != 0) {
            _seccion = linea;
        }

        System.out.println("Nuevo cargo:[" + _cargo + "]");
        linea = _entrada.readLine();
        if (linea.length() != 0) {
            _cargo = linea;
        }

        return true;
    }

    @Override
    public String toString() {
        return "PAS{" + "_identificador=" + _identificador + ", _seccion=" + _seccion + ", _cargo=" + _cargo + '}';
    }   
}
