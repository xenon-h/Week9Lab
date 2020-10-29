<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>TODO</title>
    </head>
    <body>
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


            <form method='post' action='user'>
                <input type='radio' name='active' value='${editUser.active}'>
                <input type='text' name='firstName' value='${editUser.firstName}'>
                <input type='text' name='lastName' value='${editUser.lastName}'>
                <input type='password' name='password' value='${editUser.passWord}'>
                <select name = "role" value = "${editUser.role}">
                    <c:forEach items="${roleList}" var = "role">
                        <option value='${role}'>${role}}</option>
                    </c:forEach>
                </select>
                <input type='submit' value='Submit'>
            </form>

                    
            
        </table>
    </body>
</html>