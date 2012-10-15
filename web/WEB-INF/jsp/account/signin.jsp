<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<jsp:include page="../include/PageTop.jsp"/>

<div class="block">
    <div class="centered">
        <div class="hero-unit">
            
            <form:form METHOD="POST" name="text_form" ACTION="signinc.html">
                <h1>Inscription</h1>
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

                        <label class="control-label" for="inputFirstName">Prenom</label>
                        <div class="controls">
                            <input type="text" required="required" name="firstname" />
                        </div>

                        <label class="control-label" for="inputLastName">Nom</label>
                        <div class="controls">
                            <input type="text" required="required" name="lastname" />
                        </div>

                        <label class="control-label" for="inputEmail">Email</label>
                        <div class="controls">
                            <input type="email" required="required" name="email" />
                        </div>

                        <label class="control-label" for="inputPhone">Telephone</label>
                        <div class="controls">
                            <input type="tel" required="required" name="telephone"/>
                        </div>
                        <div class="controls">
                            <button type="submit" class="btn">S'enregistrer</button>
                        </div>
                    </div>
                </form>
            </form:form>
                
        </div>
    </div>
</div>

<jsp:include page="../include/PageBottom.jsp"/> 

