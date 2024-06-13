<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.util.List"%>
<%@page import="com.models.schema.User"%>

<%
    List<User> users = (List<User>)request.getAttribute("users");
    float delay = 0.1f;
%>

<!DOCTYPE html>
<html>
<head>
    <meta charset='utf-8'>
    <meta name='viewport' content='width=device-width, initial-scale=1'>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/CSS/users.css" contentType="text/css">
    <link rel="stylesheet" href="https://fonts.googleapis.com/css2?family=Material+Symbols+Outlined:opsz,wght,FILL,GRAD@20..48,100..700,0..1,-50..200" />
    <title>Users</title>
</head>
<body>
    <section>
        <h1>All users</h1>
        <div class="content_users">
            <% for(User user: users){ %>
            <div class="content_user" style="animation-duration: <%= 1+delay %>s;">
            <% delay += 0.2;%>
                <div class="title"> Data of User</div>
                </hr>
                <div class="data-user user-username">
                    <div>Username:</div> 
                    <span>
                        <%=user.getUsername() %>
                    </span>
                    <span></span>
                </div>
                <div class="data-user user-email">
                    <div>Email:</div>
                    <span>
                        <%=user.getEmail() %>
                    </span>
                    <span></span>
                </div>
                <div class="data-user user-password">
                    <div>Password:</div>
                    <span>
                        <%=user.getPassword() %>
                    </span>
                    <span></span>
                    </div>
            </div>
            <% } %>
        </div>
    </section>

    <button class="add_button">
        <span class="material-symbols-outlined">add</span>
    </button>

</body>
</html>