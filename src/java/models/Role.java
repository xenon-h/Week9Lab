/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

import java.io.Serializable;

/**
 *
 * @author Jordan
 */
public class Role implements Serializable{
    public String roleName = null;
    public int roleId = 0;
    //1 = system admin, regular user = 2, company admin = 3
    
    public Role(int roleId, String roleName) {
        
        this.roleId = roleId;
        this.roleName = roleName;

    }
    
    public Role(){
        
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    public int getRoleId() {
        return roleId;
    }

    public void setRoleId(int roleId) {
        this.roleId = roleId;
    }
    
    
}
