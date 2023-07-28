<%--
  Created by IntelliJ IDEA.
  User: Lzping
  Date: 2022/8/31
  Time: 12:28
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form action="response" method="get">
    用户名 <input type="text" name="name" value=""><br/>
    密码   <input type="password" name="pwd" value=""><br/>
    爱好<input type="checkbox" name="fav" value="1">java
    <input type="checkbox" name="fav" value="2">c#
    <input type="checkbox" name="fav" value="3">php

    <input type="submit" name="sub" value="提交">
</form>

</body>
</html>
