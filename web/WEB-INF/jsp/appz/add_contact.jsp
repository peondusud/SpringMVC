<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<jsp:include page="../include/PageTop.jsp"/> 

<div class="container">
    <div class="hero-unit">

        <div class=status>		
            <p>Ajouter un Contact</p>
        </div>

        <form:form METHOD="POST" ACTION="add_contact_validator.html">

            Nom : <div class=nom><input type="text" name="nom" size="10" value="" required="required" ></div>
            Prenom: <div class=prenom><input type="text" name="prenom" size="10" value="" required="required" ></div>
            Email: <div class=list_mail><input type="email" name="mail" size="10" value="" required="mail" ></div>
            Telephone: <div class=list_mail><input type="tel" name="phone" size="10" value="" required="tel" ></div>
            Date de Naissance :<div class=birthday><input type="int" name="birthday" size="10" value="" required="required" ></div>
            Actif : 

            <div class=tab_button>
                <br>

                <input type="submit" value="Envoyer">

            </div>
        </form:form>
            
    </div>
</div>

<jsp:include page="../include/PageBottom.jsp"/> 