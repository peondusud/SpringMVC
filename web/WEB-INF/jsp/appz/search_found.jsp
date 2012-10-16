<%@page import="com.esiea.core.Address"%>
<%@page import="com.esiea.core.Contact"%>
<%@page import="java.util.ArrayList"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<jsp:include page="../include/PageTop.jsp"/> 

<div class="container" style="width: 95%">
    <div class="hero-unit centered">
<% ArrayList<Contact> intTtableContact = ((ArrayList<Contact>) request.getAttribute("arrContact")); %> 
<% ArrayList<Address> intAddrs = ((ArrayList<Address>) request.getAttribute("addrs")); %> 
        <% if(intTtableContact.size()==0){ %>
       <h6> No contact found</h6> 
        <% } 
        else { %>
            <div>
                <h6>Contact</h6>    
            <table>
                <tr> <div class=titres>
                    <td>Nom</td>
                    <td>Prenom</td>
                    <td>Emails</td>
                    <td>Telephone</td>                    
                    <td>Date de Naissance</td>
                </div>

                <br>
                <c:forEach items="${arrContact}" var="tableContact" varStatus="status">
                    <tr>
                        <td><div class=nom> ${tableContact.name}</div></td>
                        <td><div class=prenom> ${tableContact.surname}</div></td> 
                        <td><div class=list_mail>${tableContact.emails} </div></td>
                        <td><div class=list_phone> ${tableContact.phones} </div></td>
                        <td><div class=birthday>${tableContact.birthday}</div></td>  
                    </tr>
                </c:forEach>
            </table>
        </div>
            <% } 
          if(intAddrs.size()==0){ %>
                <h6> No adresses found</h6> 
        <% }
        else { %>
       <div class=table >
           <h6>Addresses</h6>
            <table class="tablePerso">
                  <tr> <div class=titres>
                    <td class="titrePerso">N°</td>
                    <td class="titrePerso">Rue</td>
                    <td class="titrePerso">Code postal</td>
                    <td class="titrePerso">Ville</td>
                    <td class="titrePerso">Pays</td>
                </div>       
                <br>
                <c:forEach items="${addrs}" var="addrs" varStatus="status4">
                    
                        <div class=addr>
                            <tr>
                            <td >${addrs.number} </td> 

                                <td>${addrs.rue}</td>

                                <td>${addrs.cp}</td>

                                <td>${addrs.ville}</td>

                                <td>${addrs.pays}</td>
                            </tr>
                </c:forEach> 
            </table>
        </div>
                <% } %>
        
</div>
</div>


<jsp:include page="../include/PageBottom.jsp"/> 