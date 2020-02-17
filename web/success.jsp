<%--
  Created by IntelliJ IDEA.
  User: gouzi
  Date: 2020/2/18
  Time: 00:27
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>登录成功</title>
</head>
<body>

    <div>
        <%= request.getSession().getAttribute("userName")%>, 欢迎您！
    </div>

</body>
</html>
