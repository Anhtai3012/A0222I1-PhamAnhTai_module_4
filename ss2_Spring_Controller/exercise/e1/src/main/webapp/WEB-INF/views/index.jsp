<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: This PC
  Date: 26/09/2022
  Time: 3:08 SA
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>$Title$</title>
  </head>
  <body>
<h1>Sandwich Condiments</h1>
<form action="/save" method="post">
  <input type="checkbox" name="condiment" value="lecttuce">
  <label>Lettuce</label>
  <input type="checkbox" name="condiment" value="tomato">
  <label>Tomato</label>
  <input type="checkbox" name="condiment" value="mustard">
  <label>Mustard</label>
  <input type="checkbox" name="condiment" value="sprouts">
  <label>Sprouts</label>
  <hr>
  <button type="submit">save</button>
</form>
  <h3>${result}</h3>
  </body>
</html>
