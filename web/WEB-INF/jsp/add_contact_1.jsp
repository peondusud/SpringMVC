<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>

    <head>
        <meta charset="utf-8" />
        <title>Contact</title>
    </head>

    <body>
        
		<div class=menu>
		<li> <A HREF="hello.html">Index</A> </li>
		<li> <A HREF="contact.html">Liste de Contact</A></li>
		<li> <A HREF="selected_contact.html">Info Contact</A></li>
		<li> <A HREF="modif_contact.html">Modifier Contact</A></li>
		<li> <A HREF="suppr_contact.html">Supprimer Contact</A></li>	
		</div>
		
		<div class=status>		
		<p>Liste de contact</p>
		</div>		
                <form:form METHOD="POST" ACTION="addd.html">
		<div class=table>
		<table>
   <tr> <div class=titres>
	   <td>Image</td>   
       <td>Nom</td>
       <td>Prenom</td>
       <td>emails</td>
	   <td>phones</td>
	   <td>address</td>
	   <td>birthday</td>
	   <td>Notes</td></div>
   </tr>
   <tr>
	   <td><div class=Image><input type="text" name="image" size="10" value="Image_png"></div></td>
       <td><div class=nom><input type="text" name="nom" size="10" value="zenom"</div></td>
       <td><div class=prenom><input type="text" name="prenom" size="10" value="ezprenom"></div></td>
	   <td><div class=list_mail><li><input type="text" name="mail" size="10" value="test-1@mail.fr"></li>  </li></div></td>
	   <td><div class=list_mail><li><input type="text" name="phone" size="10" value="+33617574032"></li>  </li></div></td>
	   
	   <td><div class=list_addr><li><div class=addr><li>nickname<input type="text" name="addr_nick" size="10" value="default"></li> nb rue<input type="text" name="addr_nb" size="10" value="52">
	   rue :<input type="text" name="addr_rue" size="10" value="rue de toto"></li><li>CP :<input type="text" name="addr_cp" size="10" value=" 31780"> Ville :<input type="text" name="addr_ville" size="10" value="Castelginest"> </li><li> Pays :<input type="text" name="addr_pays" size="10" value="France"></li></li></div>
		<li><div class=addr><li>nickname<input type="text" name="addr_nick" size="10" value="nickname"></li> nb rue<input type="text" name="addr_nb" size="10" value="52">
	   rue :<input type="text" name="addr_rue" size="10" value="rue de toto"></li><li>CP :<input type="text" name="addr_cp" size="10" value=" 31780"> Ville :<input type="text" name="addr_ville" size="10" value="Castelginest"> </li><li> Pays :<input type="text" name="addr_pays" size="10" value="France"></li></li>
		</div>
		</td>
	   <td><div class=birthday><input type="text" name="birthday" size="10" value="09/04/90"></div></td>
	   <td><div class=notes><TEXTAREA rows="3" name="notes">NotesNotesNotesNotesNotesNotesNotes</TEXTAREA></div></td>
   </tr>

</table>
</div>

<div class=tab_button>
	<table>
	<tr> 
	  <td> <input type="submit" value="Envoyer"></td>
	</tr>
	</table>
</div>
</form:form>
</body>
</html>