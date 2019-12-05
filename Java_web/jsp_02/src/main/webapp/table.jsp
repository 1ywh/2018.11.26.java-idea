<%@ page import="java.io.IOException" %><%--
  Created by IntelliJ IDEA.
  User: Deleteorus
  Date: 2019/6/9
  Time: 10:35
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>九九乘法表</title>
</head>
<body>
<div>
    <!--
      1*1=1
      1*2=2 2*2=4
      1*3=3 2*3=6  3*3=9
      ...
    -->
    <%!
        String printTable() {
            StringBuilder sb = new StringBuilder();
            sb.append("<h1>")
                    .append("基于表达式实现的九九乘法表")
                    .append("</h1>");
            for (int i = 1; i < 10; i++) {
                for (int j = 1; j <= i; j++) {
                    sb
                            .append(j)
                            .append("*")
                            .append(i)
                            .append("=")
                            .append(i * j)
                            .append(" ");
                }
                sb.append("<br/>");
            }
            return sb.toString();
        }
    %>
    <%=printTable()%>
</div>
<div>
    <%!
        void printTable(JspWriter out) throws IOException {
            for (int i = 1; i < 10; i++) {
                for (int j = 1; j <= i; j++) {
                    out.println(j + "*" + i + "=" + (i * j));
                    out.println("&nbsp;&nbsp;");
                }
                out.println("<br/>");
            }
        }
    %>
    <h1>基于脚本实现的九九乘法表</h1>
    <%
        printTable(out);
    %>
</div>
</body>
</html>
