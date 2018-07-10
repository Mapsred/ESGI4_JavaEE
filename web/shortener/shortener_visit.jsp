<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Visiter une URL</title>
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
                        <p>Vous essayez d'accéder à l'url suivante :
                            <a href="<%= request.getAttribute("url") %>">
                                <%= request.getAttribute("url") %>
                            </a>
                        </p>
                        <% String password = (String) request.getAttribute("password"); %>
                        <% if (null != password) {%>
                        <p>Cependant elle est protégée par un mot de passe, veuillez le rentrer ci-dessous :</p>
                        <form method="post">
                            <div class="mdl-textfield mdl-js-textfield mdl-textfield--floating-label textfield-demo">
                                <input class="mdl-textfield__input" type="password" id="password" name="password"/>
                                <label class="mdl-textfield__label" for="password">Mot de passe</label>
                            </div>

                            <div class="m-t-20">
                                <button type="submit"
                                        class="mdl-button mdl-js-button mdl-button--raised mdl-button--colored mdl-js-ripple-effect mdl-color--light-blue">
                                    Envoyer
                                </button>
                            </div>
                        </form>

                        <%} %>
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

