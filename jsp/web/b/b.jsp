<%--
  Created by IntelliJ IDEA.
  User: Lzping
  Date: 2022/9/13
  Time: 12:59
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%
    String path=request.getContextPath();
    System.out.println(path);
    String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
    System.out.println(basePath);
%>
<html>
<head>
    <base href="<%=basePath%>">
    <title>Title</title>
</head>
<body>
bbbbbbbbbbbbbbb
<%--相对路径--%>
<%--<a href="../page.jsp">page</a>--%>
<%--绝对路径--%>
<%--<a href="/jsp/page.jsp">page</a>--%>
<%--全局路径--%>
<a href="page.jsp">aaa</a>
</body>
</html>
