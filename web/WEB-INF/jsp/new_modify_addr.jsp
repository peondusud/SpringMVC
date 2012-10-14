<%-- 
    Document   : new_modify
    Created on : 13 oct. 2012, 21:21:33
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
        <title>Modify Address</title>
    </head>
    <body>
        <div class=header>	
            <jsp:include page="header.jsp"/>
        </div>	


        <div class=addr>
            nickname : <input type="text" name="addr_nick" size="10" value="${addr.nickAddress}" required="required" placeholder="Alias"></br>
            Nb rue : <input type="int" name="addr_nb" size="10" value="${addr.number}" required="required" placeholder="n°"></br>
            Rue : <input type="text" name="addr_rue" size="10" value="${addr.rue}" required="required" placeholder="Adresse"></br>
            CP : <input type="int" name="addr_cp" size="10" value="${addr.cp}" required="required" placeholder="int"></br>
            Ville : <input type="text" name="addr_ville" size="10" value="${addr.ville}" required="required" placeholder="Ville"> </br>
            Pays : <input type="text" name="addr_pays" size="10" value="${addr.pays}" required="required" placeholder="Pays"></br>
            
        </div>
        </br>



        <div class=header>	
            <jsp:include page="footer.jsp"/> 
        </div>

    </body>
</html>

