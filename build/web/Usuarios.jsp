<%-- 
    Document   : UserPage
    Created on : 27/09/2022, 07:42:06 PM
    Author     : Admin
--%>

<%@page import="Modelos.UsuarioDAO"%>
<%@page import="Modelos.Conductor"%>
<%@page import="Modelos.ConductorDAO"%>
<%@page import="java.util.List"%>
<%@page import="Modelos.Agente"%>
<%@page import="Modelos.AgenteDAO"%>
<%@page import="Modelos.Usuario"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
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
            Usuario usuario = (Usuario) request.getAttribute("usuario");
            String email;
            int agente;
            int conductor;

            if (usuario != null) {
                email = usuario.getEmail();
                agente = usuario.getAgente();
                conductor = usuario.getConductor();
            } else {
                email = request.getParameter("email") != null ? request.getParameter("email") : "";
                agente = request.getParameter("agente") != null ? Integer.valueOf(request.getParameter("agente")) : 0;
                conductor = request.getParameter("conductor") != null ? Integer.valueOf(request.getParameter("conductor")) : 0;
            }

        %>
        <h1>Usuarios</h1>
        <div class="contenedorFormulario">
            <div class="contenidoFormulario">
                <%                   
                    String error = request.getParameter("error");
                    String errorEliminar = request.getParameter("errorEliminar");

                    if (error != null) {
                        if (error.equals("emailRepetido")) {
                            out.println("<h1 class=" + "tituloAdvertencia" + ">El correo ingresado ya existe en el sistema</h1>");
                        } else {
                            out.println("<h1 class=" + "tituloAdvertencia" + ">Debe completar todos los campos</h1>");
                        }
                    }
                    
                    if (errorEliminar != null) {
                         out.println("<h1 class=" + "tituloAdvertencia" + ">" + errorEliminar + "</h1>");
                    }
                %>
                <p>Información del usuario: </p>
                <form action="ControladorUsuario" method="POST">
                    <div>
                        <div class="row filaParaInput">
                            <div class="col-2 col-form-label etiquetaDeInput">
                                <label>Correo : </label>
                            </div>
                            <div class="col-8">
                                <input type="text" class="form-control" name="txtEmail" value="<%=email%>">
                            </div>
                        </div>
                        <div class="row filaParaInput">
                            <div class="col-2 col-form-label etiquetaDeInput">
                                <label>Agente: </label>
                            </div>
                            <div class="col-8">
                                <select name="Agente" id="cmbAgente" class="form-control" disabled>
                                    <%
                                        AgenteDAO agenteDAO = new AgenteDAO();
                                        List<Agente> agentes = agenteDAO.buscarAgentes();

                                        String selectedEmpty = (agente == 0) ? "selected" : "";
                                        out.println("<option value='0'" + selectedEmpty + " disabled>No hay infromación</option>");

                                        for (Agente item : agentes) {
                                            String selected = (agente == item.getId()) ? "selected" : "";
                                            out.println("<option value=" + item.getId() + " " + selected + ">" + item.getNombre() + " " + item.getApellidos() + "</option>");
                                        }
                                    %>
                                </select>
                            </div>
                        </div>

                        <div class="row filaParaInput">
                            <div class="col-2 col-form-label etiquetaDeInput">
                                <label>Conductor: </label>
                            </div>
                            <div class="col-8">
                                <select name="Agente" id="cmbAgente" class=" form-control" disabled>
                                    <%
                                        ConductorDAO conductorDAO = new ConductorDAO();
                                        List<Conductor> conductores = conductorDAO.listarConductores();

                                        selectedEmpty = (conductor == 0) ? "selected" : "";
                                        out.println("<option value='0'" + selectedEmpty + " disabled>No hay inforamción</option>");

                                        for (Conductor item : conductores) {
                                            String selected = (conductor == item.getId()) ? "selected" : "";
                                            out.println("<option value=" + item.getId() + " " + selected + " disabled>" + item.getNombres() + " " + item.getApellidos() + "</option>");
                                        }
                                    %>
                                </select>
                            </div>
                        </div>
                    </div>    

                    <input type="hidden" name="txtId" value="${usuario.getId()}">        
                    <div class="contenedorBotonAgregar">
                        <% 
                            if (usuario != null && usuario.getId() != 0) {
                                out.println("<input type='submit' name='btnAccion' value='Actualizar' class='btn btn-dark botonAgregar' style='margin-left: 10px;'>");
                            }
                            
                        %>
                        
                    </div>
                </form>
            </div>
        </div>


        <div class="contenedorTabla">
            <div class="informacionDeTabla">
                <table class="table table-striped-columns">
                    <thead>
                        <tr class="table-dark" style="text-align: center">
                            <th>ID</th>
                            <th>Correo</th>
                            <th>Agente</th>
                            <th>Conductor</th>
                            <th>Acciones</th>
                        </tr>
                    </thead>
                    <tbody>
                        <%
                            UsuarioDAO usuarioDAO = new UsuarioDAO();
                            List<Usuario> usuarios = usuarioDAO.listarUsuarios();
                            if (!usuarios.isEmpty()) {
                                out.println("<form action=" + "'ControladorUsuario'" + "method=" + "'POST'" + ">");
                                for (Usuario item : usuarios) {
                                    String agenteText = (item.getAgente() == 0) ?"" : String.valueOf(item.getAgente());
                                    String usuarioText = (item.getConductor() == 0) ? "" : String.valueOf(item.getConductor());
                                    out.println("<tr class=" + "'table-dark'" + ">");

                                    out.println("<td>" + item.getId() + "</td>");
                                    out.println("<td>" + item.getEmail() + "</td>");
                                    out.println("<td>" + agenteText + "</td>");
                                    out.println("<td>" + usuarioText + "</td>");
                                    out.println("<td class=" + "'columnaDeBotones'" + ">");
                                        out.println("<div class=" + "'d-grid gap-2 d-md-block contenedorBotones'" + ">");
                                            out.println("<a href='ControladorUsuario?registro=" + item.getId() + "&btnAccion=Seleccionar' class='btn btn-warning estiloEnlace' >Seleccionar</a>");
                                            out.println("<a href='ControladorUsuario?registro=" + item.getId() + "&btnAccion=Eliminar' class='btn btn-danger estiloEnlace2' >Eliminar</a>");
                                        out.println("</div>");
                                    out.println("</td>");
                                    out.println("</tr>");
                                }
                                out.println("</form>");
                            }

                        %>

                    </tbody>
                </table>
            </div>
        </div>
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.1/dist/js/bootstrap.bundle.min.js" integrity="sha384-u1OknCvxWvY5kfmNBILK2hRnQC3Pr17a+RTT6rIHI7NnikvbZlHgTPOOmMi466C8" crossorigin="anonymous"></script>
    </body>
</html>
