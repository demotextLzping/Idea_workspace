<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="java.util.Random" %><%--
  Created by IntelliJ IDEA.
  User: Lzping
  Date: 2022/9/15
  Time: 10:26
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%--传统判断标签--%>
<%
  int age= new Random().nextInt(15);
  if(age<10){
%><h1>小孩子</h1>
<%}else{%>
传统逻辑判断表达式 <h1>青少年</h1>
<%}%>
<%--逻辑判断标签--%>
<%--
    if判断
      test填写逻辑判断表达式
      var 条件表达式的结果存储变量
      scope 表示指定的作用域
--%>
<c:set var="age" value="18" ></c:set>
<c:if test="${age>15}" >
逻辑判断表达式  <h1>青少年</h1>
</c:if>

<%--多重逻辑判断--%>
<%--
    多重逻辑判断 类似于switch判断
      test 逻辑判断表达式
      var 条件表达式的结果存储变量
      scope 表示指定的作用域

--%>
<c:set var="score" value="88"></c:set>
多重逻辑判断
<c:choose>
  <c:when test="${score<60}" ><h1>不及格</h1></c:when>
  <c:when test="${score<80}"><h1>良好</h1></c:when>
  <c:when test="${score<100}"><h1>优秀</h1></c:when>
  <c:otherwise><h1>成绩错误</h1></c:otherwise>
</c:choose>

</body>
</html>
