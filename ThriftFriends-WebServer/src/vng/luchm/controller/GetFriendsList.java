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
import vng.luchm.handler.Handler;
import vng.luchm.main.WebServerMain;
import vng.luchm.thrift.FriendLists;

/**
 *
 * @author luchm
 */
public class GetFriendsList extends HttpServlet {

    private WebServerMain MAIN;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        contentType(resp);
        HttpSession session = req.getSession();
        if (session.getAttribute("user_session") != null) {
            String id = req.getParameter("id");
            List<FriendLists> list = MAIN.caches.get(id);
            resp.getWriter().write(new Gson().toJson(list));
        } else {
            resp.getWriter().write(new Gson().toJson(false));
        }

    }

    private static void contentType(HttpServletResponse resp) {
        resp.setContentType("application/json");
        resp.setCharacterEncoding("UTF-8");
    }
}
