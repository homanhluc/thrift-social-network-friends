/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vng.luchm.handler;

import java.io.Serializable;
import java.util.List;
import org.apache.thrift.TException;
import vng.luchm.config.ThriftClient;
import vng.luchm.thrift.ActionUser;
import vng.luchm.thrift.User;

/**
 *
 * @author luchm
 */
public class Handler implements Serializable {

    private static final long serialVersionUID = 1L;

    public synchronized static List<User> getAllUser() throws TException {
        return ThriftClient.client.getAllUsers();
    }

    public synchronized static User getUserById(String id) throws TException {
        return ThriftClient.client.getUserById(id);
    }

    public synchronized static User login(String userName) throws TException {
        return ThriftClient.client.loginUser(userName);
    }

    public synchronized static boolean register(String userName) throws TException {
        return ThriftClient.client.registerUser(userName);
    }

    public synchronized static boolean addFriend(String id_user_one, String id_user_two) throws TException {
        return ThriftClient.client.requestAction(id_user_one, id_user_two, ActionUser.PENDING);
    }

    public synchronized static boolean acceptFriend(String id_user_one, String id_user_two) throws TException {
        return ThriftClient.client.requestAction(id_user_one, id_user_two, ActionUser.ACCEPTED);
    }

    public synchronized static boolean declinFriend(String id_user_one, String id_user_two) throws TException {
        return ThriftClient.client.requestAction(id_user_one, id_user_two, ActionUser.DECLINED);
    }

    public synchronized static boolean unFriend(String id_user_one, String id_user_two) throws TException {
        return ThriftClient.client.requestAction(id_user_one, id_user_two, ActionUser.DELETED);
    }
}
