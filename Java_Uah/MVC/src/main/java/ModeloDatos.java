

import java.util.*;
import java.sql.*;

public class ModeloDatos {
private Connection con;
private Statement set;
private ResultSet rs;

public void abrirConexion() {
String sURL="jdbc:odbc:mvc";
try
{
//Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
Class.forName( "org.apache.derby.jdbc.ClientDriver" );
//    con = DriverManager.getConnection(sURL,"","");
con=DriverManager.getConnection("jdbc:derby://localhost:1527/sample","app","app"); 
System.out.println("Se ha conectado");
}
catch(Exception e){
System.out.println("No se ha conectado");}
}


public boolean existeJugador(String nombre) {
boolean existe = false;
String cad;
try
{
set = con.createStatement();
rs = set.executeQuery("SELECT * FROM Jugadores");
while (rs.next())
{
cad = rs.getString("Nombre");
cad = cad.trim();
if (cad.compareTo(nombre.trim())==0)
existe = true;
}
rs.close();
set.close();
}catch(Exception e){
System.out.println("No lee de la tabla");
}
return(existe);
}


public void actualizarJugador(String nombre) {
try
{
set = con.createStatement();
set.executeUpdate(
"UPDATE Jugadores SET votos=votos+1 WHERE nombre " + " LIKE '%" + nombre + "%'");
rs.close();
set.close();
}catch(Exception e){
System.out.println("No modifica la tabla");
}
}


public void insertarJugador(String nombre) {
try {
set = con.createStatement();
set.executeUpdate("INSERT INTO Jugadores " + " (nombre,votos) VALUES ('" + nombre + "',1)");
rs.close();
set.close();
}catch(Exception e){
System.out.println("No inserta en la tabla");
}
}


public void cerrarConexion() {
try {
con.close();
} catch (Exception e){}
}


}