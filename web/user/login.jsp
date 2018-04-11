<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Connexion</title>
    <%@include file="/parts/stylesheets.jsp" %>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/Resources/css/login.css">
</head>
<body>
<%--<%@include file="/parts/navbar.jsp" %>--%>
<div class="demo-layout mdl-layout mdl-layout--fixed-header mdl-js-layout mdl-color--grey-100">
    <div class="demo-ribbon mdl-color--accent"></div>
    <main class="demo-main mdl-layout__content">
        <h2 class="t-center mdl-color-text--white text-shadow">Material Lite</h2>
        <a id="top"></a>
        <div class="demo-container mdl-grid">
            <div class="mdl-cell mdl-cell--4-col mdl-cell--hide-tablet mdl-cell--hide-phone"></div>
            <div class="demo-content mdl-color--white mdl-shadow--4dp content mdl-color-text--grey-800
            mdl-cell mdl-cell--4-col mdl-cell--12-col-tablet">

                <div class="mdl-card__title ">
                    <h2 class="mdl-card__title-text">
                        <i class="material-icons mdl-color-text--grey m-r-5 lh-13">account_circle</i>
                        Connexion
                    </h2>
                </div>
                <div class="p-l-20 p-r-20">
                    <%@include file="/parts/flash.jsp" %>

                    <form action="${pageContext.request.contextPath}/login" method="post">
                        <div class="mdl-textfield mdl-js-textfield mdl-textfield--floating-label textfield-demo">
                            <input class="mdl-textfield__input" type="text" id="username" name="username"/>
                            <label class="mdl-textfield__label" for="username">Pseudo</label>
                        </div>
                        <div class="mdl-textfield mdl-js-textfield mdl-textfield--floating-label textfield-demo">
                            <input class="mdl-textfield__input" type="password" id="password" name="password"/>
                            <label class="mdl-textfield__label" for="password">Mot de passe</label>
                        </div>

                        <div class="m-t-20">
                            <button type="submit"
                                    class="mdl-button mdl-js-button mdl-button--raised mdl-button--colored mdl-js-ripple-effect mdl-color--light-blue">
                                Se connecter
                            </button>
                            <a href="${pageContext.request.contextPath}/register" class="mdl-button mdl-js-button mdl-js-ripple-effect">
                                S'inscrire
                            </a>
                        </div>

                    </form>
                </div>


            </div>
        </div>
    </main>
</div>
<%@include file="/parts/scripts.jsp" %>

</body>
</html>
