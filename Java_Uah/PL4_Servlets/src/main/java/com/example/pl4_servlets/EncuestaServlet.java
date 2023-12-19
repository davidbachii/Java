package com.example.pl4_servlets;

import jakarta.servlet.*;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;
import java.io.*;
import java.sql.*;


@WebServlet("/EncuestsS")
public class EncuestaServlet extends HttpServlet
{
    Statement mandato = null;
    Connection conexion = null;
    public void init(ServletConfig config) throws ServletException
    {
        try
        {
            conexion = DriverManager.getConnection ("jdbc:derby://localhost:1527/sample","app","app");
        mandato = conexion.createStatement();
        }
        catch (Exception e)
        {
            System.out.println("Problemas al conectar con la base de datos");
            throw new ServletException("Problemas al conectar con la base de datos", e);
        }
    }


    public void service( HttpServletRequest peticion, HttpServletResponse
            respuesta ) throws ServletException, IOException
    {
        /* creación del flujo de salida hacia el cliente */
        ServletOutputStream out = respuesta.getOutputStream();
        respuesta.setContentType("text/html");
        /* recuperamos los valores que nos manda el cliente */
        String strNombre = peticion.getParameter("NOMBRE");
        String strEmail = peticion.getParameter("EMAIL");
        String strRespuesta = peticion.getParameter("RESPUESTA");
        /* insertamos los datos en la base de datos */
        String sql = "INSERT INTO ENCUESTA (NOMBRE, EMAIL, RESPUESTA) VALUES (?, ?, ?)";
        try (PreparedStatement preparedStatement = conexion.prepareStatement(sql)) {
            preparedStatement.setString(1, strNombre);
            preparedStatement.setString(2, strEmail);
            preparedStatement.setString(3, strRespuesta);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Error al ejecutar la consulta SQL: " + e.getMessage());
            e.printStackTrace();
            return;
        }
        /* leemos todos los registros para crear la estadística */
        try
        {
            int intSI = 0;
            int intNO = 0;
            ResultSet resultado = mandato.executeQuery("SELECT RESPUESTA FROM ENCUESTA");
            while (resultado.next()) {
                String resp = resultado.getString("RESPUESTA").trim();  // Elimina espacios en blanco
                if ("SI".equalsIgnoreCase(resp)) {
                    intSI++;
                } else if ("NO".equalsIgnoreCase(resp)) {
                    intNO++;
                }
            }
            out.println("<h2><center>Encuesta Servlet</center></h2>");
            out.println("<BR>Gracias por participar en esta encuesta.");
            out.println("<BR>Los resultados hasta este momento son :");
            out.println("<BR> SI : "+intSI);
            out.println("<BR> NO : "+intNO);
        }
        catch(Exception e)
        {
            throw new ServletException("Problemas al conectar con la base de datos", e);


        }
    }
    public void destroy()
    {
        try
        {
            conexion.close();
        }
        catch(SQLException e)
        {
            System.out.println(e);

            return; } } }
