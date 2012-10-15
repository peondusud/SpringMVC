package com.esiea.controller;

import com.esiea.core.Appz;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class LoggingController {
    
    @RequestMapping(value = "/index")
    public CustomModelAndView home(HttpServletRequest hsr, HttpServletResponse hsr1)
    {
        return new CustomModelAndView(hsr, hsr1,"index");
    }

    @RequestMapping(value = "/logout")
    public CustomModelAndView logout(HttpServletRequest hsr, HttpServletResponse hsr1) 
    {
        hsr.getSession().invalidate();
        return new CustomModelAndView(hsr, hsr1,"redirect:/");
    }

    @RequestMapping(value = "/about_us")
    public CustomModelAndView about_us_page(HttpServletRequest hsr, HttpServletResponse hsr1) 
    {
        return new CustomModelAndView(hsr, hsr1,"/account/about_us");
    }
    
    @RequestMapping(value = "/signin")
    public CustomModelAndView signin(HttpServletRequest hsr, HttpServletResponse hsr1) 
    {
        return new CustomModelAndView(hsr, hsr1,"/account/signin");
    }

    @RequestMapping(value = "/login")
    public CustomModelAndView loggin(HttpServletRequest hsr, HttpServletResponse hsr1) 
    {
        return new CustomModelAndView(hsr, hsr1,"/account/login");
    }

    
    @RequestMapping(value = "/login_v", method = RequestMethod.POST)
    public CustomModelAndView loggin_validator(HttpServletRequest hsr, HttpServletResponse hsr1) 
    {
        HttpSession session = hsr.getSession();
        String userName = hsr.getParameter("username");
        String userPass = hsr.getParameter("password");
        String userPassCookie = (String) session.getAttribute("password");

        if (userPassCookie == null && userPass == null) 
        {
            return new CustomModelAndView(hsr,hsr1,"/account/login");
        } 
        else if (userPassCookie != null && userPass == null) 
        {
            return new CustomModelAndView(hsr,hsr1,"redirect:/list_show.html");
        } 
        else if (userPass != null && userPassCookie == null) 
        {
            if (Appz.getInstance().UsernameAndPasswordAreCorrect(userName, userPass)) 
            {
                try 
                {
                    session.setAttribute("username", userName);
                    MessageDigest instance = MessageDigest.getInstance("MD5");
                    byte[] bytes = userPass.getBytes();
                    byte[] digest = instance.digest(bytes);
                    String toString = new String(digest);
                    session.setAttribute("password", toString);
                    return new CustomModelAndView(hsr,hsr1,"redirect:/index.html");
                } 
                catch (NoSuchAlgorithmException ex) 
                {
                    return new CustomModelAndView(hsr,hsr1,"redirect:/");
                }
            } 
            else 
            {
                String str = "Nom d'utilisateur ou mot de passe incorrect!";
                CustomModelAndView customModelAndView = new CustomModelAndView(hsr, hsr1, "/error");
                customModelAndView.addObject("str", str);
                return customModelAndView;
            }

        } 
        else 
        {
            session.invalidate();
            return new CustomModelAndView(hsr,hsr1,"redirect:/");
        }
    }
    
}
