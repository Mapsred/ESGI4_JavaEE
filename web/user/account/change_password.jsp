<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Changer mon mot de passe</title>
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
                                Changer mon mot de passe
                            </h2>
                        </div>
                        <div class="p-l-20 p-r-20">
                            <%@include file="/parts/flash.jsp" %>

                            <form action="${pageContext.request.contextPath}/user/account/change_password" method="post">
                                <div class="mdl-textfield mdl-js-textfield mdl-textfield--floating-label textfield-demo">
                                    <input class="mdl-textfield__input" type="password" id="password_original" name="password_original"/>
                                    <label class="mdl-textfield__label" for="password_original">Ancien mot de passe</label>
                                </div>
                                <div class="mdl-textfield mdl-js-textfield mdl-textfield--floating-label textfield-demo">
                                    <input class="mdl-textfield__input" type="password" id="password_new" name="password_new"/>
                                    <label class="mdl-textfield__label" for="password_new">Nouveau mot de passe</label>
                                </div>
                                <div class="mdl-textfield mdl-js-textfield mdl-textfield--floating-label textfield-demo">
                                    <input class="mdl-textfield__input" type="password" id="password_new_confirm" name="password_new_confirm"/>
                                    <label class="mdl-textfield__label" for="password_new_confirm">Nouveau mot de passe</label>
                                </div>

                                <div class="m-t-20">
                                    <button type="submit"
                                            class="mdl-button mdl-js-button mdl-button--raised mdl-button--colored mdl-js-ripple-effect mdl-color--light-blue">
                                        Valider
                                    </button>
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
