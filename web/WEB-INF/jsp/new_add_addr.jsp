<%-- 
    Document   : new_add_addr
    Created on : 13 oct. 2012, 19:17:23
    Author     : Xnl
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>

    <head>
        <meta charset="utf-8" />
        <title>Add Contact</title>
    </head>

    <body>

        <div class=header>	
            <jsp:include page="header.jsp"/> 
        </div>	
        <div class=status>		
            <p>Liste de contact</p>
        </div>		
        <form:form METHOD="POST" ACTION="add_addr_v.html">
            </br>

            <img src="http://www.autocadre.com/images/actualites/photos/lettre-type-changement-adresse.jpg" height="70" width="70">
            </br>
            nickname : <input type="text" name="addr_nick" size="10" value="" required="required" placeholder="Alias"></br>
            Nb rue : <input type="int" name="addr_nb" size="10" value="" required="required" placeholder="n°"></br>
            Rue : <input type="text" name="addr_rue" size="10" value="" required="required" placeholder="Adresse"></br>
            CP : <input type="int" name="addr_cp" size="10" value="" required="required" placeholder="int"></br>
            Ville : <input type="text" name="addr_ville" size="10" value="" required="required" placeholder="Ville"> </br>
            Pays : <input type="text" name="addr_pays" size="10" value="" required="required" placeholder="Pays"></br>

            <div class=tab_button>
                <table>
                    <tr> 
                        <td> <input type="submit" value="Envoyer"></td>
                    </tr>

                </form:form>

                <div class=header>	
                    <jsp:include page="footer.jsp"/> 
                </div>

                </body>
                </html>