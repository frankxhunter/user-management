<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.util.Map"%>
<%@page import="java.util.HashMap"%>

<% 
    Map<String, String> errors = (Map<String,String>)request.getAttribute("errors");
    if (errors == null) {
        errors = new HashMap<>();
    }
%>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"  contentType="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/CSS/form.css" content="text/css"></link>
    <title>Add a user</title>
</head>
<body>
    <div class="form_container">
    <form action="form-user" method="post" class="form">
        <div class="title">Register a user</div>
        <div>
            <label for="username">Username: </label>
            <input class="<%=(errors.get("user")!=null? "border_red": "")%>" 
            required value="${param.username}" type="text" autocomplete="off" name="username" id="username" placeholder="Jhon Doe">
        </div>
        <div>
            <label for="email">Email: </label>
            <input class="<%=(errors.get("email")!=null? "border_red": "")%>"
            required value="${param.email}" type="email" autocomplete="off" name="email" id="email" placeholder="jhondoe@gmail.com">
        </div>
        <div>
            <label for="password">Password: </label>
            <input class="<%=(errors.get("password")!=null? "border_red": "")%>"
            required value="${param.password}" type="password" autocomplete="off" name="password" id="password" placeholder="JhonDoe123@">
        </div>
        <div>
            <input type="submit" value="send" class="button_send">    
        </div>
    </form>
    </div>
    
</body>
</html>