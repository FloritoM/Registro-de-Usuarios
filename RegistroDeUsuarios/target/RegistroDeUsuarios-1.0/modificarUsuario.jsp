<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <script src="https://kit.fontawesome.com/579d3f2a89.js" crossorigin="anonymous"></script>
        <link rel="stylesheet" href="recursos/estiloModificarUsuario.css">
        <title>Modificación - Actualizacion</title>
    </head>
    <body>
        <div class="wrapper">
        <h1>Actualizar datos</h1>
        <form action="/RegistroDeUsuarios/Servlet?accion=modificar" method="POST">
            <label for="nombre">Nombre
                <input class="form-input" id="nombre" type="text" name="nombre" placeholder="Ingresa tu nombre" required> 
            </label>
            
            <label for="apellido">Apellido
                <input class="form-input" id="apellido" type="text" name="apellido" placeholder="Ingresa tu apellido" required> 
             </label>
             
             <label for="mail">Mail
                 <input class="form-input" id="mail" type="email" name="mail" value="<%=session.getAttribute("mail")%>" readonly="true"> 
             </label>
             
             <label for="password">Contraseña
                <input class="form-input" id="password" type="password" name="password" placeholder="Ingresa tu contraseña" required> 
             </label>
             
             <input class="btn-submit" type="submit" value="Modificar">
        </form>
    </div>
    <div id="link">
        <a href="ingresoOK.jsp"><i class="fas fa-arrow-circle-left"></i>&nbsp;&nbsp;Volver a Inicio</a>
    </div>         
    </body>
</html>
