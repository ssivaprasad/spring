<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>

<html>
<head>
    <link href="/webjars/bootstrap/3.3.6/css/bootstrap.min.css" rel="stylesheet">
    <script src="/webjars/jquery/1.9.1/jquery.min.js"></script>
    <script src="/webjars/bootstrap/3.3.6/js/bootstrap.min.js"></script>
    <script src="/webjars/bootstrap-datepicker/1.0.1/js/bootstrap-datepicker.js"></script>
</head>
<body>
<div class="container">
    Displaying Posts by ${userId}.

    <table class="table table-striped">
        <thead>
        <tr>
            <th>Title</th>
            <th>Content</th>
            <th>Posted Date</th>
            <th>Action</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach items="${posts}" var="post">
            <tr>
                <td>${post.title}</td>
                <td>${post.content}</td>
                <td><fmt:formatDate value="${post.postedDate}" pattern="dd/MM/yyyy"/></td>
                <td>
                    <a type="button" class="btn btn-primary" href="/update-post?id=${post.id}">Update</a>
                    <a type="button" class="btn btn-danger" href="/delete-post?id=${post.id}">Delete</a>
                </td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
    <div>
        <a class="button" href="/add-post">Add Post</a>
    </div>
</div>
</body>
</html>
