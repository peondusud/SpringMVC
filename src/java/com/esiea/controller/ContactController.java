/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.esiea.controller;

import com.esiea.core.Address;
import com.esiea.core.Appz;
import com.esiea.core.Contact;
import com.esiea.core.User;
import java.util.ArrayList;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ContactController {
    
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
            User usrLogin = Appz.getInstance().getUserFromLogin(userLoginCookie);

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
        String username = session.getAttribute("username").toString();
        String pcw = session.getAttribute("password").toString();
        boolean test = Appz.getInstance().testPcwHash(username, pcw);

        if (test) {
            Contact tmpContact = (Contact) session.getAttribute("contactOject");

            String nick = hsr.getParameter("addr_nick").toString();
            String nb = hsr.getParameter("addr_nb").toString();
            String rue = hsr.getParameter("addr_rue").toString();
            String ville = hsr.getParameter("addr_ville").toString();
            String cp = hsr.getParameter("addr_cp").toString();
            String pays = hsr.getParameter("addr_pays").toString();

            Address tmpAddr = new Address(nb, rue, ville, cp, pays);
            Appz.getInstance().addContact(username, tmpContact, tmpAddr);
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
            Appz.getInstance().modifyContact(username, old, modifyCtct);
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
            User usrLogin = Appz.getInstance().getUserFromLogin(userLoginCookie);

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
         int modAddrID = Integer.valueOf(hsr.getParameter("modaddrID"));

        String userLoginCookie = (String) session.getAttribute("username");
        String userPassCookie = (String) session.getAttribute("password");
        int modContactID = Integer.valueOf(session.getAttribute("MODcontactID").toString());
        session.setAttribute("modaddrID", modAddrID);
        if (userPassCookie == null || userLoginCookie == null) {
            String str = "not logged";
            return new ModelAndView("error", "str", str);
        }
        if (Appz.getInstance().testPcwHash(userLoginCookie, userPassCookie)) {
            User usrLogin = Appz.getInstance().getUserFromLogin(userLoginCookie);

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

    @RequestMapping(value = "/modify_addr_v",  method = RequestMethod.POST)
    public ModelAndView modify_adrr_validator(HttpServletRequest hsr, HttpServletResponse hsr1) throws Exception {

        //TODO
        HttpSession session = hsr.getSession();
        String username = session.getAttribute("username").toString();
        String pcw = session.getAttribute("password").toString();
        int modaddrID = Integer.valueOf(session.getAttribute("modaddrID").toString());
        int modContactID = Integer.valueOf(session.getAttribute("MODcontactID").toString());
        if (Appz.getInstance().testPcwHash(username, pcw)) 
        {
            String nb = hsr.getParameter("addr_nb").toString();
            String rue = hsr.getParameter("addr_rue").toString();
            String ville = hsr.getParameter("addr_ville").toString();
            String cp = hsr.getParameter("addr_cp").toString();
            String pays = hsr.getParameter("addr_pays").toString();
            Address tmpAddr = new Address(nb, rue, ville, cp, pays);
            Address oldAddr = Appz.getInstance().getDataBase().get(modContactID).getUserData().getTableAddress().get(modaddrID);
            Appz.getInstance().modifyAddr( oldAddr, tmpAddr);            
            ArrayList<Contact> arrContact = Appz.getInstance().getArrContact(username);
            return new ModelAndView("list_show", "arrContact", arrContact);
        } 
        else 
        {
            String str = "please Log in ";
            return new ModelAndView("error", "str", str);
        }
    }



    @RequestMapping(value = "/delete", method = RequestMethod.GET)
    public ModelAndView delete(HttpServletRequest hsr, HttpServletResponse hsr1) throws Exception {

        int index = Integer.valueOf(hsr.getParameter("deleteID"));
        HttpSession session = hsr.getSession();
        String username = session.getAttribute("username").toString();
        if (Appz.getInstance().testPcwHash(username, session.getAttribute("password").toString())) 
        {
            Appz.getInstance().removeContact(username, index);
            ArrayList<Contact> arrContact = Appz.getInstance().getArrContact(username);
            return new ModelAndView("list_show", "arrContact", arrContact);

        } 
        else 
        {
            String str = "please Log in ";
            return new ModelAndView("error", "str", str);
        }

    }

    @RequestMapping(value = "/list_show", method = RequestMethod.GET)
    public ModelAndView list_show_page(HttpServletRequest hsr, HttpServletResponse hsr1)
    {
        if (ServerUtils.isCorreclyLogged(hsr, hsr1)) 
        {
            String username = ServerUtils.getUsername(hsr);
            ArrayList<Contact> arrContact = Appz.getInstance().getArrContact(username);
            CustomModelAndView modelAndView = new CustomModelAndView(hsr, hsr1,"list_show");
            modelAndView.addObject("arrContact", arrContact);
            return modelAndView;
        } 
        else 
        {
            return new ModelAndView("login");
        }
    }
}
