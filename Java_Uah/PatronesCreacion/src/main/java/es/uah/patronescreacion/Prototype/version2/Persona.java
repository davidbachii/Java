package es.uah.patronescreacion.Prototype.version2;

import java.util.ArrayList;

/**
 * Clase que representa a una persona. Implementa la interfaz Cloneable.
 */
public class Persona implements Cloneable {

    /**
     * DNI de la persona.
     */
    private String dni;
    /**
     * Nombre de la persona.
     */
    private String nombre;
    /**
     * Fecha de nacimiento de la persona.
     */
    private Fecha fechaNac;
    /**
     * Dirección de la persona.
     */
    private String direccion;
    /**
     * Lista de teléfonos de la persona.
     */
    private ArrayList tfnos;

    /**
     * Constructor.
     *
     * @param p_dni DNI de la persona.
     * @param p_nombre Nombre de la persona.
     * @param p_fecnac Fecha de nacimiento de la persona.
     * @param p_direccion Dirección de la persona.
     * @param p_tfnos Lista de teléfonos de la persona.
     */
    public Persona(String p_dni, String p_nombre, Fecha p_fecnac, String p_direccion, ArrayList p_tfnos) {
        dni = p_dni;
        nombre = p_nombre;
        fechaNac = p_fecnac;
        direccion = p_direccion;
        tfnos = p_tfnos;
    }
    //En esta ya no esta como en la version 1 nuestro segundo constructor
    /**
     * Devuelve el DNI de la persona.
     *
     * @return DNI de la persona.
     */
    public String getDni() {
        return this.dni;
    }

    /**
     * Establece el DNI de la persona.
     *
     * @param dni DNI de la persona.
     */
    public void setDni(String dni) {
        this.dni = dni;
    }

    /**
     * Devuelve el nombre de la persona.
     *
     * @return Nombre de la persona.
     */
    public String getNombre() {
        return this.nombre;
    }

    /**
     * Establece el nombre de la persona.
     *
     * @param nombre Nombre de la persona.
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * Devuelve la fecha de nacimiento de la persona.
     *
     * @return Fecha de nacimiento de la persona.
     */
    public Fecha getFechaNac() {
        return this.fechaNac;
    }

    /**
     * Establece la fecha de nacimiento de la persona.
     *
     * @param fechaNac Fecha de nacimiento de la persona.
     */
    public void setFechaNac(Fecha fechaNac) {
        this.fechaNac = fechaNac;
    }

    /**
     * Devuelve la dirección de la persona.
     *
     * @return Dirección de la persona.
     */
    public String getDireccion() {
        return this.direccion;
    }

    /**
     * Establece la dirección de la persona.
     *
     * @param direccion Dirección de la persona.
     */
    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    /**
     * Devuelve la lista de teléfonos de la persona.
     *
     * @return Lista de teléfonos de la persona.
     */
    public ArrayList getTfnos() {
        return this.tfnos;
    }

    /**
     * Establece la lista de teléfonos de la persona.
     *
     * @param tfnos Lista de teléfonos de la persona.
     */
    public void setTfnos(ArrayList tfnos) {
        this.tfnos = tfnos;
    }

    @Override
    public String toString() {
        // Nota: El código que se devuelve es el código hash del objeto. 
        // Si dos objetos tienen el mismo hash, quiere decir que son iguales.
        return "DNI: " + dni + " , Nombre: " + nombre + ", # codigo objeto Persona: " + this.hashCode();
    }

    /**
     * Copia profunda.
     *
     * @return Objeto clonado.
     */
    
    //Esto es lo que cambia lo proporciona el propio java, y es el mas facil vamos a usar este
    @Override
    public Object clone() {
        Persona otra = null;
        try {
            // Clona el objeto: copia superficial.
            otra = (Persona) super.clone();
            // Ahora hacemos copia profunda.
            otra.fechaNac = (Fecha) fechaNac.clone();
            otra.tfnos = (ArrayList) tfnos.clone();
        } catch (CloneNotSupportedException e) {
        }
        // Esta excepción no debería aparecer

        return otra;
    }
    
    
}
