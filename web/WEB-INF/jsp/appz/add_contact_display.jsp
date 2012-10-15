<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" import="java.*"%>

<jsp:include page="../include/PageTop.jsp"/>

<div class="container">
    <div class="hero-unit">
        
        <div class=status>		
            <p>Liste de contact</p>
        </div>		
        <form:form METHOD="POST" ACTION="add_addr.html">
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
                            <td><div class=nom> <c:out value="${tmpCont.name}"/>  </div></td>
                            <td><div class=prenom><c:out value="${tmpCont.surname}"/></div></td>
                            <td><div class=list_mail><c:out value="${tmpCont.emails}"/></div></td>
                            <td><div class=list_phone><c:out value="${tmpCont.phones}"/></div></td>
                            <td><div class=birthday><c:out value="${tmpCont.birthday}"/></div></td>
                        </tr>
                    
                </table>
            </div>
        
            <div class=tab_button>
                <table>
                    <tr> 
                        <td> <input type="submit" value="Ajouter adresse" onsubmit=""></td>
                    </tr>
                </table>
            </div>
        </form:form>
                    
    </div>
</div>

<jsp:include page="../include/PageBottom.jsp"/> 