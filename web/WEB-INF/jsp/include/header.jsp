<% Boolean isLogged = (Boolean) request.getAttribute("isLogged"); %> 
<% if (isLogged) { %>
    <%@ include file="header_Log.jsp" %>
<% } else { %>
    <%@ include file="header_NoLog.jsp" %>
<% } %>
