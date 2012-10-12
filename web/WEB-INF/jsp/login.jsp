<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<html>
    <head>
        <title>Login Page</title>
    </head>
    <body>
        <h1>Please Log In </h1>

    <form:form method="get" action="login.html">
            Login
            <input type="text" name="username" value="" placeholder="USERNAME" required="required"/></br>
            </br>
            Password
            <input type="password" name="password" value="" required="required"/></br>
            <input type="submit" value="Ok" />
    </form:form>
    </body>
</html>
