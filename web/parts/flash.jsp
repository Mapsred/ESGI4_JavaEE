<% if (null != request.getSession().getAttribute("flash_success")) { %>
<div class="alert alert-success">
    <%=request.getSession().getAttribute("flash_success") %>
    <% request.getSession().removeAttribute("flash_success"); %>
</div>
<% } %>

<% if (null != request.getSession().getAttribute("flash_info")) { %>
<div class="alert alert-info">
    <%=request.getSession().getAttribute("flash_info") %>
    <% request.getSession().removeAttribute("flash_info"); %>
</div>
<% } %>

<% if (null != request.getSession().getAttribute("flash_warning")) { %>
<div class="alert alert-warning">
    <%=request.getSession().getAttribute("flash_warning") %>
    <% request.getSession().removeAttribute("flash_warning"); %>
</div>
<% } %>

<% if (null != request.getSession().getAttribute("flash_danger")) { %>
<div class="alert alert-danger">
    <%=request.getSession().getAttribute("flash_danger") %>
    <% request.getSession().removeAttribute("flash_danger"); %>
</div>
<% } %>
