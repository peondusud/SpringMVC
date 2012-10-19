<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<jsp:include page="../include/PageTop.jsp"/> 

        <div class="hero-unit centerPerso">
                <form:form method="post" action="login_v.html">
                    <h3>Formulaire d'identification</h3>
                        <form class="form-horizontal">
                            <div class="control-group">
                                    <label class="control-label" for="inputUsername">Nom d'Utilisateur</label>
                                    <div class="controls">
                                        <input type="text" name="username" value=""  required="required"/>
                                    </div>
                                    <label class="control-label" for="inputPassword">Mot de Passe</label>
                                    <div class="controls">
                                        <input type="password" name="password" value="" required="required"/>
                                    </div>
                                    <div class="controls">
                                        <button type="submit" class="btn">OK</button>
                                    </div>
                            </div>
                        </form>
                </form:form> 
            </div>



<jsp:include page="../include/PageBottom.jsp"/> 
