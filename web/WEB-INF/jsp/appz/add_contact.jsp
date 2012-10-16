<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<jsp:include page="../include/PageTop.jsp"/> 

<div class="container">
    <div class="hero-unit">

        <div class=status>		
            <p>Ajouter un Contact</p>
        </div>

        <form:form METHOD="POST" ACTION="add_contact_validator.html">

            Nom : <div class=nom><input type="text" name="nom" size="10" value="" required="required" ></div>
            Prenom: <div class=prenom><input type="text" name="prenom" size="10" value="" required="required" ></div>
            Email: <div class=list_mail><input type="email" name="mail" size="10" value="" required="mail"></div>
            Telephone: <div class=list_mail><input type="tel" name="phone" size="10" value="" required="tel"></div>
            Date de Naissance :    

                <div id="dpYears" class="input-append date" data-date-viewmode="years" data-date-format="dd-mm-yyyy" data-date="12-02-1998">
                    <input class="span2" type="text" name="birthday" readonly="" value="12-02-2012" size="16">
                    <span class="add-on">
                        <i class="icon-calendar"></i>
                    </span>
                </div>
      Actif : 

            <div class=tab_button>
                <br>

                <input type="submit" value="Envoyer">

            </div>
        </form:form>

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