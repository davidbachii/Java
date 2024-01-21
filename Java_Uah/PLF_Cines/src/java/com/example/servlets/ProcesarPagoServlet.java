/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package com.example.servlets;

import com.example.model.DatabaseManager;
import com.example.model.Entrada;
import com.example.model.Fecha;
import com.example.model.Reserva;
import com.example.model.Sala;
import com.example.model.Usuario;
import jakarta.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.time.LocalTime;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;

@WebServlet("/ProcesarPagoServlet")
public class ProcesarPagoServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();

        try {
            // Obtener los parámetros del formulario
            String numeroTarjeta = request.getParameter("numeroTarjeta");
            String fechaExpiracion = request.getParameter("fechaExpiracion");
            Fecha fechaExp = new Fecha(fechaExpiracion);
            String codigoSeguridad = request.getParameter("codigoSeguridad");

            // Obtener la información del usuario de la sesión
            HttpSession session = request.getSession();
            Usuario usuarioActual = (Usuario) session.getAttribute("usuario");
            String emailUsuario = usuarioActual.getCorreo();
            // Validar la tarjeta en la base de datos
            if (DatabaseManager.getInstance().validarTarjeta(usuarioActual.getCorreo(), numeroTarjeta, fechaExp, codigoSeguridad)) {
                // Los datos de la tarjeta son válidos
                out.println("<h2>Pago Exitoso</h2>");

                String numRef = "";
                int numeroAleatorioRef = new Random().nextInt(90000000) + 100000000;
                numRef = "R" + Integer.toString(numeroAleatorioRef);// Crear una nueva entrada

                //CREACION DE RESERVA
                Sala sala = (Sala) session.getAttribute("sala");
                // Obtener la cadena JSON de la solicitud
                String butacasSeleccionadasJSON = (String) session.getAttribute("butacasSeleccionadas");

                // Eliminar corchetes y comillas para obtener pares clave-valor separados por comas
                String cleanString = butacasSeleccionadasJSON.replaceAll("[\\[\\]\\{\\}\" ]", "");

                System.out.println(cleanString);

                // Dividir la cadena en pares clave-valor
                String[] keyValuePairs = cleanString.split(",");
                
                //IdEntrada para la entradas seleccionadas por el mismo usuario.
                String idEntrada = "";
                int numeroAleatorio = new Random().nextInt(90000000) + 100000000;
                idEntrada = "E" + Integer.toString(numeroAleatorio);// Crear una nueva entrada

                // Obtener información adicional de la sesión
                String fechaStr = (String) session.getAttribute("fecha");
                Fecha fecha = new Fecha(fechaStr);

                String horaStr = (String) session.getAttribute("hora");
                LocalTime hora = LocalTime.parse(horaStr);

                int fila = 0;
                int columna = 0;

                String nombreSala = sala.getNombreSala();

                for (int i = 0; i < keyValuePairs.length; i += 2) {
                    // Obtener la fila y columna
                    //Extraemos la fila
                    String[] filaKC = keyValuePairs[i].split(":");
                    fila = Integer.parseInt(filaKC[1]);
                    //Extraemos la columna
                    String[] columnaKC = keyValuePairs[i + 1].split(":");
                    columna = Integer.parseInt(columnaKC[1]);

                    Entrada entrada = new Entrada(idEntrada, fecha, hora, fila, columna, nombreSala);

                    try {
                        // Guardar la entrada en la base de datos
                        DatabaseManager.getInstance().guardarEntrada(entrada);
                    } catch (SQLException ex) {
                        Logger.getLogger(GestionButacas.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
                Reserva reserva = new Reserva(numRef,emailUsuario, idEntrada,fila, columna);
                DatabaseManager.getInstance().guardarReserva(reserva);
            } else {
                // Los datos de la tarjeta no son válidos
                out.println("<h2>Error en el Pago: Datos de Tarjeta Incorrectos</h2>");
            }
        } catch (Exception e) {
            e.printStackTrace();
            out.println("<h2>Error en el Pago</h2>");
        }
    }

}
