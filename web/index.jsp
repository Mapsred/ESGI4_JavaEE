<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="UTF-8">
    <title>Title</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">

</head>
<body>
<img src="Resources/images/logo-esgi.png" alt="esgi" style="max-width: 125px;">
<div class="container">
    <%@include file="flash.jsp" %>
    <h1>Accueil !</h1>
    <div class="panel panel-default">
        <div class="panel-body">
            <div class="list-group">
                <a href="${pageContext.request.contextPath}/" class="list-group-item">Accueil</a>
                <a href="${pageContext.request.contextPath}/add" class="list-group-item">Ajouter une visite</a>
                <a href="${pageContext.request.contextPath}/list" class="list-group-item">Liste des visites</a>
                <% if (null != request.getSession().getAttribute("username")) { %>
                <a href="${pageContext.request.contextPath}/logout" class="list-group-item">Déconnexion</a>
                <% } else { %>
                <a href="${pageContext.request.contextPath}/login" class="list-group-item">Connexion</a>
                <% } %>
            </div>
        </div>
    </div>
</div>

</body>
</html>
