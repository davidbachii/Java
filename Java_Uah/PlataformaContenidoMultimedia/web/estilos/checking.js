/* 
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/JavaScript.js to edit this template
 */
document.addEventListener('DOMContentLoaded', function () {
    document.getElementById('botonCrearPelicula').addEventListener('click', function (e) {
        //Cogeremos todos los datos del formulario
        var anho = parseInt(document.getElementById('anho').value, 10);
        var genero = document.getElementById('genero').value.toLowerCase();
        var nacionalidad = document.getElementById('nacionalidad').value;
        var clasificacionEdad = parseInt(document.getElementById('clasificacionEdad').value, 10);
        var duracion = parseInt(document.getElementById('duracion').value, 10);
        var listaGeneros = ['accion', 'animacion', 'aventura', 'ciencia ficcion', 'comedia', 'documental', 'drama', 'fantasia', 'historica', 'musical', 'romantica', 'suspense', 'terror'];
        var listaNacionalidades = ['Estadounidense', 'Española', 'Francesa', 'Inglesa', 'Alemana', 'Italiana', 'Japonesa', 'Canadiense', 'Australiana', 'Sudafricana', 'Brasileña', 'Argentina', 'Mexicana', 'India', 'China', 'Rusa', 'Sueca', 'Noruega', 'Coreana', 'Turca', 'Holandesa', 'Belga', 'Irlandesa', 'Portuguesa', 'Griega', 'Polaca', 'Checa', 'Húngara', 'Austriaca', 'Suiza', 'Danesa', 'Finlandesa', 'Islandesa', 'Noruega', 'Neozelandesa'];

        var listaClasificaciones = [0,3, 7, 12, 16, 18];
        // Una vez que todos los atributos estén seleccionados, haremos el checking de los mismos para ver si son validos
        // Verificar si el anno introducido esta entre 1980 y 2024
        if (anho < 1980 || anho > 2024) {
            document.getElementById('mensajeErrorAnho').textContent = 'Por favor, ingresa un anho entre 1980 y 2024';
            document.getElementById('mensajeErrorAnho').style.color = "red";
            e.preventDefault();
        } else {
            document.getElementById('mensajeErrorAnho').textContent = '';
        }
        //
        //Verificar que los generos introducidos son validos
        var generos = genero.split(',').map(g => g.trim());
        var generosInvalidos = generos.filter(g => !listaGeneros.includes(g));

        if (generosInvalidos.length > 0) {
            //Se verifica que no contiene el genero
            document.getElementById('mensajeErrorGenero').textContent = 'Por favor, ingresa generos validos. Los siguientes generos no son validos: ' + generosInvalidos.join(', ');
            document.getElementById('mensajeErrorGenero').style.color = "red";
            e.preventDefault();
        } else {
            document.getElementById('mensajeErrorGenero').textContent = '';
        }
        //Verificar si la nacionalidad introducida esta en la lista
        if (!listaNacionalidades.includes(nacionalidad)) {
            document.getElementById('mensajeErrorNacionalidad').textContent = 'Por favor, ingresa una nacionalidad valida';
            document.getElementById('mensajeErrorNacionalidad').style.color = "red";
            e.preventDefault();
        } else {
            document.getElementById('mensajeErrorNacionalidad').textContent = '';
        }
        //Verificar si la clasificacion de edad introducida esta en la lista
        if (!listaClasificaciones.includes(clasificacionEdad)) {
            document.getElementById('mensajeErrorClasificacionEdad').textContent = 'Por favor, ingresa una clasificacion de edad valida';
            document.getElementById('mensajeErrorClasificacionEdad').style.color = "red";
            e.preventDefault();
        } else {
            document.getElementById('mensajeErrorClasificacionEdad').textContent = '';
        }
        //Verificar si la duracion esta entre 0 y 773 minutos
        if (duracion < 0 || duracion > 773) {
            document.getElementById('mensajeErrorDuracion').textContent = 'Por favor, ingresa una duracion entre 0 y 773 minutos';
            document.getElementById('mensajeErrorDuracion').style.color = "red";
            e.preventDefault();
        } else {
            document.getElementById('mensajeErrorDuracion').textContent = '';
        }
    });


    document.getElementById('botonModificarPelicula').addEventListener('click', function (e) {
        //Cogeremos todos los datos del formulario
        var anho = parseInt(document.getElementById('nuevoAnho').value, 10);
        var genero = document.getElementById('nuevoGenero').value.toLowerCase();
        var nacionalidad = document.getElementById('nuevaNacionalidad').value;
        var clasificacionEdad = parseInt(document.getElementById('nuevaClasificacionEdad').value, 10);
        var duracion = parseInt(document.getElementById('nuevaDuracion').value, 10);
        var listaGeneros = ['accion', 'animacion', 'aventura', 'ciencia ficcion', 'comedia', 'documental', 'drama', 'fantasia', 'historica', 'musical', 'romantica', 'suspense', 'terror'];
        var listaNacionalidades = ['Espanola', 'Francesa', 'Inglesa', 'Americana', 'Turca', 'Italiana'];
        var listaClasificaciones = [0, 7, 12, 16, 18];
        // Una vez que todos los atributos estén seleccionados, haremos el checking de los mismos para ver si son validos
        // Verificar si el anno introducido esta entre 1980 y 2024
        if ((anho < 1980 || anho > 2024) || (anho === NaN)) {
            document.getElementById('mensajeErrorNuevoAnho').textContent = 'Por favor, ingresa un anho entre 1980 y 2024';
            document.getElementById('mensajeErrorNuevoAnho').style.color = "red";
            e.preventDefault();
        } else {
            document.getElementById('mensajeErrorNuevoAnho').textContent = '';
        }
        //
        //Verificar que los generos introducidos son validos
        var generos = genero.split(',').map(g => g.trim());
        var chequeo = false;

        generos.some(function (generoActual) {
            if (listaGeneros.includes(generoActual) || generoActual === "") {
                document.getElementById('mensajeErrorNuevoGenero').textContent = '';
                chequeo = true;
            } else {
                chequeo = false;
                return true; // Esto detendrá el bucle
            }
        });

        if (chequeo) {
            document.getElementById('mensajeErrorNuevoGenero').textContent = '';
        } else {
            document.getElementById('mensajeErrorNuevoGenero').textContent = 'Por favor, ingresa generos validos. Los siguientes generos no son validos: ' + generos.join(', ');
            document.getElementById('mensajeErrorNuevoGenero').style.color = "red";
            e.preventDefault();
        }
        //Verificar si la nacionalidad introducida esta en la lista
        if (!listaNacionalidades.includes(nacionalidad) && nacionalidad !== "") {
            document.getElementById('mensajeErrorNuevaNacionalidad').textContent = 'Por favor, ingresa una nacionalidad valida';
            document.getElementById('mensajeErrorNuevaNacionalidad').style.color = "red";
            e.preventDefault();
        } else {
            document.getElementById('mensajeErrorNuevaNacionalidad').textContent = '';
        }
        //Verificar si la clasificacion de edad introducida esta en la lista
        if ((!listaClasificaciones.includes(clasificacionEdad)) && !isNaN(clasificacionEdad)) {
            document.getElementById('mensajeErrorNuevaClasificacionEdad').textContent = 'Por favor, ingresa una clasificacion de edad valida';
            document.getElementById('mensajeErrorNuevaClasificacionEdad').style.color = "red";
            e.preventDefault();
        } else {
            document.getElementById('mensajeErrorNuevaClasificacionEdad').textContent = '';
        }
        //Verificar si la duracion esta entre 0 y 773 minutos
        if ((duracion < 0 || duracion > 773) || (duracion === NaN)) {
            document.getElementById('mensajeErrorNuevaDuracion').textContent = 'Por favor, ingresa una duracion entre 0 y 773 minutos';
            document.getElementById('mensajeErrorNuevaDuracion').style.color = "red";
            e.preventDefault();
        } else {
            document.getElementById('mensajeErrorNuevaDuracion').textContent = '';
        }
    });
});




