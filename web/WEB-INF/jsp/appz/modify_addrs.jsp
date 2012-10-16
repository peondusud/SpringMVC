<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<jsp:include page="../include/PageTop.jsp"/> 

<div class="container">
    <div class="hero-unit">

        
             <c:forEach items="${addrs}" var="addrs" varStatus="status">
                <table><tr><td>
                     Address_nickname : ${addrs.nickAddress} </br> ${addrs.number}, ${addrs.rue}</br> ${addrs.cp}, ${addrs.ville} </br> ${addrs.pays}
                        </td>
                        <td><A  HREF="modify_addr.html?modaddrID=${status.count-1}" >Modifier Adresse</A></td>          
                    </tr></table>
            </c:forEach> 
        
            <div class=tab_button>
                <table>
                    <tr>                     
                        <form:form METHOD="POST" ACTION="add_addr_from_modify.html">
                        <td> <input type="submit" value="Ajouter address"></td>
                        </form:form>
                </tr>
            </table>
        </div>
        <br>

    </div>
</div>

<jsp:include page="../include/PageBottom.jsp"/> 
