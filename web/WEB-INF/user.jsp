<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<link rel="stylesheet" href="style.css">

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="https://fonts.googleapis.com/css2?family=Roboto&display=swap" rel="stylesheet">
        <title>User Database</title>
    </head>
    <body>
        <div class="grid-container">
            <div id="ViewUser">
                <h4>User Database</h4>
                <table>
                    <tr class="columnLabels">
                        <td>Edit</td>
                        <td>Email</td>
                        <td>Active</td>
                        <td>First Name</td>
                        <td>Last Name</td>
                        <td>Password</td>
                        <td>Role</td>
                    </tr>
                    <c:forEach items="${userList}" var="item">
                        <tr>
                            <td><input type ="radio" value ="${item}" name = "edit"></td><br>
                        <td>${item.email}</td>
                        <td>${item.active}</td>
                        <td>${item.firstName}</td>
                        <td>${item.lastName}</td>
                        <td>${item.password}</td>
                        <td>${item.role}</td>
                        </tr>
                    </c:forEach>
                </table>
            </div>

            <div id="AddUser">
                <h4>Add User</h4>

                <form method='post' action='user'>
                    <div class="inputs">
                        <label>Email<input type='text' name='email' value='${newUser.firstName}'></label>
                        <label>First Name<input type='text' name='firstName' value='${newUser.firstName}'></label>
                        <label>Last Name<input type='text' name='lastName' value='${newUser.lastName}'></label>
                        <label>Password<input type='password' name='password' value='${newUser.password}'></label>
                        <label class="switch">Active<br>
                            <input type="checkbox" name="active" value='true' checked>
                            <span class="slider round"></span>
                        </label>
                        <label>Role<br>
                            <select name = "role" value = "${newUser.role}">
                                <c:forEach items="${roles}" var = "role">
                                    <option value='${role.roleId}'>${role.roleName}</option>
                                </c:forEach>
                            </select>
                    </div>
                    <input class="submit" type='submit' name='action' value='Add'>

                </form>
            </div>

            <div id="EditUser">
                <h4>Edit User</h4>

                <form method='post' action='user'>
                    <div class="inputs">
                        <label>First Name<input type='text' name='firstName' value='${editUser.firstName}'></label>
                        <label>Last Name<input type='text' name='lastName' value='${editUser.lastName}'></label>
                        <label>Password<input type='password' name='password' value='${editUser.password}'></label>
                        <label class="switch">Active<br>
                            <input type="checkbox" name='active' value='${editUser.active}' checked>
                            <span class="slider round"></span>
                        </label>
                        <label>Role<br>
                            <select name = "role" value = "${editUser.role}">
                                <c:forEach items="${roles}" var = "role">
                                    <option value='${role.roleId}'>${role.roleName}</option>
                                </c:forEach>
                            </select>
                    </div>
                    <input class="submit" type='submit' name='action' value='Edit'>
                </form>
            </div>
        </div>
    </body>
</html>
