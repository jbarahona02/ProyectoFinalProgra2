<%-- 
    Document   : MenuAgente
    Created on : 7/10/2022, 06:32:07 PM
    Author     : Admin
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Menú Principal</title>
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-iYQeCzEYFbKjA/T2uDLTpkwGzCiq6soy8tYaI1GyVh/UjpbCx/TYkiZhlZB6+fzT" crossorigin="anonymous">
        <style>
            body {
                margin: 0;
                padding-top: 30px;
                padding-bottom: 30px;
                background-color: #2ECCFA;
            }

            .titulo {
                font-weight: bold;
                text-align: center;
                padding: 5px;
            }

            .elementosDeMenu {
                text-align: center;
                margin-right: 5px;
            }

            .textoElementosDeMenu {
                color: white;
            }

            .contenedor {
                display: flex;
                justify-content: center;
                margin-top: 35px;
            }

            .contenedorImagenes {
                height: 530px;
                width: 750px;
            }

            .imagen {
                height: 530px;
                width: 750px;
            }

        </style>
    </head>
    <body>
        <h1 class="titulo">Sistema de infracción vehicular</h1>
        <nav class="navbar navbar-expand-md navbar-dark bg-dark">
            <div class="container-fluid">
                <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarNavDropdown" aria-controls="navbarNavDropdown" aria-expanded="false" aria-label="Toggle navigation">
                    <span class="navbar-toggler-icon"></span>
                </button>
                <div class="collapse navbar-collapse menuDeOpciones">
                    <ul class="navbar-nav">
                        <li class="nav-item elementosDeMenu">
                            <a class="nav-link textoElementosDeMenu" href="ControladorMenuPrincipal?menu=Agentes">Agentes</a>
                        </li>
                        <li class="nav-item elementosDeMenu">
                            <a class="nav-link textoElementosDeMenu" href="ControladorMenuPrincipal?menu=Usuarios">Usuarios</a>
                        </li>
                        <li class="nav-item elementosDeMenu">
                            <a class="nav-link textoElementosDeMenu" href="ControladorMenuPrincipal?menu=Vehiculos">Vehículos</a>
                        </li>
                        <li class="nav-item elementosDeMenu">
                            <a class="nav-link textoElementosDeMenu" href="ControladorMenuPrincipal?menu=Conductores" target="conductoresFrame">Conductores</a>
                        </li>
                        <li class="nav-item elementosDeMenu">
                            <a class="nav-link textoElementosDeMenu" href="ControladorMenuPrincipal?menu=Sanciones">Sanciones</a>
                        </li>
                        <li class="nav-item elementosDeMenu">
                            <a class="nav-link textoElementosDeMenu" href="ControladorMenuPrincipal?menu=Infracciones">Infracciones</a>
                        </li>
                    </ul>
                </div>
            </div>
        </nav>

       
        <!--<div class="contenedor">
            <div class="contenedorImagenes">
                <div id="carouselExampleSlidesOnly"  class="carousel slide" data-bs-ride="carousel"  data-bs-pause="false">
                    <div class="carousel-inner" >
                        <div class="carousel-item active" data-bs-interval="2000">
                            <img src="imagenes/imagen_menu_1.png" class="d-block imagen">
                        </div>
                        <div class="carousel-item" data-bs-interval="2000">
                            <img src="imagenes/imagen_menu_2.png" class="d-block imagen">
                        </div>
                        <div class="carousel-item" data-bs-interval="2000">
                            <img src="imagenes/imagen_menu_3.png" class="d-block imagen">
                        </div>
                    </div>
                </div>
            </div>
        </div>-->

        <div style="height:1000px">
            <iframe name="conductoresFrame" style="width: 100%; height: 100%; border:none"></iframe>
        </div>
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.1/dist/js/bootstrap.bundle.min.js" integrity="sha384-u1OknCvxWvY5kfmNBILK2hRnQC3Pr17a+RTT6rIHI7NnikvbZlHgTPOOmMi466C8" crossorigin="anonymous"></script>
    </body>
</html>
