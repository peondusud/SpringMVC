<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<jsp:include page="../include/PageTop.jsp"/> 

<div class="container">
    <div class="hero-unit">

        <div class=status>		
            <p>Modify Contact</p>
        </div>		
        <form:form METHOD="POST" ACTION="modify_contact_v.html">
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
                            <td><div class=nom><input type="text" name="nom" size="10" value="<c:out value="${contact.name}"/>" required="required" placeholder="Nom"></div></td>
                            <td><div class=prenom><input type="text" name="prenom" size="10" value="<c:out value="${contact.surname}"/>" required="required" placeholder="Prenom"></div></td>
                            <td><div class=list_mail><input type="email" name="mail" size="10" value="<c:out value="${contact.emails}"/>" required="mail" placeholder="Email"></div></td>
                            <td><div class=list_mail><input type="tel" name="phone" size="10" value="<c:out value="${contact.phones}"/>" required="tel" placeholder="Telephone"></div></td>
                            <td> 
                                <div id="dpYears" class="input-append date" data-date-viewmode="years" data-date-format="dd-mm-yyyy" data-date="${contact.birthday}">
                                    <input class="span2" type="text" name="birthday" readonly="" value="${contact.birthday}" size="16">
                                    <span class="add-on">
                                        <i class="icon-calendar"></i>
                                    </span>
                                </div>


                            </td>
                        </tr>

                </table>
            </div>

            <div class=tab_button>
                <table>
                    <tr> 
                        <td> <input type="submit" value="Envoyer"></td>
                        </form:form>
                        <form:form METHOD="POST" ACTION="modify_addrs.html">
                        <td> <input type="submit" value="Modify address"></td>
                        </form:form>
                </tr>
            </table>
        </div>

    </div>
</div>
    
     <script src="js/prettify.js"></script>
    <script src="js/jquery.js"></script>
    <script src="js/bootstrap-datepicker.js"></script>
	<script>
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