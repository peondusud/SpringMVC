

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
    <head>
        <meta charset="utf-8" />
        <title>Liste de Contact</title>
    </head>

    <body>

        <div class=menu>
            <li> <A HREF="index.html">Index</A> </li>
            <li> <A HREF="list.html">Liste de Contact</A></li>
            <li> <A HREF="add_contact2.html">Ajouter Contact</A></li>
            <li> <A HREF="modif_contact.html">Modifier Contact</A></li>
            <li> <A HREF="suppr_contact.html">Supprimer Contact</A></li>	
        </div>

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
                    <td>address</td>
                    <td>birthday</td>
                    <td>Notes</td>
                    <td>Supprimer</td>
                    <td>Modifier</td>
                </div>
                </tr>
                <c:set var="count" value="0" scope="page" />

                <c:forEach items="${arrContactMan.arrContact}" var="arrContact" varStatus="status">
                    <tr>
                        <td><div class=Image>Image_png</div></td>
                        <td><div class=nom> ${arrContact.nom}</div></td>
                        <td><div class=prenom> ${arrContact.prenom}</div></td>                        <td><div class=list_mail>
                                <c:forEach items="${arrContact.emails}" var="emails" varStatus="status2">
                                    <li> ${emails}</li>
                                </c:forEach> 
                            </div></td>
                            
                        <td><div class=list_phone>
                                <c:forEach items="${arrContact.phones}" var="phones" varStatus="status3">
                                    <li> ${phones}</li>
                                </c:forEach> 
                            </div></td>
                            
                       <td><div class=addr>
                                <c:forEach items="${arrContact.addrs}" var="addrs" varStatus="status4">
                                    <li>Address_nickname:${addrs.nickAddress}</p> ${addrs.number} ${addrs.rue}</p> ${addrs.cp},${addrs.ville} </p> ${addrs.pays} </li>
                               </c:forEach> 
                            </div></td>
                            <td><div class=birthday>${arrContact.brithday}</div></td>
                            <td><div class=notes>NotesNOTESnoTESnotes</div></td>
                        <td><A HREF="delete.html?deleteID=${count}">Supprimer Contact</A></td>
                        <td><A HREF="modify.html?modID=${count}">modifier Contact</A></td>
                    </tr>
                    <c:set var="count" value="${count + 1}" scope="page"/>

                </c:forEach>

            </table>
        </div>
    </body>
</html>
