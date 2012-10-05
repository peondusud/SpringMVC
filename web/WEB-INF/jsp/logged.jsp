<%-- 
    Document   : logged
    Created on : 5 oct. 2012, 20:50:06
    Author     : Xnl
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Hello World!</h1>
        <p> Vous etes loggez en tant que  <%= session.getAttribute( "username" ) %></p>
        <p> Votre mot de passe est <%= session.getAttribute( "password" ) %> </p>
        <form action="logout.html" >
            <input type="submit" value="LogOut" />
        </form>
        
    </body>
</html>