<%--
  Created by IntelliJ IDEA.
  User: antonkupreychik
  Date: 3.12.22
  Time: 14:26
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>New task</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
</head>
<body>
<div class="container">
    <br>
    <h1>New task</h1>
    <br>
    <form action="new-task" method="post">
        <div class="mb-3">
            <label for="taskName" class="form-label">Name</label>
            <input type="text" class="form-control" id="taskName" name="taskName">
        </div>

        <div class="mb-3">
            <label for="taskDescription" class="form-label">Description</label>
            <textarea class="form-control" id="taskDescription" name="taskDescription" rows="3"></textarea>
        </div>

        <div class="mb-3">
            <label for="taskStatus" class="form-label">Status</label>
            <select class="form-select" aria-label="Default select example" id="taskStatus" name="taskStatus">
                <c:forEach items="${statuses}" var="status">
                    <option value="${status.status}">${status.status}</option>
                </c:forEach>
            </select>
        </div>

        <div class="mb-3">
            <label for="taskPriority" class="form-label">Priority</label>
            <select class="form-select" aria-label="Default select example" id="taskPriority"
                    name="taskPriority">
                <c:forEach items="${priorities}" var="priority">
                    <option value="${priority.priority}">${priority.priority}</option>
                </c:forEach>
            </select>
        </div>

        <div class="mb-3">
            <label for="taskHours" class="form-label">Hours</label>
            <input type="number" class="form-control" id="taskHours" name="taskHours">
        </div>

        <div class="input-group">
            <span class="input-group-text">Write more information</span>
            <textarea class="form-control" name="taskText" aria-label="With textarea"></textarea>
        </div>

        <div class="mb-3">
            <label for="formFile" class="form-label">Add file</label>
            <input class="form-control" type="file" id="formFile">
        </div>

        <div class="mb-3">
            <label class="select-tags">Choose tags</label>
            <select multiple class="form-select" id="select-tags" aria-label="multiple select example" name="taskTags">
                <c:forEach items="${tags}" var="tag">
                    <option style="background-color: ${tag.color}" value="${tag.id}">${tag.name}</option>
                </c:forEach>
            </select>
        </div>

        <div class="mb-3">
            <button type="button" onclick="location.href='new-tag'" class="btn btn-primary">Add new tag</button>
        </div>

        <button type="submit" class="btn btn-primary">Submit</button>
    </form>
    <script>
        document.write('<a href="' + document.referrer + '">Go Back</a>');
    </script>
</div>

</body>
</html>
