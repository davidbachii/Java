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

public class EstrategiaBusquedaPorNacionalidad implements EstrategiaBusqueda {

    @Override
    public List<Pelicula> buscarPeliculas(String parametro) throws SQLException {
        return DatabaseManager.getPeliculasPorNacionalidad(parametro);
    }
}