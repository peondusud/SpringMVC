/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package contact;

/**
 *
 * @author X
 */
public class Address {
  
  private String nom;
  private String prenom;
  private String number;
  private String rue;
  private String ville;
  private String cp;
  private String pays;
  private String nickAddress;

    public Address(String nom, String prenom, String number, String rue, String ville, String cp, String pays) {
        this.nom = nom;
        this.prenom = prenom;
        this.number = number;
        this.rue = rue;
        this.ville = ville;
        this.cp = cp;
        this.pays = pays;
        this.nickAddress="defaut";

    }

    public String getNickAddress() {
        return nickAddress;
    }

    public void setNickAddress(String nickAddress) {
        this.nickAddress = nickAddress;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String Nom) {
        this.nom = Nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String Prenom) {
        this.prenom = Prenom;
    }

    public String getRue() {
        return rue;
    }

    public void setRue(String rue) {
        this.rue = rue;
    }

    public String getVille() {
        return ville;
    }

    public void setVille(String ville) {
        this.ville = ville;
    }

    public String getCp() {
        return cp;
    }

    public void setCp(String cp) {
        this.cp = cp;
    }

    public String getPays() {
        return pays;
    }

    public void setPays(String pays) {
        this.pays = pays;
    }

    @Override
    public String toString() {
        return "Address{" + "Nom=" + nom + ", Prenom=" + prenom + ", number=" + number + ", rue=" + rue + ", Ville=" + ville + ", cp=" + cp + ", pays=" + pays + '}';
    }
    
     public void modifyAddress(String nom, String prenom, String number, String rue, String ville, String cp, String pays) {
        this.nom = nom;
        this.prenom = prenom;
        this.number = number;
        this.rue = rue;
        this.ville = ville;
        this.cp = cp;
        this.pays = pays;
    }
    
  
    
}
