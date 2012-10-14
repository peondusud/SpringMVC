
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>


<jsp:include page="doctype.jsp"/> 
<html>
    <jsp:include page="head.jsp"/> 
    <body>
        <jsp:include page="header.jsp"/> 
        <div class="container">
            <div class="hero-unit">

                <h1>		
                    Liste de contact
                </h1>
                <br>
                <div class=table>
                    <table>
                        <tr> <div class=titres>
                            <td>Nom</td>
                            <td>Prenom</td>
                            <td>Emails</td>
                            <td>Telephone</td>                    
                            <td>Date de Naissance</td>
                            <td>Adresse</td>
                            <td>Supprimer</td>
                            <td>Modifier</td>
                        </div>
                        </tr>
                        <c:set var="count" value="0" scope="page" />
                        <c:forEach items="${arrContact}" var="tableContact" varStatus="status">
                            <tr>
                                <td><div class=nom> ${tableContact.name}</div></td>
                                <td><div class=prenom> ${tableContact.surname}</div></td> 
                                <td><div class=list_mail>${tableContact.emails} </div></td>
                                <td><div class=list_phone> ${tableContact.phones} </div></td>
                                <td><div class=birthday>${tableContact.birthday}</div></td>
                                <td><A HREF="list_add.html?contactID=${count}"> Voir Adresse</A></td>
                                <td><A HREF="delete.html?deleteID=${count}">Supprimer Contact</A></td>
                                <td><A HREF="modify_contact.html?modID=${count}">Modifier Contact</A></td>
                            </tr>
                            <c:set var="count" value="${count + 1}" scope="page"/>
                        </c:forEach>
                    </table>
                </div>
            </div>
        </div>
    </body>
</html>

