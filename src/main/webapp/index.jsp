<%-- 
    Document   : index
    Created on : 26 oct 2025, 6:50:52 a.m.
    Author     : Emma
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <title>Login - PokeLand</title>
    <link href="https://fonts.googleapis.com/css2?family=Press+Start+2P&display=swap" rel="stylesheet">
    <link rel="stylesheet" href="style.css"/>
</head>
<body>
    <h1 class="login-title">PokeLand</h1>
    <form action="SvLogin" method="POST" class="card">
     
        <img src="https://i.pinimg.com/736x/1a/92/f6/1a92f6751adcfa2db3aae1b37343fd72.jpg" alt="Pikachu" class="form-image"/>
        
        <label>Ingrese su Email:</label><br/>
        <input type="email" name="email" required/><br/>
        
        <label>Ingrese su Contraseña:</label><br/>
        <input type="password" name="password" required/><br/>
        
        <button type="submit">Iniciar Sesión</button>
    </form>
    <p>¿No tienes cuenta? <a href="register.jsp">Regístrate aquí</a></p>
</body>
</html>
