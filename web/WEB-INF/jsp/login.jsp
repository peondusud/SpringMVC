<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
    <head>
        <title>Login Page</title>
    </head>
    <body>
        <h1>Please Log In </h1>

    <form:form method="post" action="login_v.html">
            Login
            <input type="text" name="username" value="" placeholder="USERNAME" required="required"/></br>
            </br>
            Password
            <input type="password" name="password" value="" required="required"/></br>
            <input type="submit" value="Ok" />
    </form:form>
    </body>
</html>
