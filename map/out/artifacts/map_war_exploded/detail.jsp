<%@ page import="com.map.service.QueryLocation" %>
<%@ page import="com.map.service.imp.QueryLocationImp" %>
<%@ page import="com.map.domain.Location" %>
<%@ page import="java.util.HashSet" %>
<%@ page import="java.util.Set" %>
<%@ page import="java.util.List" %><%--
  Created by IntelliJ IDEA.
  User: 13406
  Date: 2019/2/25
  Time: 15:37
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
    <title>详细信息管理页面</title>
    <%
        QueryLocation ql = new QueryLocationImp();
        List<Location> locations = ql.getLocations();
        Set<String> points = new HashSet<>();
        for (Location l: locations) {
            points.add(l.getOrigin());
        }
        request.setAttribute("points", points);
    %>
    <script type="text/javascript" src="js/detailAjax.js"></script>
</head>
<body>
    <div>
        <div>
            <select id="search">
                <c:forEach items="${points}" var="p" varStatus="vs">
                    <option name="${p}">${p}</option>
                </c:forEach>
            </select>
            <input type="button" value="查询" onclick="searchInformation()" />
        </div>
        <div id="message">
            &nbsp;
        </div>
    </div>
    <div>
        <select id="change">
            <c:forEach items="${points}" var="p" varStatus="vs">
                <option name="${p}">${p}</option>
            </c:forEach>
        </select>
        <input type="text" id="changeText" /><br />
        <input type="button" value="修改" onclick="changeInformation()" />
    </div>
    <a href='/map/index.html'>返回首页</a><br />
</body>
</html>
