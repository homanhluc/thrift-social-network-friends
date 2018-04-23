/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vng.luchm.controller;

import com.google.gson.Gson;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.apache.thrift.TException;
import vng.luchm.handler.Handler;
import vng.luchm.main.WebServerMain;
import vng.luchm.thrift.User;

/**
 *
 * @author luchm
 */
public class Login extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private WebServerMain MAIN;
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        contentType(resp);

        HttpSession session = req.getSession();
        Status o = new Status();

        if (session.getAttribute("user_session") != null) {
            o.status = session.getAttribute("user_session").toString();
            resp.getWriter().write(new Gson().toJson(o));
        } else {
            o.status = "Time out!";
            resp.getWriter().write(new Gson().toJson(o));
        }
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        
        try {
            contentType(resp);
            
            User u = new User();
            String name = req.getParameter("name");
            u = Handler.login(name);
            if (u != null) {
                HttpSession session = req.getSession(true);
                session.setAttribute("user_session", u.Id);
                session.setMaxInactiveInterval(10*60);
                resp.getWriter().write(new Gson().toJson(u));
                MAIN.caches.put(u.Id, u.Friends);
            } else
                resp.getWriter().write(new Gson().toJson(false));

        } catch (TException ex) {
            Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private static void contentType(HttpServletResponse resp) {
        resp.setContentType("application/json");
        resp.setCharacterEncoding("UTF-8");
    }

    class Status {

        String status;
    }
}
