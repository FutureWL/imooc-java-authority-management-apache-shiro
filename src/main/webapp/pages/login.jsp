<%--
  Created by IntelliJ IDEA.
  User: weilai
  Date: 2019-04-17
  Time: 19:35
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Login</title>
</head>
<body>
<h1> 欢迎登录 </h1>
<form action="/loginUser" method="post">
    <input type="text" name="username"> <br>
    <input type="password" name="password"> <br>
    <input type="submit" value="提交">
</form>
</body>
</html>