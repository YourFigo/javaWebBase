package cn.figo.web.response;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/ResponseDemo2")
public class ResponseDemo2 extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        System.out.println("ResponseDemo2 2222222222");
        //重定向是两次请求。不能使用request对象来共享数据
        Object msg = request.getAttribute("msg");
        System.out.println(msg);

        //再请求转发回ResponseDemo1，会造成死循环，浏览器提示重定向次数过多
        //request.getRequestDispatcher("/ResponseDemo1").forward(request,response);

        //  服务器输出字节数据到浏览器
        //简单的形式，设置编码
        response.setContentType("text/html;charset=utf-8");
        //1.获取字符输出流
        //PrintWriter pw = response.getWriter();
        //2.输出数据
        //pw.write("<h1>hello response</h1>");
        //pw.write("你好啊啊啊 response");

        //1.获取字节输出流
        ServletOutputStream sos = response.getOutputStream();
        //2.输出数据
        sos.write("你好".getBytes("utf-8"));
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        this.doPost(request,response);
    }
}
