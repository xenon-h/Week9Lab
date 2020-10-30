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
                <div class = "Header"><h1>User Database</h1></div>
                <table>
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
        <div class = "AddUser">
            <div class = "Header"><h1>Add User</h1></div>

            <form method='post' action='user'>
                <input type='text' name='firstName' value='${editUser.firstName}'><br>
                <input type='text' name='lastName' value='${editUser.lastName}'><br>
                <input type='password' name='password' value='${editUser.passWord}'><br>
                <select name = "role" value = "${editUser.role}"><br>
                    <c:forEach items="${roleList}" var = "role">
                        <option value='${role}'>${role}}</option>
                        <td></td>
                        <td>Email</td>
                        <td>Active</td>
                        <td>First Name</td>
                        <td>Last Name</td>
                        <td>Password</td>
                        <td>Role</td>
                    </tr>
                    <c:forEach items = "${userList}" var = "item">  
                        <tr>
                            <td><input type ="radio" value ="${item}" name = "edit"></td><br>
                        <td>${user.email}</td>
                        <td>${user.active}</td>
                        <td>${user.firstname}</td>
                        <td>${user.lastname}</td>
                        <td>${user.password}</td>
                        <td>${user.role}</td>
                        </tr>
                    </c:forEach>
                </table>
            </div>

            <div id="AddUser">
                <div class = "Header"><h1>Add User</h1></div>

                <form method='post' action='user'>
                    <div class="inputs">
                        <input type='text' name='firstName' value='${editUser.firstName}'>
                        <input type='text' name='lastName' value='${editUser.lastName}'>
                        <input type='password' name='password' value='${editUser.passWord}'>
                        <select name = "role" value = "${editUser.role}">
                            <c:forEach items="${roleList}" var = "role">
                                <option value='${role}'>${role}}</option>
                            </c:forEach>
                        </select>
                    </div>
                            <a href="user" method="post"
                    <input type='submit' value='Submit'>

                </form>
            </div>

            <div id="EditUser">
                <div class = "Header"><h1>Edit User</h1></div>

                <form method='post' action='user'>
                    <div class="inputs">
                        <input type='text' name='firstName' value='${editUser.firstName}'>
                        <input type='text' name='lastName' value='${editUser.lastName}'>
                        <input type='password' name='password' value='${editUser.passWord}'>
                        <select name = "role" value = "${editUser.role}">
                            <c:forEach items="${roleList}" var = "role">
                                <option value='${role}'>${role}}</option>
                            </c:forEach>
                        </select>
                    </div>
                    <input type='submit' value='Submit'>
                </form>
            </div>
        </div>
    </body>
</html>
