package com.example.pl4_servlets;

import java.io.*;
import jakarta.servlet.*;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;

@WebServlet("/Calculadora")
public class CalculadoraServlet extends HttpServlet
{
    public void service (HttpServletRequest req, HttpServletResponse
            res) throws ServletException, IOException
    {
        double op1, op2, result;
        int operacion;
        String simb_op[] = {"+", "-", "*","/"};
        ServletOutputStream out = res.getOutputStream();
        op1 = Double.parseDouble(req.getParameter("operando1"));
        op2 = Double.parseDouble(req.getParameter("operando2"));
        operacion = Integer.parseInt(req.getParameter("operacion"));
        result = calcula(op1, op2, operacion);
        out.println("<html>");
        out.println("<head><title>Resultado de calcular con Servlet</title></head>");
        out.println("<body BGCOLOR = \"#E0E0FF\" TEXT= \"blue\">");
        out.println("<h1><center>La operacion efectuada es:</center></h1>");
        out.println("<h2> <b><center>"+ op1+" "+ simb_op[operacion-1] +
                " "+ op2 + " = "+ result + "</center></b></h2>");
        out.println("</body>");
        out.println("</html>");
        out.close();
    }
    public double calcula(double op1, double op2, int operacion)
    {
        double result = 0;
        switch (operacion)
        {
            case 1:
                return op1 + op2;
            case 2:
                return op1 - op2;
            case 3:
                return op1 * op2;
            case 4:
                return op1 / op2;
        }
        return result;
    }
}