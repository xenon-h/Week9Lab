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
import java.util.List;

/**
 *
 * @author 759005
 */
public class UserService {

    public List<User> getAllUsers() throws Exception {
        UserDB userDB = new UserDB();
        List<User> resultSet = userDB.getAll();
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

    public void addUser(String email, Boolean active, String firstName, String lastName, String password, Role role) throws Exception {
        UserDB userDB = new UserDB();
        User newUser = new User(email, firstName, lastName, password, role, active);
        userDB.insert(newUser);

    }

    public List<Role> getAllRoles() throws Exception {
        RoleDB roleDB = new RoleDB();
        List<Role> resultSet = roleDB.getAll();
        return resultSet;
    }

}
