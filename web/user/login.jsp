<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Breizhlink/Login</title>
    <%@include file="/parts/stylesheets.jsp" %>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/Resources/css/login.css">
</head>
<body>
<div class="mdl-layout mdl-js-layout mdl-layout--fixed-header">
    <%@include file="/parts/header.jsp" %>

    <div class="android-content mdl-layout__content">
        <div class="android-be-together-section mdl-typography--text-center">
            <div class="demo-ribbon mdl-color--accent"></div>
            <main class="demo-main mdl-layout__content">
                <h2 class="t-center mdl-color-text--white text-shadow">Breizhlink</h2>
                <a id="top"></a>
                <div class="demo-container mdl-grid">
                    <div class="mdl-cell mdl-cell--4-col mdl-cell--hide-tablet mdl-cell--hide-phone"></div>
                    <div class="mdl-color--white mdl-shadow--4dp content mdl-color-text--grey-800 mdl-cell--12-col-tablet">

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
                                    <input class="mdl-textfield__input" type="text" id="email" name="email"/>
                                    <label class="mdl-textfield__label" for="email">Email</label>
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
                                    <a href="${pageContext.request.contextPath}/register"
                                       class="mdl-button mdl-js-button mdl-js-ripple-effect">
                                        S'inscrire
                                    </a>
                                </div>

                            </form>
                        </div>


                    </div>
                </div>
            </main>
        </div>

        <%@include file="/parts/footer.jsp" %>
    </div>
</div>
<%@include file="/parts/scripts.jsp" %>

</body>
</html>
