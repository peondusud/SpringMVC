<jsp:include page="../include/PageTop.jsp"/> 

<div class="container">
    <div class="hero-unit">
        
        <form:form METHOD="POST" ACTION="modify_addr_validator.html">
            <div class=addr>
                nickname : <input type="text" name="addr_nick" size="10" value="${addr.nickAddress}" required="required" placeholder="Alias"></br>
                Nb rue : <input type="int" name="addr_nb" size="10" value="${addr.number}" required="required" placeholder="n�"></br>
                Rue : <input type="text" name="addr_rue" size="10" value="${addr.rue}" required="required" placeholder="Adresse"></br>
                CP : <input type="int" name="addr_cp" size="10" value="${addr.cp}" required="required" placeholder="int"></br>
                Ville : <input type="text" name="addr_ville" size="10" value="${addr.ville}" required="required" placeholder="Ville"> </br>
                Pays : <input type="text" name="addr_pays" size="10" value="${addr.pays}" required="required" placeholder="Pays"></br>

            </div>
            <table>
                <tr> 
                    <td> <input type="submit" value="Envoyer"></td>
                </tr>
            </table>
        </form:form>
        <br>
        
    </div>
</div>

<jsp:include page="../include/PageBottom.jsp"/> 


