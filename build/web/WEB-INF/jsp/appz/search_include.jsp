
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>


<div class="navbar-inner">
    <form:form METHOD="POST" name="text_form" ACTION="search_find.html" class="navbar-search pull-left">
        Recherche  <input type="text"  class="search-query" required="required" name="stringPattern" pattern="[A-Za-z0-9]*" placeholder="Recherche"/>
    </form:form>
</div>
