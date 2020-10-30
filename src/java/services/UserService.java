/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import models.*;
import dataaccess.UserDB;
import dataaccess.RoleDB;
import java.util.ArrayList;

/**
 *
 * @author 759005
 */
public class UserService {

    public ArrayList<User> getAllUsers() throws Exception {
        UserDB userDB = new UserDB();
        ArrayList resultSet = userDB.getAll();
        return resultSet;
    }
    
    public User getUser(String email)throws Exception{
        UserDB userDB = new UserDB();
        return userDB.getUser(email);
    }

    public void updateUser(String email, Boolean active, String firstName, String lastName, String password, int role)throws Exception {
        UserDB userDB = new UserDB();
        User currUser = new User(email, firstName, lastName, password, role, active);
        userDB.updateUser(currUser);
    }

    public void deleteUser(String email) {
        UserDB userDB = new UserDB();
        userDB.deleteUser(email);
    }

    public void addUser(String email, Boolean active, String firstName, String lastName, String password, int role) throws Exception{
        UserDB userDB = new UserDB();
        User newUser = new User(email, firstName, lastName, password, role, active);
        userDB.addUser(newUser);

    }

    public ArrayList<User> getAllRoles() throws Exception {
        RoleDB roleDB = new RoleDB();
        ArrayList resultSet = roleDB.getAll();
        return resultSet;
    }

}
