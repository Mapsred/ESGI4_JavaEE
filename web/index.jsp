<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="UTF-8">
    <title>Title</title>
    <%@include file="/parts/stylesheets.jsp" %>
</head>
<body>
<div class="mdl-layout mdl-js-layout mdl-layout--fixed-header">

    <div class="android-header mdl-layout__header mdl-layout__header--waterfall">
        <div class="mdl-layout__header-row">
          <span class="android-title mdl-layout-title">
            <img class="android-logo-image" src="${pageContext.request.contextPath}/Resources/images/logo-esgi.png">
          </span>
            <!-- Add spacer, to align navigation to the right in desktop -->
            <div class="android-header-spacer mdl-layout-spacer"></div>
            <!-- Navigation -->
            <div class="android-navigation-container">
                <nav class="android-navigation mdl-navigation">
                    <a class="mdl-navigation__link mdl-typography--text-uppercase" href="">Phones</a>
                    <a class="mdl-navigation__link mdl-typography--text-uppercase" href="">Tablets</a>
                </nav>
            </div>
            <span class="android-mobile-title mdl-layout-title">
            <img class="android-logo-image" src="${pageContext.request.contextPath}/Resources/images/logo-esgi.png">
          </span>
        </div>
    </div>

    <div class="android-content mdl-layout__content">
        <a name="top"></a>
        <div class="android-be-together-section mdl-typography--text-center">
            <div class="logo-font android-slogan">be together. not the same.</div>
            <div class="logo-font android-sub-slogan">welcome to android... be yourself. do your thing. see what's going
                on.
            </div>
        </div>

        <footer class="android-footer mdl-mega-footer">
            <div class="mdl-mega-footer--top-section">
                <div class="mdl-mega-footer--right-section">
                    <a class="mdl-typography--font-light" href="#top">
                        Retour en haut
                        <i class="material-icons">expand_less</i>
                    </a>
                </div>
            </div>

            <div class="mdl-mega-footer--middle-section">
                <p class="mdl-typography--font-light">Some features and devices may not be available in all areas</p>
            </div>
        </footer>
    </div>
</div>
<%@include file="/parts/scripts.jsp" %>

</body>
</html>
