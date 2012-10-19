<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" import="java.*"%>

<jsp:include page="../include/PageTop.jsp"/>

<div class="hero-unit centerPerso" style="width:50%">      
    <div class=status>		
        <p>Liste de contact</p>

        <form:form METHOD="POST" ACTION="add_addr.html">
            <div class="table centerPerso">
                <table>
                    <tr> <div class=titres>   
                        <td>Nom</td>
                        <td></td>
                        <td><div class=nom> <c:out value="${tmpCont.name}"/>  </div></td>
                        </tr>
                        <tr>
                            <td>Prenom</td>
                            <td></td>
                            <td><div class=prenom><c:out value="${tmpCont.surname}"/></div></td>
                        </tr>
                        <tr>
                            <td>eMail</td>
                            <td></td>
                            <td><div class=list_mail><c:out value="${tmpCont.emails}"/></div></td>
                        </tr>
                        <tr>
                            <td>Phone</td>
                            <td></td>
                            <td><div class=list_phone><c:out value="${tmpCont.phones}"/></div></td>
                        </tr>
                        <tr>
                            <td>Birthday</td>
                            <td></td>
                            <td><div class=birthday><c:out value="${tmpCont.birthday}"/></div></td>
                        </tr>
                </table>

                <table>
                    <tr> 
                        <td><button  class="btn  btn-success" type="submit">Ajouter adresse</button> 
                    </tr>
                </table>
            </div>
        </form:form>
    </div>
</div>



<jsp:include page="../include/PageBottom.jsp"/> 