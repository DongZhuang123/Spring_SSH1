<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2020/10/9 0009
  Time: 20:52
  To change this template use File | Settings | File Templates.
--%>

<%@ page contentType="text/html;charset=UTF-8" isELIgnored="false" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<html>
<head>
    <title>学生信息修改</title>
</head>
<body >
<form action="addStudent.do" method="post">
              <input type="hidden" name="sid" value="${list.sid}">
      <br>姓名<input type="text" name="sname" value="${list.sname}"></br>
      <br>年龄<input type="text" name="sage" value="${list.sage}"></br>
      <br>性别<input type="radio" name="ssex" value="M" ${list.ssex=='M'?"checked":" "}>男
              <input type="radio" name="ssex"  value="F" ${list.ssex=='F'?"checked":" "}>女
      <br>班级<select name="cid" >
          <c:forEach items="${lis}" var="lis" varStatus="flag">
             <option value="${lis.cid}" ${list.cid==lis.cid?"selected":""}>${lis.cname}</option>
         </c:forEach>
      </select>
      </br>
      <br>爱好<input type="text" name="sahao" value="${list.sahao}"></br>
    <br>爱好<input type="date" name="datatime" value="${list.datatime}"></br>
    <input  type="submit" value="添加">
</form>
</body>
</html>
