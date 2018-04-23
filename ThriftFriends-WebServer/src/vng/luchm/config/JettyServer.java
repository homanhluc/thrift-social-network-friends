/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vng.luchm.config;

import org.eclipse.jetty.server.Connector;
import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.server.ServerConnector;
import org.eclipse.jetty.server.session.HashSessionIdManager;
import org.eclipse.jetty.server.session.SessionHandler;
import org.eclipse.jetty.servlet.ServletHandler;
import org.eclipse.jetty.servlet.ServletHolder;
import org.eclipse.jetty.util.thread.QueuedThreadPool;
import vng.luchm.controller.GetAllUsers;
import vng.luchm.controller.GetFriendsList;
import vng.luchm.controller.GetUserById;
import vng.luchm.controller.Login;
import vng.luchm.controller.Logout;
import vng.luchm.controller.Register;
import vng.luchm.controller.RequestAction;

/**
 *
 * @author luchm
 */
public class JettyServer {

    private static Server server;

    public static void start() throws Exception {

        int maxThreads = 200;
        int minThreads = 10;
        int idleTimeout = 120;

        QueuedThreadPool threadPool;
        threadPool = new QueuedThreadPool(maxThreads, minThreads, idleTimeout);

        server = new Server(threadPool);
        ServerConnector connector = new ServerConnector(server);
        connector.setPort(9001);
        server.setConnectors(new Connector[]{connector});

        ServletHandler servletHandler = new ServletHandler();
        server.setHandler(servletHandler);

        servletHandler.addServletWithMapping(Register.class, "/register");
        servletHandler.addServletWithMapping(Login.class, "/login");
        servletHandler.addServletWithMapping(GetAllUsers.class, "/all");
        servletHandler.addServletWithMapping(GetUserById.class, "/user");
        servletHandler.addServletWithMapping(RequestAction.class, "/ra");
        servletHandler.addServletWithMapping(GetFriendsList.class, "/friends");
        servletHandler.addServletWithMapping(Logout.class, "/logout");
        
        
        setSessionEnableContext(server, servletHandler);
        server.start();

    }

    private static void setSessionEnableContext(Server server, ServletHandler handlerServlet) {
        // Specify the Session ID Manager        
        HashSessionIdManager idmanager = new HashSessionIdManager();
        server.setSessionIdManager(idmanager);
        // Specify the session handler
        SessionHandler sessionsHandler = new SessionHandler();
        handlerServlet.setHandler(sessionsHandler);
        
    }

    public static void stop() throws Exception {
        server.stop();
    }
}
