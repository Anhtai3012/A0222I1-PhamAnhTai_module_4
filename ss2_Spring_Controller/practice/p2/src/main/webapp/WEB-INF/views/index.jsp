<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: This PC
  Date: 23/09/2022
  Time: 2:55 CH
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>$Title$</title>
  </head>
  <body>
  <h1>Email Validate</h1>
  <c:if test="${message!=null}">
    <h3 style="color: red">${message}</h3>
  </c:if>
  <form action="/validate" method="post">
    <input type="text" name="email"><br>
    <input type="submit" value="Validate">
  </form>
  </body>
</html>
