<%@ page import="java.sql.ResultSet" %>
<%@ page import="java.sql.SQLException" %>
<%@ page import="utils.Manager" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Mon compte</title>
    <%@include file="/parts/stylesheets.jsp" %>
</head>
<body>
<div class="mdl-layout mdl-js-layout mdl-layout--fixed-header">
    <%@include file="/parts/header.jsp" %>

    <div class="android-content mdl-layout__content">
        <a name="top"></a>
        <div class="android-be-together-section mdl-typography--text-center">
            <div class="android-card-container mdl-grid">
                <%@include file="/parts/flash.jsp" %>

                <div class="mdl-cell mdl-cell--8-col mdl-cell--2-offset mdl-card mdl-shadow--3dp">
                    <div class="mdl-card__title">
                        <h4 class="mdl-card__title-text">Mes urls</h4>
                    </div>
                    <table id="linkTable">
                        <thead>
                        <tr>
                            <th>URLs Breizhlink</th>
                            <th>Vos URL Breizhlink</th>
                            <th>Date de création</th>
                            <th>Stats</th>
                        </tr>
                        </thead>
                        <tbody>
                        <% if (null != request.getAttribute("links")) {
                            try {
                                ResultSet visits = (ResultSet) request.getAttribute("links");
                                while (visits.next()) {
                                    String short_url = Manager.getCurrentUri(request) + "/shortener/visit/" + visits.getString(3);
                                    out.print("<tr>");
                                    out.print("<td> <a href='" + visits.getString(2) + "'>" + visits.getString(2) + "</a></td>");
                                    out.print("<td> <a href='" + short_url + "'>" + short_url + "</a></td>");
                                    out.print("<td>" + visits.getString(4) + "</td>");
                                    out.print("<td><a href='/user/account/stats/" + visits.getString(1) + "'>Statistiques</a></td>");
                                    out.print("</tr>");
                                }
                            } catch (SQLException e) {
                                e.printStackTrace();
                            }
                        }%>
                        </tbody>
                    </table>
                    <div class="mdl-card__supporting-text">

                    </div>
                </div>

            </div>
        </div>

        <%@include file="/parts/footer.jsp" %>
    </div>
</div>
<%@include file="/parts/scripts.jsp" %>

</body>
</html>
