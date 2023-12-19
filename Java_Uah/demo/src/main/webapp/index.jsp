<!--
Document : index.html

Author : Roberto Barchino
-->
<html>
<head>
    <title>Votacion mejor jugador liga ACB</title>
</head>
<body>
<center><H1>Votacion al mejor jugador de la liga ACB</H1></center><hr>
<form action="/demo-1.0-SNAPSHOT/Acb" method="POST">
    <p align="left">Nombre del Visitante: <input type="text" size="20"
                                                 name="txtNombre">
        eMail: <input type="text" size="20" name="txtMail"></p> REAL MADRID:<br>

    <img src="S_Rodriguez.jpg" width="100" height="67" alt="equipo1"/>
    <p align="left"><input type="radio" name="R1" value="Rodriguez">Sergio Rodriguez</p>

    <img src="Carroll.jpg" width="100" height="67" alt="equipo1"/>
    <p align="left"><input type="radio" name="R1" value="Carroll">Carroll</p>

    <img src="Llull.jpg" width="100" height="67" alt="equipo1"/>
    <p align="left"><input type="radio" name="R1" value="Llull">Llull</p>

    <img src="Rudy.jpg" width="100" height="67" alt="equipo1"/>
    <p align="left"><input type="radio" name="R1" value="Rudy">Rudy</p>

    <br>
    <p align="left"><input type="radio" name="R1" value="Otros">Otro
        <input type="text" size="20" name="txtOtros"></p>
    <p align="left">
        <input type="submit" name="B1" value="Votar">
        <input type="reset" name="B2" value="Reset"></p>
</form>
</body>
</html>