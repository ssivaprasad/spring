<%@ include file="common/header.jspf" %>
<%@ include file="common/navigation.jspf" %>

<div class="container">
    <table class="table table-striped">
        <caption>Your todos are</caption>
        <thead>
        <tr>
            <th>Description</th>
            <th>Target Date</th>
            <th>Is it Done?</th>
            <th>Action</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach items="${todos}" var="todo">
            <tr>
                <td>${todo.desc}</td>
                <td><fmt:formatDate value="${todo.targetDate}" pattern="dd/MM/yyyy"/></td>
                <td>${todo.done}</td>
                <td>
                    <a type="button" class="btn btn-primary" href="/update-todo?id=${todo.id}">Update</a>
                    <a type="button" class="btn btn-danger" href="/delete-todo?id=${todo.id}">Delete</a>
                </td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
    <div>
        <a class="button" href="/add-todo">Add a Todo</a>
    </div>
</div>