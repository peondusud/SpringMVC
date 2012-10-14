<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Welcome to Spring Web MVC project</title>
        <link href="css/bootstrap.css" rel="stylesheet">
        <link href="css/css-perso.css" rel="stylesheet">
        <script src="http://code.jquery.com/jquery-latest.js"></script>
        <script src="js/bootstrap.js"></script>
    </head>

    <body>
        <jsp:include page="header.jsp"/> 
        
        <div class="container">
        <div class="hero-unit">
            <h1>Gestionnaire de contacts</h1>
            <p>Tagline</p>
            <p>
                <a
                    <button HREF="list.html" class="btn btn-large btn-primary" type="button">List</button>

                </a>
            </p>
        </div>
            </div>  
        <%--<jsp:include page="footer.jsp"/> --%>
            
            <div class="footerPerso">
    <p> Dev By petiois, peondusud, camille </p>
</div>
    </body>
</html>
