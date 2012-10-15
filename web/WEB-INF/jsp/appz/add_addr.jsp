<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<jsp:include page="../include/PageTop.jsp"/> 

<div class="container">
    <div class="hero-unit">
        

        <form:form METHOD="POST" name="text_form" ACTION="add_addr_validator.html">
            <h1>Inscription</h1>
            <form class="form-horizontal">
                <div class="control-group">
                    <div class="row-fluid">

                        <label class="control-label" for="inputLogin">Numero</label>
                        <div class="controls">
                            <input type="text" required="required" name="addr_nb"/>
                        </div>

                        <label class="control-label" for="inputPassword">Rue</label>
                        <div class="controls">
                            <input type="text" required="required" name="addr_rue"/>
                        </div>

                        <label class="control-label" for="inputFirstName">Ville</label>
                        <div class="controls">
                            <input type="text" required="required" name="addr_ville"/>
                        </div>

                        <label class="control-label" for="inputLastName">Code Postal</label>
                        <div class="controls">
                            <input type="text" required="required" name="addr_cp"/>
                        </div>

                        <label class="control-label" for="inputPhone">Pays</label>
                        <div class="controls">
                            <input type="texte" required="required" name="addr_pays"/>
                        </div>

                        <div class=tab_button>
                            <table>
                                <tr> 
                                    <td> <input type="submit" value="Envoyer"></td>
                                </tr>
                            </table>
                        </div>

                    </div>
                </div>
            </form>
        </form:form>

    </div>
</div>


<jsp:include page="../include/PageBottom.jsp"/> 