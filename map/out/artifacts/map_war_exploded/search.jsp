<%--
  Created by IntelliJ IDEA.
  User: 13406
  Date: 2019/2/22
  Time: 20:11
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
    <title>查询系统</title>
    <script type="text/javascript">
        function search() {
            var req = new XMLHttpRequest();
            req.onreadystatechange = function () {
                if(req.readyState == 4 && req.status == 200){
                    var div = document.getElementById("result");
                    div.innerHTML = req.responseText;
                }
            }
            var originElement = document.getElementsByName("origin")[0];
            var destinationElement = document.getElementsByName("destination")[0];
            var origin = originElement.options[originElement.selectedIndex].value;
            var destination = destinationElement.options[destinationElement.selectedIndex].value;
            var data = "origin=" + encodeURI(encodeURI(origin)) + "&destination=" + encodeURI(encodeURI(destination));
            var url = "${pageContext.request.contextPath}/servlet/shortestRoute?";
            req.open("get", url + data);
            req.send();
        }
    </script>
</head>
<body>
    起始地:
    <select name="origin">
        <c:forEach items="${points}" var="p" varStatus="vs">
            <option name="${p}">${p}</option>
        </c:forEach>
    </select><br />
    目的地:
    <select name="destination">
        <c:forEach items="${points}" var="p" varStatus="vs">
            <option name="${p}">${p}</option>
        </c:forEach>
    </select><br />
    <input type="button" onclick="search()" value="查询" />
    <a href='/map/index.html'>返回首页</a><br />
    <div id="result"></div>
</body>
</html>
