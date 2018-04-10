<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Inscription</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/Resources/css/style.css">
</head>
<body>
<%@include file="/parts/navbar.jsp" %>
<main role="main" class="container">
    <form method="post" action="${pageContext.request.contextPath}/register" class="form">
        <%@include file="/parts/flash.jsp" %>
        <h1>Inscription !</h1>
        <div class="form-group">
            <input name="username" type="text" class="form-control" placeholder="Username">
        </div>
        <div class="form-group">
            <input name="password" type="password" class="form-control" placeholder="Password">
        </div>
        <div class="form-group">
            <input name="password_second" type="password" class="form-control" placeholder="Repeat the password">
        </div>
        <div class="form-group">
            <input type="submit" class="form-control" value="Register">
        </div>
    </form>
</main>

<script src="https://code.jquery.com/jquery-3.3.1.min.js"></script>
</body>
</html>
