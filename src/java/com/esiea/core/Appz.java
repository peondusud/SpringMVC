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
        UserData usrData = new UserData();
        Contact ctct = new Contact("znom", "zprenom", "zmail", "zphone", "zbirthday");
        Contact ctct2 = new Contact("xnom", "xprenom", "xmail", "xphone", "xbirthday");
        Address addr = new Address("45", "xrue", "xville", "xCP", "xpays");
        Address addr2 = new Address("38", "zrue", "zville", "zCP", "zpays");
        try 
        {
            usrData.InsertAddressAssociatedToContact(ctct, addr);
            usrData.InsertAddressAssociatedToContact(ctct, addr2);
            usrData.InsertAddressAssociatedToContact(ctct2, addr);
            usrData.InsertAddressAssociatedToContact(ctct2, addr2);
        } 
        catch (Exception ex) 
        {
            Logger.getLogger(Appz.class.getName()).log(Level.SEVERE, null, ex);
        }
        usr.setUserData(usrData);
        dataBase.add(usr);
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
    
        public boolean UsernameAndPasswordAreCorrect(String login, String pcw) 
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

    public static boolean partialMatching(String testString, String pattern) {
        String[] split = testString.split(pattern);
        if (split.toString().equals(testString)) {
            return false;
        } else {
            return true;
        }
    }

}
