package cn.figo.web.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *  访问一个Servlet，如果是第一次访问，则提示：您好，欢迎您首次访问。
 * 	如果不是第一次访问，则提示：欢迎回来，您上次访问时间为:显示时间字符串
 */
@WebServlet("/CookieTest")
public class CookieTest extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //有中文，设置响应的消息体的数据格式以及编码
        response.setContentType("text/html;charset=utf-8");
        //获取所有Cookie
        Cookie[] cookies = request.getCookies();
        boolean flag = false;
        //如果有cookie
        if (cookies != null && cookies.length > 0){
            //遍历cookie数组
            for (Cookie cookie : cookies){
                //获取cookie的名称
                String name = cookie.getName();
                //判断名称是否是：lastTime,有该Cookie，不是第一次访问
                if("lastTime".equals(name)){
                    flag = true;

                    //先从cookie中获取上次登录时间
                    String value = cookie.getValue();
                    System.out.println("解码前： " + value);
                    value = URLDecoder.decode(value,"utf-8");
                    System.out.println("解码后： " + value);
                    response.getWriter().write("欢迎回来，您上次的访问时间为： " + value);

                    //在获取当前时间来更新cookie的值
                    Date date = new Date();
                    SimpleDateFormat sdf = new SimpleDateFormat("yyyy年MM月dd日 HH:mm:ss");
                    String str_date = sdf.format(date);
                    System.out.println("编码前： " + str_date);
                    str_date = URLEncoder.encode(str_date,"utf-8");
                    System.out.println("编码后： " + str_date);

                    cookie.setValue(str_date);
                    cookie.setMaxAge(60 * 60 * 24 * 30);
                    response.addCookie(cookie);

                }
            }
        }
        if (cookies == null || cookies.length == 0 || flag == false){
            //第一次访问，设置Cookie的value
            Date date = new Date();
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy年MM月dd日 HH:mm:ss");
            String str_date = sdf.format(date);
            System.out.println("编码前： " + str_date);
            str_date = URLEncoder.encode(str_date,"utf-8");
            System.out.println("编码后： " + str_date);

            Cookie cookie = new Cookie("lastTime",str_date);
            cookie.setValue(str_date);
            cookie.setMaxAge(60 * 60 * 24 * 30);
            response.addCookie(cookie);
            response.getWriter().write("您好，欢迎您首次访问");
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        this.doPost(request,response);
    }
}
