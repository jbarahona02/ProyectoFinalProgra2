<%-- 
    Document   : ConductorPage
    Created on : 27/09/2022, 07:42:15 PM
    Author     : Javier Barahona
--%>

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
            
            .informacionDeTabla{
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
                width: 90px;
                margin: 5px;
            }
        </style>
    </head>
    <body>
        <h1>Conductor</h1>
        <div class="contenedorFormulario">
            <div class="contenidoFormulario">
                <p>Ingrese la información solicitada para registrar un conductor : </p>
                <form action="" method="">
                    
                    <div>
                        <div class="row filaParaInput">
                            <div class="col-2 col-form-label etiquetaDeInput">
                                <label>Email : </label>
                            </div>
                            <div class="col-8">
                                <input type="text" class="form-control" id="inputPassword3">
                            </div>
                        </div>
                        <div class="row filaParaInput">
                            <div class="col-2 col-form-label etiquetaDeInput">
                                <label>Email : </label>
                            </div>
                            <div class="col-8">
                                <input type="text" class="form-control" id="inputPassword3">
                            </div>
                        </div>
                        <div class="row filaParaInput">
                            <div class="col-2 col-form-label etiquetaDeInput">
                                <label>Email : </label>
                            </div>
                            <div class="col-8">
                                <input type="text" class="form-control" id="inputPassword3">
                            </div>
                        </div>
                    </div>    
                       
                     
                    <div class="contenedorBotonAgregar">
                        <input type="submit" name="btnAgregar" value="Agregar" class="btn btn-dark botonAgregar">
                    </div>
                </form>
            </div>
        </div>
        
        
        <div class="contenedorTabla">
            <div class="informacionDeTabla">
                <table class="table table-striped-columns">
                    <tr class="table-dark" style="text-align: center">
                        <th>Seleccionar</th>
                        <th>Campo 1</th>
                        <th>Campo 2</th>
                        <th>Campo 3</th>
                        <th>Campo 4</th>
                        <th>Campo 5</th>
                        <th>acciones</th>
                    </tr>
                    <tr class="table-dark">
                        <td>
                            <button type="button" class="btn btn-warning ">Seleccionar</button>
                        </td>
                        <td>asdas</td>
                        <td>asdas</td>
                        <td>asdas</td>
                        <td>asdas</td>
                        <td>asdas</td>
                        <td class="columnaDeBotones">
                            <div class="d-grid gap-2 d-md-block contenedorBotones">
                                <button type="button" class="btn btn-info botones">Actualizar</button>
                                <button type="button" class="btn btn-danger botones">Eliminar</button>
                            </div>
                        </td>
                    </tr>

                </table>
            </div>
        </div>
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.1/dist/js/bootstrap.bundle.min.js" integrity="sha384-u1OknCvxWvY5kfmNBILK2hRnQC3Pr17a+RTT6rIHI7NnikvbZlHgTPOOmMi466C8" crossorigin="anonymous"></script>
    </body>
</html>
