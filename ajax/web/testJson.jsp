<%--
  Created by IntelliJ IDEA.
  User: Lzping
  Date: 2022/11/18
  Time: 10:46
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Json</title>
    <script>
        var xhr;

        function testData() {
            xhr = new XMLHttpRequest();
            xhr.open("GET", "testServlet.do", true);
            xhr.onreadystatechange = showReturnInfo;
            xhr.send(null);
        }

        function showReturnInfo() {
            if (xhr.readyState == 4 && xhr.status == 200) {
                var info = xhr.responseText;
                var returnInfo=document.getElementById("returnInfo");
                returnInfo.innerText=info;

            }
        }
    </script>

</head>
<body>
<input type="button" value="测试" onclick="testData()"><span id="returnInfo"></span>
</body>
</html>
