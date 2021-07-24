<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>新增用户页面</title>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link href="../../css/bootstrap.min.css" rel="stylesheet">
    <script src="../../js/jquery-3.2.1.min.js"></script>
    <script src="../../js/bootstrap.min.js"></script>
</head>
<body>
<div align="center">
    <form action="${pageContext.request.contextPath}/user?method=addUser" method="post">
        <div class="form-group">
            <label for="username">用户名称</label>
            <input class="form-control" type="text" name="username" id="username">
        </div>
        <div class="form-group">
            <label for="email">用户邮箱</label>
            <input class="form-control" type="text" name="email" id="email"><br/>
        </div>
        <input class="btn btn-default" type="submit" value="添加用户信息">
    </form>
</div>
</body>
</html>
