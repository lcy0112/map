<%@ page import="com.map.service.QueryLocation" %>
<%@ page import="com.map.service.imp.QueryLocationImp" %>
<%@ page import="com.map.domain.Location" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.Set" %>
<%@ page import="java.util.HashSet" %><%--
  Created by IntelliJ IDEA.
  User: 13406
  Date: 2019/2/23
  Time: 23:16
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
    <title>修改系统</title>
    <script type="text/javascript">
        window.onload = function () {
            var tmp1 = document.getElementById("sorigin");
            var tmp2 = document.getElementById("corigin");
            soriginChange(tmp1[tmp1.selectedIndex].value);
            coriginChange(tmp2[tmp2.selectedIndex].value);
        }
    </script>
    <script type="text/javascript" src="js/changeAjax.js"></script>
    <%
        QueryLocation ql = new QueryLocationImp();
        List<Location> locations = ql.getLocations();
        Set<String> points = new HashSet<>();
        for (Location l: locations) {
            points.add(l.getOrigin());
        }
        request.setAttribute("points", points);
    %>
</head>
<body>
    <div>
        增加路线:<br />
        起始地: <input type="text" name="origin" id="11" /><br />
        目的地: <input type="text" name="destination" id="12"/><br />
        距离: <input type="text" name="length" id="13"/><br />
        <input type="button" value="增加" onclick="add()" />
    </div>
    <hr />
    <div>
        修改路线:<br />
        起始地:
        <select id="sorigin" onchange="soriginChange(this[selectedIndex].value)")>
            <c:forEach items="${points}" var="p" varStatus="vs">
                <option name="${p}">${p}</option>
            </c:forEach>
        </select><br />
        目的地:
        <select id="sdestination" onchange="sdestinationChange(this[selectedIndex].value)">

        </select><br />
        距离:<input type="text" id="slength"/><br />
        <input type="button" value="修改" onclick="submitChange()" />
    </div>
    <hr />
    <div>
        删除路线:<br />
        起始地:
        <select id="corigin" onchange="coriginChange(this[selectedIndex].value)")>
            <c:forEach items="${points}" var="p" varStatus="vs">
                <option name="${p}">${p}</option>
            </c:forEach>
        </select><br />
        目的地:
        <select id="cdestination" onchange="cdestinationChange(this[selectedIndex].value)">

        </select><br />
        距离:<span id="clength"></span><br />
        <input type="button" onclick="delPath()" value="删除" />
    </div>
    <div><a href='/map/index.html'>返回首页</a><br /></div>
</body>
</html>
