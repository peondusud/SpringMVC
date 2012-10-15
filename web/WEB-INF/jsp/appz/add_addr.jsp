<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<jsp:include page="../include/PageTop.jsp"/> 

<div class="container">
    <div class="hero-unit">
        
        <div class="row-fluid">
            <div class="span6" style="background-color: activeborder">
                <div class="block">
                    <div class="centered">
                        <form:form METHOD="POST" name="text_form" ACTION="add_addr_validator.html">
                            <h1>Inscription</h1>
                            <form class="form-horizontal">
                                <div class="control-group">
                                    <div class="row-fluid">

                                        <label class="control-label" for="inputLogin">Login</label>
                                        <div class="controls">
                                            <input type="text" required="required" name="login"/>
                                        </div>

                                        <label class="control-label" for="inputPassword">Password</label>
                                        <div class="controls">
                                            <input type="password" required="required" name="password"/>
                                        </div>

                                        <label class="control-label" for="inputFirstName">First Name</label>
                                        <div class="controls">
                                            <input type="text" required="required" name="firstname"/>
                                        </div>

                                        <label class="control-label" for="inputLastName">Last Name</label>
                                        <div class="controls">
                                            <input type="text" required="required" name="lastname"/>
                                        </div>

                                        <label class="control-label" for="inputPhone">Phone</label>
                                        <div class="controls">
                                            <input type="tel" required="required" name="telephone"/>
                                        </div>

                                        <label class="control-label" for="inputEmail">Email</label>
                                        <div class="controls">
                                            <input type="email" required="required" name="email"/>
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
            </div>
        </div>
        
    </div>
</div>


<jsp:include page="../include/PageBottom.jsp"/> 