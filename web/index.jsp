<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="UTF-8">
    <title>Title</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css">
    <link rel="stylesheet" href="Resources/css/style.css">
</head>
<body>
<%@include file="parts/navbar.jsp" %>
<main role="main" class="container">
    <%@include file="parts/flash.jsp" %>
    <h1>Accueil !</h1>
    <div class="panel panel-default">
        <div class="panel-body">
            <div class="list-group">
                <a href="${pageContext.request.contextPath}/" class="list-group-item">Accueil</a>
                <% if (null != request.getSession().getAttribute("username")) { %>
                <a href="${pageContext.request.contextPath}/logout" class="list-group-item">Déconnexion</a>
                <% } else { %>
                <a href="${pageContext.request.contextPath}/login" class="list-group-item">Connexion</a>
                <% } %>
            </div>
        </div>
    </div>
</main>

</body>
</html>