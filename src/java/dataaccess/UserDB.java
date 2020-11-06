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
import java.util.List;
import javax.persistence.EntityManager;
import models.Role;
import models.User;

/**
 *
 * @author 814992
 */
public class UserDB {

    String getAllStmt = "SELECT * from user";

    public List<User> getAll() throws Exception {//returns all users
        
        EntityManager em = DBUtil.getEmFactory().createEntityManager();
        try {
            return em.createNamedQuery("User.findAll",User.class).getResultList();

            }

        finally {
            em.close();
        }

    }

    public User get(String email) throws Exception {
        ConnectionPool cp = ConnectionPool.getInstance();
        Connection con = cp.getConnection();
        PreparedStatement ps = null;
        ResultSet rs = null;

        User user = null;

        try {
            String getStmt = "SELECT * from user WHERE email = ?";
            ps = con.prepareStatement(getStmt);
            ps.setString(1, email);
            rs = ps.executeQuery();

            while (rs.next()) {

                //email,active,firstname, lastname,password, role
                String emailString = rs.getString(1);
                Boolean active = rs.getBoolean(2);
                String firstName = rs.getString(3);
                String lastName = rs.getString(4);
                String password = rs.getString(5);
                int roleInt = rs.getInt(6);
                
                RoleDB db = new RoleDB();
                ArrayList<Role> roleList = db.getAll();
                Role role = db.get(roleInt);

                user = new User(emailString, firstName, lastName, password, role, active);
                
            }

        } catch (Exception e) {
            System.out.println("dsa");
            e.printStackTrace();
        } finally {
            System.out.println(con.toString());

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

        String insertStmt = "INSERT INTO user(email, active, first_name, last_name, password, role) VALUES(?, ?, ?, ?, ?, ?)";

        try {
            ps = con.prepareStatement(insertStmt);

            ps.setString(1, user.getEmail());
            ps.setBoolean(2, user.isActive());
            ps.setString(3, user.getFirstName());
            ps.setString(4, user.getLastName());
            ps.setString(5, user.getPassword());
            ps.setInt(6, user.getRole().getRoleId());

            ps.executeUpdate();

        } finally {
            DBUtil.closePreparedStatement(ps);
            cp.freeConnection(con);
        }

    }

    public void update(User user) throws Exception {
        ConnectionPool cp = ConnectionPool.getInstance();
        Connection con = cp.getConnection();
        PreparedStatement ps = null;

        String updateStmt = "UPDATE user SET email=?, active=?, first_name=?, last_name=?, password=?, role=? WHERE email=?";

        try {
            ps = con.prepareStatement(updateStmt);
            ps.setString(1, user.getEmail());
            ps.setBoolean(2, user.isActive());
            ps.setString(3, user.getFirstName());
            ps.setString(4, user.getLastName());
            ps.setString(5, user.getPassword());
            ps.setInt(6, user.getRole().getRoleId());
            ps.setString(7, user.getEmail());
            ps.executeUpdate();

        } finally {
            DBUtil.closePreparedStatement(ps);
            cp.freeConnection(con);
        }

    }

    public void delete(User user) throws Exception {
        ConnectionPool cp = ConnectionPool.getInstance();
        Connection con = cp.getConnection();
        PreparedStatement ps = null;

        String deleteStmt = "DELETE FROM user WHERE email=?";

        try {
            ps = con.prepareStatement(deleteStmt);
            ps.setString(1, user.getEmail());
            ps.executeUpdate();
        } finally {
            DBUtil.closePreparedStatement(ps);
            cp.freeConnection(con);
        }

    }

}
