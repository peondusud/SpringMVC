<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<div class="navbar navbar-inverse well-small">
    <div class="navbar-inner">
        <a class="btn btn-navbar" data-toggle="collapse" data-target=".nav-collapse">
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
        </a>
        <ul class="nav">
            <li class="">
                <A HREF="list_show.html">Liste de Contact</A>
            </li>
            <li class="">
                <A HREF="add_contact.html">Ajouter Contact</A>
            </li>
            <li class="">
                <A HREF="search.html">Recherche avancée</A>
            </li>

        </ul>
        <ul class="nav pull-right">
            <li class="">
                <div class="navbar-inner">
    <form:form METHOD="POST" name="text_form" ACTION="search_find.html" class="navbar-search pull-left">
       <input type="text"  class="search-query" required="required" name="stringPattern" placeholder="Recherche"/>
    </form:form>
</div>
             </li>
            <li class="">
                <A HREF="logout.html">Se Deconnecter</A>
            </li>
            <li class="">
                <A HREF="index.html">Acceuil</A>
            </li>
            <li class="">
                <A HREF="about_us.html">A Propos</A>
            </li>
        </ul>
    </div>
</div>
