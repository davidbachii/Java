package com.example.pl4_servlets;

import java.io.*;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;


@WebServlet("/HolaMundoServlet")

public class HelloServlet extends HttpServlet
{
    public void doGet (HttpServletRequest req, HttpServletResponse res)
            throws ServletException, IOException
    {
        try (PrintWriter out = res.getWriter()) {
            out.println("<html>");
            out.println("<head><title>HolaMundoServlet</title></head>");
            out.println("<body>");
            out.println("<h1><center>Hola Mundo desde el servidor WEB</center></h1>");
            out.println("</body></html>");
        } catch (IOException e) {
            // Manejar la excepción si es necesario
            e.printStackTrace();
        }

    }
    public String getServletInfo()
    {
        return "Crea una página HTML que dice HolaMundo";
    }
}