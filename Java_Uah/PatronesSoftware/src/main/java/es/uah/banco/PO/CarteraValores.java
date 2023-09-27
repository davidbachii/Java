package es.uah.banco.PO;

import java.util.ArrayList;

public class CarteraValores implements Rentabilidad {

    private String nombre;
    private ArrayList<Valor> valores;

    public CarteraValores(String nombre) {
        this.nombre = nombre;
        this.valores = new ArrayList<>();
    }

    @Override
    public double calculaRentabilidad() {
        double rentabilidad = 0;
        for (Valor valor : valores) {
            rentabilidad += valor.calculaRentabilidad();
        }
        return rentabilidad;
    }

    public void addValor(Valor v) {
        valores.add(v);
    }
}
