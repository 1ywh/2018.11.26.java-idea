<%@ page import="java.util.Enumeration" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>application内置对象</title>
</head>
<body>
<h1>application内置对象</h1>
<%
    application.setAttribute("city", "Xi·an");
    application.setAttribute("company", "pp");
    application.setAttribute("postcode", 710000);
%>
<hr>
<ol>
    <%
        Enumeration<String> enumeration = application.getAttributeNames();
        while (enumeration.hasMoreElements()) {
    %>
    <li>
        <%
            String name = enumeration.nextElement();
            Object value = application.getAttribute(name);
            out.print(name);
            out.print("=");
            out.print(value);
        %>
    </li>
    <%
        }
    %>
</ol>
<hr>
JSP引擎版本信息：<% out.print(application.getServerInfo());%>
</body>
</html>
