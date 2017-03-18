<%--
  Created by IntelliJ IDEA.
  User: jason
  Date: 2017/2/21
  Time: 16:42
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@taglib uri="http://www.jason.com/jstl/function" prefix="cfn" %>
<c:set var="token" value="23.7a8ab40eb48a6f4f2e154796f595d624.2592000.1490164345.4009844415-4329606"></c:set>
<c:set var="baseUrl" value="https://pcs.baidu.com/rest/2.0/pcs"></c:set>
<c:set var="fileBaseUrl" value="${baseUrl}/file"></c:set>
<html>
<head>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>文件</title>
</head>
<body>

    <div class="container-fluid">
        <div id="file-wrapper">
            <ul id="viewer">
                <c:forEach var="item" items="${pcsFileList.list}">
                    <c:set var="fileName" value="${cfn:getFileNameByPath(item.path)}"></c:set>
                    <li>
                        <div data-path="${item.path}" data-type="${item.isdir}" class="file-item">
                            <c:choose>
                                <c:when test="${item.isdir == 1}">
                                    <div class="img-responsive img-thumbnail img-file-thumbnail">
                                        <div class="folder-bg"></div>
                                    </div>

                                    <div class="img-desc">
                                        <span>${fileName}</span>
                                    </div>
                                </c:when>
                                <c:otherwise>
                                    <c:if test="${cfn:isImg(fileName)}">
                                        <img data-original="${fileBaseUrl}?method=download&access_token=${token}&path=${cfn:urlEncode(item.path)}" src="${baseUrl}/thumbnail?method=generate&access_token=${token}&path=${cfn:urlEncode(item.path)}&height=150&width=150" class="img-responsive img-thumbnail img-file-thumbnail" />
                                        <div class="img-desc">
                                            <span>${fileName}</span>
                                        </div>
                                    </c:if>
                                </c:otherwise>
                            </c:choose>
                        </div>
                    </li>
                </c:forEach>
            </ul>
        </div>


    </div>

</body>


<!-- 最新版本的 Bootstrap 核心 CSS 文件 -->
<link rel="stylesheet" href="https://cdn.bootcss.com/bootstrap/3.3.7/css/bootstrap.min.css" integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">
<!-- 最新的 Bootstrap 核心 JavaScript 文件 -->
<link rel="stylesheet" href="../css/list_file.css"/>
<link rel="stylesheet" href="../css/viewer.min.css"/>

<!--jquery-->
<script src="https://cdn.bootcss.com/jquery/3.1.1/jquery.js"></script>
<script src="https://cdn.bootcss.com/bootstrap/3.3.7/js/bootstrap.min.js" integrity="sha384-Tc5IQib027qvyjSMfHjOMaLkfuWVxZxUPnCJA7l2mCWNIpG9mGCD8wGNIcPD7Txa" crossorigin="anonymous"></script>

<script src="../js/list_file.js"></script>
<script src="../js/viewer.min.js"></script>
</html>





