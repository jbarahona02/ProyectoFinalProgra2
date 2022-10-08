<%-- 
    Document   : CompleteRegistro
    Created on : Oct 7, 2022, 9:46:40 AM
    Author     : joseb
--%>

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
                height: 750px;
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
                          String licencia = request.getParameter("licenciaRepetida");
                          String dpi = request.getParameter("dpiRepetido");
                          if (licencia != "" && licencia != null) {
                              out.println("<h1 class=" + "tituloWaring" + ">  " + licencia + " </h1>");
                              out.println("<h1 class=" + "titulo-sin-padding" + "> Completar Registro </h1>");
                          } else if (dpi != "" && dpi != null) {
                              out.println("<h1 class=" + "tituloWaring" + ">  " + dpi + " </h1>");
                              out.println("<h1 class=" + "titulo-sin-padding" + "> Completar Registro </h1>");
                          } else {
                              out.println("<h1 class=" + "titulo" + "> Completar Registro </h1>");
                          }
                        %>

                        <form class="formulario" action="ControladorRegistro" method="POST">
                            <div class="etiquetaDeInput">
                                <label class="form-label">Nombre: </label>
                            </div>
                            <div>
                                <input type="text" name="txtNombre" class="form-control inputDelLogin">
                            </div>
                            <br>  
                            <div class="etiquetaDeInput">
                                <label class="form-label">Apellido: </label>
                            </div>
                            <div>
                                <input type="text" name="txtApellido" class="form-control inputDelLogin">
                            </div>
                            <br>

                            
                            <div class="etiquetaDeInput">
                                <%
                                    String tipo = request.getParameter("Tipo");
                                    String email = request.getParameter("txtCorreo");
                                    String password = request.getParameter("txtContrasenia");
                                    if (tipo.equals("1")) {
                                        out.println("<label class=" + "form-label" + ">Licencia: </label>");
                                    } else {
                                        out.println("<label class=" + "form-label" + ">DPI: </label>");
                                    }
                                    out.println("<input hidden name=" + "Tipo" + " value=" + tipo + ">");
                                    out.println("<input hidden name=" + "txtCorreo" + " value=" + email + ">");
                                    out.println("<input hidden name=" + "txtContrasenia" + " value=" + password + ">");
                                %>
                                
                            </div>
                            <div>
                                <input type="text" name="txtLicenciaODpi" class="form-control inputDelLogin">
                            </div>
                            <br>
                            
                            
                            <div class="etiquetaDeInput">
                                <label class="form-label">Fecha de Nacimiento: </label>
                            </div>
                            <div>
                                <input type="date" name="txtFechaNacimiento" class="form-control inputDelLogin">
                            </div>
                            <br>
                            
                            <div class="etiquetaDeInput">
                                <label class="form-label">Telefono: </label>
                            </div>
                            <div>
                                <input type="number" name="txtTelefono" class="form-control inputDelLogin">
                            </div>
                            <br>
                            
                            <div class="contenedorDeBoton">
                                <input type="submit" name="btnAccion" value="Completar registro" class="btn btn-dark botonRegistro">
                            </div>
                        </form>
                </div>
            </div>
        </center>
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.1/dist/js/bootstrap.bundle.min.js" integrity="sha384-u1OknCvxWvY5kfmNBILK2hRnQC3Pr17a+RTT6rIHI7NnikvbZlHgTPOOmMi466C8" crossorigin="anonymous"></script>
    </body>
</html>
