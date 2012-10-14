/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.esiea.controller;

import com.esiea.core.Appz;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.springframework.web.servlet.ModelAndView;

public class ServerUtils {

    public static boolean isCorreclyLogged(HttpServletRequest hsr, HttpServletResponse hsr1) {
        try {
            HttpSession session = hsr.getSession();
            String username = session.getAttribute("username").toString();
            String pcw = session.getAttribute("password").toString();
            return Appz.getInstance().testPcwHash(username, pcw);
        } catch (Exception e) {
            return false;
        }
    }

    public static String getUsername(HttpServletRequest hsr) {
        HttpSession session = hsr.getSession();
        String username = session.getAttribute("username").toString();
        return username;
    }



}
