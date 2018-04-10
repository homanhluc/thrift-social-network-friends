/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vng.luchm.handler;

import java.util.List;
import org.apache.thrift.TException;
import vng.luchm.repository.UserRepositoryImp;
import vng.luchm.thrift.ActionUser;
import vng.luchm.thrift.SocialNetworkFriendsService;
import vng.luchm.thrift.User;

/**
 *
 * @author luchm
 */
public class SocialNetworkFriendsHandler implements SocialNetworkFriendsService.Iface {
    
    final UserRepositoryImp ur = new UserRepositoryImp();
    @Override
    public boolean requestAction(String id_user_one, String id_user_two, ActionUser action) throws TException {
        switch(action) {
            case PENDING:
                return ur.addFriend(id_user_one, id_user_two);
            case ACCEPTED:
                return ur.acceptFriend(id_user_one, id_user_two);
            case DECLINED:
                return ur.declinFriend(id_user_one, id_user_two);
            case DELETED:
                return ur.unFriend(id_user_one, id_user_two);
        }
        return false;
    }

    @Override
    public List<User> getAllUsers() throws TException {
        return ur.getAllUsers();
    }

    @Override
    public User getUserById(String id) throws TException {
        return ur.getUserById(id);
    }

    @Override
    public boolean registerUser(String un) throws TException {
        return ur.registerUser(un);
    }

    @Override
    public boolean loginUser(String un) throws TException {
        return ur.loginUser(un);
    }

    
}
