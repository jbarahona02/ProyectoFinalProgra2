<%-- 
    Document   : Login
    Created on : 30/09/2022, 08:40:43 PM
    Author     : Admin
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Login</title>
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-iYQeCzEYFbKjA/T2uDLTpkwGzCiq6soy8tYaI1GyVh/UjpbCx/TYkiZhlZB6+fzT" crossorigin="anonymous">
        <style>
            body {
                margin: 0;
                padding: 50px;
                background-color: #2ECCFA;
            }
            
            .contenedorLogin {
                margin-top: 10%;
            }
            
            .fondoDeLogin {
                background-color: rgba(225,225,225,0.4);
                width: 465px;
                height: 307px;
                margin-top: -40px;
                border-radius: 50px;
            }
            
            .titulo {
                font-weight: bold;
                font-size: 200%;
                text-align: center;
                padding-top: 57px;
            }
            
            .formulario {
                margin-top: 28px;
            }
            
            .inputDelLogin {
                width: 80%;
                height: 34px;
                font-size: 100%;
                border-radius: 10px;
            }
            
            .contenedorDeBoton {
                display: flex;
                justify-content: center;
                margin-top: 26px;
            }
            
            .boton {
                background-color: #223D62;
                padding-left: 30px;
                padding-right: 30px;
            }
            
            .boton:hover {
                background-color: #223D62 !important;
            }
            
        </style>
    </head>
    <body>
        <center>
            <div class="contenedorLogin">
                <div>
                    <img src="imagenes/login.png"> 
                </div>

                <div class="fondoDeLogin">
                        <h1 class="titulo"> Iniciar Sesión </h1>
                        <form class="formulario">
                            <input type="text" class="form-control inputDelLogin" id="inputPassword3">
                            </br>
                            <input type="text" class="form-control inputDelLogin" id="inputPassword3">
                        </form>
                        <div class="contenedorDeBoton">
                            <button type="button" class="btn btn-dark boton">Iniciar sesión</button>
                        </div>
                </div>
            </div>
        </center>
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.1/dist/js/bootstrap.bundle.min.js" integrity="sha384-u1OknCvxWvY5kfmNBILK2hRnQC3Pr17a+RTT6rIHI7NnikvbZlHgTPOOmMi466C8" crossorigin="anonymous"></script>
    </body>
</html>
