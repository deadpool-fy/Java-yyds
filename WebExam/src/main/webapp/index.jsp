<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>跳转页</title>
    <link href="WEB-INF/css/bootstrap.min.css" rel="stylesheet">
    <script src="WEB-INF/js/jquery-3.2.1.min.js"></script>
    <script src="WEB-INF/js/bootstrap.min.js"></script>
</head>
<body>
<div align="center">
    <a class="btn btn-default" href="${pageContext.request.contextPath}/user?method=findAll">查看所有用户列表</a>
</div>
</body>
</html>
