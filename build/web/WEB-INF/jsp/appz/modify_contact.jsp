<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<jsp:include page="../include/PageTop.jsp"/> 

<div class="hero-unit centerPerso" style="width: 60%">
    <div class="row">
        <div class="span4">
            <div class=status>		
                <p style="padding-top: 9%">Modifier Contact</p>
            </div>	
        </div>
        <div class="span2">
            <div class=Image><img src="http://www.nouvelles-persos.fr/auteurs/inconnu.gif" style="padding-bottom: 10%" height="80" width="80"></div>
        </div>
    </div>

    <form:form METHOD="POST" ACTION="modify_contact_v.html">
        <div class="row-fluid">
            <div class=table>
                <table style="width:100%">
                    <tr> <div class=titres>  
                        <td>Nom</td>
                        <td>Prenom</td>
                        <td>Date de naissance</td>
                        </tr>                              
                        <tr>
                            <td><div class=nom><input type="text" name="nom" value="<c:out value="${contact.name}"/>" required="required" pattern="[A-Za-z\s]*" placeholder="Nom"></div></td>
                            <td><div class=prenom><input type="text" name="prenom" value="<c:out value="${contact.surname}"/>" required="required" pattern="[A-Za-z\s]*" placeholder="Prenom"></div></td>
                            <td> 
                                <div id="dpYears" class="input-append date" data-date-viewmode="years" data-date-format="dd-mm-yyyy" data-date="${contact.birthday}">
                                    <input class="span2" style="width:50%" type="text" name="birthday" readonly="" value="${contact.birthday}" size="16">
                                    <span class="add-on">
                                        <i class="icon-calendar"></i>
                                    </span>
                                </div>
                            </td>
                        </tr>
                        <tr>
                            <td>eMail</td>
                            <td>Téléphone</td>
                            <td>Etat</td>
                        </tr>
                        <tr>
                            <td><div class=list_mail><input type="email" name="mail" value="<c:out value="${contact.emails}"/>" required="required" placeholder="Email"></div></td>
                            <td><div class=list_mail><input type="text" name="phone" value="<c:out value="${contact.phones}"/>" required="required"  pattern="[0-9]*" placeholder="Telephone"></div></td>
                            <td> <div class="btn-group" data-toggle="buttons-radio">
                                    
                                    <% Boolean boolActif = (Boolean) request.getAttribute("actif");%> 
                                    <% if (boolActif == false) {%>
                                    <button type="button" class="btn "  onclick="JavaScript:setActif()">Actif</button>
                                    <button type="button" class="btn active" onclick="JavaScript:setPassif()">Passif</button>
                                    <% } else {%>
                                    <button type="button" class="btn active"  onclick="JavaScript:setActif()">Actif</button>
                                    <button type="button" class="btn" onclick="JavaScript:setPassif()">Passif</button>



                                    <%}%>

                                    <input type="hidden" id="actif" name="actif"  value="${contact.actif}">
                                </div></td> 
                        </tr>      
                </table>
            </div>
        </div>

        <div class=tab_button>
            <table>
                <tr> 
                    <td>
                        <button class="btn btn-success" type="submit">Valider Modification</button>

                    </form:form>
                </td>
                <td> 
                    <form:form METHOD="POST" ACTION="modify_addrs.html">
                        <button class="btn btn-warning" type="submit">Modifier Adresse(s)</button>

                    </form:form>
                </td>
                <td>
                    <form:form METHOD="POST" ACTION="add_addr_from_modify.html">
                        <input type="hidden"  name="MODcontactID" value="<%request.getParameter("MODcontactID");%>">
                        <%request.getParameter("MODcontactID");%>
                        <button class="btn btn-info" type="submit">Ajouter une Adresse</button>
                    </form:form>
                </td>
            </tr>
        </table>
    </div>

</div>
</div>

<script src="js/prettify.js"></script>
<script src="js/jquery.js"></script>
<script src="js/bootstrap-datepicker.js"></script>
<script>
        
    function setActif(){ 
        $("input#actif").val("1");
        // document.getElementsByName("actif").value = '1';
    }
    function setPassif(){ 
        $("input#actif").val("0");
       // document.getElementsByName("actif").value = '0';
    }
    
    
    $(function(){
        window.prettyPrint && prettyPrint();
        $('#dp1').datepicker({
            format: 'mm-dd-yyyy'
        });
        $('#dp2').datepicker();
        $('#dp3').datepicker();
        $('#dp3').datepicker();
        $('#dpYears').datepicker();
        $('#dpMonths').datepicker();
			
			
        var startDate = new Date(2012,1,20);
        var endDate = new Date(2012,1,25);
        $('#dp4').datepicker()
        .on('changeDate', function(ev){
            if (ev.date.valueOf() > endDate.valueOf()){
                $('#alert').show().find('strong').text('The start date can not be greater then the end date');
            } else {
                $('#alert').hide();
                startDate = new Date(ev.date);
                $('#startDate').text($('#dp4').data('date'));
            }
            $('#dp4').datepicker('hide');
        });
        $('#dp5').datepicker()
        .on('changeDate', function(ev){
            if (ev.date.valueOf() < startDate.valueOf()){
                $('#alert').show().find('strong').text('The end date can not be less then the start date');
            } else {
                $('#alert').hide();
                endDate = new Date(ev.date);
                $('#endDate').text($('#dp5').data('date'));
            }
            $('#dp5').datepicker('hide');
        });
    });
</script>

<jsp:include page="../include/PageBottom.jsp"/> 