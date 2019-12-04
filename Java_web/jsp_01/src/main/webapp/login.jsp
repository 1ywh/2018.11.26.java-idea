
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>欢迎登录</title>
</head>
<body>
<h1>JSP实现登录演示</h1>
<form id="loginForm" method="post" action="doLogin.jsp">
    <div>
        <h5>登录</h5>
    </div>
    <label for="username">用户名：</label>
    <input id="username" type="text" name="username" value=""/>
    <label for="password">用户密码：</label>
    <input id="password" type="password" name="password" value=""/>
    <input type="submit" value="登录">
</form>
</body>
</html>
