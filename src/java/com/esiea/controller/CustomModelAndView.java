package com.esiea.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.web.servlet.ModelAndView;

public class CustomModelAndView extends ModelAndView
{
    public CustomModelAndView(HttpServletRequest hsr, HttpServletResponse hsr1) 
    {
        boolean test = ServerUtils.isCorreclyLogged(hsr, hsr1);
        this.addObject("isLogged", test);
    }
    
    public CustomModelAndView(HttpServletRequest hsr, HttpServletResponse hsr1, String view) 
    {
        boolean test = ServerUtils.isCorreclyLogged(hsr, hsr1);
        this.setViewName(view);
        this.addObject("isLogged", test);
    }
    
}
