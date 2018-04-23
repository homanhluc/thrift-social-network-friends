/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vng.luchm.repository;

import java.util.List;
import vng.luchm.thrift.User;

/**
 *
 * @author luchm
 */
public interface IUserRepository {
    boolean registerUser(String un);
    User loginUser(String un);
    User getUserById(String id);
    List<User> getAllUsers();
    void logQuery(String query);
    
    boolean addFriend(String id_user_one, String id_user_two);
    boolean unFriend(String id_user_one, String id_user_two);
    boolean acceptFriend(String id_user_one, String id_user_two);
    boolean declinFriend(String id_user_one, String id_user_two);
}
