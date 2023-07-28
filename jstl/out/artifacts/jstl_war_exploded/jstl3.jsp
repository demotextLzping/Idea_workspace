<%@ page import="java.util.ArrayList" %>
<%@ page import="java.util.HashMap" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--核心标签库--%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%--
  Created by IntelliJ IDEA.
  User: Lzping
  Date: 2022/9/15
  Time: 10:59
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%--
    begin起始
    end 结束
    step 步长
    varStation 循环状态变量值名称
    var 集合的数据的每条记录的迭代值
    items 从作用域中获取值
--%>
<%--循环标签（前包后包） 和表格动态显示--%>
<c:forEach begin="0" end="3" step="1" varStatus="sta">
    aaaaaaaaa<br/>
</c:forEach>

<%--输出该标签内的各个属性的值--%>
<c:forEach begin="0" end="3" step="1" varStatus="sta">
    ${sta.index}--${sta.count}--${sta.step}--
    ${sta.begin}--${sta.end}--${sta.current}--
    ${sta.first}--${sta.last}<br/>
</c:forEach>

<%
    ArrayList<String> list = new ArrayList<String>();
    list.add("aaa");
    list.add("bbb");
    list.add("ccc");
//    放入作用域
    request.setAttribute("list",list);
%>
<c:forEach begin="0" end="3" step="1" varStatus="sta" var="i" items="${list}">
    ${i}<br/>
</c:forEach>

<%
    HashMap<String, String> map = new HashMap<>();
    map.put("1","111");
    map.put("2","222");
    map.put("3","333");
    map.put("4","444");
//    放入作用域
    request.setAttribute("map",map);
%>
<table border="2px" bgcolor="#f5deb3">
    <c:forEach begin="0" end="3" step="1" varStatus="sta" var="i" items="${map}">
        <tr>
            <td>${i.key}</td>
            <td>${i.value}</td>
        </tr>
    </c:forEach>
</table>

</body>
</html>
