<%--
  Created by IntelliJ IDEA.
  User: gouzi
  Date: 2020/2/17
  Time: 22:24
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>登录页面</title>

    <script>
        window.onload = function () {
            var img = document.getElementById("img");
            img.onclick = function () {
                var time = new Date().getTime();
                img.src = "/loginModule/checkCodeServlet?time=" + time;
            }
        }
    </script>
</head>
<body>

    <form action="/loginModule/newLoginServlet" method="post">
        <table>
            <tr>
                <td>用户名:</td>
                <td><input type="text" name="username"></td>
            </tr>
            <tr>
                <td>密码:</td>
                <td><input type="password" name="password"></td>
            </tr>
            <tr>
                <td>验证码:</td>
                <td><input type="text" name="checkcode"></td>
            </tr>
            <tr>
                <td colspan="2"><img id="img" src="/loginModule/checkCodeServlet"></td>
            </tr>
            <tr>
                <td colspan="2"><input type="submit" value="提交"></td>
            </tr>
        </table>
    </form>
    <div>
        <%= request.getAttribute("loginCheckCodeError") == null ? "" : request.getAttribute("loginCheckCodeError")%>
    </div>
    <div>
        <%= request.getAttribute("loginError") == null ? "" : request.getAttribute("loginError")%>
    </div>
</body>

</html>
