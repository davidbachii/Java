package patrones.universidad;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class PDI {

    private int _identificador;
    private String _departamento;
    private String _area;

    public PDI(int identificador, String departamento, String area) {
        _identificador = identificador;
        _departamento = departamento;
        _area = area;
    }

    public int getIdentificador() {
        return _identificador;
    }
   
    public String getDepartamento() {
        return _departamento;
    }

    public void setDepartamento(String _departamento) {
        this._departamento = _departamento;
    }

    public String getArea() {
        return _area;
    }

    public void setArea(String _area) {
        this._area = _area;
    }

    public void generarNomina() {
        System.out.println("Generada nómina de PDI " + _identificador);
    }

    public boolean modificar() throws IOException {
        BufferedReader _entrada = new BufferedReader(new InputStreamReader(System.in));
        String linea;

        System.out.println("Nuevo departamento:[" + _departamento + "]");
        linea = _entrada.readLine();
        if (linea.length() != 0) {
            _departamento = linea;
        }

        System.out.println("Nueva area:[" + _area + "]");
        linea = _entrada.readLine();
        if (linea.length() != 0) {
            _area = linea;
        }

        return true;
    }

    @Override
    public String toString() {
        return "PDI{" + "_identificador=" + _identificador + ", _departamento=" + _departamento + ", _area=" + _area + '}';
    }
}
