<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>异步验证</title>
    <%--    <script type="text/javascript" src="js/jquery-3.1.1.min.js"></script>--%>
    <script>
        var xhr;

        function checkName() {
            var unameDOM = document.getElementById("uname");
            var unameText = unameDOM.value;
            if (null == unameText || unameText === '') {
                var info = document.getElementById("usernameInfo");
                info.innerText = "输入不能为空";
                return false;
            }
            var info = document.getElementById("usernameInfo");
            info.innerText = "";
            //发送异步请求
            //获取一个XMLHttpRequest对象，对象能帮助发送异步请求
            xhr = new XMLHttpRequest();
            //使用xhr对象设置打开链接，设置请求方式和参数xhr。open(请求方式，请求的url，是否使用异步方式)
            xhr.open("GET", "unameCheckServlet.do?username=" + unameText, true);
            //设置回调函数
            xhr.onreadystatechange = showReturnInfo;
            xhr.send(null);
        }

        function showReturnInfo() {
            if (xhr.readyState == 4 && xhr.status == 200) {
                var returnInfo = xhr.responseText;
                var info = document.getElementById("usernameInfo");
                info.innerText = returnInfo;
            }
        }
    </script>
</head>
<body>
<form action="myServlet.do" method="get">
    用户名: <input id="uname" type="text" name="username" onblur="checkName()"><span id="usernameInfo"></span><br/>
    密码 :<input type="password" name="password"><br/>
    <input type="submit" value="提交">
</form>
</body>
</html>
