/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.peondusud.contact;

import contact.Address;
import java.util.ArrayList;
import java.util.UUID;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author X
 */
public class Contact {

    private String nom;
    private String prenom;
    private ArrayList<String> emails;
    private ArrayList<String> phones;
    private String brithday;    
    private ArrayList<Address> addrs;
    private String img;
    private String uuid;

 

    public Contact(String nom, String prenom, String email, String phone, String brithday) {
        this.nom = nom;
        this.prenom = prenom;
        addrs = new ArrayList<Address>();
       // addrs.add(new Address(nom, prenom, "?", "?" ,"?" ,"?", "?"));
        emails = new ArrayList<String>();
        emails.add(email);
        phones = new ArrayList<String>();
        phones.add(phone);
        this.brithday = brithday;
        this.uuid = UUID.randomUUID().toString();
    }

    public ArrayList<Address> getAddrs() {
        return addrs;
    }

    public void setAddrs(ArrayList<Address> addrs) {
        this.addrs = addrs;
    }

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public ArrayList<String> getEmails() {
        return emails;
    }

    public void setEmails(ArrayList<String> emails) {
        this.emails = emails;
    }

    public ArrayList<String> getPhones() {
        return phones;
    }

    public void setPhones(ArrayList<String> phones) {
        this.phones = phones;
    }

    public String getBrithday() {
        return brithday;
    }

    public void setBrithday(String brithday) {
        this.brithday = brithday;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }



    public boolean addEmail(String email) {

        if (emails.contains(email)) {
            return true;
        }
        if (isValideEmail(email)) {
            this.emails.add(email);
            return true;
        }
        return false;
    }

    public boolean isValideEmail(String str) {
        Pattern p = Pattern.compile("^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,6}$");
        Matcher m = p.matcher(str.toUpperCase());
        return m.matches();
    }

    public boolean addPhoneNumber(String phone) {
        if (phones.contains(phone)) {
            return true;
        }
        if (isValideEmail(phone)) {
            this.phones.add(phone);
            return true;
        }
        return false;
    }

    public boolean isValidePhone(String str) {
        Pattern p = Pattern.compile("(\\+[0-9]{3}( [0-9][0-9])+)|([0-9]+)");
        Matcher m = p.matcher(str.toUpperCase());
        return m.matches();
    }
    
    
    public void modifyContact(String nom, String prenom, String email, String phone, String brithday) {
        this.nom = nom;
        this.prenom = prenom;
        this.emails.add(email);
        this.phones.add(phone);
        this.brithday = brithday;
    }
    

     
    public void addAddress(Address addr){
    
            this.addrs.add(addr);
    }
    
    public void addAddress( String number2, String rue2, String ville2, String cp2, String pays2){
        
        Address addr = new Address(this.nom, this.prenom, number2, rue2, ville2, cp2, pays2);        
        this.addrs.add(addr);
    }
    
        public void addEmailNoCheck(String mail){    
            this.emails.add(mail);
    }
    
        public void addPhoneNoCheck(String phon){    
            this.phones.add(phon);
    }

    @Override
    public String toString() {
        return "Contact{" + "nom=" + nom + ", prenom=" + prenom + ", emails=" + emails + ", phones=" + phones + ", brithday=" + brithday + ", addrs=" + addrs + ", img=" + img + ", uuid=" + uuid + '}';
    }
    
    
}
