/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dataaccess;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import models.User;

/**
 *
 * @author 814992
 */
public class UserDB {
    
    ArrayList<User> userList = new ArrayList();
    ConnectionPool cp = ConnectionPool.getInstance();
    Connection con = cp.getConnection();
    PreparedStatement ps = null;
    ResultSet rs = null;
    
    String getAllStmt = "SELECT * from userdb";
    
    
    
    public ArrayList<User> getAll() throws Exception{
        
        
        
        try{
        ps = con.prepareStatement(getAllStmt);
        rs = ps.executeQuery();
        
        while(rs.next()){
            
            //email,active,firstname, lastname,password, role
            
            String email = rs.getString(1);
            Boolean active = rs.getBoolean(2);
            String firstName = rs.getString(3);
            String lastName = rs.getString(4);
            String password = rs.getString(5);
            int role = rs.getInt(6);
            
            User user = new User(email, firstName,lastName, password, role, active);
            userList.add(user);
            
            
        }
        
        
        
        
        }
        finally {
            DBUtil.closeResultSet(rs);
            DBUtil.closePreparedStatement(ps);
            cp.freeConnection(con);
        }
        return userList;
        
    }
    
    
    
    
    
}
