<%--
  Created by IntelliJ IDEA.
  User: Lzping
  Date: 2022/9/13
  Time: 10:00
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<b>我是请求转发</b>
<%=request.getParameter("china")%>
<br/>
<%=request.getParameter("hubei")%>
</body>
</html>
