<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<jsp:include page="PageTop.jsp"/> 

<div class="container">
    <div class="centered">
        <div class="hero-unit">
            <div class="centered">
                <form:form method="post" action="login_v.html">
                    <h1>Formulaire d'identification</h1>
                    <div class="centered">
                        <form class="form-horizontal">

                            <div class="control-group">
                                <div class="centered">
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
                            </div>
                        </form>
                    </div> 
                </form:form> 
            </div> 
        </div>
    </div>
</div>


<jsp:include page="PageBottom.jsp"/> 
