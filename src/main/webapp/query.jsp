<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2020/10/9 0009
  Time: 20:52
  To change this template use File | Settings | File Templates.
--%>
<!DOCTYPE html>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page isELIgnored="false" %>
<html>
<head>
    <!-- 引入 Bootstrap -->
    <link href="js/bootstrap.min.css" rel="stylesheet">
    <!-- HTML5 Shiv 和 Respond.js 用于让 IE8 支持 HTML5元素和媒体查询 -->
    <!-- 注意： 如果通过 file://  引入 Respond.js 文件，则该文件无法起效果 -->
    <!--[if lt IE 9]>
    <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
    <script src="https://oss.maxcdn.com/libs/respond.js/1.3.0/respond.min.js"></script>
    <![endif]-->
    <!-- jQuery (Bootstrap 的 JavaScript 插件需要引入 jQuery) -->
    <script src="js/jquery-3.3.1.min.js" type="text/javascript"></script>
    <!-- 包括所有已编译的插件 -->
    <script src="js/bootstrap.min.js"></script>


    <script type="text/javascript">
        function readradio() {
            var cstuden = document.getElementsByName("student")
            for (var i = 0; i < cstuden.length; i++) {
                cstuden[i].checked = !cstuden[i].checked;
            }
        }

    </script>


<body>
<nav class="navbar navbar-inverse" role="navigation">
    <div class="container-fluid">
        <div class="navbar-header">
            <a class="navbar-brand" >首页</a>
        </div>
        <div>
            <ul class="nav navbar-nav">
                <li class="active"><a href="queryH_Class.do">添加</a></li>
                <li class="active"><a href="#">全部删除</a></li>
            </ul>
        </div>
    </div>
</nav>

<form action="queryAndStu.do" method="post" class="form-inline">
    <div class="input-group input-group-lg">
        <span class="input-group-addon">姓名：</span>
        <input type="text" class="form-control" placeholder="请输入姓名">
    </div>
</div>

    性别：
    <div class="radio">
        <label>
            <input type="radio" name="sex" value="F" checked="checked"> 女生
        </label>
    </div>
    <div class="radio">
        <label>
            <input type="radio" name="sex"  value="M">男生
        </label>
    </div>


    班级:
    <select name="cid" style="padding: 20px 5px 5px;">
        <option value="-1">请选择</option>
        <c:forEach items="${lis}" var="lis">
            <option value="${lis.cid}">${lis.cname}</option>
        </c:forEach>
    </select>

    <input type="submit" value="查询">
</form>
<form action="jquery.do" method="post">
    <table class="table table-hover">
        <tr>
            <td><input type="checkbox" onclick="readradio()"></td>
            <td>序列</td>
            <td>姓名</td>
            <td>年龄</td>
            <td>性别</td>
            <td>班级</td>
            <td>爱好</td>
            <td>生日</td>
            <td>证件照</td>
            <td>操作
            <td>
        </tr>
        <c:forEach items="${list}" var="list" varStatus="flag">
        <tr>
            <td><input type="checkbox" name="student" value="${list[0].sid}"></td>
            <td>${flag.index+1}</td>
            <td>${list[0].sname}</td>
            <td>${list[0].sage}</td>
            <td>${list[0].ssex=='F'?"女":"男"}</td>
            <td>${list[1].cname}</td>
            <td>${list[0].sahao}</td>
            <td>${list[0].datatime}</td>
            <img src="D:/Work/apache-tomcat-9.0.1/${list[0].file}">
            <td><a href="getStudentid.do?sid=${list[0].sid}">修改</a><a href="item/${list[0].sid}">删除</a></td>
        </tr>
        </c:forEach>
        <input type="submit" value="删除">
</form>
</table>
</body>
</html>
