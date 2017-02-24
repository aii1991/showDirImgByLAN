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
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>文件</title>
</head>
<body>

    <div class="container-fluid">
        <div>
            <c:forEach var="item" items="${pcsFileList.list}">
                ${item.isdir}
                <c:choose>
                    <c:when test="${item.isdir == 1}">
                        我是目录
                    </c:when>
                    <c:otherwise>
                        <%--<img src="<c:out value="${item.path}"></c:out>" class="img-responsive img-thumbnail" />--%>
                        <a href="download?path=<c:out value="${item.path}"></c:out>"><c:out value="${item.path}"></c:out></a>
                    </c:otherwise>
                </c:choose>

                <c:out value="${item.path}"></c:out>
            </c:forEach>
        </div>
    </div>



</body>


<!-- 最新版本的 Bootstrap 核心 CSS 文件 -->
<link rel="stylesheet" href="https://cdn.bootcss.com/bootstrap/3.3.7/css/bootstrap.min.css" integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">
<!-- 可选的 Bootstrap 主题文件（一般不用引入） -->
<link rel="stylesheet" href="https://cdn.bootcss.com/bootstrap/3.3.7/css/bootstrap-theme.min.css" integrity="sha384-rHyoN1iRsVXV4nD0JutlnGaslCJuC7uwjduW9SVrLvRYooPp2bWYgmgJQIXwl/Sp" crossorigin="anonymous">
<!-- 最新的 Bootstrap 核心 JavaScript 文件 -->
<script src="https://cdn.bootcss.com/bootstrap/3.3.7/js/bootstrap.min.js" integrity="sha384-Tc5IQib027qvyjSMfHjOMaLkfuWVxZxUPnCJA7l2mCWNIpG9mGCD8wGNIcPD7Txa" crossorigin="anonymous"></script>
<link rel="stylesheet" href="list_file.jsp"/>
</html>





