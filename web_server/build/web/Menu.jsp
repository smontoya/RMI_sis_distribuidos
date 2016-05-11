<%-- 
    Document   : menu
    Created on : 11-may-2016, 1:45:59
    Author     : samue
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="es">
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Menu - Sistemas Distribuidos</title>
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css" integrity="sha384-1q8mTJOASx8j1Au+a5WDVnPi2lkFfwwEAa8hDDdjZlpLegxhjVME1fgjWPGmkzs7" crossorigin="anonymous">
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js" integrity="sha384-0mSbJDEHialfmuBBQP6A4Qrprq5OVfW37PRR3j5ELqxss1yVqOtnepnHVP9aJ7xS" crossorigin="anonymous"></script>
        <meta name="description" content="">
        <meta name="author" content="">
        <link rel="mask-icon" href="https://assets-cdn.github.com/pinned-octocat.svg" color="red">
        <link rel="icon" type="image/x-icon" href="https://assets-cdn.github.com/favicon.ico">
        
    </head>
    <body>
        <nav class="navbar navbar-inverse navbar-fixed-top">
          <div class="container">
            <div class="navbar-header">
              <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#navbar" aria-expanded="false" aria-controls="navbar">
                <span class="sr-only">Toggle navigation</span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
              </button>
              <a class="navbar-brand" href="#">Sistemas Distribuidos</a>
            </div>
            <div id="navbar" class="collapse navbar-collapse">
              <ul class="nav navbar-nav">
                <li class="active"><a href="./">Inicio</a></li>
                <li><a href="Cuentas.jsp">Cuentas</a></li>
                <li><a href="Usuarios.jsp">Usuarios</a></li>
                <li><a href="Login?action=out">Cerrar Sesión</a></li>
              </ul>
            </div><!--/.nav-collapse -->
          </div>
        </nav>
        
        
        <div class="jumbotron">
            Bienvenido ${usuario}!
        </div>  
        <div>
                <a class="btn btn-lg" id="usuarios" href="Usuarios" >Ver usuarios</a>
                <a class="btn btn-lg" id="cuentas" href="Cuentas" >Ver Cuentas</a>
        </div>
        </body>
</html>
