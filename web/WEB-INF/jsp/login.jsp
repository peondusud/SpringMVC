<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
    <head>

        <title>Login Page</title>
        <link href="css/bootstrap.css" rel="stylesheet">
        <link href="css/css-perso.css" rel="stylesheet">
        <script src="http://code.jquery.com/jquery-latest.js"></script>
        <script src="js/bootstrap.js"></script>
    </head>

    <body>

        <jsp:include page="header.jsp"/> 

        <div class="block">
            <div class="centered">
                <form:form method="post" action="login_v.html">
                    <h1>Please LogIn</h1>
                    <form class="form-horizontal">
                        <div class="control-group">
                            <label class="control-label" for="inputUsername">Username</label>
                            <div class="controls">
                                <input type="text" name="username" value="" placeholder="USERNAME" required="required"/>
                            </div>
                            <label class="control-label" for="inputPassword">Password</label>
                            <div class="controls">
                                <input type="password" name="password" value="" required="required"/>
                            </div>
                            <div class="controls">
                                <button type="submit" class="btn">Ok</button>
                            </div>
                        </div>
                    </form>
                </form:form> 
            </div> 
        </div> 
    </body>
</html>