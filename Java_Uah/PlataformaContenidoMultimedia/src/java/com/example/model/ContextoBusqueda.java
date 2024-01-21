/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.model;

/**
 *
 * @author david
 */
import java.sql.SQLException;
import java.util.List;

public class ContextoBusqueda {

    private EstrategiaBusqueda estrategia;

    public ContextoBusqueda(EstrategiaBusqueda estrategia) {
        this.estrategia = estrategia;
    }

    public List<Pelicula> buscarPeliculas(String parametro) throws SQLException {
        return estrategia.buscarPeliculas(parametro);
    }
}
