/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.example.model;

/**
 *
 * @author david
 */
import java.sql.SQLException;
import java.util.List;

public interface EstrategiaBusqueda {

    List<Pelicula> buscarPeliculas(String parametro) throws SQLException;
}
