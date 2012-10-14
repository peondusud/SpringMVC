/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.esiea.controller;

import com.esiea.core.Appz;
import com.esiea.core.User;
import java.util.ArrayList;
import java.util.Iterator;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class ServerUtils 
{

    public static boolean isCorreclyLogged(HttpServletRequest hsr, HttpServletResponse hsr1) 
    {
        try 
        {
            HttpSession session = hsr.getSession();
            String username = session.getAttribute("username").toString();
            String pcw = session.getAttribute("password").toString();
            boolean test = Appz.getInstance().testPcwHash(username, pcw);
            if(!test)
            {
                hsr.removeAttribute("password");
                hsr.removeAttribute("username");
            }
            return test;
        } 
        catch (Exception e) 
        {
            return false;
        }
    }

    private static String getUsername(HttpServletRequest hsr) throws Exception 
    {
        try 
        {
            
            HttpSession session = hsr.getSession();
            String username = session.getAttribute("username").toString();
            return username;
        } 
        catch (Exception e) 
        {
            throw new Exception();
        }
    }
    
    private static User getUserFromLogin(String str) 
    {
        ArrayList<User> dataBase = Appz.getInstance().getDataBase();
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
    
    public static User getUser(HttpServletRequest hsr, HttpServletResponse hsr1) throws Exception
    {
        if(!ServerUtils.isCorreclyLogged(hsr, hsr1))
        {
            throw new Exception();
        }
        else
        {
            try
            {
                return ServerUtils.getUserFromLogin(ServerUtils.getUsername(hsr));
            }
            catch (Exception e) 
            {
                throw e;
            }
        }
    }

}
