<%-- 
    Document   : index
    Created on : 21 dic 2023, 14:13:23
    Author     : david
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en" >
<head>
  <meta charset="UTF-8">
  <title>Formulario</title>
  <link rel='stylesheet' href='https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.14.0/css/all.min.css'><link rel="stylesheet" href="./Estilos/login.css">

</head>
<body>

<div class="container" id="container">
	<div class="form-container sign-up-container">
		<form action="CrearUsuario" method="post">
			<h1>Crear Cuenta</h1>
			<div class="social-container">
				<a href="#" class="social"><i class="fab fa-facebook-f"></i></a>
				<a href="#" class="social"><i class="fab fa-google-plus-g"></i></a>
				<a href="#" class="social"><i class="fab fa-linkedin-in"></i></a>
			</div>
			<span>o usa su correo electronico para registrarte</span>
			<input type="text" placeholder="Nombre" id="Name" name="Name"/>
			<span id="error-nombre" class="error"></span>
			<input type="email" placeholder="Correo electronico" id="mail" name="mail"/>
			<span id="error-email" class="error"></span>
			<input type="password" placeholder="Contraseña" id="pswd" name="pswd"/>
			<span id="error-contrasena" class="error"></span>
			<input type="date" placeholder="Fecha-nacimiento" id="Fecha-nacimiento" name="Fecha-nacimiento"/>
			<span id="error-fecha" class="error"></span>
			<button  type="submit" id="Registrar">Registrar</button>
		</form>
	</div>
	<div class="form-container sign-in-container">
		<form action="AccederUsuario" method="post">
			<h1>Cinesa</h1>
			<div class="social-container">
				<a href="#" class="social"><i class="fab fa-facebook-f"></i></a>
				<a href="#" class="social"><i class="fab fa-google-plus-g"></i></a>
				<a href="#" class="social"><i class="fab fa-linkedin-in"></i></a>
			</div>
			<span>o usa tu cuenta</span>
			<input type="email" placeholder="Correo electronico"  id = "mail-2" name="mail-2"/>
			<span id="error-email-acceso" class="error"></span>
			<input type="password" placeholder="Contrasena" id = "pswd-2" name="pswd-2"/>
			<span id="error-contrasena-acceso" class="error"></span>
			<a href="#">¿Olvidaste tu contrasena?</a>
			<button type="submit" id="Acceder">Acceder</button>
		</form>
	</div>
	<div class="overlay-container">
		<div class="overlay">
			<div class="overlay-panel overlay-left">
				<h1>¡Bienvenido/a de nuevo!</h1>
				<p>Para seguir conectado con nosotros, introduce tus datos</p>
				<button class="ghost" id="signIn">Acceder</button>
			</div>
			<div class="overlay-panel overlay-right">
				<h1>¡Hola, amigo!</h1>
				<p>Introduce tus datos y registrate en Cinesa</p>
				<button class="ghost" id="signUp">Registrarse</button>
			</div>
		</div>
	</div>
</div>
    <script src="./login.js"></script>


</body>
</html>

