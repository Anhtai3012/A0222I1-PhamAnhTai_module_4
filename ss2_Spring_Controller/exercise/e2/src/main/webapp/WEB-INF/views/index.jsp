<%--
  Created by IntelliJ IDEA.
  User: This PC
  Date: 26/09/2022
  Time: 4:01 SA
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>$Title$</title>
  </head>
  <body>
<h1>Calculator</h1>
<form action="/realizable" method="post">
  <input type="number" size="35" name="number1">
  <input type="number" size="35" name="number2">
  <br>
  <input type="submit" name="calculator" value="+">
  <input type="submit" name="calculator" value="-">
  <input type="submit" name="calculator" value="*">
  <input type="submit" name="calculator" value="/">

</form>
  <h3>${result}</h3>
  </body>
</html>
