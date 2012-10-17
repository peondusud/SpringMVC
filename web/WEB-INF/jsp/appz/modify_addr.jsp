<%@page import="com.esiea.core.Address"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<jsp:include page="../include/PageTop.jsp"/> 

<div class="container">
    <div class="hero-unit centerPerso" style="width:50%">

        <form:form METHOD="POST" ACTION="modify_addr_v.html">
            <div class=addr>

                nickname :
                <% Address add = (Address) request.getAttribute("addr");%> 
                <% add.getNickAddress();%> 
                <% if (add.getNickAddress().equals("Facturation")) {%>
                ${addr.nickAddress}
                <% } else {%>
                ${addr.nickAddress}                               
                <% }%>
                <div class="table">
                    <table style="width:100%">
                        <tr><td>
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
                            </td></tr>    

                        <tr><td>
                                Nb rue : <input type="text" name="addr_nb" size="10" value="${addr.number}" required="required" placeholder="n°">                
                            </td></tr>
                        <tr><td>
                                Rue : <input type="text" name="addr_rue" size="10" value="${addr.rue}" required="required" placeholder="Adresse">
                            </td></tr>
                        <tr><td>
                                CP : <input type="text" name="addr_cp" size="10" value="${addr.cp}" required="required" placeholder="int">
                            </td></tr>
                        <tr><td>
                                Ville : <input type="text" name="addr_ville" size="10" value="${addr.ville}" required="required" placeholder="Ville"> 
                            </td></tr>
                        <tr><td>
                                Pays : <input type="text" name="addr_pays" size="10" value="${addr.pays}" required="required" placeholder="Pays">
                            </td></tr>

                    </table>
                    <div class=tab_button>
                        <table style="text-align: right">
                            <tr>                     
                                <form:form METHOD="POST" ACTION="add_addr_from_modify.html">
                                    <td> 

                                    </td>
                                    <td> 

                                    </td>
                                    <td> 
                                        <button  class="btn btn-info" type="submit">Valider Modification</button>
                                    </td>
                                </form:form>
                            </tr>
                        </table>
                    </div>
                </form:form>
                <br>

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



