package org.peon.core;

import java.util.UUID;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Contact {

    private String name;
    private String surname;
    private String emails;
    private String phones;
    private String brithday;
    private String uuid;

    public Contact(String nom, String prenom, String email, String phone, String brithday) {
        this.name = nom;
        this.surname = prenom;
        this.emails = email;
        this.phones = phone;
        this.brithday = brithday;
        this.uuid = UUID.randomUUID().toString();
    }

    public String getUuid() {
        return uuid;
    }

    public String getNom() {
        return name;
    }

    public void setNom(String nom) {
        this.name = nom;
    }

    public String getPrenom() {
        return surname;
    }

    public void setPrenom(String prenom) {
        this.surname = prenom;
    }

    public String getEmails() {
        return emails;
    }

    public void setEmails(String emails) {
        this.emails = emails;
    }

    public String getPhones() {
        return phones;
    }

    public void setPhones(String phones) {
        this.phones = phones;
    }

    public String getBrithday() {
        return brithday;
    }

    public void setBrithday(String brithday) {
        this.brithday = brithday;
    }

    public boolean isValideEmail(String str) {
        Pattern p = Pattern.compile("^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,6}$");
        Matcher m = p.matcher(str.toUpperCase());
        return m.matches();
    }

    public boolean isValidePhone(String str) {
        Pattern p = Pattern.compile("(\\+[0-9]{3}( [0-9][0-9])+)|([0-9]+)");
        Matcher m = p.matcher(str.toUpperCase());
        return m.matches();
    }

    public void modifyContact(String nom, String prenom, String email, String phone, String brithday) {
        this.name = nom;
        this.surname = prenom;
        this.emails = email;
        this.phones = phone;
        this.brithday = brithday;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Contact other = (Contact) obj;
        if ((this.uuid == null) ? (other.uuid != null) : !this.uuid.equals(other.uuid)) {
            return false;
        }
        return true;
    }
}