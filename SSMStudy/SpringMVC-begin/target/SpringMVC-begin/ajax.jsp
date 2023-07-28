<%--
  Created by IntelliJ IDEA.
  User: Lzping
  Date: 2023/4/16
  Time: 16:00
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<html>
<head>
    <title>Json</title>
    <script src="static/js/jquery-3.1.1.min.js"></script>
    <script>
        $(function (){
            $("#btn").click(function (){
                $.get("testJson",
                    {pname:"xm",page:"10"},
                    function (data){
                        console.log(data.petName)
                        console.log(data.petType)
                    }
                )
            })
        })
    </script>
</head>
<body>
<input id="btn" type="button" value="test">
</body>
</html>
