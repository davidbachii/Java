package com.example.servlets;

import com.example.model.DatabaseManager;
import com.example.model.Entrada;
import com.example.model.Fecha;
import com.example.model.Sala;
import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.sql.SQLException;
import java.time.LocalTime;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Alejandro
 */
@WebServlet("/GestionButacas")
public class GestionButacas extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();

        Sala sala = (Sala) session.getAttribute("sala");
        // Obtener la cadena JSON de la solicitud
        String butacasSeleccionadasJSON = request.getParameter("butacasSeleccionadas");
        session.setAttribute("butacasSeleccionadas",butacasSeleccionadasJSON);
        response.sendRedirect(request.getContextPath() + "/confirmarReserva.jsp");

    }
}
