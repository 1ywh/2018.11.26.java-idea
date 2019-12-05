<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>这是测试include</title>
</head>
<body>
<%@ include file="header.jsp"%>
<p>这是body内容</p>
<p>这是body内容</p>
<p>这是body内容</p>
<p>这是body内容</p>
<%--<%@ include file="segments/footer.jsp"%>--%>
<jsp:include page="footer.jsp" flush="true"/>
</body>
</html>
