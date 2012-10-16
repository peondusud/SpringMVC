<%@page import="com.esiea.core.Address"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<jsp:include page="../include/PageTop.jsp"/> 

<div class="container">
    <div class="hero-unit">

        <form:form METHOD="POST" ACTION="modify_addr_v.html">
            <div class=addr>

                nickname :
                <% Address add = (Address) request.getAttribute("addr");%> 
                <% add.getNickAddress();%> 
                <% if (add.getNickAddress().equals("Facturation")) {%>
                        ${addr.nickAddress}
                <% } else { %>
                ${addr.nickAddress}                               
                <% } %>

                <div class="controls">
                    <div class="btn-group">
                        <a class="btn btn-info btn-small dropdown-toggle" data-toggle="dropdown" href="#">
                            Type d'adresse
                            <span class="caret"></span>
                        </a>
                        <ul class="dropdown-menu">
                            <li><a  class=".livraison" onclick="Javascript:livraison();" >Livraison</a></li>
                            <li><a  class=".facturation" onclick="Javascript:facturation();">Facturation</a></li>
                        </ul>
                    </div>
                </div>


                <input type="hidden" id="nickaddress" name="nickaddress" value="">


                <br>
                Nb rue : <input type="int" name="addr_nb" size="10" value="${addr.number}" required="required" placeholder="n°"></br>
                Rue : <input type="text" name="addr_rue" size="10" value="${addr.rue}" required="required" placeholder="Adresse"></br>
                CP : <input type="int" name="addr_cp" size="10" value="${addr.cp}" required="required" placeholder="int"></br>
                Ville : <input type="text" name="addr_ville" size="10" value="${addr.ville}" required="required" placeholder="Ville"> </br>
                Pays : <input type="text" name="addr_pays" size="10" value="${addr.pays}" required="required" placeholder="Pays"></br>

            </div>
            <table>
                <tr> 
                    <td> <input type="submit" value="Envoyer"></td>
                </tr>
            </table>
        </form:form>
        <br>

    </div>
</div>

<script src="js/jquery.js"></script>
<script>
    function facturation(){ 
        document.getElementsByName("nickaddress").value = "Facturation";
    }
    function livraison(){ 
        document.getElementsByName("nickaddress").value = "Livraison";
     
    }
</script>

<jsp:include page="../include/PageBottom.jsp"/> 



