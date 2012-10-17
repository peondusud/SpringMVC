<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<jsp:include page="../include/PageTop.jsp"/> 

<div class="hero-unit centerPerso" style="width: 65%">
    <c:forEach items="${addrs}" var="addrs" varStatus="status">

        <div class="table ">
            <table style="width: 100%">
                <tr style="text-align: center">
                    <td>Nickname</td>
                    <td>Adresse</td>
                    <td>CP</td>
                    <td>Ville</td>
                    <td>Pays</td>                    
                </tr>
                <tr><td>
                        ${addrs.nickAddress}  
                    </td>
                    <td>
                        ${addrs.number}, ${addrs.rue}
                    </td>

                    <td>
                        ${addrs.cp}

                    <td>
                        ${addrs.ville}
                    </td>
                    <td>
                        ${addrs.pays}
                    </td>
                    <td style="text-align: right">
                       <a <button HREF="modify_addr.html?modaddrID=${status.count-1}" class="btn btn-small btn-warning" type="button">Modifier Adresse</button>
          
                       </a>
                    </td>          
                </tr>
            </table>
        </div>

    </c:forEach> 


    <div class=tab_button>
        <table style="text-align: right">
            <tr>                     
                <form:form METHOD="POST" ACTION="add_addr_from_modify.html">
                    <td> 
                       
                    </td>
                    <td> 
                      
                    </td>
                    <td> 
                        <button  class="btn btn-info" type="submit">Ajouter address</button>
                    </td>
                </form:form>
            </tr>
        </table>
    </div>


</div>

<jsp:include page="../include/PageBottom.jsp"/> 
