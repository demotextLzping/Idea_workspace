<%--
  Created by IntelliJ IDEA.
  User: Lzping
  Date: 2022/9/12
  Time: 16:37
  To change this template use File | Settings | File Templates.
--%>
<%--page
        contentType:表示游览器解析响应信息的时候使用的编码格式
        language: 标识jsp要转译的文件类型
        pageEncoding :设置页面的编码格式
        import : 导入需要的包，多个包同时导入使用逗号分割
        session : 用来控制servlet钟是否有session对象
        extends : 需要要转译的servlet类要继承的父类(包名+类名)
    局部代码块
        可以将java代码和页面展示的标签写到一个页面中，java代码转译成的servlet文件中，java代码跟输出是保存在servlet方法中的
        缺点：代码可读性差，开发比较麻烦
    全局代码块
        定义公共的方法时候需要使用全局代码块<%!%>，生成的代码在servlet中
        调用的时候需要使用全局变量
    脚本调用方法
        使用<%=%>，方法必须有返回值
    页面导入
        静态导入
            <%@ include file="staticImport.jsp"%> 相对路径
            不会将静态导入的页面生成一个新的servlet文件，而是将两个文件合并
            优点: 运行效率高
            缺点: 两个页面会耦合到一起，同时两个页面中不能出现同名的变量
        动态导入
            <jsp:include page="dynamicImport.jsp"></jsp:include>
            两个页面不会进行合并，分别生成各自的servlet文件，但是页面在最终的时候会在同一页面
            优点 : 没有耦合，可以存在同名的变量
        请求转发
            在jsp中实现servlet请求转发的功能
            <jsp:forward page="forward.jsp"></jsp:forward>
            在标签中不能添加任何的字符，除非使用传递参数
                <jsp:param name="china" value="shanghai"></jsp:param>
                <jsp:param name="hubei" value="jingzhou"/>
            在转发的页面获取属性通过 <%=request.getParameter(键名)%>获取数据值
    九大内置对象
        jsp页面在转译成其对应的servlet文件的时候，会自动声明一些对象，在jsp而页面中能直接使用
        pageContext  表示页面上下文的对象封装了其他的内部对象，封存了但钱页面的全部运行信息
                     每一个页面都有一个对应的pageContext对象，伴随着页面的消失而消失
        request      封装当前请求的数据，由tomcat创建，一次请求对于一个request对象
        session      用来封装同一个用户的不同请求数据，一次会话对用一个session对象
        application  相当于ServeltContext对象，一个项目只能有一个对象，存储哥哥用户的共享数据，从服务器启动到结束
        response     响应对象，用来请求数据，将处理结果返回给游览器，可以惊醒重定向
        exception    异常对象，存储当前运行的异常信息，必须在page指令中添加属性isErrorPage=true
        config       相当于SevletConfig对象，用来获取web.xml文件中的数据，完成servlet的初始化操作
        out          响应对象，jsp内部使用，带有缓存的响应对象，效率高于response
    四大作用域
        pageContext 表示当前页面，解决当前页面内的数据共享问题，获取内置对象
        request     一次请求，一次请求的servlet数据共享，通过请求转发的方式，将数据流转带下一个servelt
        session     一次会话，一个用户发送的不同的请求之间的数据共享，可以将数据从一个数据流转到其他的请求
        application 项目内，不同的数据共享问题，将数据冲一个用户转到其他的用户
    路径问题
        想要获取项目中的资源，可以使用相对路径，也可以使用绝对路径
        相对路径  相对于当前的页面
            问题 1.资源的位置不能随意的修改
                2.需要使用../进行文件夹的跳出，如果目录结果比较深，操作起来会比较麻烦
                <a href="../page.jsp">page</a>
        绝对路径
            在请求的路径的前面加上./ 表示当前服务器的根路径，使用的时候就要添加/虚拟项目名称/资源目录
            <a href="/jsp/page.jsp">page</a>
        使用jsp自带的全局路径
            全局变量配置
            <%
            String path=request.getContextPath();
                    System.out.println(path);
                String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
                    System.out.println(basePath);
             %>
             head标签下配置
                 <base href="<%=basePath%>">
             调用
                 <a href="b/b.jsp">bbb</a>
             添加路径的时候,从当前项目的web目录下添加即可
         





--%>
<%@ page contentType="text/html;charset=UTF-8" language="java"  import="java.util.*,java.lang.*" pageEncoding="utf-8" %>
<%@ page session="false" %>
<%@ page errorPage="error.jsp" isErrorPage="true" %>
<%--<%@ page extends="javax.servlet.http" %>--%>

<%
String path=request.getContextPath();
    System.out.println(path);
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
    System.out.println(basePath);
%>

<html>
<base>
    <base href="<%=basePath%>">
    <title>Title</title>

</head>
<body>
<%--全局代码块创建--%>
<%!
public void test(){
    System.out.println("我是test方法");
}
public String  demo(){
    return "我是demo方法";
}
%>
<%--脚本调用 没有返回值的不能直接调用--%>
<%=demo()%>
<%--全局代码快调用--%>
<%!
String str="我是字符串";
%>
<%=str%>
<%--<% int i=5/0;%>--%>
<%--<h1>page</h1>--%>
<%--局部代码块--%>
<%  int i=new Random().nextInt(10);
    if(i<5){
%>
<h1>今天心情不好</h1>
<%}else{
%>
<h1>今天心情好</h1>
<%}%>

<%--静态导入--%>
<%@ include file="staticImport.jsp"%>
<%--动态导入--%>
<jsp:include page="dynamicImport.jsp"></jsp:include>

<%--请求转发--%>
<%--<jsp:forward page="forward.jsp">--%>
<%--    <jsp:param name="china" value="shanghai"></jsp:param>--%>
<%--    <jsp:param name="hubei" value="jingzhou"/>--%>
<%--</jsp:forward>--%>

<%--重定向--%>
<%--<%--%>
<%--    response.sendRedirect("forward.jsp");--%>

<%--相对路径--%>
<%--<a href="a/a.jsp">aaa</a>--%>
<%--<a href="b/b.jsp">bbb</a>--%>

<%--绝对路径--%>
<%--<a href="/jsp/a/a.jsp">aaa</a>--%>
<%--<a href="/jsp/b/b.jsp">bbb</a>--%>


<%--全局路径--%>
<a href="a/a.jsp">aaa</a>
<a href="b/b.jsp">bbb</a>
</body>
</html>