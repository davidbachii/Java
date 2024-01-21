/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.model;

/**
 *
 * @author david
 */
import java.util.StringTokenizer;

/**
 * Clase para adaptar fechas en formato de USA (AAAA-MM-DD) a fechas en formato
 * de España (DD/MM/AAAA)
 */
public class AdaptadorFecha implements Fecha {

    /**
     * Fecha en formato USA que se va a adaptar.
     */
    private FechaUS fus;

    /**
     * Constructor
     *
     * @param fus Fecha en formato USA.
     */
    public AdaptadorFecha(FechaUS fus) {
        this.fus = fus;
    }

    @Override
    public String toString() {
        StringTokenizer st = new StringTokenizer(fus.toString(), "-");
        String aa = st.nextToken();
        String mm = st.nextToken();
        String dd = st.nextToken();

        return dd + "/" + mm + "/" + aa;
    }

    @Override
    public int getAño() {
        return this.fus.getYear();
    }

    @Override
    public void setAño(int año) {
        this.fus.setYear(año);
    }

    @Override
    public int getDia() {
        return this.fus.getDay();
    }

    @Override
    public void setDia(int dia) {
        this.fus.setDay(dia);
    }

    @Override
    public int getMes() {
        return this.fus.getMonth();
    }

    @Override
    public void setMes(int mes) {
        this.fus.setMonth(mes);
    }
}
