/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.test.controller;

/**
 *
 * @author Xnl
 */
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.peondusud.*;
import org.peon.core.*;
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
////        String pathInfo = hsr.getPathInfo();
//        
////        if("/show".equals(pathInfo)){
////            model=this.get();
////        }
////        else if("/add".equals(pathInfo)){
////            model=this.save(hsr.getAttribute("contactForm"));
////        }
////        else if("/modify".equals(pathInfo)){
////            model=this.modifiyLink(hsr, hsr1);
////        }
////         else if("/index".equals(pathInfo)){
////            model=this.home();
////        }
////          else if("/list".equals(pathInfo)){
////            model=this.list();
////        }
//        
        return model;
    }

    @RequestMapping(value = "/show", method = RequestMethod.GET)
    public ModelAndView get() {





        return new ModelAndView("show_list", "contactMan", contactMan);
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

    @RequestMapping(value = "/modify", method = RequestMethod.GET)
    public ModelAndView modifiyLink(HttpServletRequest hsr, HttpServletResponse hsr1) {
        //indice  modID arraylist pour choix contact
        org.peondusud.contact.Contact contact = contactMan.getArrContact().get(Integer.valueOf(hsr.getParameter("modID")));
        return new ModelAndView("show_ selected", "contact", contact);
    }

    @RequestMapping(value = "/index")
    public ModelAndView home() {
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
//        if(org.peon.core.Appz.getInstance().isLoginPresent(login.toString()) ){
//            String str = new String(" already used login");
//            return new ModelAndView("error","value",str);
//        }
        
        Appz.getInstance().addUser( new User(login.toString(), pcw.toString()) );
        System.out.println(firstname);
        System.out.println(lastname);
        System.out.println(email);
        System.out.println(phone);

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

        //TODO : destroy session
        HttpSession session = hsr.getSession();
        session.invalidate();
        return new ModelAndView("index");
    }
}
