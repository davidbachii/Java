package es.uah.banco.PO;

public class Empleado extends Persona {

    private Sucursal sucursal;

    public Empleado(String DNI, String nombre, String direccion, long telefono, Sucursal sucursal) {
        super(DNI, nombre, direccion, telefono);
        this.sucursal = sucursal;
    }

}
