<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8" />
        <meta http-equiv="X-UA-Compatible" content="IE=edge" />
        <meta name="viewport" content="width=device-width, initial-scale=1.0" />
        <link rel="stylesheet" href="recursos/styles.css"/>
        <script src="https://kit.fontawesome.com/579d3f2a89.js" crossorigin="anonymous"></script>
        <link rel="stylesheet" href="recursos/estiloIngresoOk.css">
        <title>Bienvenido</title>
    </head>
    <body>
        <h1>Usuario Registrado</h1>
    
        <main>
            <div class="text">
                <span>Tus datos fueron cargados en nuestra base de datos</span>
            </div>

            <div class="links">
                <ul>
                    <li><a href="mostrarDatos.jsp"><i class="fas fa-eye icon"></i><span>¿Que datos acabo de compartir?</span></a></li>

                    <li><a href="modificarUsuario.jsp"><i class="fas fa-pencil-alt"></i><span>Quiero modificar mis datos</span></a></li>

                    <li><a href="eliminarUsuario.jsp"><i class="fas fa-times-circle"></i><span>No quiero mis datos en la base de datos</span></a></li>

                </ul>
            </div>
        </main>
    </body>
</html>
