<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>用户登录</title>
</head>
<body>
<%
    request.setCharacterEncoding("UTF-8");
    String username = request.getParameter("username");
    String password = request.getParameter("password");

%>
<p>用户名：<%=username%></p>
<p>用户密码：<%=password%></p>
<p>邮箱：<%=request.getParameter("email")%></p>
<p>技能：<%=request.getParameter("skill")%></p>
<jsp:include page="footer.jsp"/>
</body>
</html>
