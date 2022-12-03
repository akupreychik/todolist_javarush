<%--
  Created by IntelliJ IDEA.
  User: antonkupreychik
  Date: 3.12.22
  Time: 15:38
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Task Information</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
</head>
<body>
<div class="container">

        <div class="col-12">
            <h1>Task Information</h1>
            <br>

            <p>Id: ${task.id}</p>
            <p>Title: ${task.name}</p>
            <p>Description: ${user.name}</p>
            <p>Created: ${task.created}</p>
            <p>Updated: ${task.updated}</p>
            <p>Status: ${task.status}</p>
            <p>Priority: ${task.priority}</p>
            <p>Hours: ${task.hours}</p>
            <p>Text: ${task.text}</p>
            <p>Tags: ${task.tags}</p>
        </div>
</div>
</body>
</html>
