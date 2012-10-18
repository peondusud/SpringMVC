<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<jsp:include page="../include/PageTop.jsp"/>

<div class="block">
    <div class="hero-unit centerPerso">
        <form:form METHOD="POST" name="text_form" ACTION="signinc.html">
            <h3>Inscription</h3>
            <br>
            <form class="form-horizontal">
                <div class="control-group">
                    <label class="control-label" for="inputLogin">Nom d'Utilisateur</label>
                    <div class="controls">
                        <input type="text" required="required" name="login" />
                    </div>
                    <label class="control-label" for="inputPassword">Mot de Passe</label>
                    <div class="controls">
                        <input type="password" required="required" name="password" />
                    </div>


                    <div class="controls">
                        <button type="submit" class="btn">S'enregistrer</button>
                    </div>
                </div>
            </form>
        </form:form>

    </div>
</div>

<jsp:include page="../include/PageBottom.jsp"/> 

