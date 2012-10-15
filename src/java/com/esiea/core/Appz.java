package com.esiea.core;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.logging.Level;
import java.util.logging.Logger;

public final class Appz 
{

    private static volatile Appz instance = null;
    private ArrayList<User> dataBase;

    private Appz() 
    {
        dataBase = new ArrayList<User>();
        this.populate();
    }

    public static Appz getInstance() 
    {
        if (Appz.instance == null) 
        {
            synchronized (Appz.class) 
            {
                if (Appz.instance == null) 
                {
                    Appz.instance = new Appz();
                }
            }
        }
        return Appz.instance;
    }

    public ArrayList<User> getDataBase() 
    {
        return dataBase;
    }

    private void populate() 
    {
        User usr = new User("peon", "111");
        User usr2 = new User("codec", "111");
        UserData usrData = new UserData();
        UserData usrData2 = new UserData();
        Contact ctct = new Contact("znom", "zprenom", "zmail@gmail.com", "zphone", "zbirthday");
        Contact ctct2 = new Contact("xnom", "xprenom", "xmail@gmail.com", "xphone", "xbirthday");
        Address addr = new Address("45", "xrue", "xville", "xCP", "xpays");
        Address addr2 = new Address("38", "zrue", "zville", "zCP", "zpays");
        try 
        {
            usrData.InsertAddressAssociatedToContact(ctct, addr);
            usrData.InsertAddressAssociatedToContact(ctct, addr2);
            usrData.InsertAddressAssociatedToContact(ctct2, addr);
            usrData.InsertAddressAssociatedToContact(ctct2, addr2);
            usrData2.InsertAddressAssociatedToContact(ctct, addr);
            usrData2.InsertAddressAssociatedToContact(ctct, addr2);
            usrData2.InsertAddressAssociatedToContact(ctct2, addr);
            usrData2.InsertAddressAssociatedToContact(ctct2, addr2);
        } 
        catch (Exception ex) 
        {
            Logger.getLogger(Appz.class.getName()).log(Level.SEVERE, null, ex);
        }
        usr.setUserData(usrData);
        usr2.setUserData(usrData2);
        dataBase.add(usr);
        dataBase.add(usr2);
    }

    public Boolean isLoginPresentInDataBase(String str) 
    {
        Iterator<User> itr = dataBase.iterator();
        while (itr.hasNext()) 
        {
            User element = itr.next();
            if (element.getUsername().equals(str)) 
            {
                return true;
            }
        }
        return false;
    }

    public void addUser(User usr) 
    {
        dataBase.add(usr);
    }

    public User getUserFromLogin(String str) 
    {

        Iterator<User> itr = dataBase.iterator();
        while (itr.hasNext()) 
        {
            User element = itr.next();
            if (element.getUsername().equals(str)) 
            {
                return element;
            }
        }
        return null;
    }

    public int indexPresentLogin(String str) 
    {

        Iterator<User> itr = dataBase.iterator();
        int count = 0;
        while (itr.hasNext()) 
        {
            User element = itr.next();
            if (element.getUsername().equals(str)) 
            {
                return count;
            }
            count++;
        }
        return -1;
    }

    public void addContact(String str, Contact ctct, Address addr) throws Exception 
    {
        User usr = getUserFromLogin(str);
        usr.getUserData().InsertAddressAssociatedToContact(ctct, addr);
    }

    public void addContact(String str, Contact ctct) throws Exception 
    {
        User usr = getUserFromLogin(str);
        usr.getUserData().InsertContact(ctct);
    }

    public void modifyContact(String str, Contact old_ctct, Contact modify_ctct) throws Exception 
    {

        old_ctct.setBirthday(modify_ctct.getBirthday());
        old_ctct.setEmails(modify_ctct.getEmails());
        old_ctct.setName(modify_ctct.getName());
        old_ctct.setPhones(modify_ctct.getPhones());
        old_ctct.setSurname(modify_ctct.getSurname());
    }

    public void modifyAddr(Address addr, Address newAddr) throws Exception 
    {
        addr.setCp(newAddr.getCp());
        addr.setNumber(newAddr.getNumber());
        addr.setPays(newAddr.getPays());
        addr.setRue(newAddr.getRue());
        addr.setVille(newAddr.getVille());
    }

    public boolean checkLoginPass(String login, String pcw) 
    {
        User usr = null;
        try 
        {
            usr = getUserFromLogin(login);
        } 
        catch (Exception e) 
        {
            return false;
        }
        if (usr == null) 
        {
            return false;
        }
        else 
        {
            return usr.getPassword().equals(pcw);
        }
    }

    public boolean testPcwHash(String login, String hashpcw) 
    {
        User usr;
        try 
        {
            usr = getUserFromLogin(login);
        } 
        catch (Exception e) 
        {
            return false;
        }
        if (usr == null) 
        {
            return false;
        } else 
        {
            try 
            {
                MessageDigest instance2 = MessageDigest.getInstance("MD5");
                String password = usr.getPassword();
                byte[] bytes = password.getBytes();
                byte[] digest = instance2.digest(bytes);
                String toString = new String(digest);
                return toString.equals(hashpcw);
            } 
            catch (NoSuchAlgorithmException ex) 
            {
                return false;
            }
        }
    }

    public ArrayList<Address> getArrAddress(String user, Contact ctct) 
    {
        return Appz.getInstance().getDataBase().get(Appz.getInstance().indexPresentLogin(user)).getUserData().getAddressAssociatedToContact(ctct);
    }

    public ArrayList<Contact> getArrContact(String user) 
    {
        return Appz.getInstance().getDataBase().get(Appz.getInstance().indexPresentLogin(user)).getUserData().getTableContact();
    }

    public void removeContact(String user, int ctctIndice) 
    {
        //TODO
        int userIndice = indexPresentLogin(user);
        int size = Appz.getInstance().getDataBase().get(userIndice).getUserData().getTableContact().size();
        if (size != 0) 
        {
            Contact ctct = Appz.getInstance().getDataBase().get(userIndice).getUserData().getTableContact().get(ctctIndice);
            if (ctct != null) 
            {
                Appz.getInstance().getDataBase().get(userIndice).getUserData().removeContact(ctct);
            }
        }
    }

    public void removeAddr(String user, int ctctIndice, int addrIndice) 
    {
        //TODO
        int userIndice = indexPresentLogin(user);
        int size = Appz.getInstance().getDataBase().get(userIndice).getUserData().getTableContact().size();
        if (size != 0) 
        {
            Contact ctct = Appz.getInstance().getDataBase().get(userIndice).getUserData().getTableContact().get(ctctIndice);
            int size2 = Appz.getInstance().getDataBase().get(userIndice).getUserData().getTableAddress().size();
            if (size2 != 0) 
            {
                Address addrs = Appz.getInstance().getDataBase().get(userIndice).getUserData().getTableAddress().get(addrIndice);
                if (addrs != null) 
                {
                    Appz.getInstance().getDataBase().get(userIndice).getUserData().removeAddressAssociatedToContact(addrs, ctct);
                }
            }
        }
    }
    public ArrayList<Contact> searchContact(String user, String str) {

        ArrayList<Contact> arrCct = null;
        int userIndice = indexPresentLogin(user);
        int size = Appz.getInstance().getDataBase().get(userIndice).getUserData().getTableContact().size();
        if (size != 0) {
            ArrayList<Contact> tableContact = Appz.getInstance().getDataBase().get(userIndice).getUserData().getTableContact();
            Iterator<Contact> itr = tableContact.iterator();
            while (itr.hasNext()) {
                Contact element = itr.next();
                if (element.getName().equals(str) || element.getSurname().equals(str) || element.getEmails().equals(str) || element.getPhones().equals(str)) {
                    arrCct.add(element);
                }
            }
        }
        return arrCct;
    }

    public ArrayList<Address> searchAddr(String user, String str) {
        ArrayList<Address> arrAddr = null;
        int userIndice = indexPresentLogin(user);
        int size = Appz.getInstance().getDataBase().get(userIndice).getUserData().getTableContact().size();
        if (size != 0) {
            ArrayList<Contact> tableContact = Appz.getInstance().getDataBase().get(userIndice).getUserData().getTableContact();
            Iterator<Contact> itr = tableContact.iterator();
            while (itr.hasNext()) {
                Contact element = itr.next();
                Iterator<Address> itr2 = Appz.getInstance().getDataBase().get(userIndice).getUserData().getAddressAssociatedToContact(element).iterator();
                while (itr2.hasNext()) {
                    Address addr = itr2.next();
                    if (addr.getRue().equals(str)) {
                        arrAddr.add(addr);
                    }
                }
            }
        }
        return arrAddr;
    }
    


}
