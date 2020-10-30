/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

/**
 *
 * @author User
 */
public class Role {
    private String role_name = null;
    private int role_id = 0;
    //1 = system admin, regular user = 2, company admin = 3
    
    public Role(int role_id, String role_name) {
        
        this.role_id = role_id;
        this.role_name = role_name;

    }
}
