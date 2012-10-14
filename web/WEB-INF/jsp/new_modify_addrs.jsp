<%-- 
    Document   : new_modify_addrs
    Created on : 14 oct. 2012, 11:46:11
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
          <META HTTP-EQUIV="CACHE-CONTROL" CONTENT="NO-CACHE">
        <META HTTP-EQUIV="Pragma" CONTENT="no-cache">
        <META HTTP-EQUIV="Expires" CONTENT="-1">    
        <title>Modify Address</title>
    </head>
    <body>
        <div class=header>	
            <jsp:include page="header.jsp"/>
        </div>	
</br>
</br>

        <div class=addr>
            <c:forEach items="${addrs}" var="addrs" varStatus="status">
                <table><tr><td>
               Address_nickname : ${addrs.nickAddress}</br> ${addrs.number}, ${addrs.rue}</br> ${addrs.cp}, ${addrs.ville} </br> ${addrs.pays}
               </td>
               <td><A HREF="modify_addr.html?modaddrID=${status.count-1}">Modifier Contact</A></td>
               </tr></table>
            </c:forEach> 
        </div>
        </br>

        <div class=header>	
            <jsp:include page="footer.jsp"/> 
        </div>

    </body>
</html>