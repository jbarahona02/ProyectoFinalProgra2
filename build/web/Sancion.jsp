<%-- 
    Document   : Sancion
    Created on : 20/10/2022, 01:33:58
    Author     : alera
--%>

<%@page import="java.util.List"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page import="Modelos.*"%>
<%@page import="java.util.AbstractList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Sanciones</title>
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
            Sancion sancion = (Sancion) request.getAttribute("sancion");
            String descripcion;
            Double amount;

            if (sancion != null) {
                descripcion = sancion.getDescripcion();
                amount = sancion.getAmount();
            } else {
                descripcion = request.getParameter("descripcion") != null ? descripcion = request.getParameter("descripcion") : "";
                amount = request.getParameter("amount") != null ? Double.valueOf(request.getParameter("amount")) : 0;
            }

        %>
        <h1>Sanciones</h1>
        <div class="contenedorFormulario">
            <div class="contenidoFormulario">
                <%                    
                    String error = request.getParameter("error");
                    String errorEliminar = request.getParameter("errorEliminar");
                    
                    if (error != null) {
                        if (error.equals("sancionRepetida")) {
                            out.println("<h1 class=" + "tituloAdvertencia" + ">La descripcion ingresada ya existe en el sistema</h1>");
                        } else {
                            out.println("<h1 class=" + "tituloAdvertencia" + ">Debe completar todos los campos</h1>");
                        }
                    }
                    
                    if (errorEliminar != null) {
                         out.println("<h1 class=" + "tituloAdvertencia" + ">" + errorEliminar + "</h1>");
                    }
                %>
                <p>Ingrese la información solicitada para registrar un sancion : </p>
                <form action="ControladorSancion" method="POST">
                    <div>
                        <div class="row filaParaInput">
                            <div class="col-2 col-form-label etiquetaDeInput">
                                <label>Descripcion : </label>
                            </div>
                            <div class="col-8">
                                <input type="text" class="form-control" name="txtDescripcion" value="<%=descripcion%>">
                            </div>
                        </div>
                        <div class="row filaParaInput">
                            <div class="col-2 col-form-label etiquetaDeInput">
                                <label>Monto : </label>
                            </div>
                            <div class="col-8">
                                <input type="text" class="form-control" name="txtAmount" value="<%=amount%>">
                            </div>
                        </div>
                    </div>    

                    <input type="hidden" name="txtId" value="${sancion.getId()}">        
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
                            <th>Descripcion</th>
                            <th>Monto</th>
                            <th>Acciones</th>
                        </tr>
                    </thead>
                    <tbody>
                        <c:forEach var="sancion" items="${sanciones}">
                            <tr class="table-dark">
                                <td>${sancion.getId()}</td>
                                <td>${sancion.getDescripcion()}</td>
                                <td>${sancion.getAmount()}</td>
                                <td class="columnaDeBotones">
                                    <div class="d-grid gap-2 d-md-block contenedorBotones">
                                        <a class="btn btn-warning estiloEnlace" href="ControladorSancion?accion=Seleccionar&id=${sancion.getId()}">Seleccionar</a>
                                        <a class="btn btn-danger botones estiloEnlace2" href="ControladorSancion?accion=Eliminar&id=${sancion.getId()}">Eliminar</a>
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
