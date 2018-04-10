<%@ page import="java.sql.ResultSet" %>
<%@ page import="java.sql.SQLException" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Visites</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
</head>
<body>
<div class="container">
    <img src="${pageContext.request.contextPath}/Resources/images/logo-esgi.png" alt="esgi" style="max-width: 125px;">
    <%@include file="flash.jsp" %>
    <h1>Visites !</h1>
    <table class="table">
        <thead>
        <tr>
            <th>#</th>
            <th>Nom</th>
            <th>Note</th>
            <th>Date</th>
        </tr>
        </thead>
        <tbody>
        <% if (null != request.getAttribute("visits")) {
            try {
                ResultSet visits = (ResultSet) request.getAttribute("visits");
                while (visits.next()) {
                    out.print("<tr>");
                    out.print("<td>" + visits.getString(1) + "</td>");
                    out.print("<td>" + visits.getString(2) + "</td>");
                    out.print("<td>" + visits.getString(3) + "</td>");
                    out.print("<td>" + visits.getString(4) + "</td>");
                    out.print("<tr>");
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }%>
        </tbody>
    </table>
</div>

<script src="https://code.jquery.com/jquery-3.3.1.min.js"></script>
</body>
</html>
