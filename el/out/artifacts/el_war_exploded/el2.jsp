<%--
  Created by IntelliJ IDEA.
  User: Lzping
  Date: 2022/9/13
  Time: 21:10
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%--<h1>name: ${param.name}</h1>--%>
<%--<h1>pwd: ${param.pwd}</h1>--%>
<%--<h1>aa: ${aa} </h1>--%>
<%--<h1>town: ${user.address.town}</h1>--%>
<%--<h1>town: ${list[0].address.town}</h1>--%>
<%--<h1>town: ${map.user.address.town}</h1>--%>
<%--
    作用域
        pageContext--》request--》session--》application
    获取作用于数据的顺序
        重小的作用域开始查询，如果找到对应的的值，不接着向大范围寻找数据
        当四种作用域中存在相同key的属性的时候，可以通过pageScope，requestScooe,sessionScope,applicationScope获取指定作用域的数据
    EL表达式可以直接进行算术运算符和关系运算符
        直接在表达式中写入算法操作即可，如果是关系运算，返回true或者false
        注意 : 在el表达式中+代表的是加法操作而不是字符串拼接
--%>
<%--作用域范围--%>
<%
pageContext.setAttribute("key","hello pageContext");
request.setAttribute("key","hello request");
session.setAttribute("key","hello session");
application.setAttribute("key","hello application");
%>
作用域<br/>
key:${key}<br/>
${pageScope.key}<br/>
${requestScope.key}<br/>
${sessionScope.key}<br/>
${applicationScope.key}<br/>
<%--算术运算符--%>
算术运算符<br/>
${2+8}<br/>
${2-8}<br/>
${2*8}<br/>
${2/8}<br/>
${2%8}<br/>
<%--关系运算符--%>
关系运算符<br/>
${2>8}<br/>
${2<8}<br/>
${2==8}<br/>
${2!=8}<br/>
<%--逻辑运算--%>
逻辑运算符<br/>
${true&&false}<br/>
${true||false}<br/>
${true&&true}<br/>
${false||false}<br/>
<%--获取请求头数据--%>
获取请求头数据<br/>
${header}<br/>
${header.host}<br/>
${header["host"]}<br/>
${headerValues["accept-language"][0]}<br/>
<%--获取cookie的数据--%>
获取cookie数据<br/>
${cookie}<br/>
${cookie.JSESSIONID}<br/>
${cookie.JSESSIONID.name}<br/>
${cookie.JSESSIONID.value}<br/>






</body>
</html>
