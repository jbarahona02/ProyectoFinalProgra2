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
        <script type="text/javascript">
        function newSite(value) {
            document.getElementById('myIframe').src = value;
        }    
        </script>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Sistema de infracción vehicular</title>
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
                            <a style="margin-right: 10px; border:none;" class="btn btn-outline-light"  onClick="newSite('ControladorMenuPrincipal?menu=Agentes')">Agentes</a>
                        </li>
                        <li class="nav-item elementosDeMenu">
                            <a style="margin-right: 10px; border:none;" class="btn btn-outline-light"  onClick="newSite('ControladorMenuPrincipal?menu=Usuarios')">Usuarios</a>
                        </li>
                        <li class="nav-item elementosDeMenu">
                            <a style="margin-right: 10px; border:none;" class="btn btn-outline-light" onClick="newSite('ControladorMenuPrincipal?menu=Vehiculos')">Vehículos</a>
                        </li>
                        <li class="nav-item elementosDeMenu">
                            <a style="margin-right: 10px; border:none;" class="btn btn-outline-light" onClick="newSite('ControladorMenuPrincipal?menu=Conductores')">Conductores</a>
                        </li>
                        <li class="nav-item elementosDeMenu">
                            <a style="margin-right: 10px; border:none;" class="btn btn-outline-light" onClick="newSite('ControladorMenuPrincipal?menu=Sanciones')">Sanciones</a>
                        </li>
                        <li class="nav-item elementosDeMenu">
                            <a style="margin-right: 10px; border:none;" class="btn btn-outline-light" onClick="newSite('ControladorMenuPrincipal?menu=Infracciones')">Infracciones</a>
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
        <div style="height: 1000px; width: 100%; overflow: hidden">
            <iframe style="height: 1000px; width: 100%" id="myIframe" src="MenuImagenes.jsp"></iframe>
        </div>
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.1/dist/js/bootstrap.bundle.min.js" integrity="sha384-u1OknCvxWvY5kfmNBILK2hRnQC3Pr17a+RTT6rIHI7NnikvbZlHgTPOOmMi466C8" crossorigin="anonymous"></script>
    </body>
</html>
