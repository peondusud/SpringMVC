<%@page import="com.esiea.core.Address"%>
<%@page import="com.esiea.core.Contact"%>
<%@page import="java.util.ArrayList"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<jsp:include page="../include/PageTop.jsp"/> 

    <div class="hero-unit centerPerso" style="width: 50%">
<% ArrayList<Contact> intTtableContact = ((ArrayList<Contact>) request.getAttribute("arrContact")); %> 
<% ArrayList<Address> intAddrs = ((ArrayList<Address>) request.getAttribute("addrs")); %> 

  <% if(intTtableContact.size()==0 && intAddrs.size()==0){ %>
     <h5> Aucun contact & Aucune adresse trouvé</h5> 
      <% } 
        else { %>
        <% if(intTtableContact.size()==0){ %>
       <h5> Aucun contact trouvé</h5> 
        <% } 
        else { %>
            <div>
                <h4>Contact</h4>    
            <table>
                <table class=table>
                <tr class="titrePerso">
                    <td>Nom</td>
                    <td>Prenom</td>
                    <td>Emails</td>
                    <td>Telephone</td>                    
                    <td>Date de Naissance</td></tr>
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
                <h5> Aucune adresse trouvée</h5> 
        <% }
        else { %>
       <div class=table >
           <h4>Addresses</h4>
            <table class="tablePerso">
                  <tr class="titrePerso">
                    <td>N°</td>
                    <td>Rue</td>
                    <td>Code postal</td>
                    <td>Ville</td>
                    <td>Pays</td>      
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
                <% } }%> 
</div>


<jsp:include page="../include/PageBottom.jsp"/> 