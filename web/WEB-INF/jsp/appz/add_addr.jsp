<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<jsp:include page="../include/PageTop.jsp"/> 

<div class="hero-unit centerPerso">
    <form:form METHOD="POST" name="text_form" ACTION="add_addr_validator.html">
        <h3>Ajout d'une adresse</h3>
        <br>
        <form class="form-horizontal">
            <div class="control-group">
                <div class="row-fluid">

                    <div class="controls">
                        <div class="btn-group centerPerso">
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


                    <input type="hidden" id="nickaddress" name="nickaddress"  value="">





                    <br>
                    <label class="control-label" >Numero</label>
                    <div class="controls">
                        <input type="text" required="required" pattern="[0-9]*" name="addr_nb"/>
                    </div>

                    <label class="control-label" >Rue</label>
                    <div class="controls">
                        <input type="text" required="required" pattern="[A-Za-z\s]*" name="addr_rue"/>
                    </div>

                    <label class="control-label" >Ville</label>
                    <div class="controls">
                        <input type="text" required="required" pattern="[A-Za-z\s]*" name="addr_ville"/>
                    </div>

                    <label class="control-label" >Code Postal</label>
                    <div class="controls">
                        <input type="text" required="required" pattern="[0-9]*" name="addr_cp"/>
                    </div>

                    <label class="control-label" >Pays</label>
                    <div class="controls">
                        <input type="text" required="required" pattern="[A-Za-z\s]*" name="addr_pays"/>
                    </div>
                    <label class="control-label" ></label>
                    <div class="controls">

                        <button  class="btn  btn-success" type="submit">Valider</button>
                    </div>
                </div>
            </div>
        </form>
    </form:form>
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