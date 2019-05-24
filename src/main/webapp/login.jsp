<%@page pageEncoding="UTF-8" %>
<html>

<head>
    <meta charset="utf-8">
    <title>登录系统</title>
</head>
<script>
    if (window.top !== window.top.location.href) {
        window.top = window.location.href;
    }
    // window.top !== window&&window.top.location.href = window.location.href;
</script>
<body>
<strong>${message}</strong>
<form action="login.do" method="post">
    <p>
        <label>Account:<input name="account"></label>
    </p>
    <p>
        <label>Password:<input name="password"></label>
    </p>
    <p>
        <button type="submit">login</button>
    </p>
</form>
</body>
</html>
