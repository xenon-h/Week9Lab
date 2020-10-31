/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

import dataaccess.RoleDB;
import java.io.Serializable;
import java.util.ArrayList;

/**
 *
 * @author User
 */
public class User implements Serializable{
    
    private String email = null;
    private boolean active = false;
    private String firstName = null, lastName = null;
    private String password = null;
    private Role role; //1 = system admin, regular user = 2, company admin = 3
    
    public User(String email, String firstName, String lastName, String password, Role role, boolean active) {//Constructor with role as object
        
        this.email = email;
        this.firstName = firstName;
        this.lastName = lastName;
        this.password = password;
        this.role = role;
        this.active = active;
    }
    public User(String email, String firstName, String lastName, String password, int roleInt, boolean active) throws Exception {//Constructor with role as integer
        RoleDB db = new RoleDB();
        this.email = email;
        this.firstName = firstName;
        this.lastName = lastName;
        this.password = password;
        
        
        
        Role role = db.get(roleInt-1);
        
        this.role = role;
        this.active = active;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
    
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastname() {
        return lastName;
    }

    public void setLastname(String lastname) {
        this.lastName = lastname;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    
    
    
    
    
    
    
}
