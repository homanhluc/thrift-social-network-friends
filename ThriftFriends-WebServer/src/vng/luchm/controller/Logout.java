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
public class Logout extends HttpServlet {
    private static final long serialVersionUID = 1L;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        contentType(resp);
        HttpSession session = req.getSession();
        if (session.getAttribute("user_session") != null) {
            session.invalidate();
            resp.getWriter().write(new Gson().toJson(true));
        } else {
            resp.getWriter().write(new Gson().toJson(false));
        }
    }

    private static void contentType(HttpServletResponse resp) {
        resp.setContentType("application/json");
        resp.setCharacterEncoding("UTF-8");
    }
}
