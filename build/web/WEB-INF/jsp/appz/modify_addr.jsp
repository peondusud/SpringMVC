<%@page import="com.esiea.core.Address"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<jsp:include page="../include/PageTop.jsp"/> 

<div class="container">
    <div class="hero-unit centerPerso" style="width:50%">

        <form:form METHOD="POST" ACTION="modify_addr_v.html">
            <div class=addr>


                <div class="table">
                    <table style="width:100%">
                        <tr><td>Type d'adresse
                                <div class="controls">
                                    <div class="btn-group centerPerso">
                                        <a class="btn btn-info btn-small dropdown-toggle" data-toggle="dropdown" href="#">
                                            <% Address add = (Address) request.getAttribute("addr");%> 

                                            <% add.getNickAddress();%> 
                                            <% if (add.getNickAddress().equals("Facturation")) {%>
                                            ${addr.nickAddress}
                                            <% } else {%>
                                            ${addr.nickAddress}                               
                                            <% }%>


                                            <span class="caret"></span>
                                        </a>
                                            <ul class="dropdown-menu">
                                            <% Boolean hasFacturation = (Boolean) request.getAttribute("hasFacturation");%> 
                                            <% Boolean isFacturationAddress = (Boolean) request.getAttribute("isFacturationAddress");%>

                                            <% if (hasFacturation && !isFacturationAddress) {%>

                                            <li><a  class=".livraison" onclick="Javascript:livraison();" >Livraison</a></li>

                                            <% } else {%>

                                            <li><a  class=".livraison" onclick="Javascript:livraison();" >Livraison</a></li>
                                            <li><a  class=".facturation" onclick="Javascript:facturation();">Facturation</a></li>      

                                            <% }%>
                                        </ul>
                                    </div>
                                </div>


                                <input type="hidden" id="nickaddress" name="nickaddress" value="${addr.nickAddress}">
                            </td></tr>    

                        <tr><td>
                                Nb rue : <input type="text" name="addr_nb" size="10" value="${addr.number}" pattern="[0-9]*" required="required" placeholder="n�">                
                            </td></tr>
                        <tr><td>
                                Rue : <input type="text" name="addr_rue" size="10" value="${addr.rue}" pattern="[A-Za-z\s]*" required="required" placeholder="Adresse">
                            </td></tr>
                        <tr><td>
                                CP : <input type="text" name="addr_cp" size="10" value="${addr.cp}" pattern="[0-9]*" required="required" placeholder="int">
                            </td></tr>
                        <tr><td>
                                Ville : <input type="text" name="addr_ville" size="10" value="${addr.ville}" pattern="[A-Za-z\s]*" required="required" placeholder="Ville"> 
                            </td></tr>
                        <tr><td>
                                Pays : <input type="text" name="addr_pays" size="10" value="${addr.pays}" pattern="[A-Za-z\s]*" required="required" placeholder="Pays">
                            </td></tr>
                        <tr><td>

                                <div class=tab_button>

                                    <button  class="btn btn-info" type="submit">Valider Modification</button>

                                </form:form>

                            </div>
                        </td></tr> 
                </table>



            </div>
        </div>
    </div>
</div>

<script src="js/jquery.js"></script>
<script>
   
    function facturation(){ 
        $("input#nickaddress").val("Facturation");
    }
    function livraison(){ 
        
        $("input#nickaddress").val("Livraison");
    }
</script>

<jsp:include page="../include/PageBottom.jsp"/> 



