/* Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package com.example.servlets;

import com.example.model.DatabaseManager;
import com.example.model.Sala;
import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Alejandro
 */
@WebServlet(name = "Reservas", urlPatterns = {"/Reservas"})
public class Reservas extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession();

        // Obtener los parámetros del formulario
        String peliculaId = request.getParameter("peliculaSeleccionada");
        String fecha = request.getParameter("fecha");
        String hora = request.getParameter("hora");

        String sala = request.getParameter("salaSeleccionada");
        System.out.println(sala);
        try {
            Sala salaSelec = DatabaseManager.getInstance().getSalaPorNombre(sala);
            System.out.println(salaSelec.getNombreSala() + "EN EL SERVLET");
            // Almacenar los datos en la sesión
            session.setAttribute("peliculaId", peliculaId);
            session.setAttribute("hora", hora);
            session.setAttribute("fecha", fecha);
            session.setAttribute("sala", salaSelec);
            // Redireccionar a butacas.jsp
           
            response.sendRedirect(request.getContextPath() + "/butacas.jsp");
        } catch (SQLException ex) {
            Logger.getLogger(Reservas.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

}
