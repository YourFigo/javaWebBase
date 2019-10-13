package cn.figo.web.servletContent;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/ServletContentDemo1")
public class ServletContentDemo1 extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        //1. 通过request对象获取
        ServletContext context1 = request.getServletContext();
        //2. 通过HttpServlet获取
        ServletContext context2 = this.getServletContext();

        System.out.println(context1);
        System.out.println(context2);

        System.out.println(context1 == context2);//true

        //3. 定义文件名称
        String filename = "a.jpg";//image/jpeg
        //4.获取MIME类型
        String mimeType = context2.getMimeType(filename);
        System.out.println(mimeType);

        // 获取文件的服务器路径
        String b = context2.getRealPath("/b.txt");//web目录下资源访问
        System.out.println(b);

        //设置数据
        context2.setAttribute("msg","haha");
        //获取数据
        Object msg = context1.getAttribute("msg");
        System.out.println(msg);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        this.doPost(request,response);
    }
}
