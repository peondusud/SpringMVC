<jsp:include page="../include/PageTop.jsp"/> 

<div class="container">
    <div class="hero-unit">

        <div class=addr>
            <c:forEach items="${addrs}" var="addrs" varStatus="status">
                <table><tr><td>
                     Address_nickname : ${addrs.nickAddress} </br> ${addrs.number}, ${addrs.rue}</br> ${addrs.cp}, ${addrs.ville} </br> ${addrs.pays}
                        </td>
                        <td><A HREF="modify_addr.html?modaddrID=${status.count-1}">Modifier Contact</A></td>          
                    </tr></table>
            </c:forEach> 
        </div>
        <br>

    </div>
</div>

<jsp:include page="../include/PageBottom.jsp"/> 
