<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>

    <head>
        <meta charset="utf-8" />
        <title>Inscription</title>
    </head>

    <body>


        <div class=status>		
            <p>Inscription</p>
        </div>	

        <form:form METHOD="POST" name="text_form" ACTION="signinc.html">

            <table>
                <tr>
                    <td>Login</td>
                    <td><input type="text" required="required" name="login" placeholder="LOGIN"/></td>
                </tr>
                <tr>
                    <td>Password</td>
                    <td><input type="password" required="required" name="password" placeholder="PASSWORD"/></td>
                </tr>
                <tr>
                    <td>First Name</td>
                    <td><input type="text" required="required" name="firstname" placeholder="FIRSTNAME"/></td>
                </tr>
                <tr>
                    <td>Last Name</td>
                    <td><input type="text" required="required" name="lastname" placeholder="LAST_NAME"/></td>
                </tr>
                <tr>
                    <td>Email</td>
                    <td><input type="email" required="required" name="email" placeholder="EMAIL"/></td>
                </tr>
                <tr>
                    <td>Telephone</td>
                    <td><input type="tel" required="required" name="telephone" placeholder="TELEPHONE"/></td>
                </tr>
                <tr>
                    <td colspan="2">
                        <input type="submit" value="Sign In"/>
                    </td>
                </tr>
            </table> 


        </form:form>

    </body>
</html>
