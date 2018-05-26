<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<a name="top"></a>
<div class="android-header mdl-layout__header mdl-layout__header--waterfall">
    <div class="mdl-layout__header-row">
          <span class="android-title mdl-layout-title">
              <a href="${pageContext.request.contextPath}/">
                  <img class="android-logo-image" src="${pageContext.request.contextPath}/Resources/images/logo-esgi.png">
              </a>
          </span>
        <div class="android-header-spacer mdl-layout-spacer"></div>
            <span>
                <a href="${pageContext.request.contextPath}/">
                    <img class="pub-image" src="${pageContext.request.contextPath}/Resources/images/bannierepub.jpg">
                </a>
            </span>
        <!-- Add spacer, to align navigation to the right in desktop -->
        <div class="android-header-spacer mdl-layout-spacer"></div>
        <!-- Navigation -->
        <div class="android-navigation-container">
            <nav class="android-navigation mdl-navigation">

                <a href="${pageContext.request.contextPath}/"
                   class="mdl-navigation__link mdl-typography--text-uppercase">
                    Accueil
                </a>

                <a href="${pageContext.request.contextPath}/presentation"
                   class="mdl-navigation__link mdl-typography--text-uppercase">
                    Présentation
                </a>


                <a href="${pageContext.request.contextPath}/shortener"
                   class="mdl-navigation__link mdl-typography--text-uppercase">
                    Réduire une URL
                </a>

                <% if (null != request.getSession().getAttribute("email")) { %>
                <a href="${pageContext.request.contextPath}/user/account"
                   class="mdl-navigation__link mdl-typography--text-uppercase">
                    Mon compte
                </a>
                <a href="${pageContext.request.contextPath}/logout"
                   class="mdl-navigation__link mdl-typography--text-uppercase">
                    Déconnexion
                </a>
                <% } else { %>
                <a href="${pageContext.request.contextPath}/login"
                   class="mdl-navigation__link mdl-typography--text-uppercase">
                    Connexion
                </a>
                <a href="${pageContext.request.contextPath}/register"
                   class="mdl-navigation__link mdl-typography--text-uppercase">
                    Inscription
                </a>
                <% } %>
            </nav>
        </div>
        <span class="android-mobile-title mdl-layout-title">
              <a href="${pageContext.request.contextPath}/">
                  <img class="android-logo-image"
                       src="${pageContext.request.contextPath}/Resources/images/logo-esgi.png">
              </a>
          </span>
    </div>
</div>