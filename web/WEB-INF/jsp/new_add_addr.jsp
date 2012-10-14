<%-- 
    Document   : new_add_addr
    Created on : 13 oct. 2012, 19:17:23
    Author     : Xnl
--%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>

    <head>
        <meta charset="utf-8" />
        <title>Add Contact</title>
        <link href="css/bootstrap.css" rel="stylesheet">
        <link href="css/css-perso.css" rel="stylesheet">
        <script src="http://code.jquery.com/jquery-latest.js"></script>
        <script src="js/bootstrap.js"></script>
    </head>

    <body>

        <jsp:include page="header.jsp"/> 
        <%--
    <div class="row-fluid">
        <div class="span12" style="background-color: activeborder">
            Level 1 column
            <div class="row-fluid">
                <div class="span6" style="width: 300px">
                    <label class="control-label" for="inputPassword">Nom</label>
                    <div class="controls">
                        <input type="text" name="nom" size="10" value="" required="required" placeholder="Nom"/>
                    </div>

                        <label class="control-label" for="inputFirstName">Prénom</label>
                        <div class="controls">
                            <input type="text" name="prenom" size="10" value="" required="required" placeholder="Prenom">
                        </div>

                        <label class="control-label" for="inputLastName">Email</label>
                        <div class="controls">
                            <input type="email" name="mail" size="10" value="" required="mail" placeholder="Email">
                        </div>

                        <label class="control-label" for="inputEmail">Téléphone</label>
                        <div class="controls">
                            <input type="tel" name="phone" size="10" value="" required="tel" placeholder="Telephone">
                        </div>

                        <label class="control-label" for="inputPhone">Age</label>
                        <div class="controls">
                            <input type="int" name="birthday" size="10" value="" required="required" placeholder="Age">
                        </div>
                    </div>
                    <div class="span6"> <label class="control-label" for="inputLogin">Photo</label>
                        <div class="controls">
                            <img src="Django.jpg" height="70" width="70">
                        </div>


                        <label class="control-label" for="inputPhone">Commentaire</label>
                        <div class="controls">
                            <TEXTAREA cols='5' rows='1' name="notes" placeholder=Notes></TEXTAREA>
                        </div>
                    </div>
                </div>
            </div>
        </div>
        --%>


        <div class="row-fluid">
            <div class="span6" style="background-color: activeborder">
                <div class="block">
                    <div class="centered">
                        <form:form METHOD="POST" name="text_form" ACTION="signinc.html">
                            <h1>Inscription</h1>
                            <form class="form-horizontal">
                                <div class="control-group">
                                    <div class="row-fluid">
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
                                        <label class="control-label" for="inputPhone">Phone</label>
                                        <div class="controls">
                                            <input type="tel" required="required" name="telephone" placeholder="TELEPHONE"/>
                                        </div>


                                        <label class="control-label" for="inputEmail">Email</label>
                                        <div class="controls">
                                            <input type="email" required="required" name="email" placeholder="EMAIL"/>
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

        <%--
    <form:form METHOD="POST" ACTION="add_contact_v.html">
        <div class=table>
            <table>
                <tr> <div class=titres>
                    <td>   </td>   
                    <td>Nom</td>
                    <td>Prenom</td>
                    <td>eMail</td>
                    <td>Phone</td>
                    <td>Birthday</td>
                </tr>
                <tr>

                         <td><div class=Image><img src="http://www.nouvelles-persos.fr/auteurs/inconnu.gif" height="70" width="70"></div></td>
                        <td><div class=nom><input type="text" name="nom" size="10" value="" required="required" placeholder="Nom"></div></td>
                        <td><div class=prenom><input type="text" name="prenom" size="10" value="" required="required" placeholder="Prenom"></div></td>
                        <td><div class=list_mail><input type="email" name="mail" size="10" value="" required="mail" placeholder="Email"></div></td>
                        <td><div class=list_mail><input type="tel" name="phone" size="10" value="" required="tel" placeholder="Telephone"></div></td>
                        <td><div class=birthday><input type="int" name="birthday" size="10" value="" required="required" placeholder="Age"></div></td>
                    </tr>

                </table>
            </div>

            <div class=tab_button>
                <table>
                    <tr> 
                        <td> <input type="submit" value="Envoyer"></td>
                    </tr>
                </table>
            </div>
        </form:form>

        <div class=header>    
           <jsp:include page="footer.jsp"/> 
        </div>
        --%>
    </body>
</html>