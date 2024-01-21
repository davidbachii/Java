<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="java.util.List" %>
<%@ page import="com.example.model.Sala" %>
<%@ page import="com.example.model.Entrada" %>
<%@ page import="com.example.model.DatabaseManager" %>
<%@ page import="com.example.model.Fecha" %>

<%@ page import="java.util.ArrayList" %>

<%
    List<Entrada> entradas = new ArrayList<>();
try {
    Sala salaSelec = (Sala) session.getAttribute("sala");
    String fechaStr = (String) session.getAttribute("fecha");
    Fecha fecha = new Fecha(fechaStr);

    entradas = DatabaseManager.getAllEntradas(); 

%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8">
        <title>Selección de Butacas</title>
        <script src="https://code.jquery.com/jquery-3.6.4.min.js"></script>
        <link rel='stylesheet' href='https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.14.0/css/all.min.css'>
        <link rel="stylesheet" href="estilos/butacas.css">
    </head>
    <body>
        <h2>Butacas para la Sala: <%= salaSelec.getNombreSala() %></h2>
        <form action="GestionButacas" method="post">
            <table style='border-collapse: collapse;'>
                <%
                for (int i = 0; i < salaSelec.getFilas(); i++) {
                %>
                <tr>
                    <%
                    for (int j = 0; j < salaSelec.getColumnas(); j++) {
                        int fila = i + 1;
                        int columna = j + 1;
                        boolean ocupadaPorOtroCliente = false;

                        // Verificar si la butaca está ocupada por otras entradas
                        for (Entrada entrada : entradas) {
                            if (entrada.getNombreSala().equals(salaSelec.getNombreSala()) &&
                                entrada.getFila() == fila &&
                                entrada.getColumna() == columna)
                                 {
                                ocupadaPorOtroCliente = true;
                                break;
                            }
                        }
                    %>
                    <td>
                        <%
                            if (!ocupadaPorOtroCliente) {
                                // Verificar si la butaca está libre u ocupada
                                boolean ocupada = false;  

                                if (ocupada) {
                                //Si esta ocupada , establecer imagen butaca_seleccionada
                        %>
                        <img class='butaca ocupada'
                             src='butacas/butaca_seleccionada.png'
                             alt='Butaca <%= fila %>-<%= columna %>'
                             data-fila='<%= fila %>' data-columna='<%= columna %>'>
                        <%
                        } else {
                       //Si esta libre , establecer imagen butaca_libre

                        %>
                        <img class='butaca'
                             src='butacas/butaca_libre.png'
                             alt='Butaca <%= fila %>-<%= columna %>'
                             data-fila='<%= fila %>' data-columna='<%= columna %>'>
                        <%
                        }
                    } else {
                    //Si esta ocupada previamente, establecer imagen butaca_ocupada
                        %>
                        <img class='butaca ocupadaPorClientes'
                             src='butacas/butaca_ocupada.png'
                             alt='Butaca <%= fila %>-<%= columna %>'
                             data-fila='<%= fila %>' data-columna='<%= columna %>'>
                        <%
                        }
                        %>

                    </td>
                    <%
                    }
                        }
                    %>
                </tr>

            </table>

            <!-- Campo oculto para almacenar butacas seleccionadas -->
            <input type="hidden" name="butacasSeleccionadas" id="butacasSeleccionadas">

            <button type="submit" name="comprarButacas">Comprar</button>
        </form>
        <script>
$(document).ready(function () {
    var butacasSeleccionadas = [];

    // Manejar el clic en una butaca
    $('.butaca').click(function () {
        var fila = $(this).data('fila');
        var columna = $(this).data('columna');

        // Verificar si la butaca está ocupada por otros clientes
        var ocupadaPorClientes = $(this).hasClass('ocupadaPorClientes');

        if (!ocupadaPorClientes) {
            // Verificar si la butaca está libre u ocupada
            var ocupada = $(this).hasClass('ocupada');

            if (!ocupada) {
                // Si la butaca está libre, cambiar a ocupada
                $(this).attr('src', 'butacas/butaca_seleccionada.png');
                $(this).addClass('ocupada');
                // Agregar la butaca a la lista de seleccionadas
                butacasSeleccionadas.push({fila: fila, columna: columna});
            } else {
                // Si la butaca está ocupada, cambiar a libre
                $(this).attr('src', 'butacas/butaca_libre.png');
                $(this).removeClass('ocupada');
                // Eliminar la butaca de la lista de seleccionadas
                butacasSeleccionadas = butacasSeleccionadas.filter(function (butaca) {
                    return butaca.fila !== fila || butaca.columna !== columna;
                });
            }
        }

        // Actualizar el campo oculto con las butacas seleccionadas
        $('#butacasSeleccionadas').val(JSON.stringify(butacasSeleccionadas));
    });
});
</script>
</body>
</html>
<%
} catch (Exception e) {
    e.printStackTrace();
}
%>