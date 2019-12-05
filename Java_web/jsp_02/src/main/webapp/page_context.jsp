<%--
  Created by IntelliJ IDEA.
  User: Deleteorus
  Date: 2019/6/16
  Time: 11:10
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>内置对象pageContext</title>
</head>
<body>
<%
    session.setAttribute("username", "jack");
%>
<h1>姓名：<%=pageContext.getSession().getAttribute("username")%>
</h1>
<%
    //跳转
    //pageContext.forward("login.jsp");
    //包含页面
    pageContext.include("index.jsp");
%>

</body>
</html>
