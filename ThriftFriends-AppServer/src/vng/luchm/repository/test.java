/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vng.luchm.repository;

import org.apache.thrift.TException;
import vng.luchm.handler.SocialNetworkFriendsHandler;

/**
 *
 * @author luchm
 */
public class test {
    public static void main(String[] args) throws TException {
        SocialNetworkFriendsHandler d = new SocialNetworkFriendsHandler();
        //System.out.println(d.getUserById("5ac6e9ce35953417ba93998c"));
        System.out.println(d.getAllUsers());
    }
}
