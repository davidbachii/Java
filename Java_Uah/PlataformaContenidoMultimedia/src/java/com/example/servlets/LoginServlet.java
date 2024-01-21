/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package com.example.servlets;

import com.example.model.DatabaseManager;
import com.example.model.Usuario;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet("/AccederUsuario")
public class LoginServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String correo = request.getParameter("mail-2");
        String contrasena = request.getParameter("pswd-2");

        try {
            if (correo.equals("admin@gmail.com") && contrasena.equals("admin")) {
                // Usuario admin autenticado correctamente
                Usuario usuario = new Usuario("Admin", "Admin", contrasena, correo, null);
                HttpSession session = request.getSession();
                         session.setAttribute("usuario", usuario);
                response.sendRedirect("panelAdmin.jsp");

            } else {
                
                // Obtener el usuario por correo
                Usuario usuario = DatabaseManager.getInstance().getUsuarioPorCorreo(correo);
                System.out.println("He obtenido correctamente el usuario de la bbdd");

                if (usuario != null) {
                    if (usuario.getContraseña().equals(contrasena)) {
                        
                        
                         HttpSession session = request.getSession();
                         session.setAttribute("usuario", usuario);
                        // Usuario autenticado correctamente (no admin)
                        // Aquí puedes redirigir a una página de bienvenida o realizar otras acciones
                        //response.getWriter().println("Acceso autorizado. ¡Bienvenido, " + usuario.getNombre() + "!");
                        response.sendRedirect("index.jsp");

                    }else{
                        response.getWriter().println("Usuario y/o contraseña incorrectos.");
                    }
                } else {
                    // Usuario no encontrado o contraseña incorrecta
                    response.getWriter().println("No hay ningun usuario registrado en el sistema.");
                }
                
            }

        } catch (SQLException e) {
            e.printStackTrace();
            response.getWriter().println("Error al acceder.");
        }

    }
}

