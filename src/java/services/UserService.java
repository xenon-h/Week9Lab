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
import java.util.logging.Level;
import java.util.logging.Logger;

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

    public User getUser(String email) throws Exception {
        UserDB userDB = new UserDB();
        return userDB.get(email);
    }

    public void updateUser(String email, Boolean active, String firstName, String lastName, String password, int role) throws Exception {
        UserDB userDB = new UserDB();
        User currUser = new User(email, firstName, lastName, password, role, active);
        userDB.update(currUser);
    }

    public void deleteUser(String email) throws Exception {
        UserDB userDB = new UserDB();
        User user;
        user = userDB.get(email);
        userDB.delete(user);
    }

    public void addUser(String email, Boolean active, String firstName, String lastName, String password, int role) throws Exception {
        UserDB userDB = new UserDB();
        User newUser = new User(email, firstName, lastName, password, role, active);
        userDB.insert(newUser);

    }

    public ArrayList<Role> getAllRoles() throws Exception {
        RoleDB roleDB = new RoleDB();
        ArrayList<Role> resultSet = roleDB.getAll();
        return resultSet;
    }

}
