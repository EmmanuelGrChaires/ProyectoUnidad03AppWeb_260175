<%-- 
    Document   : login
    Created on : 26 oct 2025, 6:51:13 a.m.
    Author     : Emma
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
  <title>Registro - PokeLand</title>
  <link rel="stylesheet" href="style.css"/>
</head>
<body>
  <h1> Crear Cuenta </h1>
  <form action="SvRegister" method="POST" class="card">
    <label>Nombre</label>
    <input type="text" name="nombre" required/>
    <label>Email</label>
    <input type="email" name="email" required/>
    <label>Contraseña</label>
    <input type="password" name="password" required/>
    <button>Registrarme</button>
  </form>
  <p><a href="index.jsp">Volver al Login</a></p>
</body>
</html>
