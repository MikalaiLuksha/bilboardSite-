<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.1/dist/css/bootstrap.min.css" rel="stylesheet"
      integrity="sha384-+0n0xVW2eSR5OomGNYDnhzAbDsOXxcvSN1TPprVMTNDbiYZCxYbOOl7+AMvyTG2x" crossorigin="anonymous">

<head>
    <nav class="navbar navbar-light" style="background-color: #f4ac63; height: 55px">

        <div class="row ">
            <div class="col-md-3 offset-md-3">
                <p>
                    <a class="btn btn-primary" href="/" role="button">Return</a>
                </p>
            </div>
        </div>
    </nav>
</head>

<body>
<form action="/createBoard" method="post">

    <div class="dropdown mt-2">
        <br><button class="btn btn-primary dropdown-toggle offset-sm-2" type="button" id="appl" data-toggle="dropdown">
        Performer  <span class="caret"></span>
    </button><br>
        <ul class="dropdown-menu">
            <li class="dropdown-input offset-sm-1"><label><input type="checkbox" name="userPerformer" value="-1"> All </label></li>
            <c:forEach items="${requestScope.userList}" var="user">
            <li class="dropdown-input offset-sm-1"><label><input type="checkbox" name="userPerformer" value="${user.id}">${user.firstName}  ${user.lastName} </label></li>
            </c:forEach>
        </ul>
    </div>

    <div class="form-group text-light">
        <label for="Task1" class="offset-sm-2">Task</label>
        <textarea class="form-control w-50 offset-sm-2" id="Task1" name="task" rows="3"></textarea>
    </div>

    <div class="mb-3">
    </div>
    <button type="submit" class="btn btn-primary offset-sm-2">Submit</button>
</form>


<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.1/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-gtEjrD/SeCtmISkJkNUaaKMoLD0//ElJ19smozuHV6z3Iehds+3Ulb9Bn9Plx0x4"
        crossorigin="anonymous">
</script>
<script>
    $('.dropdown-input').click(function(event){
        event.stopPropagation();
    });
</script>
<script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"
        integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj"
        crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js"
        integrity="sha384-Q6E9RHvbIyZFJoft+2mJbHaEWldlvI9IOYy5n3zV9zzTtmI3UksdQRVvoxMfooAo"
        crossorigin="anonymous"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"
        integrity="sha384-B4gt1jrGC7Jh4AgTPSdUtOBvfO8shuf57BaghqFfPlYxofvL8/KUEfYiJOMMV+rV"
        crossorigin="anonymous"></script>
</body>
</html>
