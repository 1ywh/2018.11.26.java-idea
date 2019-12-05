<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Session页面2</title>
</head>
<body>
<h1>session内置对象</h1>
<hr>
session中的用户名：<%out.print(session.getAttribute("username"));%><br>
session中的密码：<%out.print(session.getAttribute("password"));%><br>
session中的年龄：<%out.print(session.getAttribute("age"));%><br>
</body>
</html>
