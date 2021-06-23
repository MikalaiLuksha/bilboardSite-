<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.1/dist/css/bootstrap.min.css" rel="stylesheet"
      integrity="sha384-+0n0xVW2eSR5OomGNYDnhzAbDsOXxcvSN1TPprVMTNDbiYZCxYbOOl7+AMvyTG2x" crossorigin="anonymous">

<body>

<nav class="navbar navbar-light" style="background-color: #f4ac63; height: 55px">

        <div class="row ">
             <div class="col-md-3 offset-md-3">
                <p>
                    <a class="btn btn-primary" href="/" role="button">Return</a>
                </p>
            </div>
</nav>

<table class="table">
    <thead>
    <tr>
        <th scope="col">#</th>
        <th scope="col">id</th>
        <th scope="col">First Name</th>
        <th scope="col">Last Name</th>
        <th scope="col">Login</th>
        <th scope="col">Password</th>
        <th scope="col">Role</th>
    </tr>
    </thead>
    <tbody>
<c:forEach items="${requestScope.allUsers}" var="last" varStatus="сounter">
    <tr>
        <th scope="row">${сounter.count}</th>
    <td>${last.id}</td>
        <td>${last.firstName}</td>
    <td>${last.lastName}</td>
    <td>${last.login}</td>
    <td>${last.password}</td>
    <td>${last.role}</td>
    </tr>
</c:forEach>
    </tbody>
</table>

<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.1/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-gtEjrD/SeCtmISkJkNUaaKMoLD0//ElJ19smozuHV6z3Iehds+3Ulb9Bn9Plx0x4"
        crossorigin="anonymous"></script>
</body>
</html>
