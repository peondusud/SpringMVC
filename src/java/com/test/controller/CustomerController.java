/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.test.controller;

/**
 *
 * @author Xnl
 */
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.Iterator;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.peon.core.*;
import org.peondusud.contact.ContactManager;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class CustomerController {

    org.peondusud.contact.ContactManager contactMan = new org.peondusud.contact.ContactManager(org.peondusud.contact.ContactManager.PopulateContact());

    protected ModelAndView handleRequestInternal(HttpServletRequest hsr, HttpServletResponse hsr1) throws Exception {
        ModelAndView model = null;

        return model;
    }

//    @RequestMapping(value = "/show", method = RequestMethod.GET)
//    public ModelAndView get(HttpServletRequest hsr, HttpServletResponse hsr1) {
//        HttpSession session = hsr.getSession();
//        String userLoginCookie = (String) session.getAttribute("username");
//        String userPassCookie = (String) session.getAttribute("password");
//
//        if (userPassCookie == null || userLoginCookie == null) {
//            String str = "not logged";
//            return new ModelAndView("error", "str", str);
//        }
//
//        User usrLogin = Appz.getInstance().userPresentLogin(userLoginCookie);
//        //usrLogin.getPassword() != userPassCookie.toString()
//        if (!usrLogin.getPassword().equals(userPassCookie.toString())) {
//
//            String str = "login & password no match same user";
//            return new ModelAndView("error", "str", str);
//        }
//
//        ArrayList<Contact> arrContact = usrLogin.getUserData().getTableContact();
//        org.peondusud.contact.ContactManager arrContactMan = new ContactManager();
//        ArrayList<org.peondusud.contact.Contact> arrCont = new ArrayList<org.peondusud.contact.Contact>();
//        Iterator<Contact> itr = arrContact.iterator();
//        while (itr.hasNext()) {
//            org.peondusud.contact.Contact tmpContact = new org.peondusud.contact.Contact();
//            Contact element = itr.next();
//            tmpContact.setNom(element.getName());
//            tmpContact.setPrenom(element.getSurname());
//            tmpContact.setBrithday(element.getBrithday());
//
//            ArrayList<String> arrStr = new ArrayList<String>();
//            arrStr.add(element.getPhones());
//            tmpContact.setPhones(arrStr);
//
//            ArrayList<String> arrStr2 = new ArrayList<String>();
//            arrStr2.add(element.getEmails());
//            tmpContact.setEmails(arrStr2);
//
//            ArrayList<org.peondusud.contact.Address> tmpArrayAddr = new ArrayList<org.peondusud.contact.Address>();
//            Iterator<Address> itrAddr = usrLogin.getUserData().getAddressAssociatedToContact(element).iterator();
//            while (itrAddr.hasNext()) {
//                Address elementAddr = itrAddr.next();
//                tmpArrayAddr.add(new org.peondusud.contact.Address(elementAddr.getNickAddress(), elementAddr.getNumber(), elementAddr.getRue(), elementAddr.getCp(), elementAddr.getVille(), elementAddr.getPays()));
//
//            }
//            tmpContact.setAddrs(tmpArrayAddr);
//            arrCont.add(tmpContact);
//            //arrContactMan.arrContact.add(tmpContact);
//        }
//        arrContactMan.setArrContact(arrCont);
//        //return new ModelAndView("show_list_2", "arrContact", arrContact);
//        return new ModelAndView("show_list_1", "arrContactMan", arrContactMan);
//    }
    @RequestMapping(value = "/list_add", method = RequestMethod.GET)
    public ModelAndView list(HttpServletRequest hsr, HttpServletResponse hsr1) throws Exception {
        HttpSession session = hsr.getSession();
        String userLoginCookie = (String) session.getAttribute("username");
        String userPassCookie = (String) session.getAttribute("password");

        if (userPassCookie == null || userLoginCookie == null) {
            String str = "not logged";
            return new ModelAndView("error", "str", str);
        }
        if (Appz.getInstance().testPcwHash(userLoginCookie, userPassCookie)) {
            User usrLogin = Appz.getInstance().userPresentLogin(userLoginCookie);

            ArrayList<Contact> arrContact = usrLogin.getUserData().getTableContact();
            if (arrContact.size() != 0) {
                Contact ctct = arrContact.get(Integer.valueOf(hsr.getParameter("contactID")));
                ArrayList<Address> addrs = usrLogin.getUserData().getAddressAssociatedToContact(ctct);
                if (addrs.size() != 0) {
                    return new ModelAndView("list_add", "addrs", addrs);
                }
            }
        }
        return null;
    }

    @RequestMapping(value = "/add_contact")
    public ModelAndView add_contact_page() {
        return new ModelAndView("new_add_contact");
    }

    @RequestMapping(value = "/add_contact_v", method = RequestMethod.POST)
    public ModelAndView add_contact_validator(HttpServletRequest hsr, HttpServletResponse hsr1) throws Exception {
        String prenom = hsr.getParameter("prenom").toString();
        String nom = hsr.getParameter("nom").toString();
        String phone = hsr.getParameter("phone").toString();
        String mail = hsr.getParameter("mail").toString();
        String birthday = hsr.getParameter("birthday").toString();
        HttpSession session = hsr.getSession();
        String userLoginCookie = (String) session.getAttribute("username");
        String userPassCookie = (String) session.getAttribute("password");
        if (userPassCookie == null || userLoginCookie == null) {
            String str = "not logged";
            return new ModelAndView("error", "str", str);
        }
        //TODO check good login
        Contact tmpCont = new Contact(nom, prenom, mail, phone, birthday);
        Appz.getInstance().addContact(userLoginCookie, tmpCont);
        session.setAttribute("contactOject", tmpCont);

        return new ModelAndView("new_add_contact_display", "tmpCont", tmpCont);
    }

    @RequestMapping(value = "/add_addr")
    public ModelAndView add_addr_page() {
        return new ModelAndView("new_add_addr");
    }

    @RequestMapping(value = "/add_addr_v")
    public ModelAndView add_addr_validator(HttpServletRequest hsr, HttpServletResponse hsr1) throws Exception {

        HttpSession session = hsr.getSession();
        String toString = session.getAttribute("username").toString();
        String toString1 = session.getAttribute("password").toString();
        boolean test = Appz.getInstance().testPcwHash(toString, toString1);

        if (test) {
            Contact tmpContact = (Contact) session.getAttribute("contactOject");

            String nick = hsr.getParameter("addr_nick").toString();
            String nb = hsr.getParameter("addr_nb").toString();
            String rue = hsr.getParameter("addr_rue").toString();
            String ville = hsr.getParameter("addr_ville").toString();
            String cp = hsr.getParameter("addr_cp").toString();
            String pays = hsr.getParameter("addr_pays").toString();

            Address tmpAddr = new Address(nb, rue, ville, cp, pays);
            Appz.getInstance().addContact(session.getAttribute("username").toString(), tmpContact, tmpAddr);
            return new ModelAndView("new_add_addr");

        } else {
            String str = "please Log in ";
            return new ModelAndView("error", "str", str);
        }
    }

//
//    @RequestMapping(value = "/addd", method = RequestMethod.POST)
//    public ModelAndView saved(HttpServletRequest hsr, HttpServletResponse hsr1) throws Exception {
//        //TODO teste si champ vide
//        Object prenom = hsr.getParameter("prenom");
//        Object nom = hsr.getParameter("nom");
//        Object phone = hsr.getParameter("phone");
//        Object mail = hsr.getParameter("mail");
//        Object addr_nick = hsr.getParameter("addr_nick");
//        Object addr_nb = hsr.getParameter("addr_nb");
//        Object addr_rue = hsr.getParameter("addr_rue");
//        Object addr_cp = hsr.getParameter("addr_cp");
//        Object addr_ville = hsr.getParameter("addr_ville");
//        Object addr_pays = hsr.getParameter("addr_pays");
//        Object birthday = hsr.getParameter("birthday");
//        HttpSession session = hsr.getSession();
//        String userLoginCookie = (String) session.getAttribute("username");
//        String userPassCookie = (String) session.getAttribute("password");
//
//        if (userPassCookie == null || userLoginCookie == null) {
//            String str = new String("not logged");
//            return new ModelAndView("error", "str", str);
//        }
//
//        User usrLogin = Appz.getInstance().userPresentLogin(userLoginCookie);
//        ArrayList<Contact> arrContact = usrLogin.getUserData().getTableContact();
//
//
//        Address tmpAddr = new Address(addr_nb.toString(), addr_rue.toString(), addr_ville.toString(), addr_cp.toString(), addr_pays.toString());
//        Contact tmpCont = new Contact(nom.toString(), prenom.toString(), mail.toString(), phone.toString(), birthday.toString());
//        // Contact tmp = Appz.getInstance().getDataBase().get( Appz.getInstance().indexPresentLogin(userLoginCookie) ).getUserData().getTableContact().get(index);
//        Appz.getInstance().addContact(userLoginCookie, tmpCont, tmpAddr);
//        ArrayList<Contact> arrContactMan = adpaterPeonCore(usrLogin);
//        return new ModelAndView("show_list_1", "arrContactMan", arrContactMan);
//    }
    @RequestMapping(value = "/modify_contact", method = RequestMethod.GET)
    public ModelAndView modify_contact_page(HttpServletRequest hsr, HttpServletResponse hsr1) throws Exception {
        //indice  modID arraylist pour choix contact
        HttpSession session = hsr.getSession();
        String username = session.getAttribute("username").toString();
        Integer indice = Integer.valueOf(hsr.getParameter("modID"));
        if (Appz.getInstance().testPcwHash(username, session.getAttribute("password").toString())) {
            Contact contact = Appz.getInstance().getArrContact(username).get(indice);
            session.setAttribute("MODcontactID", indice);
            return new ModelAndView("new_modify_contact", "contact", contact);

        } else {
            String str = "please Log in ";
            return new ModelAndView("error", "str", str);
        }
    }

    @RequestMapping(value = "/modify_contact_v")
    public ModelAndView modify_contact_validator(HttpServletRequest hsr, HttpServletResponse hsr1) throws Exception {
        HttpSession session = hsr.getSession();
        String username = session.getAttribute("username").toString();
        String prenom = hsr.getParameter("prenom").toString();
        String nom = hsr.getParameter("nom").toString();
        String phone = hsr.getParameter("phone").toString();
        String mail = hsr.getParameter("mail").toString();
        String birthday = hsr.getParameter("birthday").toString();
        if (Appz.getInstance().testPcwHash(username, session.getAttribute("password").toString())) {
            int modContactID = Integer.valueOf(session.getAttribute("MODcontactID").toString());
            Contact old = Appz.getInstance().getDataBase().get(Appz.getInstance().indexPresentLogin(username)).getUserData().getTableContact().get(modContactID);
            //TODO test unique contact
            Contact modifyCtct = new Contact(nom, prenom, mail, phone, birthday);
            Appz.getInstance().modifyContact_v2(username, old, modifyCtct);
            ArrayList<Contact> arrContact = Appz.getInstance().getArrContact(username);
            return new ModelAndView("list_show", "arrContact", arrContact);
        }
        //TODO
        return null;
    }

    @RequestMapping(value = "/modify_addrs")
    public ModelAndView modify_adrrs_page(HttpServletRequest hsr, HttpServletResponse hsr1) throws Exception {

        //TODO
        return new ModelAndView("new_modify_addrs");
    }

    @RequestMapping(value = "/modify_addr")
    public ModelAndView modify_adrr_page(HttpServletRequest hsr, HttpServletResponse hsr1) throws Exception {

        //TODO
        return new ModelAndView("list_show");
    }

    @RequestMapping(value = "/modify_addr_v")
    public ModelAndView modify_adrr_validator(HttpServletRequest hsr, HttpServletResponse hsr1) throws Exception {

        //TODO
        HttpSession session = hsr.getSession();
        String username = session.getAttribute("username").toString();
        String pcw = session.getAttribute("password").toString();


        if (Appz.getInstance().testPcwHash(username, pcw)) {
            Contact tmpContact = (Contact) session.getAttribute("contactOject");

            String nick = hsr.getParameter("addr_nick").toString();
            String nb = hsr.getParameter("addr_nb").toString();
            String rue = hsr.getParameter("addr_rue").toString();
            String ville = hsr.getParameter("addr_ville").toString();
            String cp = hsr.getParameter("addr_cp").toString();
            String pays = hsr.getParameter("addr_pays").toString();

            ArrayList<Contact> arrContact = Appz.getInstance().getArrContact(username);
            return new ModelAndView("list_show", "arrContact", arrContact);
        }
         else {
            String str = "please Log in ";
            return new ModelAndView("error", "str", str);
        }
    }

    @RequestMapping(value = "/index")
    public ModelAndView home() {
        Appz instance = Appz.getInstance();
        return new ModelAndView("index");
    }

//    @RequestMapping(value = "/list", method = RequestMethod.GET)
//    public ModelAndView list() {
//
//        return new ModelAndView("show_list", "contactMan", contactMan);
//    }
    @RequestMapping(value = "/delete", method = RequestMethod.GET)
    public ModelAndView delete(HttpServletRequest hsr, HttpServletResponse hsr1) throws Exception {

        int index = Integer.valueOf(hsr.getParameter("deleteID"));
        HttpSession session = hsr.getSession();
        String username = session.getAttribute("username").toString();
        if (Appz.getInstance().testPcwHash(username, session.getAttribute("password").toString())) {
            Appz.getInstance().removeContact(username, index);
            ArrayList<Contact> arrContact = Appz.getInstance().getArrContact(username);
            return new ModelAndView("list_show", "arrContact", arrContact);

        } else {
            String str = "please Log in ";
            return new ModelAndView("error", "str", str);
        }

    }

    @RequestMapping(value = "/list_show", method = RequestMethod.GET)
    public ModelAndView list_show(HttpServletRequest hsr, HttpServletResponse hsr1) throws Exception {
        HttpSession session = hsr.getSession();
        String username = session.getAttribute("username").toString();
        if (Appz.getInstance().testPcwHash(username, session.getAttribute("password").toString())) {
            ArrayList<Contact> arrContact = Appz.getInstance().getArrContact(username);
            return new ModelAndView("list_show", "arrContact", arrContact);

        } else {
            String str = "please Log in ";
            return new ModelAndView("error", "str", str);
        }
    }

    @RequestMapping(value = "/signinc", method = RequestMethod.POST)
    public ModelAndView signinc(HttpServletRequest hsr, HttpServletResponse hsr1) {

        Object login = hsr.getParameter("login");
        Object pcw = hsr.getParameter("password");
        Object firstname = hsr.getParameter("firstname");
        Object lastname = hsr.getParameter("lastname");
        Object email = hsr.getParameter("email");
        Object phone = hsr.getParameter("telephone");
        if (login != null && pcw != null && firstname != null && lastname != null && email != null && phone != null) {
            if (org.peon.core.Appz.getInstance().isLoginPresent(login.toString())) {
                String str = "login already used";
                return new ModelAndView("error", "str", str);
            }

            Appz.getInstance().addUser(new User(login.toString(), pcw.toString()));
            return new ModelAndView("success");
        }
        String str = "missed signin field";
        return new ModelAndView("error", "str", str);
    }

    @RequestMapping(value = "/signin")
    public ModelAndView signin(HttpServletRequest hsr, HttpServletResponse hsr1) {
        return new ModelAndView("signin");
    }

    @RequestMapping(value = "/login")
    public ModelAndView loggin() {
        return new ModelAndView("login");
    }

    @RequestMapping(value = "/login_v", method = RequestMethod.POST)
    public ModelAndView loggin_validator(HttpServletRequest hsr, HttpServletResponse hsr1) throws NoSuchAlgorithmException, Exception {
        HttpSession session = hsr.getSession();
        String userName = hsr.getParameter("username");
        String userPass = hsr.getParameter("password");
        String userPassCookie = (String) session.getAttribute("password");

        if (userPassCookie == null && userPass == null) {
            return new ModelAndView("login");
        } else if (userPassCookie != null && userPass == null) {
            return new ModelAndView("redirect:/list_show.html");
        } else if (userPass != null && userPassCookie == null) {

            if (Appz.getInstance().checkLoginPass(userName, userPass)) {

                session.setAttribute("username", userName);
                MessageDigest instance = MessageDigest.getInstance("MD5");
                byte[] bytes = userPass.getBytes();
                byte[] digest = instance.digest(bytes);
                String toString = new String(digest);
                session.setAttribute("password", toString);
                return new ModelAndView("redirect:/list_show.html");
            } else {
                String str = "login  password error";
                return new ModelAndView("error", "str", str);
            }

        } else {
            session.invalidate();
            return new ModelAndView("redirect:/");
        }

    }

    private ArrayList<Contact> adpaterPeonCore(User usrLogin) {
        ArrayList<Contact> arrContact = usrLogin.getUserData().getTableContact();
        org.peondusud.contact.ContactManager arrContactMan = new ContactManager();
        ArrayList<org.peondusud.contact.Contact> arrCont = new ArrayList<org.peondusud.contact.Contact>();
        Iterator<Contact> itr = arrContact.iterator();
        while (itr.hasNext()) {
            org.peondusud.contact.Contact tmpContact = new org.peondusud.contact.Contact();
            Contact element = itr.next();
            tmpContact.setNom(element.getName());
            tmpContact.setPrenom(element.getSurname());
            tmpContact.setBrithday(element.getBrithday());

            ArrayList<String> arrStr = new ArrayList<String>();
            arrStr.add(element.getPhones());
            tmpContact.setPhones(arrStr);

            ArrayList<String> arrStr2 = new ArrayList<String>();
            arrStr2.add(element.getEmails());
            tmpContact.setEmails(arrStr2);

            ArrayList<org.peondusud.contact.Address> tmpArrayAddr = new ArrayList<org.peondusud.contact.Address>();
            Iterator<Address> itrAddr = usrLogin.getUserData().getAddressAssociatedToContact(element).iterator();
            while (itrAddr.hasNext()) {
                Address elementAddr = itrAddr.next();
                tmpArrayAddr.add(new org.peondusud.contact.Address(elementAddr.getNickAddress(), elementAddr.getNumber(), elementAddr.getRue(), elementAddr.getCp(), elementAddr.getVille(), elementAddr.getPays()));

            }
            tmpContact.setAddrs(tmpArrayAddr);
            arrCont.add(tmpContact);
            //arrContactMan.arrContact.add(tmpContact);
        }
        arrContactMan.setArrContact(arrCont);

        return arrContact;
    }
}
