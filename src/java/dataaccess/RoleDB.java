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
public class RoleDB {

    public List<Role> getAll() throws Exception {
        
        EntityManager em = DBUtil.getEmFactory().createEntityManager();

        try {
                return em.createNamedQuery("Role.findAll",Role.class).getResultList();
 


        } finally {
            em.close();
        }


    }


    public Role get(int index) throws Exception {
        EntityManager em = DBUtil.getEmFactory().createEntityManager();
        
        String getStmt = "select * from role WHERE role_id=?";

        try {
            Role role = em.find(Role.class, index);
            

        return role;
        } finally {
            em.close();
        }
        

    }
}
