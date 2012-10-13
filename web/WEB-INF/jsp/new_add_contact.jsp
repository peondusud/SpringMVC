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
        <form:form METHOD="POST" ACTION="add_contact_v.html">
            <div class=table>
                <table>
                    <tr> <div class=titres>
                        <td>   </td>   
                        <td>Nom</td>
                        <td>Prenom</td>
                        <td>eMail</td>
                        <td>Phone</td>
                        <td>Birthday</td>
                    </tr>
                    <tr>

                         <td><div class=Image><img src="http://www.nouvelles-persos.fr/auteurs/inconnu.gif" height="70" width="70"></div></td>
                        <td><div class=nom><input type="text" name="nom" size="10" value="" required="required" placeholder="Nom"></div></td>
                        <td><div class=prenom><input type="text" name="prenom" size="10" value="" required="required" placeholder="Prenom"></div></td>
                        <td><div class=list_mail><input type="email" name="mail" size="10" value="" required="mail" placeholder="Email"></div></td>
                        <td><div class=list_mail><input type="tel" name="phone" size="10" value="" required="tel" placeholder="Telephone"></div></td>
                        <td><div class=birthday><input type="int" name="birthday" size="10" value="" required="required" placeholder="Age"></div></td>
                    </tr>

                </table>
            </div>

            <div class=tab_button>
                <table>
                    <tr> 
                        <td> <input type="submit" value="Envoyer"></td>
                    </tr>
                </table>
            </div>
        </form:form>

        <div class=header>	
           <jsp:include page="footer.jsp"/> 
        </div>
        
    </body>
</html>