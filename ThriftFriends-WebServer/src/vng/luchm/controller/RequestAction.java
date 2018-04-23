/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vng.luchm.controller;

import com.google.gson.Gson;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.apache.thrift.TException;
import vng.luchm.handler.Handler;
import vng.luchm.thrift.User;

/**
 *
 * @author luchm
 */
public class RequestAction extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            HttpSession session = req.getSession();
            if (session.getAttribute("user_session") != null) {
                String id_user_one = req.getParameter("user1");
                String id_User_two = req.getParameter("user2");
                String requet_action = req.getParameter("action");

                switch (Integer.parseInt(requet_action)) {
                    case 1:
                        Handler.addFriend(id_user_one, id_User_two);
                        break;
                    case 2:
                        Handler.acceptFriend(id_user_one, id_User_two);
                        break;
                    case 3:
                        Handler.declinFriend(id_user_one, id_User_two);
                        break;
                    case 4:
                        Handler.unFriend(id_user_one, id_User_two);
                        break;
                }
            } else {
                resp.getWriter().write(new Gson().toJson(false));
            }

        } catch (TException ex) {
            Logger.getLogger(RequestAction.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private static void contentType(HttpServletResponse resp) {
        resp.setContentType("application/json");
        resp.setCharacterEncoding("UTF-8");
    }
}
