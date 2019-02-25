<%@ page import="com.map.service.QueryLocation" %>
<%@ page import="com.map.domain.Location" %>
<%@ page import="java.util.List" %>
<%@ page import="com.map.service.imp.QueryLocationImp" %>
<%@ page import="java.util.Set" %>
<%@ page import="java.util.HashSet" %><%--
  Created by IntelliJ IDEA.
  User: 13406
  Date: 2019/2/25
  Time: 17:15
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
    <title>高级查询功能</title>
    <%
        QueryLocation ql = new QueryLocationImp();
        List<Location> locations = ql.getLocations();
        Set<String> points = new HashSet<>();
        for (Location l: locations) {
            points.add(l.getOrigin());
        }
        request.setAttribute("points", points);
    %>
    <script type="text/javascript" src="js/advanceSearchAjax.js"></script>
</head>
<body>
    <div>
        <div>
            两点之间的全部路径:<br />
            起始地:
            <select id="origin">
                <c:forEach items="${points}" var="p" varStatus="vs">
                    <option name="${p}">${p}</option>
                </c:forEach>
            </select>&nbsp;&nbsp;
            目的地:
            <select id="destination">
                <c:forEach items="${points}" var="p" varStatus="vs">
                    <option name="${p}">${p}</option>
                </c:forEach>
            </select>&nbsp;&nbsp;
            <input type="button" value="查询" onclick="allPath()" />
        </div>
        <div id="allPathResult"></div>
    </div>
    <br /><br /><hr />
    <div>
        <div>
            多个指定点的路径:
            <p>输入格式:位置1#位置2#....#位置n</p>
            <input type="text" id="points" />&nbsp;&nbsp;
            <input type="button" value="查询" onclick="multiPoints()"/>
        </div>
        <div id="multiRes"></div>
    </div>
    <div><a href='/map/index.html'>返回首页</a></div>
</body>
</html>
