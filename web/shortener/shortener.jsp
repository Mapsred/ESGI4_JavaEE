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

    <% if (null != request.getSession().getAttribute("email")) { %>
        <div class="android-content mdl-layout__content">
            <a name="top"></a>
            <div class="android-be-together-section">
                <div class="android-card-container mdl-grid">
                    <%@include file="/parts/flash.jsp" %>
                    <div class="mdl-cell mdl-cell--8-col mdl-cell--2-offset mdl-card mdl-shadow--3dp">
                        <div class="mdl-card__title">
                            <h4 class="mdl-card__title-text">Raccourcir une URL</h4>
                        </div>
                        <form method="post">
                            <div class="mdl-card__supporting-text">
                                <!-- URL -->
                                <div class="mdl-textfield mdl-js-textfield mdl-textfield--floating-label">
                                    <input class="mdl-textfield__input" type="text" name="url" id="url" required>
                                    <label class="mdl-textfield__label" for="url">URL à raccourcir</label>
                                </div>

                                <!-- MDP -->
                                <div>
                                    <label class="mdl-checkbox mdl-js-checkbox mdl-js-ripple-effect" for="secured">
                                        <input type="checkbox" id="secured" name="secured" class="mdl-checkbox__input">
                                        <span class="mdl-checkbox__label">Sécuriser avec un mot de passe</span>
                                    </label>
                                </div>
                                <div class="mdl-textfield mdl-js-textfield mdl-textfield--floating-label"
                                     style="display: none" id="passwordBlock">
                                    <input class="mdl-textfield__input" type="password" name="password" id="password">
                                    <label class="mdl-textfield__label" for="password">Mot de passe</label>
                                </div>

                                <!-- CAPTCHA -->
                                <div>
                                    <label class="mdl-checkbox mdl-js-checkbox mdl-js-ripple-effect" for="captcha">
                                        <input type="checkbox" id="captcha" name="captcha" class="mdl-checkbox__input">
                                        <span class="mdl-checkbox__label">Sécuriser avec un captcha</span>
                                    </label>
                                </div>

                                <!-- NB CLICK -->
                                <div>
                                    <label class="mdl-checkbox mdl-js-checkbox mdl-js-ripple-effect" for="click">
                                        <input type="checkbox" id="click" name="click" class="mdl-checkbox__input">
                                        <span class="mdl-checkbox__label">Nombre max de clique</span>
                                    </label>
                                </div>
                                <div class="mdl-textfield mdl-js-textfield mdl-textfield--floating-label"
                                     style="display: none" id="clickBlock">
                                    <input class="mdl-textfield__input" type="password" name="password" id="password">
                                    <label class="mdl-textfield__label" for="password">Nombre de clique max</label>
                                </div>

                                <!-- DATE RANGE -->
                                <div>
                                    <label class="mdl-checkbox mdl-js-checkbox mdl-js-ripple-effect" for="daterange">
                                        <input type="checkbox" id="daterange" name="daterange" class="mdl-checkbox__input">
                                        <span class="mdl-checkbox__label">Valable d'une date à une autre</span>
                                    </label>
                                </div>
                                <div class="mdl-textfield mdl-js-textfield mdl-textfield--floating-label"
                                     style="display: none" id="dateDebutBlock">
                                    <input class="mdl-textfield__input" type="password" name="password" id="password">
                                    <label class="mdl-textfield__label" for="password">Date debut</label>
                                </div>
                                <div class="mdl-textfield mdl-js-textfield mdl-textfield--floating-label"
                                     style="display: none" id="dateFinBlock">
                                    <input class="mdl-textfield__input" type="password" name="password" id="password">
                                    <label class="mdl-textfield__label" for="password">Date fin</label>
                                </div>

                                <!-- DATE MAX -->
                                <div>
                                    <label class="mdl-checkbox mdl-js-checkbox mdl-js-ripple-effect" for="datemax">
                                        <input type="checkbox" id="datemax" name="datemax" class="mdl-checkbox__input">
                                        <span class="mdl-checkbox__label">Valable jusqu'au</span>
                                    </label>
                                </div>
                                <div class="mdl-textfield mdl-js-textfield mdl-textfield--floating-label"
                                     style="display: none" id="dateMaxBlock">
                                    <input class="mdl-textfield__input" type="password" name="password" id="password">
                                    <label class="mdl-textfield__label" for="password">Date max</label>
                                </div>



                            </div>
                            <div class="mdl-card__actions mdl-typography--text-center">
                                <button type="submit" class="android-link mdl-button mdl-js-button mdl-typography--text-uppercase">
                                    Valider
                                </button>
                            </div>
                        </form>
                    </div>

                </div>
            </div>
    <% } else { %>
    <div class="android-content mdl-layout__content">
        <a name="top"></a>
        <div class="android-be-together-section">
            <div class="android-card-container mdl-grid">
                <%@include file="/parts/flash.jsp" %>
                <div class="mdl-cell mdl-cell--8-col mdl-cell--2-offset mdl-card mdl-shadow--3dp">
                    <div class="mdl-card__title">
                        <h4 class="mdl-card__title-text">Raccourcir une URL</h4>
                    </div>
                    <form method="post">
                        <div class="mdl-card__supporting-text">
                            <div class="mdl-textfield mdl-js-textfield mdl-textfield--floating-label">
                                <input class="mdl-textfield__input" type="text" name="url" id="url" required>
                                <label class="mdl-textfield__label" for="url">Lien</label>
                            </div>
                            <div>
                                <label class="mdl-checkbox mdl-js-checkbox mdl-js-ripple-effect" for="secured">
                                    <input type="checkbox" id="secured" name="secured" class="mdl-checkbox__input">
                                    <span class="mdl-checkbox__label">Sécuriser avec un mot de passe</span>
                                </label>
                            </div>
                            <div class="mdl-textfield mdl-js-textfield mdl-textfield--floating-label"
                                 style="display: none" id="passwordBlock">
                                <input class="mdl-textfield__input" type="password" name="password" id="password">
                                <label class="mdl-textfield__label" for="password">Mot de passe</label>
                            </div>

                            <div>
                                <a href="${pageContext.request.contextPath}/register">Créer un compte pour voir nos autres options disponibles</a>
                            </div>
                        </div>
                        <div class="mdl-card__actions mdl-typography--text-center">
                            <button type="submit" class="android-link mdl-button mdl-js-button mdl-typography--text-uppercase">
                                Valider
                            </button>
                        </div>
                    </form>
                </div>

            </div>
        </div>
    <% } %>

        <%@include file="/parts/footer.jsp" %>
    </div>
</div>
<%@include file="/parts/scripts.jsp" %>

</body>
</html>

