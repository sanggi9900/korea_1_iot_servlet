<%--
  Created by IntelliJ IDEA.
  User: user
  Date: 24. 10. 11.
  Time: 오전 10:51
  To change this template use File | Settings | File Templates.
--%>


<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>User List</title>
</head>
<body>
    <h2>User List</h2>
    <table border="1">
        <tr>
            <th>ID</th>
            <th>Name</th>
            <th>Email</th>
            <th>Country</th>
            <th>Actions</th>
        </tr>


        <c:forEach var="user" items="${listUser}">
            <tr>
                <td>${user.id}</td>
                <td>${user.name}</td>
                <td>${user.email}</td>
                <td>${user.country}</td>
                <td>
                    <a href="edit?id=${user.id}">Edit</a>
                    <a href="delete?id=${user.id}">Delete</a>
                </td>
            </tr>
        </c:forEach>
    </table>
    <br />
<a href="new">Add New User</a>
</body>
</html>
