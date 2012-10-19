package com.esiea.core;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.logging.Level;
import java.util.logging.Logger;

public final class Appz {

    private static volatile Appz instance = null;
    private ArrayList<User> dataBase;

    private Appz() {
        dataBase = new ArrayList<User>();
        this.populate();
    }

    public static Appz getInstance() {
        if (Appz.instance == null) {
            synchronized (Appz.class) {
                if (Appz.instance == null) {
                    Appz.instance = new Appz();
                }
            }
        }
        return Appz.instance;
    }

    public ArrayList<User> getDataBase() {
        return dataBase;
    }

    private void populate() {
        User usr = new User("peon", "111");
        UserData usrData = new UserData();
        Contact ctct = new Contact("nomContact1", "prenomContact1", "EmailContact1@gmail.com", "TelephoneContact1", "17-02-1985");
        Contact ctct2 = new Contact("nomContact2", "prenomContact2", "EmailContact2@gmail.com", "TelephoneContact2", "12-08-1986");
        Contact ctct3 = new Contact("nomContact3", "prenomContact3", "EmailContact3@gmail.com", "TelephoneContact3", "26-12-1989");
        Address addr11 = new Address("Livraison","11", "rue du quai ", "Marseille", "13000", "MAROC");
        Address addr12 = new Address("Facturation","12", "rue de la paie", "lille", "80", "LENORD");
        Address addr21 = new Address("Livraison","21", "rue de Stalin", "Saint-Petersbourg", "+7 812", "URSS");
        Address addr22 = new Address("Facturation","22", "rue Vesale", "PARIS", "75000", "FRANCE");
        try {
            usrData.InsertAddressAssociatedToContact(ctct, addr11);
            usrData.InsertAddressAssociatedToContact(ctct, addr12);
            usrData.InsertAddressAssociatedToContact(ctct2, addr21);
            usrData.InsertAddressAssociatedToContact(ctct2, addr22);
            usrData.InsertAddressAssociatedToContact(ctct3, addr21);
            usrData.InsertAddressAssociatedToContact(ctct3, addr22);
        } catch (Exception ex) {
            Logger.getLogger(Appz.class.getName()).log(Level.SEVERE, null, ex);
        }
        usr.setUserData(usrData);
        dataBase.add(usr);
    }

    public Boolean isLoginPresentInDataBase(String str) {
        Iterator<User> itr = dataBase.iterator();
        while (itr.hasNext()) {
            User element = itr.next();
            if (element.getUsername().equals(str)) {
                return true;
            }
        }
        return false;
    }

    public void addUser(User usr) {
        dataBase.add(usr);
    }

    public User getUserFromLogin(String str) {

        Iterator<User> itr = dataBase.iterator();
        while (itr.hasNext()) {
            User element = itr.next();
            if (element.getUsername().equals(str)) {
                return element;
            }
        }
        return null;
    }

    public int indexPresentLogin(String str) {

        Iterator<User> itr = dataBase.iterator();
        int count = 0;
        while (itr.hasNext()) {
            User element = itr.next();
            if (element.getUsername().equals(str)) {
                return count;
            }
            count++;
        }
        return -1;
    }


    public static boolean partialMatching(String testString, String pattern) {
        boolean matches = testString.toUpperCase().matches(".*"+pattern.toUpperCase()+".*");
                 return matches;
    }

    public boolean UsernameAndPasswordAreCorrect(String login, String pcw) {
        User usr;
        try {
            usr = getUserFromLogin(login);
        } catch (Exception e) {
            return false;
        }
        if (usr == null) {
            return false;
        } else {
            return usr.getPassword().equals(pcw);
        }
    }

    public boolean testPcwHash(String login, String hashpcw) {
        User usr;
        try {
            usr = getUserFromLogin(login);
        } catch (Exception e) {
            return false;
        }
        if (usr == null) {
            return false;
        } else {
            try {
                MessageDigest instance2 = MessageDigest.getInstance("MD5");
                String password = usr.getPassword();
                byte[] bytes = password.getBytes();
                byte[] digest = instance2.digest(bytes);
                String toString = new String(digest);
                return toString.equals(hashpcw);
            } catch (NoSuchAlgorithmException ex) {
                return false;
            }
        }
    }
}