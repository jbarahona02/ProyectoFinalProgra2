<%-- 
    Document   : RegistrarPage
    Created on : Oct 7, 2022, 8:50:31 AM
    Author     : joseb
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Registro</title>
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-iYQeCzEYFbKjA/T2uDLTpkwGzCiq6soy8tYaI1GyVh/UjpbCx/TYkiZhlZB6+fzT" crossorigin="anonymous">
        <style>
            body {
                margin: 0;
                padding: 50px;
                background-color: #2ECCFA;
            }
            
            .contenedorLogin {
                margin-top: 5%;
            }
            
            .fondoDeLogin {
                background-color: rgba(225,225,225,0.4);
                width: 465px;
                height: 500px;
                margin-top: -40px;
                border-radius: 50px;
            }
            
            .titulo {
                font-weight: bold;
                font-size: 200%;
                text-align: center;
                padding-top: 57px;
            }
            
            .titulo-sin-padding {
                font-weight: bold;
                font-size: 200%;
                text-align: center;
            }
            
            .tituloWaring {
                font-weight: bold;
                color: red;
                font-size: 100%;
                text-align: center;
                padding-top: 57px;
            }
            
            .formulario {
                margin-top: 28px;
            }
            
            .etiquetaDeInput {
                text-align: left;
                margin-left: 50px;
                font-size: 19px;
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
            
            .botonAgregar {
                background-color: #223d62;
                padding-left: 30px;
                padding-right: 30px;
            }
            
            .botonRegistro {
                background-color: #223d62;
                padding-left: 30px;
                padding-right: 30px;
                margin-left: 30px;
            }
            
            .botonAgregar:hover {
                background-color: #223d62 !important;
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
                            
                        <% 
                          String email = request.getParameter("emailRepetido");
                          if (email != null && !email.equals("")) {
                              out.println("<h1 class=" + "tituloWaring" + "> Correo electronico ya existe en el sistema </h1>");
                              out.println("<h1 class=" + "titulo-sin-padding" + "> REGISTRARSE </h1>");
                          } else {
                              out.println("<h1 class=" + "titulo" + "> REGISTRARSE </h1>");
                          }
                        %>
                              
                        <form class="formulario" action="ControladorRegistro" method="POST">
                            <div class="etiquetaDeInput">
                                <label class="form-label">Correo: </label>
                            </div>
                            <div>
                                <input type="text" name="txtCorreo" class="form-control inputDelLogin">
                            </div>
                            <br>  
                            <div class="etiquetaDeInput">
                                <label class="form-label">Contraseña: </label>
                            </div>
                            <div>
                                <input type="text" name="txtContrasenia" class="form-control inputDelLogin">
                            </div>
                            <br>
                            <div class="etiquetaDeInput">
                                <label class="form-label">Tipo de usuario: </label>
                            </div>
                            <div>
                                <select name="Tipo" id="tipoUsuario" class="form-control inputDelLogin">
                                    <option value="1">Conductor</option>
                                    <option value="2">Agente</option>
                                 </select>
                            </div>
                            
                            <div class="contenedorDeBoton">
                                 <input type="submit" name="btnAccion" value="Regresar" class="btn btn-dark botonRegistro">
                                <input type="submit" name="btnAccion" value="Crear cuenta" class="btn btn-dark botonRegistro">
                            </div>
                        </form>
                </div>
            </div>
        </center>
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.1/dist/js/bootstrap.bundle.min.js" integrity="sha384-u1OknCvxWvY5kfmNBILK2hRnQC3Pr17a+RTT6rIHI7NnikvbZlHgTPOOmMi466C8" crossorigin="anonymous"></script>
    </body>
</html>
