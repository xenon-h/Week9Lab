/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;

import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import models.Role;
import models.User;
import services.UserService;

/**
 *
 * @author 798676
 */
public class userServlet extends HttpServlet {

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        UserService service = new UserService();
        ArrayList<User> userList;
        ArrayList<Role> roles;

        try {
            userList = service.getAllUsers();
            roles = service.getAllRoles();
            request.setAttribute("userList", userList);
            request.setAttribute("roles", roles);
        } catch (Exception ex) {
            Logger.getLogger(userServlet.class.getName()).log(Level.SEVERE, null, ex);
        }

       getServletContext().getRequestDispatcher("/WEB-INF/user.jsp").forward(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        UserService service = new UserService();

        String action = request.getParameter("action");

        if (action != null) {

            String email = request.getParameter("email");

            switch (action) {
                case "delete":
                    try {
                        service.deleteUser(email);
                    } catch (Exception ex) {
                        Logger.getLogger(userServlet.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    break;
                case "editSelect": {
                    try {
                        User user = service.getUser(email);
                        request.setAttribute("editUser", user);
                    } catch (Exception ex) {
                        Logger.getLogger(userServlet.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
                break;
                default:

                    String activeString = request.getParameter("active");
                    Boolean active = Boolean.parseBoolean(activeString);
                    String firstName = request.getParameter("firstName");
                    String lastName = request.getParameter("lastName");
                    String password = request.getParameter("password");
                    String roleName = request.getParameter("roleName");
                    int roleID = Integer.parseInt(request.getParameter("roleID"));
                    Role role = new Role(roleID, roleName);

                    if (validateFields(email, active, firstName, lastName, password)) {
                        switch (action) {
                            case "Add": {
                                try {
                                    service.addUser(email, active, firstName, lastName, password, roleID);
                                } catch (Exception ex) {
                                    Logger.getLogger(userServlet.class.getName()).log(Level.SEVERE, null, ex);
                                    User user = new User(email, firstName, lastName, password, role, active);
                                    request.setAttribute("newUser", user);
                                }
                            }
                            break;
                            case "Edit":
                                try {
                                    service.updateUser(email, active, firstName, lastName, password, roleID);
                                } catch (Exception ex) {
                                    Logger.getLogger(userServlet.class.getName()).log(Level.SEVERE, null, ex);
                                    User user = new User(email, firstName, lastName, password, role, active);
                                    request.setAttribute("editUser", user);
                                }
                                break;
                        }
                    } else {
                        //message about invalid fields potentially
                    }
                    break;

            }
        }

        ArrayList<User> userList = new ArrayList();
        ArrayList<Role> roles;

        try {
            userList = service.getAllUsers();
            roles = service.getAllRoles();
            request.setAttribute("userList", userList);
            request.setAttribute("roles", roles);
        } catch (Exception ex) {
            Logger.getLogger(userServlet.class.getName()).log(Level.SEVERE, null, ex);
        }

        getServletContext().getRequestDispatcher("/WEB-INF/user.jsp").forward(request, response);

    }

    private boolean validateFields(String email, Boolean active, String firstName, String lastName, String password) {

        return email != null && !email.equals("") && firstName != null && !firstName.equals("") && password != null && !password.equals("");

    }

}
