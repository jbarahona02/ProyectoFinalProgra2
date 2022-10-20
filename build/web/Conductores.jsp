<%-- 
    Document   : ConductorPage
    Created on : 27/09/2022, 07:42:15 PM
    Author     : Javier Barahona
--%>

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page import="Modelos.Conductor"%>
<%@page import="java.util.AbstractList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Conductores</title>
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-iYQeCzEYFbKjA/T2uDLTpkwGzCiq6soy8tYaI1GyVh/UjpbCx/TYkiZhlZB6+fzT" crossorigin="anonymous">
        <style>
            body {
                margin: 0;
                padding: 50px;
                background-color: #2ECCFA;
            }

            h1 {
                text-align: center;
                font-size: 50px;
                font-weight: bold;
            }

            p {
                font-size: 20px;  
            }

            .contenedorFormulario{
                position: relative;
                margin-top: 50px;
                background-color: #FFFFFF60;
                width: 700px;
                border-radius: 5px;
            }

            .tituloAdvertencia {
                font-weight: bold;
                color: red;
                font-size: 17px;
                text-align: center;
            }

            .contenidoFormulario {
                padding: 20px;
            }

            .filaParaInput {
                margin-top: 20px;
            }

            .etiquetaDeInput {
                font-size: 18px;
                display: flex;
                align-items: center;
                justify-content: end;
                padding: 0;
            }

            .contenedorBotonAgregar{
                display: flex;
                justify-content: center;
            }

            .botonAgregar {
                width: 120px;
                font-size: 17px;
                margin-top: 20px;
            }

            .contenedorTabla {
                display: flex; 
                justify-content: center;
                width: 100%
            }

            .informacionDeTabla {
                margin-top: 20px;
                width: 1200px;
                display: flex;
                justify-content: center;
                font-size: 18px;
            }

            .columnaDeBotones {
                width: 230px;
            }

            .contenedorBotones {
                text-align: center;
            }

            .botones {
                margin: 5px;
            }

            .estiloEnlace {
                color: black;
                text-decoration: none;
            }

            .estiloEnlace:hover {
                color: black;
                text-decoration: none;
            }

            .estiloEnlace2 {
                color: white;
                text-decoration: none;
            }

            .estiloEnlace2:hover {
                color: white;
                text-decoration: none;
            }
        </style>
    </head>
    <body>
        <%
            Conductor conductor = (Conductor) request.getAttribute("conductor");
            String licencia;
            String nombres;
            String apellidos;
            String telefono;
            String fechaNac;
            int idC;
            
            if (conductor != null) {
                idC = conductor.getId();
                licencia = conductor.getLicencia();
                nombres = conductor.getNombres();
                apellidos = conductor.getApellidos();
                telefono = conductor.getTelefono();
                fechaNac = conductor.getFechaNacimiento().toString();
            } else {  
                idC = request.getParameter("idC") != null ? Integer.parseInt(request.getParameter("idC")) : 0;
                licencia = request.getParameter("licencia") != null ? request.getParameter("licencia") : "";
                nombres = request.getParameter("nombres") != null ? request.getParameter("nombres") : "";
                apellidos = request.getParameter("apellidos") != null ? request.getParameter("apellidos") : "";
                telefono = request.getParameter("telefono") != null ? request.getParameter("telefono") : "";
                fechaNac = request.getParameter("fechaNac") != null ? request.getParameter("fechaNac") : "";
            }
        %>
        <h1>Conductores</h1>
        <div class="contenedorFormulario">
            <div class="contenidoFormulario">
                <%                    
                    String error = request.getParameter("error");

                    if (error != null) {
                        if (error.equals("licenciaRepetida")) {
                            out.println("<h1 class=" + "tituloAdvertencia" + ">La licencia ingresada ya existe en el sistema</h1>");
                        } else {
                            out.println("<h1 class=" + "tituloAdvertencia" + ">Debe completar todos los campos</h1>");
                        }
                    }
                %>
                <p>Ingrese la información solicitada para registrar un conductor : </p>
                <form action="ControladorConductor" method="POST">
                    <div>
                        <div class="row filaParaInput">
                            <div class="col-2 col-form-label etiquetaDeInput">
                                <label>Licencia : </label>
                            </div>
                            <div class="col-8">
                                <input type="text" class="form-control" name="txtLicencia" value="<%=licencia%>">
                            </div>
                        </div>
                        <div class="row filaParaInput">
                            <div class="col-2 col-form-label etiquetaDeInput">
                                <label>Nombres : </label>
                            </div>
                            <div class="col-8">
                                <input type="text" class="form-control" name="txtNombres" value="<%=nombres%>">
                            </div>
                        </div>
                        <div class="row filaParaInput">
                            <div class="col-2 col-form-label etiquetaDeInput">
                                <label>Apellidos : </label>
                            </div>
                            <div class="col-8">
                                <input type="text" class="form-control" name="txtApellidos" value="<%=apellidos%>">
                            </div>
                        </div>
                        <div class="row filaParaInput">
                            <div class="col-2 col-form-label etiquetaDeInput">
                                <label>Teléfono : </label>
                            </div>
                            <div class="col-8">
                                <input type="text" class="form-control" name="txtTelefono" value="<%=telefono%>">
                            </div>
                        </div>
                        <div class="row filaParaInput">
                            <div class="col-2 col-form-label etiquetaDeInput" style="width: 206px">
                                <label>Fecha de nacimiento : </label>

                            </div>
                            <div class="col-8" style="width: 365px">
                                <input type="date" class="form-control" name="txtFechaNacimiento" value="<%=fechaNac%>">
                            </div>
                        </div>
                    </div>    

                    <input type="hidden" name="txtId" value="<%=idC%>">        
                    <div class="contenedorBotonAgregar">
                        <input type="submit" name="accion" value="Agregar" class="btn btn-dark botonAgregar">
                        <input type="submit" name="accion" value="Actualizar" class="btn btn-dark botonAgregar" style="margin-left: 10px;">
                    </div>
                </form>
            </div>
        </div>


        <div class="contenedorTabla">
            <div class="informacionDeTabla">
                <table class="table table-striped-columns" style="text-align: center">
                    <thead>
                        <tr class="table-dark" style="text-align: center">
                            <th>ID</th>
                            <th>Licencia</th>
                            <th>Nombres</th>
                            <th>Apellidos</th>
                            <th>Teléfono</th>
                            <th>Fecha de Nacimiento</th>
                            <th>Acciones</th>
                        </tr>
                    </thead>
                    <tbody>
                        <c:forEach var="conductor" items="${conductores}">
                            <tr class="table-dark">
                                <td>${conductor.getId()}</td>
                                <td>${conductor.getLicencia()}</td>
                                <td>${conductor.getNombres()}</td>
                                <td>${conductor.getApellidos()}</td>
                                <td>${conductor.getTelefono()}</td>
                                <td>${conductor.getFechaNacimiento()}</td>
                                <td class="columnaDeBotones">
                                    <div class="d-grid gap-2 d-md-block contenedorBotones">
                                        <a class="btn btn-warning estiloEnlace" href="ControladorConductor?accion=Seleccionar&id=${conductor.getId()}">Seleccionar</a>
                                        <a class="btn btn-danger botones estiloEnlace2" href="ControladorConductor?accion=Eliminar&id=${conductor.getId()}">Eliminar</a>
                                    </div>
                                </td>
                            </tr>
                        </c:forEach>
                    </tbody>
                </table>
            </div>
        </div>
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.1/dist/js/bootstrap.bundle.min.js" integrity="sha384-u1OknCvxWvY5kfmNBILK2hRnQC3Pr17a+RTT6rIHI7NnikvbZlHgTPOOmMi466C8" crossorigin="anonymous"></script>
    </body>
</html>
