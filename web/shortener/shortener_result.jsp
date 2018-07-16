<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Raccourcir une URL</title>
    <%@include file="/parts/stylesheets.jsp" %>
</head>
<body>
<div class="mdl-layout mdl-js-layout mdl-layout--fixed-header">
    <%@include file="/parts/header.jsp" %>

    <div class="android-content mdl-layout__content">
        <a name="top"></a>
        <div class="android-be-together-section">
            <div class="android-card-container mdl-grid">
                <%@include file="/parts/flash.jsp" %>
                <div class="mdl-cell mdl-cell--8-col mdl-cell--2-offset mdl-card mdl-shadow--3dp">
                    <div class="mdl-card__title">
                        <h4 class="mdl-card__title-text">URL raccourcie</h4>
                    </div>
                    <div class="mdl-card__supporting-text">
                        <p>Votre URL raccourcie est :
                            <a href="<%= request.getAttribute("short_url") %>"><%= request.getAttribute("short_url") %>
                            </a>
                        </p>
                        <% if (request.getAttribute("short_password") != null) {%>
                            <p>
                                Votre URL est protégée par le mot de passe suivant :
                                <%= request.getAttribute("short_password") %>
                            </p>
                            <p>Vous pouvez partager le mot de passe en même temps que le lien : </p>
                            <p>
                                <a href="<%= request.getAttribute("full_url") %>">
                                    <%= request.getAttribute("full_url") %>
                                </a>
                            </p>
                        <%} %>
                        <div>
                            <a href="${pageContext.request.contextPath}/register">Créer un compte pour voir nos autres options disponibles</a>
                        </div>
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

