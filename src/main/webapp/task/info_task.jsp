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
    <title>Task Information</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
</head>
<body>
<div class="container">

    <h1>Task Information</h1>
    <br>

    <div class="col-12">
        <br>
        <p>Id: ${task.id}</p>
        <p>Title: ${task.title}</p>
        <p>Description: ${task.description}</p>
        <p>Status: ${task.status}</p>
        <p>Priority: ${task.priority}</p>
        <p>Hours: ${task.hours}</p>
        <p>Text: ${task.text}</p>
        <p>Tags:</p>
        <ul>
            <c:forEach var="tag" items="${task.tags}">
                <li>
                    <span style="background-color:${tag.color}"><c:out value="${tag.name}"/></span>
                </li>
            </c:forEach>
        </ul>
        <p>Comments:</p>
        <ul>
            <c:forEach var="comment" items="${task.comments}">
                <li>
                    <p><strong>${comment.username}</strong>  : ${comment.created}</p>
                    <p>${comment.comment}</p>
                </li>
            </c:forEach>
        </ul>

        <br>
        <form action="new-task-comment" method="post">
            <div class="input-group">
                <span class="input-group-text">Leave comment</span>
                <textarea class="form-control" name="comment" aria-label="With textarea"></textarea>
            </div>
            <input type="hidden" name="taskId" value="${task.id}">
            <br>
            <button type="submit" class="btn btn-primary">Add comment</button>
        </form>
    </div>
    <script>
        document.write('<a href="' + document.referrer + '">Go Back</a>');
    </script>
</div>
</body>
</html>
