<%--
  Created by IntelliJ IDEA.
  User: david
  Date: 30/11/2023
  Time: 20:51
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<HTML>
<HEAD>
    <TITLE>Calculadora con Servlet</TITLE>
</HEAD>
<BODY BGCOLOR = "#E0FFE0" TEXT= "green" LINK="blue" VLINK="brown">
<CENTER>
    <HR style = "color:#325732; heigth:6px; width:500px">
    <FONT size = 5> CALCULADORA </FONT>
    <HR style = "color:green; heigth:6px; width:500px">
    <BR>
    <BR>
    <FORM action=/PL4_Servlets-1.0-SNAPSHOT/Calculadora method=POST>
        <TABLE border = "3" WIDTH = "400" >
            <TR>
                <TD aling = "rigth"> <INPUT name="operando1" type="text">
                </TD>
                <TD> <SELECT name="operacion">
                    <OPTION value= "1" selected >&nbsp;&nbsp;+
                        &nbsp;&nbsp;</OPTION>
                    <OPTION value= "2" >&nbsp;&nbsp; -
                        &nbsp;&nbsp;</OPTION>
                    <OPTION value= "3" >&nbsp;&nbsp; *
                        &nbsp;&nbsp;</OPTION>
                    <OPTION value= "4" >&nbsp;&nbsp; /
                        &nbsp;&nbsp;</OPTION>
                </SELECT>
                <TD aling = "rigth"> <INPUT name="operando2" type= "text">
                </TD>
            </TR>
        </TABLE>
        <BR>
        <BR>
        <input name="Calcular" value="Calcular" type="submit">
        &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
        <input name="limpiar" value="Limpiar" type="reset">
    </FORM>
</CENTER>
</BODY>
</HTML>
