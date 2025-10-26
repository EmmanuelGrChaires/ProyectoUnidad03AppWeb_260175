<%-- 
    Document   : home
    Created on : 26 oct 2025, 6:52:10 a.m.
    Author     : Emma
--%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <title>Home - PokeLand</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/style.css"/>
</head>
<body>
    <nav>
        <h2>Bienvenido (a) ${sessionScope.nombre}</h2>

       
        <c:if test="${empty listaPokemon}">
            <form action="${pageContext.request.contextPath}/SvApi" method="get" style="display:inline;">
                <button class="nav-button">Ver Pokémones</button>
            </form>
            <form action="${pageContext.request.contextPath}/index.jsp" method="get" style="display:inline;">
                <button class="nav-button">Cerrar Sesión</button>
            </form>
        </c:if>

        
        <c:if test="${not empty listaPokemon}">
            <form action="${pageContext.request.contextPath}/index.jsp" method="get" style="display:inline;">
                <button class="nav-button">Cerrar Sesión</button>
            </form>
        </c:if>
    </nav>

    <main>
      
        <c:if test="${not empty listaPokemon}">
            <h3> Pokémones Recomendados </h3>
            <div class="grid">
                <c:forEach var="p" items="${listaPokemon}">
                    <div class="card-api">
                        <img src="${p.image}" alt="${p.name}"/>
                        <h4>${p.name}</h4>
                    </div>
                </c:forEach>
            </div>
        </c:if>
    </main>
</body>
</html>
