package es.uah.patronesfundamentales.DelegationInt;

import java.util.ArrayList;

/**
 * Clase que representa al personal de la universidad, ya sea profesor, alumno o
 * ambas cosas a la vez
 */
public class PersonalUniversitario {

    /**
     * DNI de la persona.
     */
    private String dni;
    /**
     * Nombre de la persona.
     */
    private String nombre;
    /**
     * Dirección de la persona.
     */
    private String direccion;
    /**
     * Lista de roles que identifica las funciones que desempeña el personal en
     * la universidad.
     */
    private ArrayList<Descripcion> roles; //Con esto podemos acceder a todos los metodos describir ya sea de profesor o de estudiante ya que
    //esta clase va de personal universitario y no sabemos su es profesor o estudiante

    /**
     * Constructor
     *
     * @param dni DNI de la persona.
     * @param nombre Nombre de la persona.
     * @param direccion Dirección de la persona.
     */
    public PersonalUniversitario(String dni, String nombre, String direccion) {
        this.dni = dni;
        this.nombre = nombre;
        this.direccion = direccion;
        this.roles = new ArrayList<>();
    }

    /**
     * Devuelve el DNI de la persona.
     *
     * @return DNI de la persona.
     */
    public String getDni() {
        return dni;
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
        return nombre;
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
     * Devuelve la dirección de la persona.
     *
     * @return Dirección de la persona.
     */
    public String getDireccion() {
        return direccion;
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
     * Devielve la lista de roles de una persona.
     *
     * @return Lista de roles de una persona.
     */
    public ArrayList getRoles() {
        return roles;
    }

    /**
     * Establece la lista de roles de una persona.
     *
     * @param roles Lista de roles de una persona.
     */
    public void setRoles(ArrayList roles) {
        this.roles = roles;
    }

    /**
     * Añade un nuevo rol a la persona.
     *
     * @param rol Rol de la persona.
     */
    public void setRol(Descripcion rol) {
        this.roles.add(rol);
    }

    /**
     * Elimina un rol de la persona.
     *
     * @param rol Rol de la persona.
     */
    public void borraRol(Descripcion rol) {
        this.roles.remove(rol);
    }

    /**
     * Devuelve la descripción de una persona con sus roles.
     *
     * @return Cadena con la descripción de la persona.
     */
    public String descripcion() {
        String desc = this.dni + " - " + this.nombre + " - " + this.direccion + "\n";
        for (Descripcion role : roles) {
            desc += role.descripcion() + "\n"; //Delegación
        }
        return desc;
    }
}
