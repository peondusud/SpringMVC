/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.test.controller;

/**
 *
 * @author Xnl
 */
import java.util.ArrayList;
import java.util.Iterator;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.peondusud.*;
import org.peon.core.*;
import org.peondusud.contact.ContactManager;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.portlet.mvc.AbstractController;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class CustomerController {

    org.peondusud.contact.ContactManager contactMan = new org.peondusud.contact.ContactManager(org.peondusud.contact.ContactManager.PopulateContact());

    protected ModelAndView handleRequestInternal(HttpServletRequest hsr, HttpServletResponse hsr1) throws Exception {
        ModelAndView model = null;
    
        return model;
    }

    @RequestMapping(value = "/show", method = RequestMethod.GET)
    public ModelAndView get(HttpServletRequest hsr, HttpServletResponse hsr1) {
        HttpSession session = hsr.getSession();
        String userLoginCookie = (String) session.getAttribute("username");
        String userPassCookie = (String) session.getAttribute("password");

        if (userPassCookie == null || userLoginCookie == null) {
            String str = "not logged";
            return new ModelAndView("error", "str", str);
        }

        User usrLogin = Appz.getInstance().userPresentLogin(userLoginCookie);
        //usrLogin.getPassword() != userPassCookie.toString()
        if (!usrLogin.getPassword().equals(userPassCookie.toString())) {

            String str = "login & password no match same user";
            return new ModelAndView("error", "str", str);
        }

        ArrayList<Contact> arrContact = usrLogin.getUserData().getTableContact();
        org.peondusud.contact.ContactManager arrContactMan = new ContactManager();
        ArrayList<org.peondusud.contact.Contact> arrCont= new ArrayList<org.peondusud.contact.Contact>();
        Iterator<Contact> itr = arrContact.iterator();
        while (itr.hasNext()) {
            org.peondusud.contact.Contact tmpContact = new org.peondusud.contact.Contact();
            Contact element = itr.next();
            tmpContact.setNom(element.getNom());
            tmpContact.setPrenom(element.getPrenom());
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
        //return new ModelAndView("show_list_2", "arrContact", arrContact);
        return new ModelAndView("show_list_1", "arrContactMan", arrContactMan);
    }

    @RequestMapping(value = "/list_add", method = RequestMethod.GET)
    public ModelAndView list(HttpServletRequest hsr, HttpServletResponse hsr1) {
        HttpSession session = hsr.getSession();
        String userLoginCookie = (String) session.getAttribute("username");
        String userPassCookie = (String) session.getAttribute("password");

        if (userPassCookie == null || userLoginCookie == null) {
            String str = new String("not logged");
            return new ModelAndView("error", "str", str);
        }

        User usrLogin = Appz.getInstance().userPresentLogin(userLoginCookie);
        ArrayList<Contact> arrContact = usrLogin.getUserData().getTableContact();
        Contact ctct = arrContact.get(Integer.valueOf(hsr.getParameter("contactID")));
        ArrayList<Address> addrs = usrLogin.getUserData().getAddressAssociatedToContact(ctct);
        return new ModelAndView("list_add", "addrs", addrs);
    }

    @RequestMapping(value = "/add", method = RequestMethod.GET)
    public ModelAndView add_page() {
        return new ModelAndView("add_contact", "contactMan", contactMan);
    }

    @RequestMapping(value = "/addc", method = RequestMethod.POST)
    public ModelAndView save(HttpServletRequest hsr, HttpServletResponse hsr1) {
        Object toto = hsr.getParameter("image");
        System.out.println(toto);
        Object toto2 = hsr.getParameter("nom");
        System.out.println(toto2);
        return new ModelAndView("add_contact", "contactMan", contactMan);
    }

        @RequestMapping(value = "/add2", method = RequestMethod.GET)
    public ModelAndView add_page2() {
        return new ModelAndView("add_contact", "contactMan", contactMan);
    }

    @RequestMapping(value = "/addd", method = RequestMethod.POST)
    public ModelAndView saved(HttpServletRequest hsr, HttpServletResponse hsr1) {
        Object prenom = hsr.getParameter("prenom");
        Object nom = hsr.getParameter("nom");
        Object phone = hsr.getParameter("phone");
        Object mail = hsr.getParameter("mail");
        Object addr_nick = hsr.getParameter("addr_nick");
        Object addr_nb = hsr.getParameter("addr_nb");
        Object addr_rue = hsr.getParameter("addr_rue");
        Object addr_cp = hsr.getParameter("addr_cp");
        Object addr_ville = hsr.getParameter("addr_ville");
        Object addr_pays = hsr.getParameter("addr_pays");
         Object birthday = hsr.getParameter("birthday");
                HttpSession session = hsr.getSession();
        String userLoginCookie = (String) session.getAttribute("username");
        String userPassCookie = (String) session.getAttribute("password");

        if (userPassCookie == null || userLoginCookie == null) {
            String str = new String("not logged");
            return new ModelAndView("error", "str", str);
        }

        User usrLogin = Appz.getInstance().userPresentLogin(userLoginCookie);
        ArrayList<Contact> arrContact = usrLogin.getUserData().getTableContact();
         
        Appz.getInstance().addContact(userLoginCookie) ;

        
         System.out.println(prenom);
        System.out.println(nom);
        
        return new ModelAndView("show_list_1", "contactMan", contactMan);
    }
    
    
    @RequestMapping(value = "/modify", method = RequestMethod.GET)
    public ModelAndView modifiyLink(HttpServletRequest hsr, HttpServletResponse hsr1) {
        //indice  modID arraylist pour choix contact
        org.peondusud.contact.Contact contact = contactMan.getArrContact().get(Integer.valueOf(hsr.getParameter("modID")));
        return new ModelAndView("show_ selected", "contact", contact);
    }

    @RequestMapping(value = "/index")
    public ModelAndView home() {
        Appz instance = Appz.getInstance();
        return new ModelAndView("index");
    }

    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public ModelAndView list() {

        return new ModelAndView("show_list", "contactMan", contactMan);
    }

    @RequestMapping(value = "/delete", method = RequestMethod.GET)
    public ModelAndView delete(HttpServletRequest hsr, HttpServletResponse hsr1) {

        int index = Integer.valueOf(hsr.getParameter("deleteID"));
        contactMan.arrContact.remove(index);
        return new ModelAndView("show_list", "contactMan", contactMan);
    }

    @RequestMapping(value = "/signinc", method = RequestMethod.POST)
    public ModelAndView signinc(HttpServletRequest hsr, HttpServletResponse hsr1) {

        //TODO : inscription
        //test si login existe sinon on cree un user
        //teste chanp vide javascript

        Object login = hsr.getParameter("login");
        Object pcw = hsr.getParameter("password");
        Object firstname = hsr.getParameter("firstname");
        Object lastname = hsr.getParameter("lastname");
        Object email = hsr.getParameter("email");
        Object phone = hsr.getParameter("telephone");
        if (org.peon.core.Appz.getInstance().isLoginPresent(login.toString())) {
            String str = new String("login already used");
            return new ModelAndView("error", "str", str);
        }

        Appz.getInstance().addUser(new User(login.toString(), pcw.toString()));
        return new ModelAndView("success");
    }

    @RequestMapping(value = "/signin")
    public ModelAndView signin(HttpServletRequest hsr, HttpServletResponse hsr1) {
        return new ModelAndView("signin");
    }

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public ModelAndView loggin(HttpServletRequest hsr, HttpServletResponse hsr1) {

        HttpSession session = hsr.getSession();
        String userPass = hsr.getParameter("password");
        String userPassCookie = (String) session.getAttribute("password");

        if (userPassCookie == null && userPass == null) {
            return new ModelAndView("login");
        } else if (userPassCookie != null) {
            String userName = (String) session.getAttribute("username");
            return new ModelAndView("logged", "userName", userName);
        } else if (userPass != null) {
            String userName = hsr.getParameter("username");
            session.setAttribute("username", userName);
            session.setAttribute("password", userPass);
            return new ModelAndView("logged", "userName", userName);
        } else {
            return new ModelAndView("login");
        }
    }

    @RequestMapping(value = "/logout")
    public ModelAndView logout(HttpServletRequest hsr, HttpServletResponse hsr1) {

        HttpSession session = hsr.getSession();
        session.invalidate();
        return new ModelAndView("index");
    }
}
