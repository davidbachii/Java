<%--
  Created by IntelliJ IDEA.
  User: david
  Date: 30/11/2023
  Time: 21:14
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Ejemplo Encuesta</title>
</head>
<body bgcolor=white>
<center><h2>Por favor rellene todos los datos</h2>
    <form action=”/PL4_Servlets-1.0-SNAPSHOT/EncuestsS” method=POST>
        <BR>Nombre:<BR>
        <BR>
        <input type=text name=NOMBRE>
        <BR>
        <BR>E-Mail:<BR>
        <BR>
        <input type=text name=EMAIL>
        <BR>
        <BR><B>Pregunta:</B>¿Piensas utilizar a los Servlets para los
        proyectos a partir de ahora?<BR>
        <BR>
        Sí<input type=radio name=RESPUESTA value=SI>
        No<input type=radio name=RESPUESTA value=NO>
        <BR><BR><input type=submit value=Enviar>
        <input type=reset value=Borrar>
    </form></center>
</body>
</html>