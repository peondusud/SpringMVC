<jsp:include page="include/PageTop.jsp"/> 

<div class="container centerPerso" style="width: 35%">
    <div class="hero-unit">

        <h2>Gestionnaire de contacts</h2>
        <div style="margin-top: 4%; margin-bottom: 2%">
            <h4>Ce site vous permet de gérer une liste de contacts en :</h4>
        </div>             
        <h6>
            <div class="row-fluid centerPerso" style="width: 100%">
                <div class="span2 offset2" style="text-align: left">
                    <li style="margin-bottom: 10%">
                        Se loggant
                    </li>
                    <li>
                        S'identifiant
                    </li>
                </div>

                <div class="span2 centerPerso">
                    <img src="http://www.crasc-dz.org/IMG/Image/fleche.png" width="50%" height="50%">
                </div>

                <div class="span4" style="text-align: left">
                    <li>
                        Ajoutant un nouveau contact
                    </li>
                    <li>
                        Modifiant un contact existant
                    </li>
                    <li>
                        Supprimant un contact existant
                    </li>
                </div>
            </div>

        </h6>

        <div class="row-fluid centerPerso" style="width: 100%; margin-top: 4%">
            <div class="span12 centerPerso">
                <p>
                    <a
                        <button HREF="list_show.html" class="btn btn-large btn-primary" type="button">Voir ma liste de contacts</button>
                    </a>
                </p>
            </div>
    </div>
</div>  

<jsp:include page="include/PageBottom.jsp"/> 

