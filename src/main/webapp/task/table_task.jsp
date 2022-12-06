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
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
    <title>List of my tasks</title>
</head>
<body>
<div class="container">
    <div class="row">
        <div class="col-12">
            <h1>Hello, ${username}. Your tasks here:</h1>
        </div>
    </div>
    <br>
    <table class="table">
        <thead class="table-dark">
        <tr>
            <th scope="col">Task</th>
            <th scope="col">Description</th>
            <th scope="col">Status</th>
            <th scope="col">Priority</th>
            <th scope="col">Hours</th>
            <th scope="col">Tags</th>
            <th scope="col">Actions</th>
        </thead>
        <tbody>
        <c:forEach items="${tasks}" var="task">
            <tr>
                <td>
                    <a href="task?id=${task.id}">${task.title}</a>
                </td>
                <td>${task.description}</td>
                <td>${task.status}</td>
                <td>${task.priority}</td>
                <td>${task.hours}</td>
                <td>
                    <c:forEach items="${task.tags}" var="tag">
                        <span class="badge badge-primary" style="background-color:${tag.color}">${tag.name}</span>
                    </c:forEach>
                </td>
                <td>
                    <a href="editTask?id=${task.id}&action=edit">Edit</a>
                    <a href="task?id=${task.id}&action=DELETE">Delete</a>
                </td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
    <br>
    <div class="row">
        <div class="col-12">
            <p>Press to task name for get more information</p>
        </div>
    </div>
    <br>
    <div class="row">
        <div class="col-12">
            <a onclick="location.href='new-task'" class="btn btn-primary">Add new task</a>
        </div>
    </div>
    <script>
        document.write('<a href="' + document.referrer + '">Go Back</a>');
    </script>
</div>
</body>
</html>