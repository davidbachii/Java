package es.uah.banco.PO;

import java.util.ArrayList;

public class Banco {

    private String CIF;
    private String nombre;
    private ArrayList<Sucursal> sucursales;

    public Banco(String CIF, String nombre) {
        this.CIF = CIF;
        this.nombre = nombre;
        this.sucursales = new ArrayList<>();
    }

}
