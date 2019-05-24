<%--
  Created by IntelliJ IDEA.
  User: jyx
  Date: 2019/5/23
  Time: 15:15
  To change this template use File | Settings | File Templates.
--%>
<%@ page pageEncoding="UTF-8" contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="utf-8">
    <title>主页</title>
    <style>
        menu, h1, ul {
            margin: 0;
        }

        html, body {
            margin: 0;
            height: 100%;
            font-size: 14px;
        }

        body > header {
            line-height: 80px;
            text-align: center;
            background: #999;
        }

        body > header > h1 {
            display: inline;
            text-align: center;
        }

        .body {
            position: absolute;
            top: 80px;
            bottom: 0;
            width: 100%;
        }

        .body > menu {
            position: absolute;
            left: 0;
            float: left;
            width: 200px;
            height: 100%;
            background: #24a1ff;
            box-sizing:border-box;
        }

        .body > main {
            margin-left: 200px;
            height: 100%;
            display: block;
            text-align: center;
        }

        main > iframe {
            width: 100%;
            height: 100%;
            border: 0;
            display: block;
        }
    </style>
</head>
<body>
<header>
    <h1>佳佳乐VIP消费查询系统</h1>
    <span>
            <b>${sessionScope.get("currentUser").name}</b>
            <a href="/logout.do">退出登录</a>
        </span>
</header>
<section class="body">
    <menu>
        <ul>
            <li>
                <a>VIP客户查询</a>
            </li>
            <li>
                <a>录入VIP客户</a>
            </li>
            <li>
                <a>VIP客户管理</a>
            </li>
            <li>
                <a>查询VIP消费记录</a>
            </li>
            <li>
                <a>录入VIP消费记录</a>
            </li>
            <li>
                <a href="/updatepassword.do" target="mainFrame">修改密码</a>
            </li>
        </ul>
    </menu>

    <main>
        <iframe name="mainFrame" src="/welcome.do"></iframe>
    </main>
</section>
</body>
<body>
你好!
</body>
</html>
