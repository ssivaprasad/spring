<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>

<html>
<head>
    <link href="webjars/bootstrap/3.3.6/css/bootstrap.min.css" rel="stylesheet">
    <script src="webjars/jquery/1.9.1/jquery.min.js"></script>
    <script src="webjars/bootstrap/3.3.6/js/bootstrap.min.js"></script>
    <script src="webjars/bootstrap-datepicker/1.0.1/js/bootstrap-datepicker.js"></script>
</head>

<body>
<div class="container" style="margin-top: 30px">
    <form:form method="post" modelAttribute="post">
        <div>
            <div class="form-group">
                <form:label path="title" cssStyle="width: 100px">Title</form:label>
                <form:input path="title" type="text" name="title"/>
                <form:errors path="title" cssClass="text-danger"/>
            </div>
            <div class="form-group">
                <form:label path="content" cssStyle="width: 100px">Contenet</form:label>
                <form:input path="content" type="text" name="title"/>
                <form:errors path="content" cssClass="text-danger"/>
            </div>
            <button type="submit" class="btn btn-success">Submit</button>
        </div>
    </form:form>
</div>
</body>
</html>