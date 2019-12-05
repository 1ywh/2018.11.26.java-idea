<%@ page import="java.io.PrintWriter" %><%--
  Created by IntelliJ IDEA.
  User: Deleteorus
  Date: 2019/6/16
  Time: 9:55
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>内置对象out和response输出内容</title>
</head>
<body>
<p>
    <%
        //HttpServletResponse
        response.setCharacterEncoding("UTF-8");
        response.setContentType("text/html");

        //JspWriter
        out.print("这是out对象输出的内容，内置对象");
        out.flush();
        //response对象在JSP中输出内容优先于out对象

        PrintWriter writer = response.getWriter();
        writer.println("这是response输出的内容");
        writer.println("这是response输出的内容");
        writer.println("这是response输出的内容");

    %>
</p>

</body>
</html>
