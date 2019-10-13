<%@ page import="java.util.List" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="java.util.Date" %>
<%@ page import="cn.figo.el_jstl.domain.User" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

    <%request.setAttribute("number",3);%>
    <c:if test="${number % 2 != 0}">
        ${number}为奇数
    </c:if>

    <hr>

    <%request.setAttribute("number",51);%>
    <c:choose>
        <c:when test="${number == 1}">星期一</c:when>
        <c:when test="${number == 2}">星期二</c:when>
        <c:when test="${number == 3}">星期三</c:when>
        <c:when test="${number == 4}">星期四</c:when>
        <c:when test="${number == 5}">星期五</c:when>
        <c:when test="${number == 6}">星期六</c:when>
        <c:when test="${number == 7}">星期天</c:when>
        <c:otherwise>数字输入有误</c:otherwise>
    </c:choose>

    <hr>

    <c:forEach begin="0" end="10" var="i" step="2" varStatus="s">
        ${i} ${s.index} ${s.count} <br>
    </c:forEach>

    <hr>

    <%
        List list = new ArrayList();
        list.add("aaa");
        list.add("bbb");
        list.add("ccc");
        request.setAttribute("list",list);
    %>

    <c:forEach items="${list}" var="str" varStatus="s">
        ${s.index} ${s.count} ${str}<br>
    </c:forEach>


    <%
        List list1 = new ArrayList();
        list1.add(new User("张三",23,new Date()));
        list1.add(new User("李四",24,new Date()));
        list1.add(new User("王五",25,new Date()));

        request.setAttribute("list1",list1);
    %>

    <hr>
    <table border="1" width="500" align="center">
        <tr>
            <th>编号</th>
            <th>姓名</th>
            <th>年龄</th>
            <th>生日</th>
        </tr>
        <%--数据行--%>
        <c:forEach items="${list1}" var="user" varStatus="s">

            <c:if test="${s.count % 2 != 0}">

                <tr bgcolor="red">
                    <td>${s.count}</td>
                    <td>${user.name}</td>
                    <td>${user.age}</td>
                    <td>${user.birStr}</td>
                </tr>
            </c:if>

            <c:if test="${s.count % 2 == 0}">

                <tr  bgcolor="green">
                    <td>${s.count}</td>
                    <td>${user.name}</td>
                    <td>${user.age}</td>
                    <td>${user.birStr}</td>
                </tr>
            </c:if>
        </c:forEach>
    </table>

</body>
</html>
