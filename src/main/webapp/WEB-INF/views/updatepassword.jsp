<%--
  Created by IntelliJ IDEA.
  User: jyx
  Date: 2019/5/24
  Time: 14:51
  To change this template use File | Settings | File Templates.
--%>
<%@ page pageEncoding="UTF-8" contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<strong>${message}</strong>
<form action="/updatepassword.do" method="post">
    <p>
        <label>旧密码:<input name="oldPwd"></label>
    </p>
    <p>
        <label>新密码:<input name="newPwd"></label>
    </p>
    <p>
        <label>新密码确认:<input name="newAginPwd"></label>
    </p>
    <p>
        <button type="submit">确定</button>
        <a href="/welcome.do">返回</a>
    </p>
</form>
</body>
</html>
