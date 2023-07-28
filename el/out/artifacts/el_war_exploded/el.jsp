<%@ page import="com.entity.User" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="java.util.HashMap" %><%--
  Created by IntelliJ IDEA.
  User: Lzping
  Date: 2022/9/13
  Time: 15:39
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1>name:<%=request.getParameter("name")%></h1>
<h1>pwd:<%=request.getParameter("pwd")%></h1>
<h1>aa: <%=request.getAttribute("aa")%></h1>
<h1>town: <%=((User)request.getAttribute("user")).getAddress().getTown()%></h1>
<h1>town: <%=((User)((ArrayList)request.getAttribute("list")).get(1)).getAddress().getTown()%></h1>
<h1>town: <%=((User)((HashMap)request.getAttribute("map")).get("user")).getAddress().getTown()%></h1>
</body>
</html>
