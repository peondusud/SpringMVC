<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<jsp:include page="../include/PageTop.jsp"/> 
       
        <div class="container">
    <div class="hero-unit">
    <h1>Search!</h1>

        <form:form METHOD="POST" name="text_form" ACTION="search_find.html">


            Recherche  <input type="text" required="required" name="stringPattern"/>


        </form:form>
    </div>
</div>

<jsp:include page="../include/PageBottom.jsp"/> 
