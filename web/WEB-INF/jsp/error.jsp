<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<jsp:include page="doctype.jsp"/> 
<html>
    <jsp:include page="head.jsp"/> 
    <body>
        <jsp:include page="header.jsp"/> 
        <div class="hero-unit">
            <h1>ErroR</h1></br>
            <h2>${str}</h2>
            <br>
            <p>
                <a
                    <button HREF="index.html" class="btn btn-large btn-primary" type="button">Back to Home !</button>
                </a>
            </p>
        </div>
    </body>
</html>
