package lzp.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author： LZPing
 * @date： 2022-11-18 09:19
 * @Description
 */
@WebServlet("/unameCheckServlet1.do")
public class unameCheckServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String username = req.getParameter("username");
        String jsoncallback = req.getParameter("jsoncallback");
        String info;
        if ("lzp".equals(username)) {
            info = "用户名已经占用";
        } else {
            info = "用户名可用";
        }
        resp.setCharacterEncoding("UTF-8");
        resp.setContentType("text/javaScript;charset=UTF-8");
        //返回对象结果
        resp.getWriter().print(jsoncallback+"('"+info+"')");
    }
}
