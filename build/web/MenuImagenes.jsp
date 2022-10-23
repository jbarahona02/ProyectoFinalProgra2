<%-- 
    Document   : MenuImagenes
    Created on : 23/10/2022, 03:56:30 PM
    Author     : Javier Barahona
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-iYQeCzEYFbKjA/T2uDLTpkwGzCiq6soy8tYaI1GyVh/UjpbCx/TYkiZhlZB6+fzT" crossorigin="anonymous">
        <style>
            body {
                margin: 0;
                padding-top: 30px;
                padding-bottom: 30px;
                background-color: #2ECCFA;
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
        <div class="contenedor">
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
        </div>
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.1/dist/js/bootstrap.bundle.min.js" integrity="sha384-u1OknCvxWvY5kfmNBILK2hRnQC3Pr17a+RTT6rIHI7NnikvbZlHgTPOOmMi466C8" crossorigin="anonymous"></script>
    </body>
</html>
