package org.peon.core;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.logging.Level;
import java.util.logging.Logger;

public final class Appz {

    private static volatile Appz instance = null;
    private ArrayList<User> dataBase;

    private Appz() {
        super();
        dataBase = new ArrayList<User>();
        this.populate();
    }

    public final static Appz getInstance() {
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
        //TODO : completer
        User usr = new User("peon", "111");
        UserData usrData = new UserData();
        Contact ctct = new Contact("znom", "zprenom", "zmail", "zphone", "zbirthday");
        Contact ctct2 = new Contact("xnom", "xprenom", "xmail", "xphone", "xbirthday");
        Address addr = new Address("45", "rue", "ville", "CP", "pays");
        try {
            usrData.InsertAddressAssociatedToContact(ctct, addr);
            usrData.InsertAddressAssociatedToContact(ctct2, addr);
        } catch (Exception ex) {
            Logger.getLogger(Appz.class.getName()).log(Level.SEVERE, null, ex);
        }
        usr.setUserData(usrData);

        dataBase.add(usr);
    }

    public Boolean isLoginPresent(String str) {

        //TODO chech si login existe
        Iterator<User> itr = dataBase.iterator();
        while (itr.hasNext()) {
            User element = itr.next();
            if (element.getId().equals(str)) {
                return true;
            }
        }
        return false;
    }

    public void addUser(User usr) {
        dataBase.add(usr);
    }
    
        public User indexPresentLogin(String str) {

        //TODO chech si login existe
        Iterator<User> itr = dataBase.iterator();
        while (itr.hasNext()) {
            User element = itr.next();
            if (element.getId().equals(str)) {
                return element;
            }
        }
        return null;
    }
    
    
}