<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<link rel="stylesheet" href="style.css">

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="https://fonts.googleapis.com/css2?family=Roboto&display=swap" rel="stylesheet">
        <script src="https://kit.fontawesome.com/97e2ee3dbf.js" crossorigin="anonymous"></script>
        <script src="JScript.js" rel="script" type="text/javascript" defer></script>
        <title>User Database</title>
    </head>
    <body>
        <form class="BIG">
            <input type="button" name="addButton" onclick="add()" value="Add User">
        </form>
        <div class="grid-container">
            <div id="ViewUser">
                <h4>&nbsp;Users</h4><br/>
                <table class="userTable">
                    <tr class="columnLabels">
                        <td>Email</td>
                        <td>First Name</td>
                        <td>Last Name</td>
                        <td>Password</td>
                        <td>Role</td>
                        <td>Active</td>
                        <td>Delete</td>
                        <td>Edit</td>
                    </tr>
                    <c:forEach items="${userList}" var="item">
                        <tr>
                        <form method="post" action="user">
                            <td>${item.email}</td>
                            <td>${item.firstName}</td>
                            <td>${item.lastName}</td>
                            <td>${item.password}</td>
                            <td>${item.role}</td>
                            <td>${item.active}</td>
                            <td>
                                <button class='iconButton deleteButton' type="submit" name='action' value='delete'>
                                    <i class="fas fa-trash-alt"></i>
                                </button>
                            <td>
                                <button class='iconButton editButton' type="button" id ="editButton" onclick="edit()" name='action' value='editSelect'>
                                    <i class="fas fa-user-edit"></i>
                                </button>
                            </td>
                            <input type='hidden' name="email" value='${item.email}' readonly>
                        </form>
                        </tr>
                    </c:forEach>
                </table>
            </div>
            <div class="modalContainer">
                <div class="modalShaun"></div>
                
                    <div class="modalAdd" id="AddUser">
                        <div class="close">+</div>
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

            <div id="AddUser">
                <h4>Add User</h4>

                <form method='post' action='user'>
                    <div class="inputs">
                        <label>Email:<input type='text' name='email' value='${newUser.firstName}'></label>
                        <label>First Name:<input type='text' name='firstName' value='${newUser.firstName}'></label>
                        <label>Last Name:<input type='text' name='lastName' value='${newUser.lastName}'></label>
                        <label>Password:<input type='password' name='password' value='${newUser.password}'></label>
                        <label>Active:
                            <div>
                                <label class="switch">
                                    <input type="checkbox" class='activeBoxes' name='active' value='${newUser.active}' checked>
                                    <span class="slider round"></span>
                                </label>
                            </div>
                        </label>
                        <label>Role:<br>
                            <select name = "roleID" value = "${newUser.role}">
                                <c:forEach items="${roles}" var = "role">
                                    <option value='${role.roleId}'>${role.roleName}</option>
                                </c:forEach>
                            </select>
                    </div>
                    <input class="submit" type='submit' name='action' value='Add'>

                </form>
                    </form>
                </div>
            </div>
            <div class="modalContainer">
                <div id="EditUser" class="modalEdit">
                    <h4>Edit User</h4>

            <div id="EditUser">
                <h4>Edit User</h4>

                <form method='post' action='user'>
                    <div class="inputs">
                        <label>Email:<input type='text' name='email' value='${editUser.email}' readonly></label>
                        <label>First Name:<input type='text' name='firstName' value='${editUser.firstName}'></label>
                        <label>Last Name:<input type='text' name='lastName' value='${editUser.lastName}'></label>
                        <label>Password:<input type='password' name='password' value='${editUser.password}'></label>
                        <label>Active:
                            <div>
                                <label class="switch">
                                    <input type="checkbox" class='activeBoxes' name='active' value='${editUser.active}' checked>
                                    <span class="slider round"></span>
                                </label>
                            </div>
                        </label>
                        <label>Role:<br>
                            <select name = "roleID" value = "${editUser.role}">
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
