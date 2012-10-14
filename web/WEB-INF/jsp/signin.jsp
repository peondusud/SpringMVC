<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<jsp:include page="doctype.jsp"/> 
<html>
<jsp:include page="head.jsp"/> 
    <body>
        <jsp:include page="header.jsp"/> 
        <div class="block">
            <div class="centered">
                <form:form METHOD="POST" name="text_form" ACTION="signinc.html">
                    <h1>Inscription</h1>
                    <form class="form-horizontal">
                        <div class="control-group">
                            <label class="control-label" for="inputLogin">Login</label>
                            <div class="controls">
                                <input type="text" required="required" name="login" placeholder="LOGIN"/>
                            </div>
                            <label class="control-label" for="inputPassword">Password</label>
                            <div class="controls">
                                <input type="password" required="required" name="password" placeholder="PASSWORD"/>
                            </div>

                            <label class="control-label" for="inputFirstName">First Name</label>
                            <div class="controls">
                                <input type="text" required="required" name="firstname" placeholder="FIRSTNAME"/>
                            </div>

                            <label class="control-label" for="inputLastName">Last Name</label>
                            <div class="controls">
                                <input type="text" required="required" name="lastname" placeholder="LAST_NAME"/>
                            </div>

                            <label class="control-label" for="inputEmail">Email</label>
                            <div class="controls">
                                <input type="email" required="required" name="email" placeholder="EMAIL"/>
                            </div>

                            <label class="control-label" for="inputPhone">Phone</label>
                            <div class="controls">
                                <input type="tel" required="required" name="telephone" placeholder="TELEPHONE"/>
                            </div>
                            <div class="controls">
                                <button type="submit" class="btn">Sign In</button>
                            </div>
                        </div>
                    </form>
                </form:form>
            </div>
        </div>
    </body>
</html>
