<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
    <head>
        <meta charset="utf-8" />
        <title>Modifier  contact</title>
    </head>

    <body>
        
		<div class=menu>
		<li> <A HREF="index.html">Index</A> </li>
		<li> <A HREF="list.html">Liste de Contact</A></li>
		<li> <A HREF="selected_contact.html">Info Contact</A></li>
		<li> <A HREF="modif_contact.html">Modifier Contact</A></li>
		<li> <A HREF="suppr_contact.html">Supprimer Contact</A></li>	
		</div>
		
		<div class=status>		
		<p>Modifier  contact</p>
		</div>		
		
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
	   <td><div class=Image>Image_png</div></td>
       <td><div class=nom> ${contact.nom}</div></td>
       <td><div class=prenom> ${contact.prenom}</div></td>
	   <td><div class=list_mail>
                    <c:forEach items="${contact.emails}" var="emails" varStatus="status2">
                   <li> ${emails}</li>
                    </c:forEach> 
                    </div></td>
                    
	   <td><div class=list_phone>
                   <c:forEach items="${contact.phones}" var="phones" varStatus="status3">
                   <li> ${phones}</li>
                    </c:forEach> 
                    </div></td>
                    
           <td><div class=addr>
                    <c:forEach items="${contact.addrs}" var="addrs" varStatus="status4">
                   <li>Address_nickname:${addrs.nickAddress}</p> ${addrs.number} ${addrs.rue}</p> ${addrs.cp},${addrs.ville} </p> ${addrs.pays} </li>
                    </c:forEach> 
                    </div></td>
	   <td><div class=birthday>${contact.brithday}</div></td>
	   <td><div class=notes>NotesNOTESnoTESnotes</div></td>
   </tr>


</table>
</div>
</body>
</html>