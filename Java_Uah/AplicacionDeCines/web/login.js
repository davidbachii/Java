/* 
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/JavaScript.js to edit this template
 */

document.addEventListener('DOMContentLoaded', function() {
    document.getElementById('Registrar').addEventListener('click', function(e) {
        var nombre = document.getElementById('Name').value;
        var emailRegistro = document.getElementById('mail').value;
        var contrasena = document.getElementById('pswd').value;
        var fechaNacimiento = document.getElementById('Fecha-nacimiento').value;
        var emailPattern = /^[^\s@]+@[^\s@]+\.[^\s@]+$/;
        var fechaPattern = /^\d{4}-\d{2}-\d{2}$/; // Define un patrón de fecha (AAAA-MM-DD)

        // Verificar si el nombre está lleno
        if (nombre.trim() === '') {
            document.getElementById('error-nombre').textContent = 'Por favor, ingresa tu nombre';
            e.preventDefault();
        } else {
            document.getElementById('error-nombre').textContent = '';
        }

        // Verificar si el correo electrónico de registro es válido
        if (!emailRegistro.match(emailPattern)) {
            document.getElementById('error-email').textContent = 'Por favor, ingresa un correo electrónico válido';
            e.preventDefault();
        } else {
            document.getElementById('error-email').textContent = '';
        }

        // Verificar si la contraseña está lleno
        if (contrasena.trim() === '') {
            document.getElementById('error-contrasena').textContent = 'Por favor, ingresa una contraseña';
            e.preventDefault();
        } else {
            document.getElementById('error-contrasena').textContent = '';
        }

        // Verificar si la fecha cumple con el formato esperado
        if (!fechaNacimiento.match(fechaPattern)) {
            document.getElementById('error-fecha').textContent = 'Por favor, ingresa una fecha válida en el formato DD-MM-AAAA';
            e.preventDefault();
        } else {
            document.getElementById('error-fecha').textContent = '';
        }
    });

    document.getElementById('Acceder').addEventListener('click', function(e) {
        var emailAcceso = document.getElementById('mail-2').value;
        var contrasena = document.getElementById('pswd-2').value;
        var emailPattern = /^[^\s@]+@[^\s@]+\.[^\s@]+$/;

        // Verificar si el correo electrónico de acceso es válido
        if (!emailAcceso.match(emailPattern)) {
            document.getElementById('error-email-acceso').textContent = 'Por favor, ingresa un correo electrónico válido';
            e.preventDefault();
        } else {
            document.getElementById('error-email-acceso').textContent = '';
        }

        // Verificar si la contraseña está lleno
        if (contrasena.trim() === '') {
            document.getElementById('error-contrasena-acceso').textContent = 'Por favor, ingresa una contraseña';
            e.preventDefault();
        } else {
            document.getElementById('error-contrasena-acceso').textContent = '';
        }
    });

    document.getElementById('signIn').addEventListener('click', function() {
        document.getElementById('container').classList.remove('right-panel-active');
    });

    document.getElementById('signUp').addEventListener('click', function() {
        document.getElementById('container').classList.add('right-panel-active');
    });
});


