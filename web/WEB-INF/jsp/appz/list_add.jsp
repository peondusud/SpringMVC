<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
	
<jsp:include page="../include/PageTop.jsp"/> 

<div class="container">
    <div class="hero-unit">


        <div class=addr>
            <c:forEach items="${addrs}" var="addrs" varStatus="status4">
                <li> Address_nickname:${addrs.nickAddress}</br> ${addrs.number} ${addrs.rue}</br> ${addrs.cp},${addrs.ville} </br> ${addrs.pays} </li>
            </c:forEach> 
        </div>
        <br>

    </div>
</div>
        
<jsp:include page="../include/PageBottom.jsp"/> 
