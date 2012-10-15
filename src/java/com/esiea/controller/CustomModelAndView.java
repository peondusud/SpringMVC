package com.esiea.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.web.servlet.ModelAndView;

public class CustomModelAndView extends ModelAndView
{
    public CustomModelAndView(HttpServletRequest hsr, HttpServletResponse hsr1) 
    {
        boolean test;
        try 
        {
            test = ServerUtils.isCorreclyLogged(hsr, hsr1);
        } catch (Exception ex) 
        {
            test=false;
        }
        this.addObject("isLogged", test);
    }
    
    public CustomModelAndView(HttpServletRequest hsr, HttpServletResponse hsr1, String view) 
    {
        boolean test;
        try 
        {
            test = ServerUtils.isCorreclyLogged(hsr, hsr1);
        } catch (Exception ex) 
        {
            test=false;
        }
        this.setViewName(view);
        this.addObject("isLogged", test);
    }
    
}
