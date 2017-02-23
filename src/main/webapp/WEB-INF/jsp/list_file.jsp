<%--
  Created by IntelliJ IDEA.
  User: jason
  Date: 2017/2/21
  Time: 16:42
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib  uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>文件</title>
</head>
<body>
    <c:forEach var="item" items="${pcsFileList.list}">
        <c:out value="${item.path}"></c:out>
    </c:forEach>
</body>
</html>
