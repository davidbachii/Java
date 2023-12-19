
import java.io.*;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import java.util.*;
import java.sql.*;


public class ACB extends HttpServlet {
private ModeloDatos bd;


public void init(ServletConfig cfg) throws ServletException
{
bd=new ModeloDatos();
bd.abrirConexion();
}


public void service(HttpServletRequest req,
HttpServletResponse res) throws ServletException, IOException
{
HttpSession s = req.getSession(true);
String nombreP=(String)req.getParameter("txtNombre");
String nombre=(String)req.getParameter("R1");
if (nombre.equals("Otros")) nombre=(String)req.getParameter("txtOtros");
if (bd.existeJugador(nombre)){
bd.actualizarJugador(nombre);
}
else
bd.insertarJugador(nombre);
s.setAttribute("nombreCliente", nombreP);
// Llamada a la página jsp que nos da las gracias
res.sendRedirect(res.encodeRedirectURL("/demo-1.0-SNAPSHOT/TablaVotos.jsp"));
}


public void destroy()
{
bd.cerrarConexion();
super.destroy();
}
}