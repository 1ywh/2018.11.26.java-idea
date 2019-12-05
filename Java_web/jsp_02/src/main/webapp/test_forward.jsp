<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>用户登录</title>
</head>
<body>
<%--添加参数--%>
<jsp:forward page="test_user.jsp">
    <jsp:param name="email" value="jack@gmail.com"/>
    <jsp:param name="skill" value="C++,Java,PHP"/>
</jsp:forward>
</body>
</html>
