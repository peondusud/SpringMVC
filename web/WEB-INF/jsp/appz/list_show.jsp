<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>


<jsp:include page="../include/PageTop.jsp"/>

<div class="container" style="width: 95%">
    <div class="hero-unit centered">

        <div class="row-fluid centered">
            <div class="span4 centered" style="padding: 23px">
                <h3>		
                    Liste de contact(s)
                </h3>
            </div>
            <div class="span1"   >

            </div>
            <div class="span1 ">

            </div>
            <div class="span2 ">

            </div>
            <div class="span2 ">

            </div>
            <div class="span2" style="padding: 5px">
                <img src="contacts.png" width="100px" height="100px"> 
            </div>


            <br>
            <div class="table centered">
                <table>
                    <tr> <div class=titres>
                        <td>Nom</td>
                        <td>Prenom</td>
                        <td>Emails</td>
                        <td>Telephone</td>                    
                        <td>Date de Naissance</td>
                        <td>Adresse</td>
                        <td>Modifier</td>
                        <td>Supprimer</td>
                    </div>

                    <br>
                    <c:set var="count" value="0" scope="page" />
                    <c:forEach items="${arrContact}" var="tableContact" varStatus="status">
                        <tr>
                            <td><div class=nom> ${tableContact.name}</div></td>
                            <td><div class=prenom> ${tableContact.surname}</div></td> 
                            <td><div class=list_mail>${tableContact.emails} </div></td>
                            <td><div class=list_phone> ${tableContact.phones} </div></td>
                            <td><div class=birthday>${tableContact.birthday}</div></td>
                            <td>
                                <a
                                    <button HREF="list_add.html?contactID=${count}" class="btn btn-small btn-primary" type="button"> Voir Adresse(s)</button>
                                </a>
                            </td>    
                            <td>
                                <a
                                    <button HREF="modify_contact.html?modID=${count}" class="btn btn-small btn-warning" type="button"> Modifier contact</button>
                                </a>  
                            </td>
                            <td>
                                <a
                                    <button HREF="delete.html?deleteID=${count}" class="btn btn-small btn-danger" type="button"> Supprimer contact</button>
                                </a>
                            </td> 
                        </tr>
                        <c:set var="count" value="${count + 1}" scope="page"/>
                    </c:forEach>
                </table>
            </div>

        </div>
    </div>
                
<jsp:include page="../include/PageBottom.jsp"/> 
                        
