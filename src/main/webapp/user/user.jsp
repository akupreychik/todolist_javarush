<%--
  Created by IntelliJ IDEA.
  User: antonkupreychik
  Date: 3.12.22
  Time: 02:49
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
    <title>User Creating page</title>
</head>
<body>
<div class="container">
    <br>
    <p class="h2">Create new user!</p>
    <br>
    <form action="user-sign-up" method="post">
        <div class=" mb-3">
            <label for="exampleInputUsername" class="form-label">Username</label>
            <input name="username" type="text" class="form-control" id="exampleInputUsername" placeholder="Anton"
                   aria-label="Username"
                   aria-describedby="basic-addon1">
        </div>

        <div class="mb-3">
            <label for="exampleInputFirstName" class="form-label">First name</label>
            <input name="firstName" type="text" id="exampleInputFirstName" class="form-control" placeholder="Anton"
                   aria-label="First name"
                   aria-describedby="basic-addon1">
        </div>

        <div class="mb-3">
            <label for="exampleInputLastName" class="form-label">Last name</label>
            <input name=lastName type="text" id="exampleInputLastName" class="form-control" placeholder="Kupreychik"
                   aria-label="Last name"
                   aria-describedby="basic-addon1">
        </div>

        <div class="mb-3">
            <label for="exampleInputEmail1" class="form-label">Email address</label>
            <input name="email" type="email" class="form-control" id="exampleInputEmail1" aria-describedby="emailHelp">
            <div id="emailHelp" class="form-text">We'll never share your email with anyone else.</div>
        </div>
        <div class="mb-3">
            <label for="exampleInputPassword1" class="form-label">Password</label>
            <input name="password" type="password" class="form-control" id="exampleInputPassword1">
        </div>

        <button type="submit" class="btn btn-primary">Submit</button>
    </form>
    <script>
        document.write('<a href="' + document.referrer + '">Go Back</a>');
    </script>

</div>
</body>
</html>
