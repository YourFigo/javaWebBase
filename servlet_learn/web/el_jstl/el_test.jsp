<%@ page import="cn.figo.el_jstl.domain.User" %>
<%@ page import="java.util.*" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    ${3 > 4}

    \${3 > 4}
    <hr>

    <h3>算数运算符</h3>
    ${3 + 4}<br>
    ${3 / 4}<br>
    ${3 div 4}<br>
    ${3 % 4}<br>
    ${3 mod 4}<br>
    <h3>比较运算符</h3>
    ${3 == 4}<br>

    <h3>逻辑运算符</h3>
    ${3 > 4  && 3 < 4}<br>
    ${3 > 4  and 3 < 4}<br>


    <h4>empty运算符</h4>
    <%

        String str = "";
        request.setAttribute("str",str);

        List list = new ArrayList();
        request.setAttribute("list",list);

        //在域中存储数据
        session.setAttribute("name","李四");

        request.setAttribute("name","张三");
        session.setAttribute("age","23");

        request.setAttribute("str","");

    %>
    ${not empty str}
    ${not empty list}
    <hr>
    <h3>el获取值</h3>
    ${requestScope.name}
    ${sessionScope.age}
    ${sessionScope.haha}
    ${name}
    ${sessionScope.name}

    <%
        User user = new User();
        user.setName("张三");
        user.setAge(23);
        user.setBirthday(new Date());


        request.setAttribute("u",user);


        List list1 = new ArrayList();
        list1.add("aaa");
        list1.add("bbb");
        list1.add(user);

        request.setAttribute("list1",list1);


        Map map = new HashMap();
        map.put("sname","李四");
        map.put("gender","男");
        map.put("user",user);

        request.setAttribute("map",map);

    %>

    <hr>
    <h3>el获取对象中的值</h3>
    ${requestScope.u}<br>
    ${requestScope.u.name}<br>
    ${u.age}<br>
    ${u.birthday}<br>
    ${u.birthday.month}<br>

    ${u.birStr}<br>

    <h3>el获取List值</h3>
    ${list1}<br>
    ${list1[0]}<br>
    ${list1[1]}<br>
    ${list1[10]}<br>

    ${list1[2].name}

    <h3>el获取Map值</h3>
    ${map.gender}<br>
    ${map["gender"]}<br>
    ${map.user.name}

    <hr>
    <h4>在jsp页面动态获取虚拟目录</h4>
    ${pageContext.request}<br>
    ${pageContext.request.contextPath}
</body>
</html>
