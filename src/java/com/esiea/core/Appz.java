package org.peon.core;

import java.security.MessageDigest;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.springframework.web.servlet.ModelAndView;

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
        Address addr = new Address("45", "xrue", "xville", "xCP", "xpays");
        Address addr2 = new Address("38", "zrue", "zville", "zCP", "zpays");
        try {
            usrData.InsertAddressAssociatedToContact(ctct, addr);
            usrData.InsertAddressAssociatedToContact(ctct, addr2);
            usrData.InsertAddressAssociatedToContact(ctct2, addr);
            usrData.InsertAddressAssociatedToContact(ctct2, addr2);
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

    public User userPresentLogin(String str) {

        Iterator<User> itr = dataBase.iterator();
        while (itr.hasNext()) {
            User element = itr.next();
            if (element.getId().equals(str)) {
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
            if (element.getId().equals(str)) {
                return count;
            }
            count++;
        }
        return -1;
    }

    public void addContact(String str, Contact ctct, Address addr) throws Exception {

        User usr = userPresentLogin(str);
        usr.getUserData().InsertAddressAssociatedToContact(ctct, addr);
    }

    public void addContact(String str, Contact ctct) throws Exception {

        User usr = userPresentLogin(str);
        usr.getUserData().InsertContact(ctct);
    }

    public void modifyContact(String str, Contact old_ctct, Contact modify_ctct) throws Exception {

        User usr = userPresentLogin(str);
        ArrayList<Address> addr = usr.getUserData().getAddressAssociatedToContact(old_ctct);
        usr.getUserData().removeContact(old_ctct);
        Iterator<Address> itr = addr.iterator();
        while (itr.hasNext()) {
            usr.getUserData().InsertAddressAssociatedToContact(modify_ctct, itr.next());
        }
    }

    public void modifyContact_v2(String str, Contact old_ctct, Contact modify_ctct) throws Exception {

        User usr = userPresentLogin(str);
        old_ctct.setBrithday(modify_ctct.getBrithday());
        old_ctct.setEmails(modify_ctct.getEmails());
        old_ctct.setName(modify_ctct.getName());
        old_ctct.setPhones(modify_ctct.getPhones());
        old_ctct.setSurname(modify_ctct.getSurname());
        //  usr.getUserData().
    }

    public boolean modifyAddrr(String str, Contact ctct, Address addr, Address newAddr) throws Exception {

        User usr = userPresentLogin(str);
        ArrayList<Address> addressAssociatedToContact = usr.getUserData().getAddressAssociatedToContact(ctct);
        Iterator<Address> itr = addressAssociatedToContact.iterator();
        while (itr.hasNext()) {
            Address element = itr.next();
            if (element.equals(addr)) {
                element.setNickAddress(newAddr.getNickAddress());
                element.setCp(newAddr.getCp());
                element.setNumber(newAddr.getNumber());
                element.setPays(newAddr.getPays());
                element.setRue(newAddr.getRue());
                element.setVille(newAddr.getVille());
                return true;
            }
        }
        return false;
    }
    
        public void modifyAddrrV2( Address addr, Address newAddr) throws Exception {


                addr.setNickAddress(newAddr.getNickAddress());
                addr.setCp(newAddr.getCp());
                addr.setNumber(newAddr.getNumber());
                addr.setPays(newAddr.getPays());
                addr.setRue(newAddr.getRue());
                addr.setVille(newAddr.getVille());
 
    }

    public boolean checkLoginPass(String login, String pcw) {
        User usr = null;
        try {
            usr = userPresentLogin(login);
        } catch (Exception e) {
            return false;
        }

        if (usr == null) {
            return false;
        } else {
            return usr.getPassword().equals(pcw);
        }
    }

    public boolean testPcwHash(String login, String hashpcw) throws Exception {

        User usr = null;
        try {
            usr = userPresentLogin(login);
        } catch (Exception e) {
            return false;
        }

        if (usr == null) {
            return false;
        } else {
            MessageDigest instance2 = MessageDigest.getInstance("MD5");
            String password = usr.getPassword();
            byte[] bytes = password.getBytes();
            byte[] digest = instance2.digest(bytes);
            String toString = new String(digest);
            return toString.equals(hashpcw);
        }
    }

    public ArrayList<Address> getArrAddress(String user, Contact ctct) {
        return Appz.getInstance().getDataBase().get(Appz.getInstance().indexPresentLogin(user)).getUserData().getAddressAssociatedToContact(ctct);
    }

    public ArrayList<Contact> getArrContact(String user) {
        return Appz.getInstance().getDataBase().get(Appz.getInstance().indexPresentLogin(user)).getUserData().getTableContact();
    }

    public void removeContact(String user, int ctctIndice) {
        //TODO
        int userIndice = indexPresentLogin(user);

        int size = Appz.getInstance().getDataBase().get(userIndice).getUserData().getTableContact().size();
        if (size != 0) {
            Contact ctct = Appz.getInstance().getDataBase().get(userIndice).getUserData().getTableContact().get(ctctIndice);
            if (ctct != null) {
                Appz.getInstance().getDataBase().get(userIndice).getUserData().removeContact(ctct);
            }
        }
    }

    public void removeAddr(String user, int ctctIndice, int addrIndice) {
        //TODO
        int userIndice = indexPresentLogin(user);
        int size = Appz.getInstance().getDataBase().get(userIndice).getUserData().getTableContact().size();
        if (size != 0) {
            Contact ctct = Appz.getInstance().getDataBase().get(userIndice).getUserData().getTableContact().get(ctctIndice);
            int size2 = Appz.getInstance().getDataBase().get(userIndice).getUserData().getTableAddress().size();
            if (size2 != 0) {
                Address addrs = Appz.getInstance().getDataBase().get(userIndice).getUserData().getTableAddress().get(addrIndice);
                if (addrs != null) {
                    Appz.getInstance().getDataBase().get(userIndice).getUserData().removeAddressAssociatedToContact(addrs, ctct);
                }
            }
        }
    }
    

}
