package com.test.controller;

/**
 *
 * @author Xnl
 */
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.peon.core.*;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class CustomerController {

    protected ModelAndView handleRequestInternal(HttpServletRequest hsr, HttpServletResponse hsr1) throws Exception {
        ModelAndView model = null;

        return model;
    }

    @RequestMapping(value = "/list_add", method = RequestMethod.GET)
    public ModelAndView list_addr_page(HttpServletRequest hsr, HttpServletResponse hsr1) throws Exception {
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
            if (!arrContact.isEmpty()) {
                Contact ctct = arrContact.get(Integer.valueOf(hsr.getParameter("contactID")));
                ArrayList<Address> addrs = usrLogin.getUserData().getAddressAssociatedToContact(ctct);
                if (!addrs.isEmpty()) {
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

        HttpSession session = hsr.getSession();
        String userLoginCookie = (String) session.getAttribute("username");
        String userPassCookie = (String) session.getAttribute("password");
        int modContactID = Integer.valueOf(session.getAttribute("MODcontactID").toString());
        if (userPassCookie == null || userLoginCookie == null) {
            String str = "not logged";
            return new ModelAndView("error", "str", str);
        }
        if (Appz.getInstance().testPcwHash(userLoginCookie, userPassCookie)) {
            User usrLogin = Appz.getInstance().userPresentLogin(userLoginCookie);

            ArrayList<Contact> arrContact = usrLogin.getUserData().getTableContact();
            if (!arrContact.isEmpty()) {
                Contact ctct = arrContact.get(modContactID);
                ArrayList<Address> addrs = usrLogin.getUserData().getAddressAssociatedToContact(ctct);
                if (!addrs.isEmpty()) {
                    return new ModelAndView("new_modify_addrs", "addrs", addrs);
                }
            }
        }
        //TODO
        return new ModelAndView("error");
    }

    @RequestMapping(value = "/modify_addr", method = RequestMethod.GET)
    public ModelAndView modify_adrr_page(HttpServletRequest hsr, HttpServletResponse hsr1) throws Exception {

        //TODO
        HttpSession session = hsr.getSession();
        int modAddrID = Integer.valueOf(hsr.getAttribute("modaddrID").toString());
        
        String userLoginCookie = (String) session.getAttribute("username");
        String userPassCookie = (String) session.getAttribute("password");
        int modContactID = Integer.valueOf(session.getAttribute("MODcontactID").toString());
         session.setAttribute("modaddrID", modAddrID);
        if (userPassCookie == null || userLoginCookie == null) {
            String str = "not logged";
            return new ModelAndView("error", "str", str);
        }
        if (Appz.getInstance().testPcwHash(userLoginCookie, userPassCookie)) {
            User usrLogin = Appz.getInstance().userPresentLogin(userLoginCookie);

            ArrayList<Contact> arrContact = usrLogin.getUserData().getTableContact();
            if (!arrContact.isEmpty()) {
                Contact ctct = arrContact.get(modContactID);
                Address addr = usrLogin.getUserData().getAddressAssociatedToContact(ctct).get(modAddrID);
                if (addr != null) {
                    return new ModelAndView("new_modify_addr", "addr", addr);
                }
            }
        }
            //TODO
        return new ModelAndView("error");
    }

    @RequestMapping(value = "/modify_addr_v")
    public ModelAndView modify_adrr_validator(HttpServletRequest hsr, HttpServletResponse hsr1) throws Exception {

        //TODO
        HttpSession session = hsr.getSession();
        String username = session.getAttribute("username").toString();
        String pcw = session.getAttribute("password").toString();
       int modContactID = Integer.valueOf(session.getAttribute("modaddrID").toString());

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
        } else {
            String str = "please Log in ";
            return new ModelAndView("error", "str", str);
        }
    }

    @RequestMapping(value = "/index")
    public ModelAndView home() {
        Appz instance = Appz.getInstance();
        return new ModelAndView("index");
    }
    
        @RequestMapping(value = "/about_us")
    public ModelAndView about_us_page() {
        
        return new ModelAndView("about_us");
    }

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
    public ModelAndView list_show_page(HttpServletRequest hsr, HttpServletResponse hsr1) throws Exception {
        HttpSession session = hsr.getSession();
        String username = session.getAttribute("username").toString();
        String pcw = session.getAttribute("password").toString();
        if (Appz.getInstance().testPcwHash(username, pcw )) {
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
}
