package es.uah.banco.PO;

public class Persona {

    private String DNI;
    private String nombre;
    private String direccion;
    private long telefono;

    public Persona(String DNI, String nombre, String direccion, long telefono) {
        this.direccion = direccion;
        this.DNI = DNI;
        this.nombre = nombre;
        this.telefono = telefono;
    }

}
