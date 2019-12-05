<%@ page import="java.text.SimpleDateFormat" %>
<%@ page import="java.util.Date" %><%--
  Created by IntelliJ IDEA.
  User: Deleteorus
  Date: 2019/6/16
  Time: 10:14
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Session页面1</title>
</head>
<body>
<h1>session内置对象</h1>
<hr>
<%
    SimpleDateFormat format = new SimpleDateFormat("yyyy年MM月dd日 HH:mm:ss");
    Date date = new Date(session.getCreationTime());
    session.setAttribute("username", "zhangsan");
    session.setAttribute("password", "123456");
    session.setAttribute("age", 22);
%>
session创建时间：<%out.print(format.format(date));%><br>
session的id:<%out.print(session.getId());%>
session的过期时间：<%out.print(session.getMaxInactiveInterval());%>
重置session过期时间：<% session.setMaxInactiveInterval(5);%>
<a href="session_page2.jsp">session page2</a>
</body>
</html>
