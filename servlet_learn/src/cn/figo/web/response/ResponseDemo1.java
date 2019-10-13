package cn.figo.web.response;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/ResponseDemo1")
public class ResponseDemo1 extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("ResponseDemo1 1111111111");

        request.setAttribute("msg","hello");
        // 重定向
        //response.setStatus(302);
        //response.setHeader("location","/servlet_learn/ResponseDemo2");

        //简单重定向
        //response.sendRedirect("/servlet_learn/ResponseDemo2");
        //重定向可以重定向到其他站点
        //response.sendRedirect("https://www.baidu.com/");
        //这个是绝对路径，实际路径为http://localhost:8080/ResponseDemo2，
        // 但是ResponseDemo2的真实路径为 http://localhost:8080/servlet_learn/ResponseDemo2
        //response.sendRedirect("/ResponseDemo2");  //访问失败
        // 可以使用相对路径
        //response.sendRedirect("./ResponseDemo2");

        // 请求转发 可以使用 request域共享数据
        request.getRequestDispatcher("/ResponseDemo2").forward(request,response);
        // 转发就不需要加虚拟目录，给服务器用不需要加虚拟路径，给浏览器用需要加虚拟目录，
        // 因为重定向浏览器地址栏要变，因此必须加虚拟目录

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        this.doPost(request,response);
    }
}
