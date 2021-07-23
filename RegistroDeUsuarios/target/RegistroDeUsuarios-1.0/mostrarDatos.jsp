<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8" />
        <meta http-equiv="X-UA-Compatible" content="IE=edge" />
        <meta name="viewport" content="width=device-width, initial-scale=1.0" />
        <script src="https://kit.fontawesome.com/579d3f2a89.js" crossorigin="anonymous"></script>
        <link rel="stylesheet" href="recursos/estiloTablaDatos.css">
        <title>Tus datos</title>
    </head>
    <body>
        <h1>DATOS</h1>
        <div class="wrapper">
            <table class="table">
                <tr class="row">
                    <td class="left-td">Nombre</td>
                    <td class="right-td"><%=session.getAttribute("nombre")%></td>
                </tr>
                <tr class="row">
                    <td class="left-td">Apellido</td>
                    <td class="right-td"><%=session.getAttribute("apellido")%></td>
                </tr>
                <tr class="row">
                    <td class="left-td">Mail</td>
                    <td class="right-td"><%=session.getAttribute("mail")%></td>
                </tr>
                <tr class="row">
                    <td class="left-td">Contraseña</td>
                    <td class="right-td"><%=session.getAttribute("password")%></td>
                </tr>
            </table>
        </div>
        
        <div id="link">
            <a href="ingresoOK.jsp"><i class="fas fa-arrow-circle-left"></i>&nbsp;&nbsp;Volver a Inicio</a>
        </div>

    </body>
</html>

