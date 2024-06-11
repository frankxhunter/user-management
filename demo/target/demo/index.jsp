<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.util.List"%>
<%@page import="com.models.schema.User"%>


<%
    List<User> users = (List<User>)request.getAtribute("errors");
%>




<!DOCTYPE html>
<html>
<head>
    <meta charset='utf-8'>
    <meta name='viewport' content='width=device-width, initial-scale=1'>
    <title>Users</title>
</head>
<body>
    <section>
        <h1>All users</h1>
        <div class="content_users">
            <% for(User user: users){ %>
            <div class="content_user">
                <div><%=user.getUsername() %></div>
                <div><%=user.getEmail() %></div>
                <div><%=user.getPassword() %></div>
            </div>
            <% } %>
        </div>
    </section>

</body>
</html>