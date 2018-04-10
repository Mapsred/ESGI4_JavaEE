<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Login</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css">
    <link rel="stylesheet" href="Resources/css/style.css">
</head>
<body>
<div class="container">
    <form method="post" action="${pageContext.request.contextPath}/login" class="form">
        <img src="Resources/images/logo-esgi.png" alt="esgi" style="max-width: 125px;">
        <%@include file="parts/flash.jsp" %>
        <h1>Connexion !</h1>
        <div class="form-group">
            <input name="username" type="text" class="form-control" placeholder="Username">
        </div>
        <div class="form-group">
            <input name="password" type="password" class="form-control" placeholder="Password">
        </div>
        <div class="form-group">
            <input type="submit" class="form-control" value="Connect">
        </div>
    </form>
</div>

<script src="https://code.jquery.com/jquery-3.3.1.min.js"></script>
</body>
</html>
