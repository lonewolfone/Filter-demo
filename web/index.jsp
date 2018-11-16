<%--
  Created by IntelliJ IDEA.
  User: 听音乐的酒
  Date: 2018/11/15
  Time: 17:00
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>index页面：Filter学习</title>
  </head>
  <body>
      <h4><a href="/fristServlet">firstServlet请求转发到secondServlet请求</a></h4><br>

      <%--<h4>Filter实际开发中典型应用</h4><br>
      <form action="/fromServlet" method="get">
          用户名：<input type="text" name="username" id="username" value=""><br><br>
          <input type="submit" value="提交"><br><br>
      </form>--%>

      <h3>Filter实际开发中典型应用之用户登陆</h3><br>
      <form action="/loginServlet" method="get">
          用户名：<input type="text" name="username"  value=""><br><br>
          <input type="submit" value="提交"><br><br>
      </form>
      <span style="color: red">${msg}</span>
  </body>
</html>
