/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vng.luchm.controller;

import com.google.gson.Gson;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.apache.thrift.TException;
import vng.luchm.handler.Handler;

/**
 *
 * @author luchm
 */
public class GetAllUsers extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            contentType(resp);
            HttpSession session = req.getSession();
            if (session.getAttribute("user_session") != null) {
                resp.getWriter().write(new Gson().toJson(Handler.getAllUser()));
            } else {
                resp.getWriter().write(new Gson().toJson(false));
            }
            
        } catch (TException ex) {
            ex.printStackTrace();
        }
    }

    private static void contentType(HttpServletResponse resp) {
        resp.setContentType("application/json");
        resp.setCharacterEncoding("UTF-8");
        resp.setHeader("Access-Control-Allow-Origin", "http://localhost:9001");
        resp.setHeader("Access-Control-Allow-Methods", "GET");
    }
}
