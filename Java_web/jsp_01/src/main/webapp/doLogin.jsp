<%--
  Created by IntelliJ IDEA.
  User: Deleteorus
  Date: 2019/6/9
  Time: 11:38
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>登录</title>
</head>
<body>
<%
    String username = request.getParameter("username");
    String password = request.getParameter("password");
    if (username == null || password == null) {
        out.print("<h1>");
        out.print("请输入用户名和密码");
        out.print("</h1>");

    } else {
        if ("admin".equals(username) && "admin".equals(password)) {
            out.print("欢迎，");
            out.print(username);
        } else {
            out.print("用户名或者密码错误");
            out.print("<a href='login.jsp'>");
            out.print("重新登录");
            out.print("</a>");
        }
    }
%>

</body>
</html>
