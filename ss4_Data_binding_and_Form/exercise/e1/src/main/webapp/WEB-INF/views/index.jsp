<%--
  Created by IntelliJ IDEA.
  User: This PC
  Date: 28/09/2022
  Time: 10:16 CH
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>$Title$</title>
  </head>
  <body>
  <h1>view-edit</h1>
  <table>
    <form:form method="post" modelAttribute="setting" action="/save">
      <tr>
        <td>Languages</td>
        <td>
          <form:select path="language" cssClass="form-select">
            <form:option value="English">English</form:option>
            <form:option value="Vietnamese">Vietnamese</form:option>
            <form:option value="Japanese">Japanese</form:option>
            <form:option value="Chinese">Chinese</form:option>
          </form:select>
        </td>
      </tr>
      <tr>
        <td>Page Size:</td>
        <td>
          Show
          <form:select path="pageSize">
            <form:option value="5">5</form:option>
            <form:option value="10">10</form:option>
            <form:option value="15">15</form:option>
            <form:option value="25">25</form:option>
            <form:option value="50">50</form:option>
            <form:option value="100">100</form:option>
          </form:select>
          emails per page
        </td>
      </tr>
      <tr>
        <td>Spams filter:</td>
        <td class="d-flex">
          <form:checkbox path="spamFilter" value="true" cssClass="form-check"/>
          Enable spams filter
        </td>
      </tr>
      <tr>
        <td>Signature</td>
        <td>
          <form:textarea path="signature" rows="7" cols="20"></form:textarea>
        </td>
      </tr>
      <tr>
        <td></td>
        <td>
          <button type="submit">Update</button>
          <button type="button">Cancel</button>
        </td>
      </tr>
    </form:form>
  </table>
  </body>
</html>
