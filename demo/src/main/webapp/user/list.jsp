<%@ page import="org.example.demo.model.User" %>
<%@ page import="java.util.List" %><%--
  Created by IntelliJ IDEA.
  User: user
  Date: 24. 10. 11.
  Time: 오전 10:49
  To change this template use File | Settings | File Templates.
--%>

<%-- <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %> --%>
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

    <%
        // JSP 스크립틀릿 내에서 Java 코드를 사용해 listUser를 순회
        List<User> listUser = (List<User>) request.getAttribute("listUser");
        if (listUser != null) {
            for (User user : listUser) {
    %>
    <tr>
        <td><%= user.getId() %></td>
        <td><%= user.getName() %></td>
        <td><%= user.getEmail() %></td>
        <td><%= user.getCountry() %></td>
        <td>
            <a href="edit?id=<%= user.getId() %>">Edit</a>
            <a href="delete?id=<%= user.getId() %>">Delete</a>
        </td>
    </tr>
    <%
        }
    } else {
    %>
    <tr>
        <td colspan="5">No users found.</td>
    </tr>
    <%
        }
    %>
</table>
<br />
<a href="new">Add New User</a>
</body>
</html>