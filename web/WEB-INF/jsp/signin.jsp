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

        <script type="text/javascript"> <!-- 
            function Blank_TextField_Validator()
            {
                // Check the value of the element named text_name from the form named text_form
                if (text_form.login.value == "" && text_form.password.value == "" && text_form.firstname.value == "" && 
                    text_form.lastname.value == "" && text_form.email.value == "" && text_form.telephone.value == "" )    {
                  
                    alert("Please fill in the text field.");
                    // Place the cursor on the field for revision
                    text_form.login.focus();
                    // return false to stop further processing
                    return (false);
                }
                // If text_name is not null continue processing
                return (true);
            }
            --> </script>

        <form:form METHOD="POST" name="text_form" ACTION="signinc.html">

            <table>
                <tr>
                    <td>Login</td>
                    <td><input type="text" name="login" /></td>
                </tr>
                <tr>
                    <td>Password</td>
                    <td><input type="text" name="password" /></td>
                </tr>
                <tr>
                    <td>First Name</td>
                    <td><input type="text" name="firstname" /></td>
                </tr>
                <tr>
                    <td>Last Name</td>
                    <td><input type="text" name="lastname" /></td>
                </tr>
                <tr>
                    <td>Email</td>
                    <td><input type="text" name="email" /></td>
                </tr>
                <tr>
                    <td>Telephone</td>
                    <td><input type="text" name="telephone" /></td>
                </tr>
                <tr>
                    <td colspan="2">
                        <input type="submit" value="Sign In" onsubmit="return Blank_TextField_Validator()"/>
                    </td>
                </tr>
            </table> 


        </form:form>

    </body>
</html>
