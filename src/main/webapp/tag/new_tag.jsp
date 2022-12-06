<%--
  Created by IntelliJ IDEA.
  User: antonkupreychik
  Date: 3.12.22
  Time: 16:01
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Add new tag</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
</head>
<body>
<div class="container">
    <br>
    <h1>Add new tag</h1>
    <form action="new-tag" method="post">
        <div class="form-group">
            <label for="tagName" class="form-label">Tag name</label>
            <input type="text" class="form-control" id="tagName" name="tagName" placeholder="Enter tag name">
            <br>
            <label class="form-label" for="favcolor">Select your color:</label>
            <br>
            <input type="color" id="favcolor" name="favcolor" value="#ff0000">

            <br>
            <br>
            <button type="submit" class="btn btn-success">Submit</button>
        </div>
    </form>
    <button type="button" class="btn btn-primary" onclick="location.href='table-tag'">All tags</button>
    <script>
        document.write('<a href="' + document.referrer + '">Go Back</a>');
    </script>
</div>
</body>
</html>
