<%--
  Created by IntelliJ IDEA.
  User: zhuxiang
  Date: 2018/5/1
  Time: 18:18
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>文章预览</title>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="keywords" content="微素材">
    <meta name="description" content="寻找微素材" />

    <link rel="icon" href="/images/icons/logo.png" type="image/x-icon"/>
    <link href="/css/myCommon.css" rel="stylesheet" type="text/css" />
    <link href="/css/index.css" rel="stylesheet" type="text/css" />
    <link href="/css/bootstrap/bootstrap.css" rel="stylesheet" type="text/css" />

    <script src="/js/bootstrap/jquery-2.1.4.min.js"></script>
</head>
<body>
    <div class="container">
        <div id="headerWrap"></div>
        <script>
            //加载header
            $('#headerWrap').load('/header');
        </script>

        <div class="row clearfix">
            <div class="col-md-12">
                <div id="articleInfo" style="-moz-user-select: none;-khtml-user-select: none;user-select: none;">
                    <h2>${article.title}</h2>
                    <span id="time">
                        ${article.releaseTime.getYear()}-
                        ${article.releaseTime.getMonthValue()}-
                        ${article.releaseTime.getDayOfMonth()}
                        ${article.releaseTime.getHour()}:
                        ${article.releaseTime.getMinute()}:
                        ${article.releaseTime.getSecond()}
                    </span>
                    <div style="padding:30px 10px">
                        <p>${article.content}</p>
                    </div>
                </div>
            </div>
        </div>
        <div id="footerWrap"></div>
        <script>
            //加载footer
            $('#footerWrap').load('/footer');
        </script>
    </div>

<script src="/js/bootstrap/jquery-2.1.4.min.js"></script>
<script src="/js/bootstrap/bootstrap.js"></script>
<script src="/js/vue/vue.js"></script>
</body>
</html>
