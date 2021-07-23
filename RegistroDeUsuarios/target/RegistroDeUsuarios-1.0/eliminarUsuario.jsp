<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8" />
        <meta http-equiv="X-UA-Compatible" content="IE=edge" />
        <meta name="viewport" content="width=device-width, initial-scale=1.0" />
        <script src="https://kit.fontawesome.com/579d3f2a89.js" crossorigin="anonymous"></script>
        <link rel="stylesheet" href="recursos/estiloEliminarUser.css">
        <title>Eliminacion de Usuario</title>
    </head>
    <body>
        <h1>Eliminacion de Usuario</h1>
        <div class="wrapper">
           <form action="/RegistroDeUsuarios/Servlet" method="GET">
              <label for="email">
                <span>Confirma presionando "Enviar" </span><br/>
                <input type="mail" name="mail" value="<%=session.getAttribute("mail")%>" readonly="true"/>
                <input id="btn-submit" type="submit" />
              </label>
          </form> 
        </div>
         <div id="link">
            <a href="ingresoOK.jsp"><i class="fas fa-arrow-circle-left"></i>&nbsp;&nbsp;Volver a Inicio</a>
        </div>        
    </body>
</html>
