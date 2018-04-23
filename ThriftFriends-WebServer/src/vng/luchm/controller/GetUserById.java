/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vng.luchm.controller;

import com.google.gson.Gson;
import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.apache.thrift.TException;
import vng.luchm.handler.Handler;
import vng.luchm.thrift.FriendLists;
import vng.luchm.thrift.User;

/**
 *
 * @author luchm
 */
public class GetUserById extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            HttpSession session = req.getSession();
            if (session.getAttribute("user_session") != null) {
                Handler handler = new Handler();
                User o = handler.getUserById(req.getParameter("id"));
                contentType(resp);
                resp.getWriter().write(new Gson().toJson(o));
            } else {
                resp.getWriter().write(new Gson().toJson(false));
            }

        } catch (TException ex) {
            System.out.println(ex);
        }
    }

    private static void contentType(HttpServletResponse resp) {
        resp.setContentType("application/json");
        resp.setCharacterEncoding("UTF-8");
    }
}
