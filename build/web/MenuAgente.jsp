<%-- 
    Document   : MenuAgente
    Created on : 7/10/2022, 06:32:07 PM
    Author     : Javier Barahona
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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

            .estiloDeDropDown {
                background-color: #00BDFF;
                border: 1px solid #00BDFF;
                margin-right: 16px;
                color: black;
            }

            .estiloDeDropDown:hover {
                background-color: #00BDFF !important;
                border: 1px solid #00BDFF !important;
                margin-right: 16px;
                color: black !important;
            }

        </style>
    </head>
    <body>
        <h1 class="titulo">Sistema de infracción vehicular</h1>
        <nav class="navbar navbar-expand-md navbar-dark bg-dark">
            <div class="container-fluid">
                <div class="collapse navbar-collapse menuDeOpciones">
                    <ul class="navbar-nav">
                        <li class="nav-item">
                            <a style="margin-right: 10px; border:none;" class="btn btn-outline-light" href="ControladorMenuPrincipal?menu=Agentes">Agentes</a>
                        </li>
                        <li class="nav-item elementosDeMenu">
                            <a style="margin-right: 10px; border:none;" class="btn btn-outline-light" href="ControladorMenuPrincipal?menu=Usuarios" target="usuariosFrame">Usuarios</a>
                        </li>
                        <li class="nav-item elementosDeMenu">
                            <a style="margin-right: 10px; border:none;" class="btn btn-outline-light" href="ControladorMenuPrincipal?menu=Vehiculos">Vehículos</a>
                        </li>
                        <li class="nav-item elementosDeMenu">
                            <a style="margin-right: 10px; border:none;" class="btn btn-outline-light" href="ControladorMenuPrincipal?menu=Conductores&accion=Listar" target="conductoresFrame">Conductores</a>
                        </li>
                        <li class="nav-item elementosDeMenu">
                            <a style="margin-right: 10px; border:none;" class="btn btn-outline-light" href="ControladorMenuPrincipal?menu=Sanciones">Sanciones</a>
                        </li>
                        <li class="nav-item elementosDeMenu">
                            <a style="margin-right: 10px; border:none;" class="btn btn-outline-light" href="ControladorMenuPrincipal?menu=Infracciones">Infracciones</a>
                        </li>
                    </ul>
                </div>
            </div>
            <div class="dropdown">
                <button class="btn btn-secondary dropdown-toggle estiloDeDropDown" type="button" data-bs-toggle="dropdown" aria-expanded="false">
                    ${usuario.getEmail()}
                </button>
                <ul class="dropdown-menu dropdown-menu-dark">
                    <form action="ControladorInicioSesion" method="POST">
                        <button name="btnCerrarSesion" value="Salir" class="dropdown-item">Cerrar sesión</button>
                    </form>
                </ul>
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

        <div style="height: 550px">
            <iframe name="conductoresFrame" style="width: 100%; height: 100%; border:none"></iframe>
        </div>
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.1/dist/js/bootstrap.bundle.min.js" integrity="sha384-u1OknCvxWvY5kfmNBILK2hRnQC3Pr17a+RTT6rIHI7NnikvbZlHgTPOOmMi466C8" crossorigin="anonymous"></script>
    </body>
</html>
