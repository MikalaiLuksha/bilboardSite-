<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<html>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.1/dist/css/bootstrap.min.css" rel="stylesheet"
      integrity="sha384-+0n0xVW2eSR5OomGNYDnhzAbDsOXxcvSN1TPprVMTNDbiYZCxYbOOl7+AMvyTG2x" crossorigin="anonymous">

<body>
<nav class="navbar navbar-light" style="background-color: #f4ac63; height: 55px">
    <form class="container-fluid justify-content-start">
        <div class="row">
            <div class="col pr-5">
                <p>
                    <button class="btn btn-primary" type="button" data-bs-toggle="collapse"
                            data-bs-target="#collapseExample" aria-expanded="false" aria-controls="collapseExample"
                            style="width: 220px">
                        <c:if test="${!requestScope.key1}">
                            Enter or Registration
                        </c:if>
                        <c:if test="${requestScope.key1}">
                            ${sessionScope.currentUser.firstName}
                        </c:if>
                    </button>
                </p>
            </div>

            <c:if test="${sessionScope.admin}">
            <div class="col pr-5">
                <p>
                    <a class="btn btn-primary" href="/userList" role="button">Users List</a>
                </p>
            </div>
            <div class="col pr-5">
                <p>
                    <a class="btn btn-primary" href="/createBoard" role="button" style="width: 220px">Create board</a>
                </p>
            </div>
            </c:if>

    </form>
</nav>
<div class="collapse" id="collapseExample">
    <div class="card card-body">
        <c:if test="${!requestScope.key1}">
            <form class="px-4 py-3" action="/auth" method="post">
                <div class="mb-3">
                    <label for="exampleDropdownFormLogin" class="form-label">Login</label>
                    <input type="text" name="login" class="form-control w-25 p-1" id="exampleDropdownFormLogin"
                           placeholder="Login">
                </div>
                <div class="mb-3">
                    <label for="exampleDropdownFormPassword1" class="form-label">Password</label>
                    <input type="password" name="password" class="form-control w-25 p-1"
                           id="exampleDropdownFormPassword1" placeholder="Password">
                </div>
                <div class="mb-3">
                </div>
                <button type="submit" class="btn btn-primary">Sign in</button>
            </form>
            <div class="dropdown-divider"></div>
            <a class="dropdown-item" href="/reg">Registration</a>
            <a class="dropdown-item" href="#">Forgot password?</a>
        </c:if>
        <c:if test="${requestScope.key1}">
            <a class="dropdown-item" href="/profiles">Profiles</a>
            <a class="dropdown-item" href="/logout">Logout</a>
        </c:if>
    </div>
</div>


<c:if test="${sessionScope.check}">
    <div class="card">
        <div class="card-body">
                ${sessionScope.checkAuth}
        </div>
    </div>
</c:if>

<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.1/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-gtEjrD/SeCtmISkJkNUaaKMoLD0//ElJ19smozuHV6z3Iehds+3Ulb9Bn9Plx0x4"
        crossorigin="anonymous"></script>
</body>
</html>


