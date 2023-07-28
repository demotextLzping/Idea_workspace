<%--
  Created by IntelliJ IDEA.
  User: Lzping
  Date: 2022/9/14
  Time: 20:39
  To change this template use File | Settings | File Templates.
--%>
<%--
    jstl
        是E类的扩展，同时它依赖于el，为了方便的从狱中获取值
    jstl的导入
        1.添加到将jar包lib目录下（如果报错，将jar导入tomcat的lib文件夹下）
        2.<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
   标签
        输出<c:out value="你好"></c:out>
            value：填写要输出的值
            default默认输出的值
        向作用域设置属性值
            <c:set var="java" value="application" scope="application"></c:set>
            var 表示参数的key
            value 表示参数的值
            scope 表示向哪个作用域设置属性值
            当只配置两个属性的时候，默认是向pageContext作用域设置属性值，可以通过参数来悬着指向那个作用域
        删除作用域中的数据值
            <c:remove var="java"></c:remove>
            var 鄙视属性的key
            scope 表示指定的作用域
            如果没有指定作用域，那么会默认删除全部的作用域的参数
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%--输出--%>
<c:out value="你好"></c:out><br/>
<%--设置--%>
<c:set var="java" value="pageContext" scope="page"></c:set>
<c:set var="java" value="requestt" scope="request"></c:set>
<c:set var="java" value="session" scope="session"></c:set>
<c:set var="java" value="application" scope="application"></c:set>
<%--未设定作用域时是得到的值是最后一个--%>
<%--设定作用域后，按作用域大小--%>
未移除前 : <c:out value="${java}"></c:out><br/>
<%--移除--%>
<c:remove var="java" scope="page"></c:remove>
移除pageContext : <c:out value="${java}"></c:out><br/>
</body>
</html>
