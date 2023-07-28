<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>异步验证</title>
    <script type="text/javascript" src="js/jquery-3.1.1.min.js"></script>
    <script>
        <%--       传统方式--%>
        //         function testLoad(){
        //             $.ajax({
        //                 url:"loadServlet.do",
        //                 type:"GET",
        //                 data:"username=lisi&password=123456",
        //                 success:function (info){
        //                     $("#d1").html(info)
        //                 }
        //             }
        //             )
        //         }
        //    load方法  会自动注入数据数据
        // function testLoad() {
        //     $("#d1").load("loadServlet.do", "username=lisi&password=123456", function () {
        //     })
        // }

        //load读取其他文件的数据
        function testLoad() {
            $("#d1").load("testLoad2.jsp #a")
        }

    </script>
</head>
<body>
<div id="d1" style="width: 200px ;height: 132px ;border: 1px solid black"></div>

<input type="submit" value="测试" onclick="testLoad()">
</body>
</html>