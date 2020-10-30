<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<link rel="stylesheet" href="style.css">

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>User Database</title>
    </head>
    <body>
        <div class = "ViewUser">
            <div class = "Header"><h1>User Database</h1></div>
            <table>
                <tr>
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
                        <td><input type ="radio" value ="${item}" name = "edit">${user}<br></td>
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
        <div class = "AddUser">
            <div class = "Header"><h1>Add User</h1></div>

            <form method='post' action='user'>
                <input type='radio' name='active' value='${editUser.active}'><br>
                <input type='text' name='firstName' value='${editUser.firstName}'><br>
                <input type='text' name='lastName' value='${editUser.lastName}'><br>
                <input type='password' name='password' value='${editUser.passWord}'><br>
                <select name = "role" value = "${editUser.role}"><br>
                    <c:forEach items="${roleList}" var = "role">
                        <option value='${role}'>${role}}</option>
                    </c:forEach>
                </select>
                <input type='submit' value='Submit'>


            </form>
        </div>
        <div class = "EditUser">
            <div class = "Header"><h1>Edit User</h1></div>

            <form method='post' action='user'>
                <input type='radio' name='active' value='${editUser.active}'><br>
                <input type='text' name='firstName' value='${editUser.firstName}'><br>
                <input type='text' name='lastName' value='${editUser.lastName}'><br>
                <input type='password' name='password' value='${editUser.passWord}'><br>
                <select name = "role" value = "${editUser.role}"><br>
                    <c:forEach items="${roleList}" var = "role">
                        <option value='${role}'>${role}}</option>
                    </c:forEach>
                </select>
                <input type='submit' value='Submit'>

            </form>
        </div>
    </body>
</html>
