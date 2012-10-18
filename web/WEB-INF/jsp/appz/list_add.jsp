<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<jsp:include page="../include/PageTop.jsp"/> 

    <div class="hero-unit centerPerso" style="width:60%">
        <h4>
            Liste d'Adresse(s)
        </h4>
        <div class=table >
            <table class="tablePerso">
                <tr> <div class=titres>
                    <td class="titrePerso">nickAdress</td>
                    <td class="titrePerso">N°</td>
                    <td class="titrePerso">Rue</td>
                    <td class="titrePerso">Code postal</td>
                    <td class="titrePerso">Ville</td>
                    <td class="titrePerso">Pays</td>
                </div>       
                <br>
                <c:set var="count" value="0" scope="page" />
                <c:forEach items="${addrs}" var="addrs" varStatus="status4">

                    <div class=addr>
                        <tr>
                            <td >${addrs.nickAddress} </td> 
                            
                            <td >${addrs.number} </td> 

                            <td>${addrs.rue}</td>

                            <td>${addrs.cp}</td>

                            <td>${addrs.ville}</td>

                            <td>${addrs.pays}</td>
                        </tr>
                        <c:set var="count" value="${count + 1}" scope="page"/>
                    </c:forEach> 
            </table>
        </div>
    </div>

<jsp:include page="../include/PageBottom.jsp"/> 
