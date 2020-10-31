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
import models.Role;
import models.User;

/**
 *
 * @author 814992
 */
public class RoleDB {

    public ArrayList<Role> getAll() throws Exception {
        ArrayList<Role> roleList = new ArrayList();
        ConnectionPool cp = ConnectionPool.getInstance();
        Connection con = cp.getConnection();
        PreparedStatement ps = null;
        ResultSet rs = null;
        String getAllStmt = "select * from role";

        try {
            ps = con.prepareStatement(getAllStmt);
            rs = ps.executeQuery();

            while (rs.next()) {
                int role_id = rs.getInt(1);
                String role_name = rs.getString(2);
                
                Role role = new Role(role_id,role_name);
                roleList.add(role);

            }

        } finally {
            DBUtil.closeResultSet(rs);
            DBUtil.closePreparedStatement(ps);
            cp.freeConnection(con);
        }
        return roleList;

    }
}
