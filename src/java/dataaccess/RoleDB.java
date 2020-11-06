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
import javax.persistence.EntityManager;
import models.Role;
import models.User;

/**
 *
 * @author 814992
 */
public class RoleDB {

    public ArrayList<Role> getAll() throws Exception {
        ArrayList<Role> roleList = new ArrayList();
        EntityManager em = DBUtil.getEmFactory().createEntityManager();
        PreparedStatement ps = null;
        ResultSet rs = null;
        String getAllStmt = "select * from role ORDER BY role_id";

        try {
            rs = ps.executeQuery();

            while (rs.next()) {
                int role_id = rs.getInt(1);
                String role_name = rs.getString(2);

                Role role = new Role(role_id, role_name);
                roleList.add(role);

            }

        } finally {
            DBUtil.closeResultSet(rs);
            DBUtil.closePreparedStatement(ps);
            em.close();
        }
        return roleList;

    }

    public Role get(int index) throws Exception {
        Role role = null;
        ConnectionPool cp = ConnectionPool.getInstance();
        Connection con = cp.getConnection();
        PreparedStatement ps = null;
        ResultSet rs = null;
        String getStmt = "select * from role WHERE role_id=?";

        try {
            ps = con.prepareStatement(getStmt);
            ps.setInt(1, index);
            rs = ps.executeQuery();

            while (rs.next()) {
                
            
                int role_id = rs.getInt(1);
                String role_name = rs.getString(2);
                
                role = new Role(role_id,role_name);
            }

        } finally {
            DBUtil.closeResultSet(rs);
            DBUtil.closePreparedStatement(ps);
            cp.freeConnection(con);
        }
        return role;

    }
}
