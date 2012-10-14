package com.esiea.core;

import java.util.UUID;

public class Address {

    private String number;
    private String rue;
    private String ville;
    private String cp;
    private String pays;
    private String nickAddress;
    private String uuid;

    public Address( String number, String rue, String ville, String cp, String pays) {
        this.number = number;
        this.rue = rue;
        this.ville = ville;
        this.cp = cp;
        this.pays = pays;
        this.nickAddress = "defaut";
        this.uuid = UUID.randomUUID().toString();

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

    public String getUuid() {
        return uuid;
    }

    @Override
    public String toString() {
        return "Address{" + " number=" + number + ", rue=" + rue + ", Ville=" + ville + ", cp=" + cp + ", pays=" + pays + '}';
    }

    public void modifyAddress(String number, String rue, String ville, String cp, String pays) {
        this.number = number;
        this.rue = rue;
        this.ville = ville;
        this.cp = cp;
        this.pays = pays;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Address other = (Address) obj;
        if ((this.uuid == null) ? (other.uuid != null) : !this.uuid.equals(other.uuid)) {
            return false;
        }
        return true;
    }

}