<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<jsp:include page="../include/PageTop.jsp"/> 

<div class="container">
    <div class="hero-unit centerPerso" style="width: 40%">
        <h3 style="margin-bottom: 2%">Recherche avancée</h3>
        <h5>Saisir une valeur et sélectioner <i>Adresse(s)</i>  et/ou <i>Contact(s)</i></h5><br>
        <form:form METHOD="POST" name="text_form" ACTION="search_found.html">
            Recherche  <input type="text" required="required" pattern="[A-Za-z0-9\s]*" name="stringPattern"/>
            <div class="btn-toolbar">

                <p><h5> Addesse(s) <input type='checkbox' id='address' name='address'></h5></p>
                <p><h5>Contact(s) <input type='checkbox' id='contact' name='contact'></h5></p>
            </div>
            <div class="controls"  style="margin-top: 5%">
                <button  class="btn  btn-success btn-large" type="submit">Valider</button>
            </div>
        </form:form>
    </div>
</div>

<jsp:include page="../include/PageBottom.jsp"/> 
