<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="UTF-8">
    <title>Title</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
    <link rel="stylesheet"
          href="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-datepicker/1.7.1/css/bootstrap-datepicker3.min.css"/>

</head>
<body>
<form method="post" class="form">
    <img src="Resources/images/logo-esgi.png" alt="esgi" style="max-width: 125px;">
    <div class="container">
        <%@include file="flash.jsp" %>
        <h1>Visite !</h1>
        <div class="form-group">
            <input name="nomEtudiant" type="text" class="form-control" placeholder="nom étudiant">
        </div>
        <div class="form-group">
            <input name="date" type="text" class="form-control datepicker" placeholder="date">
        </div>
        <div class="form-group">
            <input name="note" type="number" class="form-control" placeholder="note">
        </div>
        <div class="form-group">
            <input type="submit" class="form-control" value="Connect">
        </div>
    </div>
</form>

<script src="https://code.jquery.com/jquery-3.3.1.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-datepicker/1.7.1/js/bootstrap-datepicker.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-datepicker/1.7.1/locales/bootstrap-datepicker.fr.min.js"></script>
<script src="Resources/js/script.js"></script>

</body>
</html>
