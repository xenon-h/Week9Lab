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
    String getStmt = "SELECT * from userdb WHERE email = ?";
    public User get(String email) throws Exception{
        
        User user = null;
        
        try{
        ps = con.prepareStatement(getStmt);
        ps.setString(1, email);
        rs = ps.executeQuery();
        
        while(rs.next()){
            
            //email,active,firstname, lastname,password, role
            
            String emailString = rs.getString(1);
            Boolean active = rs.getBoolean(2);
            String firstName = rs.getString(3);
            String lastName = rs.getString(4);
            String password = rs.getString(5);
            int role = rs.getInt(6);
            
            user = new User(emailString, firstName,lastName, password, role, active);
            
            
            
        }
        
        
        
        
        }
        finally {
            DBUtil.closeResultSet(rs);
            DBUtil.closePreparedStatement(ps);
            cp.freeConnection(con);
        }
        return user;
        
    }
    
    public void insert(User user) throws Exception {
        ConnectionPool cp = ConnectionPool.getInstance();
        Connection con = cp.getConnection();
        
        
        PreparedStatement ps = null;
        
        String insertStmt = "INSERT INTO userdb(email, active, firstName, lastName, password, role) VALUES(?, ?, ?, ?, ?, ?)";
        
        try{
            ps = con.prepareStatement(insertStmt);
            
            ps.setString(1, user.getEmail());
            ps.setBoolean(2, user.isActive());
            ps.setString(3, user.getFirstName());
            ps.setString(4, user.getLastName());
            ps.setString(5, user.getPassword());
            ps.setInt(6, user.getRole());
            
        }
        finally{
            DBUtil.closePreparedStatement(ps);
            cp.freeConnection(con);
        }
        
        
        
        
        
        
    }
    
    public void update(User user) throws Exception
        {
        ConnectionPool cp = ConnectionPool.getInstance();
        Connection con = cp.getConnection();
        PreparedStatement ps = null;
        
        String updateStmt = "UPDATE userdb SET email=?, active=?, firstName=?, lastName=?, password=?, role=? WHERE email=?";
        
        try{
             ps = con.prepareStatement(updateStmt);
        ps.setString(1, user.getEmail());
            ps.setBoolean(2, user.isActive());
            ps.setString(3, user.getFirstName());
            ps.setString(4, user.getLastName());
            ps.setString(5, user.getPassword());
            ps.setInt(6, user.getRole());
            ps.setString(7, user.getEmail());
        }
        finally {
            DBUtil.closePreparedStatement(ps);
            cp.freeConnection(con);
        }
        
        
        
        
        }
    
    public void delete(User user) throws Exception
    {
        ConnectionPool cp = ConnectionPool.getInstance();
        Connection con = cp.getConnection();
        PreparedStatement ps = null;
        
        String deleteStmt = "DELETE FROM userdb WHERE email=?";
        
        
        
        try{
         ps = con.prepareStatement(deleteStmt);
         ps.setString(1, user.getEmail());
         ps.executeUpdate();
        }
        finally {
            DBUtil.closePreparedStatement(ps);
            cp.freeConnection(con);
        }
        
        
        
        
        
    }
    
}
