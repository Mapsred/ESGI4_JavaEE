<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Breizhlink/Partner</title>
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
                        <h4 class="mdl-card__title-text">Breizhlink</h4>
                    </div>
                    <div class="mdl-card__actions">

                        <h4>5 bonnes raisons de devenir partenaire Breizhlink</h4>

                        <p>1. Associez-vous à l'acteur incontournable du marché de l'utilitaire, une solution quotidienne au cœur de leur IT.</p>
                        <p>2. Gagnez des prospects en étant référencé sur l'annuaire en ligne des partenaires Breizhlink.</p>
                        <p>3. Renforcez votre crédibilité auprès de vos clients en utilisant Breizhlink.</p>
                        <p>4. Nous sommes prêts à créez de nouvelles solutions ou étendre les fonctionnalités pour nos partenaires.</p>
                        <p>5. Bénéficier d'un contact privilégié avec les créateur de l'application : Mathieu François ou Evrard Axel.</p>
                        <p>Retrouvez nos partenaire ci-dessous : </p>

                        <img class="pub-ges" src="${pageContext.request.contextPath}/Resources/images/GES_logo.png">
                        <!-- <img class="pub-kam" src="${pageContext.request.contextPath}/Resources/images/oncle-kam.png"> -->

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
