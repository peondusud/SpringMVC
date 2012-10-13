<%-- 
    Document   : list_add
    Created on : 6 oct. 2012, 16:03:21
    Author     : Xnl
--%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>List Address</title>
    </head>
    <body>
        <div class=header>	
            <jsp:include page="header.jsp"/>
        </div>	


        <div class=addr>
            <c:forEach items="${addrs}" var="addrs" varStatus="status4">
                <li> Address_nickname:${addrs.nickAddress}</br> ${addrs.number} ${addrs.rue}</br> ${addrs.cp},${addrs.ville} </br> ${addrs.pays} </li>
            </c:forEach> 
        </div>
        </br>



        <div class=header>	
            <jsp:include page="footer.jsp"/> 
        </div>

    </body>
</html>
