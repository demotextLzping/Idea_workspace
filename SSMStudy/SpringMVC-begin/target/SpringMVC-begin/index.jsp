<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%--注入POJO类型数据--%>
<form action="getDataByPOJO" method="post">
    <p>姓名: <input type="text" name="username"></p>
    <p>密码: <input type="text" name="password"></p>
    <p>性别:
        <input type="radio" name="gender" value="male">男
        <input type="radio" name="gender" value="female">女
    </p>
    <p>爱好:
        <input type="checkbox" name="hobby" value="basketBall">篮球
        <input type="checkbox" name="hobby" value="footBall">足球
        <input type="checkbox" name="hobby" value="volleyballBall">排球
    </p>
    <p>生日: <input type="text" name="birthdate"></p>
    <p>宠物</p>
    <p>宠物:<input type="text" name="pet.petName"> <input type="text" name="pet.petType"></p>
    <p>宠物list</p>
    <p>宠物1:<input type="text" name="pets[0].petName"> <input type="text" name="pets[0].petType"></p>
    <p>宠物2:<input type="text" name="pets[1].petName"> <input type="text" name="pets[1].petType"></p>
    <p>宠物Map</p>
    <p>宠物1:<input type="text" name="petMap['0'].petName"> <input type="text" name="petMap['0'].petType"></p>
    <p>宠物2:<input type="text" name="petMap['1'].petName"> <input type="text" name="petMap['1'].petType"></p>
    <input type="submit" value="POJOSubmit">
</form>

</body>
</html>