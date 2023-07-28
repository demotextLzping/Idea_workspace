<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>异步验证</title>
    <script type="text/javascript" src="js/jquery-3.1.1.min.js"></script>
    <script>
        var xhr;

        function checkName() {
            if (null == $("#uname").val() || $("#uname").val() === '') {
                $("#usernameInfo").text("用户名不能为空");
                return false;
            }
            $("#usernameInfo").text("");
            $.ajax({
                type: "GET",
                url: "unameCheckServlet1.do",
                data: "username=" + $("#uname").val(),
                success: function (info) {
                    $("#usernameInfo").text(info);
                }
            })
        }
    </script>
</head>
<body>
<form action="myServlet1.do" method="get">
    用户名: <input id="uname" type="text" name="username" onblur="checkName()"><span id="usernameInfo"></span><br/>
    密码 :<input type="password" name="password"><br/>
    <input type="submit" value="提交">
</form>
</body>
</html>
