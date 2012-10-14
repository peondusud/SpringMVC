<jsp:include page="doctype.jsp"/> 
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
    <jsp:include page="head.jsp"/> 
    <body>
        <jsp:include page="header.jsp"/>
        <div class=status>		
            <p>Liste de contact</p>
        </div>		
        <div class=table>
            <table>
                <tr> <div class=titres>
                    <td>Image</td>   
                    <td>Nom</td>
                    <td>Prenom</td>
                    <td>emails</td>
                    <td>phones</td>                    
                    <td>birthday</td>
                    <td>address</td>
                    <td>Supprimer</td>
                    <td>Modifier</td>
                </div>
                </tr>
                <c:set var="count" value="0" scope="page" />
                <c:forEach items="${arrContact}" var="tableContact" varStatus="status">
                    <tr>
                        <td><div class=Image>Image_png</div></td>
                        <td><div class=nom> ${tableContact.name}</div></td>
                        <td><div class=prenom> ${tableContact.surname}</div></td> 
                        <td><div class=list_mail>${tableContact.emails} </div></td>
                        <td><div class=list_phone> ${tableContact.phones} </div></td>
                        <td><div class=birthday>${tableContact.brithday}</div></td>
                        <td><A HREF="list_add.html?contactID=${count}"> show address</A></td>
                        <td><A HREF="delete.html?deleteID=${count}">Supprimer Contact</A></td>
                        <td><A HREF="modify_contact.html?modID=${count}">Modifier Contact</A></td>
                    </tr>
                    <c:set var="count" value="${count + 1}" scope="page"/>
                </c:forEach>
            </table>
        </div>
    </body>
</html>

