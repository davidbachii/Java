<%-- 
    Document   : index.jsp
    Created on : 29 dic 2023, 13:54:32
    Author     : david
--%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ page import="java.util.List" %>
<%@ page import="java.time.LocalDate" %>
<%@ page import="com.example.model.Entrada" %>
<%@ page import="com.example.model.Sala" %>
<%@ page import="com.example.model.Pelicula" %>
<%@ page import="com.example.model.DatabaseManager" %>
<%@ page import="java.util.ArrayList" %>


<!DOCTYPE html>
<html lang="en" dir="ltr">
    <head>




        <script async src="https://www.googletagmanager.com/gtag/js?id=UA-155274620-1"></script>
        <script>
            window.dataLayer = window.dataLayer || [];
            function gtag() {
                dataLayer.push(arguments);
            }
            gtag('js', new Date());

            gtag('config', 'UA-155274620-1');
        </script>

        <title>Web oficial</title>
       
        <meta charset="utf-8">
        

        <!-- Fav and touch icons -->
        <link rel="shortcut icon" href="/static/ico/favicon.png">
        <link rel="apple-touch-icon" sizes="57x57" href="/static/ico/apple-icon-57x57.png">
        <link rel="apple-touch-icon" sizes="60x60" href="/static/ico/apple-icon-60x60.png">
        <link rel="apple-touch-icon" sizes="72x72" href="/static/ico/apple-icon-72x72.png">
        <link rel="apple-touch-icon" sizes="76x76" href="/static/ico/apple-icon-76x76.png">
        <link rel="apple-touch-icon" sizes="114x114" href="/static/ico/apple-icon-114x114.png">
        <link rel="apple-touch-icon" sizes="120x120" href="/static/ico/apple-icon-120x120.png">
        <link rel="apple-touch-icon" sizes="144x144" href="/static/ico/apple-icon-144x144.png">
        <link rel="apple-touch-icon" sizes="152x152" href="/static/ico/apple-icon-152x152.png">
        <link rel="apple-touch-icon" sizes="180x180" href="/static/ico/apple-icon-180x180.png">
        <link rel="icon" type="image/png" sizes="192x192"  href="/static/ico/android-icon-192x192.png">
        <link rel="icon" type="image/png" sizes="32x32" href="/static/ico/favicon-32x32.png">
        <link rel="icon" type="image/png" sizes="96x96" href="/static/ico/favicon-96x96.png">
        <link rel="icon" type="image/png" sizes="16x16" href="/static/ico/favicon-16x16.png">
        <link rel="manifest" href="/static/ico/manifest.json">

        <!-- Bootstrap core CSS -->

        <link href="estilos/bootstrap.css" rel="stylesheet">
        <link href="estilos/style.css" rel="stylesheet">
        <!-- styles needed for carousel slider -->
        <link href="estilos/owl.carousel.css" rel="stylesheet">

        <link href="estilos/fontawesome.min.css" rel="stylesheet"/>

        <link href="estilos/multicines.css" rel="stylesheet" />


        <!-- include pace script for automatic web page progress bar  -->
        <script>
            paceOptions = {
                elements: true
            };
        </script>



        <script type="application/ld+json">
            {"@context": "https://schema.org", "@type": "ItemList", "itemListElement": [{"@type": "ListItem", "position": 1, "url": "https://www.multicinesguadalajara.com/pelicula/yo-capitan/"}, {"@type": "ListItem", "position": 2, "url": "https://www.multicinesguadalajara.com/pelicula/agente-x-ultima-mision/"}, {"@type": "ListItem", "position": 3, "url": "https://www.multicinesguadalajara.com/pelicula/acusado/"}, {"@type": "ListItem", "position": 4, "url": "https://www.multicinesguadalajara.com/pelicula/los-que-se-quedan/"}, {"@type": "ListItem", "position": 5, "url": "https://www.multicinesguadalajara.com/pelicula/kina-y-yuk/"}, {"@type": "ListItem", "position": 6, "url": "https://www.multicinesguadalajara.com/pelicula/el-peor-equipo-del-mundo/"}, {"@type": "ListItem", "position": 7, "url": "https://www.multicinesguadalajara.com/pelicula/fallen-leaves/"}, {"@type": "ListItem", "position": 8, "url": "https://www.multicinesguadalajara.com/pelicula/migracion-un-viaje-patas-arriba/"}, {"@type": "ListItem", "position": 9, "url": "https://www.multicinesguadalajara.com/pelicula/aquaman-y-el-reino-perdido/"}, {"@type": "ListItem", "position": 10, "url": "https://www.multicinesguadalajara.com/pelicula/a-fuego-lento/"}, {"@type": "ListItem", "position": 11, "url": "https://www.multicinesguadalajara.com/pelicula/el-libro-de-las-soluciones/"}, {"@type": "ListItem", "position": 12, "url": "https://www.multicinesguadalajara.com/pelicula/camino-a-belen/"}, {"@type": "ListItem", "position": 13, "url": "https://www.multicinesguadalajara.com/pelicula/la-sombra-de-caravaggio/"}, {"@type": "ListItem", "position": 14, "url": "https://www.multicinesguadalajara.com/pelicula/la-sociedad-de-la-nieve/"}, {"@type": "ListItem", "position": 15, "url": "https://www.multicinesguadalajara.com/pelicula/wonka/"}, {"@type": "ListItem", "position": 16, "url": "https://www.multicinesguadalajara.com/pelicula/anatomia-de-una-caida/"}, {"@type": "ListItem", "position": 17, "url": "https://www.multicinesguadalajara.com/pelicula/ocho-apellidos-marroquis/"}, {"@type": "ListItem", "position": 18, "url": "https://www.multicinesguadalajara.com/pelicula/la-navidad-en-sus-manos/"}, {"@type": "ListItem", "position": 19, "url": "https://www.multicinesguadalajara.com/pelicula/wish-el-poder-de-los-deseos/"}, {"@type": "ListItem", "position": 20, "url": "https://www.multicinesguadalajara.com/pelicula/napoleon/"}, {"@type": "ListItem", "position": 21, "url": "https://www.multicinesguadalajara.com/pelicula/los-juegos-del-hambre-balada-de-pajaros-cantores-y-serpientes/"}, {"@type": "ListItem", "position": 22, "url": "https://www.multicinesguadalajara.com/pelicula/el-maestro-que-prometio-el-mar/"}]}
        </script>

    </head>
    <body>
        <div id="wrapper" class="d-flex flex-column">
            <div class="header">
                <nav class="navbar fixed-top navbar-site navbar-light bg-light navbar-expand-lg" role="navigation" >
                    <div class="container">
                        <div class="navbar-identity">
                            
                            <button data-target=".navbar-collapse" data-toggle="collapse" class="navbar-toggler pull-right" type="button">
                                <svg xmlns="https://www.w3.org/2000/svg" viewbox="0 0 30 30" width="30" height="30" focusable="false"><title>Menu</title><path stroke="currentColor" stroke-width="2" stroke-linecap="round" stroke-miterlimit="10" d="M4 7h22M4 15h22M4 23h22"/></svg>
                            </button>
                        </div>
                        <div class="navbar-collapse collapse" style="height: auto;">
                            <ul class="nav navbar-nav ml-auto navbar-right">
                                <li class="nav-item"><a href="index.jsp" class="nav-link">VOLVER AL MENU DE PELICULAS</a></li>
                                <li class="nav-item"><a href="login.jsp" class="nav-link">REGISTRARSE</a></li>
                                <li class="nav-item"><a href="#" class="nav-link">ALQUILER DE SALAS</a></li>
                                <li class="nav-item"><a href="#" class="nav-link">PRECIOS</a></li>
                                <li class="nav-item"><a href="#" class="nav-link">PROMOCIONES</a></li>
                                <li class="nav-item"><a href="#" class="nav-link">MERCHANDISING</a></li>
                                <li class="nav-item"><a href="#" class="nav-link">CONTACTO</a></li>
                            </ul>
                        </div>
                        <!--/.nav-collapse -->
                    </div>
                    <!-- /.container-fluid -->
                </nav>
            </div>
            <!-- /.header -->
            <div class="main-container inner-page flex-fill " style="padding-top: 30px !important;
                 ">
                <div class="container">





                    <div class="white-box">
                        <h3 class="titulo-cine">ELIGE LA PELICULA</h3>
                        <div class="row">

                            <%  // Llamamos al metodo getAllPeliculas para iterar sobre todas las peliculas
                                List<Pelicula> listaPeliculas = DatabaseManager.getInstance().getAllPeliculas(); %>

                            <% for(Pelicula pelicula : listaPeliculas){ %>
                            <div class="col-6 col-sm-4 col-md-3 col-xl-2dot4 mb20">
                                <div class="card card-event info-overlay">
                                    <div class="img has-background">

                                        <a href="indexDetallado.jsp?id=<%= pelicula.getNombre() %>" class="event-pop-link">
                                            <div class="event-pop-info">
                                                <p class="price" style="font-size:1.1em; padding: 5px;"><button type="submit" style="background: none; border: none; padding: 0; color: inherit; cursor: pointer;"><%= pelicula.getNombre() %></button></p>
                                                <span style="font-size: 0.90em; background-color: #53234f;" class="badge badge-primary">VER FICHA Y PASES</span><br /><br />
                                            </div>
                                        </a>

                                        <a href="indexDetallado.jsp?id=<%= pelicula.getNombre() %>"><img class="img-responsive" src="<%= pelicula.getUrl_image() %>" /></a>
                                        </form>
                                    </div>
                                </div>
                            </div>
                            <% } %>
                        </div>






                    </div>
                </div>
                <!-- /.main-container -->


            </div>
            <!-- /.wrapper -->






            <script src="/static/plantilla_bootstrap/assets/js/jquery/jquery-3.3.1.min.js"></script>
            <script src="/static/js/script.js"></script>
            <script src="/static/plantilla_bootstrap/assets/js/pace.min.js"></script>
            <script src="/static/plantilla_bootstrap/assets/plugins/modernizr/modernizr-custom.js"></script>
            <script src="/static/plantilla_bootstrap/assets/plugins/sweetalert/sweetalert2.all.min.js"></script>
            <script src="/static/plantilla_bootstrap/assets/bootstrap/js/bootstrap.bundle.js"></script>
            <script src="/static/plantilla_bootstrap/assets/js/vendors.min.js"></script>
            <script src="/static/plantilla_bootstrap/assets/plugins/ekko-lightbox/5.3.0/ekko-lightbox.min.js"></script>
            <script src="/static/plantilla_bootstrap/assets/plugins/responsive-cookie/cookies-message.js"></script>


            <script>
            /* Politica de cookies */
            $.CookiesMessage(
                    {
                        messageText: 'Para garantizarte una navegación por nuestra web segura y de calidad, te informamos que utilizamos Cookies. Puedes aceptar todas las cookies pulsando el botón “Aceptar y seguir navegando”. Puedes bloquear o eliminar las cookies instaladas en su equipo mediante la configuración de las opciones del navegador. Para más información consulte nuestra <b><a href="/politica-de-cookies/">Política de cookies</a></b>',
                        messageBg: "#fff", // Message box background color
                        messageColor: "#53234f", // Message box text color
                        messageLinkColor: "#53234f", // Message box links color
                        closeEnable: false,
                        acceptEnable: true, // Show the Accept button
                        acceptText: "ACEPTAR Y SEGUIR NAVEGANDO", // Accept button text
                        infoEnable: false, // Show the More Info button
                        infoText: "Más información", // More Info button text
                        infoUrl: "#", // More Info button URL
                        cookieExpire: 180										// Cookie expire time (days)
                    }
            );


            /* Bannners */








            /* End banners */

            $(document).on('click', '[data-toggle="lightbox"]', function (event) {
                event.preventDefault();
                $(this).ekkoLightbox();

                $('body').on('click', '.ekko-lightbox', function () {
                    if (lightbox_close_auto == null) {
                        $(this).modal('hide')
                    }
                })
            });

            $(document).ready(function () {







            })

            </script>




            <script>
                $(document).ready(function () {
                    $('.bxslider').bxSlider({
                        mode: 'horizontal',
                        touchEnabled: false,
                        speed: 500,
                        auto: true,
                        pause: 6000,
                        autoHover: true,
                        onSliderLoad: function () {
                            $("#siteslides").css("visibility", "visible");
                        }
                    });
                })
            </script>

    </body>
</html>
