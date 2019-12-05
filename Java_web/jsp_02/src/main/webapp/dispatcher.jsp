<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>验证重定向和转发</title>
</head>
<body>
<h1>

    验证转发：
    <%
    <%--    验证重定向：--%>
    <%--    多次请求客户端地址发生变化--%>
    response.sendRedirect("request_form.jsp");
    <%--    验证转发--%>
    request.getRequestDispatcher("request_form.jsp")
    .forward(request,response);
    %>
</h1>
</body>
</html>
