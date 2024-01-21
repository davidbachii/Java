/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.model;

import java.time.LocalDate;
import java.util.NoSuchElementException;
import java.util.StringTokenizer;

/**
 *
 * @author david
 */
/**
 * Clase para manejar fechas (AAAA-MM-DD).
 */
public class Fecha implements Cloneable {

    private int año;
    private int mes;
    private int dia;

    /**
     * Constructor.
     *
     * @param cadenaFecha Fecha en formato AAAA-MM-DD
     */
    public Fecha(String cadenaFecha) {
        try {
            // Separamos los tokens que componen la fecha.
            StringTokenizer st = new StringTokenizer(cadenaFecha, "-");
            String aa = st.nextToken();
            String mm = st.nextToken();
            String dd = st.nextToken();
            // Convertimos los tokens en enteros y asignamos.
            this.año = Integer.parseInt(aa);
            this.mes = Integer.parseInt(mm);
            this.dia = Integer.parseInt(dd);
        } catch (NumberFormatException | NoSuchElementException e) {
            // Manejar la excepción (puede imprimir un mensaje o lanzar otra excepción según tu lógica)
            e.printStackTrace();
            System.out.println("La fecha no se ha creado correctamente");
        }
    }

    @Override
    public String toString() {
        return año + "-" + mes + "-" + dia;
    }

    public int getAño() {
        return año;
    }

    public int getMes() {
        return mes;
    }

    public int getDia() {
        return dia;
    }

   

     public LocalDate toLocalDate() {
        return LocalDate.of(año, mes, dia);
    }
}
