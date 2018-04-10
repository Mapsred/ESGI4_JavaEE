<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<nav class="navbar navbar-expand-md navbar-dark fixed-top bg-dark">
    <a class="navbar-brand" href="#">
        <img src="${pageContext.request.contextPath}/Resources/images/logo-esgi.png" alt="esgi" class="esgi-logo">
    </a>
    <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarCollapse"
            aria-controls="navbarCollapse" aria-expanded="false" aria-label="Toggle navigation">
        <span class="navbar-toggler-icon"></span>
    </button>
    <div class="collapse navbar-collapse" id="navbarCollapse">

        <% String path = (String) request.getAttribute("javax.servlet.forward.request_uri"); %>

        <ul class="navbar-nav mr-auto">
            <li class="nav-item <%= path.equals("/") ? "active" : "" %>">
                <a href="${pageContext.request.contextPath}/" class="nav-link">
                    Home <span class="sr-only">(current)</span>
                </a>
            </li>
            <% if (null != request.getSession().getAttribute("username")) { %>
            <li class="nav-item">
                <a href="${pageContext.request.contextPath}/logout" class="nav-link">Déconnexion</a>
            </li>
            <% } else { %>
            <li class="nav-item <%= path.equals("/login") ? "active" : "" %>">
                <a href="${pageContext.request.contextPath}/login" class="nav-link">Connexion</a>
            </li>
            <li class="nav-item <%= path.equals("/register") ? "active" : "" %>">
                <a href="${pageContext.request.contextPath}/register" class="nav-link">Inscription</a>
            </li>
            <% } %>

        </ul>
    </div>
</nav>