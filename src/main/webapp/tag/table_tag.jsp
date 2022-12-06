<%--
  Created by IntelliJ IDEA.
  User: antonkupreychik
  Date: 3.12.22
  Time: 15:38
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>List of tags</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
</head>
<body>
<div class="container">
    <table class="table">
        <thead>
        <tr>
            <th scope="col">Name</th>
            <th scope="col">Color</th>
            <th scope="col">Edit</th>
            <th scope="col">Delete</th>
        <tr>
        </thead>
        <tbody>
        <c:forEach items="${tags}" var="tag">
            <tr>
                <td>${tag.name}</td>
                <td style="background-color:${tag.color}"></td>
                <td>
                    <a href="${pageContext.request.contextPath}/tag/edit?id=${tag.id}">Edit</a>
                </td>
                <td>
                    <a href="${pageContext.request.contextPath}/tag/delete?id=${tag.id}">Delete</a>
                </td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
    <button type="button" class="btn btn-primary" onclick="location.href='new-tag'">Add tag</button>
    <script>
        document.write('<a href="' + document.referrer + '">Go Back</a>');
    </script>
</div>
</body>
</html>
