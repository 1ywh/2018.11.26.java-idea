<%@ page import="java.time.LocalDateTime" %>
<%@ page import="java.util.Arrays" %>
<%@ page import="java.util.HashMap" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.Map" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>第一个 JSP页面</title>
</head>
<body>
<h1>欢迎，来到JSP页面</h1>
<%
    //单行注释
    /*
       多行注释
     */
    String datetime = LocalDateTime.now().toString();
    out.println(datetime);
%>
<!-- 这是HTML的注释  -->
<%-- 这是JSP注释 --%>
<div>
    <%
        StringBuilder sb = new StringBuilder();
        sb.append("Java");
        sb.append(" ");
        sb.append("PHP");
        out.println(sb.toString());
    %>
</div>
<div>
    <%!
        String name = "Jack";

        int add(int a, int b) {
            return a + b;
        }
    %>
    <p> 名称：
        <%
            out.println(name);
        %>
    </p>
    <p>
        计算求和（1+2）:
        <%
            out.println(add(1, 2));
        %>
    </p>
</div>
<div>
    <table>
        <thead>
        <tr>
            <td>
                编码
            </td>
            <td>
                城市
            </td>
            <td>
                景点
            </td>
        </tr>
        </thead>
        <tbody>
        <%!
            //声明 定义变量，定义方法
            Map<String, List<String>> map = new HashMap<>();

        %>
        <%

            map.put("西安", Arrays.asList("大雁塔", "兵马俑"));
            map.put("宝鸡", Arrays.asList("太白山", "法门寺"));
            map.put("咸阳", Arrays.asList("乾陵", "茂陵"));
            int i = 0;
            for (Map.Entry<String, List<String>> entry : map.entrySet()) {

                String city = entry.getKey();
                List<String> spots = entry.getValue();
                for (String spot : spots) {
                    i++;
        %>
        <tr>
            <td>
                <%
                    out.print(i);
                %>
            </td>
            <td>
                <%
                    out.print(city);
                %>
            </td>

            <td>
                <%
                    out.print(spot);
                %>
            </td>
        </tr>
        <%
                }
            }
        %>
        </tbody>
    </table>
</div>
<%!
    String css = "color: cornflowerblue";
%>
<div>
    <p>表达式的用法</p>
    <p>姓名：<%=name %>
    </p>
    <p style="<%=css%>">
        就算20+10=<%=add(20,10)%>
    </p>
</div>
</body>
</html>
