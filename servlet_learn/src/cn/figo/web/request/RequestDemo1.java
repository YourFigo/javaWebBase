package cn.figo.web.request;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.IOException;
import java.util.Enumeration;
import java.util.Map;
import java.util.Set;

@WebServlet("/requestDemo1")
public class RequestDemo1 extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        // 请求体，只有post方式有
        //获取字符输入流，只能操作字符数据
        // user=lisi&btn=%E6%8F%90%E4%BA%A4
        BufferedReader br = request.getReader();
        String line = null;
        while ((line = br.readLine()) != null){
            System.out.println(line);
        }
        //获取字节输入流，可以操作所有类型数据
        // ServletInputStream getInputStream()


    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 请求行
        // GET /requestDemo1?user=shangsan&btn=%E6%8F%90%E4%BA%A4 HTTP/1.1
        // GET /servlet_learn/requestDemo1?user=lisi&btn=%E6%8F%90%E4%BA%A4 HTTP/1.1
        System.out.println(request.getMethod());  // GET
        System.out.println(request.getContextPath());
        // 第一次tomcat中配置为/因此为空；第二次配置为/servlet_learn，结果为 /servlet_learn
        System.out.println(request.getServletPath()); // /requestDemo1
        System.out.println(request.getQueryString()); // user=shangsan&btn=%E6%8F%90%E4%BA%A4
        System.out.println(request.getRequestURI());  // /requestDemo1
        System.out.println(request.getRequestURL());  // http://localhost:8080/requestDemo1
        System.out.println(request.getProtocol());    // HTTP/1.1
        System.out.println(request.getRemoteAddr());  // 0:0:0:0:0:0:0:1

        // 请求头
        Enumeration<String> headerNames = request.getHeaderNames();
        System.out.println(headerNames);
        while (headerNames.hasMoreElements()){
            String headerName = headerNames.nextElement();
            String value = request.getHeader(headerName);
            System.out.println(headerName + ": " + value);
        }

        System.out.println("-----------------------------");
        String userValue = request.getParameter("user");
        System.out.println(userValue);
        System.out.println("-----------------------------");
        String[] likeValues = request.getParameterValues("like");
        for (String likeValue : likeValues) {
            System.out.println(likeValue);
        }

        System.out.println("-----------------------------");
        Enumeration<String> paraNames = request.getParameterNames();
        while (paraNames.hasMoreElements()){
            String paraName = paraNames.nextElement();
            String paraValue = request.getParameter(paraName);
            // String[] paraValue = request.getParameterValues(paraName);
            System.out.println(paraName + ": " + paraValue);
        }

        System.out.println("-------------------------------");
        Map<String,String[]> paraMap = request.getParameterMap();
        Set<String> keySet = paraMap.keySet();
        for (String name :keySet){
            System.out.println(name);
            String[] values = paraMap.get(name);
            System.out.println(values);
            for (String value : values){
                System.out.println(value);
            }
            System.out.println("============");
        }

    }
}
