<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-+0n0xVW2eSR5OomGNYDnhzAbDsOXxcvSN1TPprVMTNDbiYZCxYbOOl7+AMvyTG2x" crossorigin="anonymous">

<body>
   <form action="/reg" method="post" class= "offset-sm-1" >
        <div class="form-group text-light">
            <label for="firstName1" class="w-25 p-1">First Name </label>
            <input type="text" class="form-control w-25 p-1" id="firstName1" name="firstName">
        </div>
        <div class="form-group text-light">
            <label for="lastName2" class="w-25 p-1">Last Name</label>
            <input type="text" class="form-control w-25 p-1" id="lastName2" name="lastName">
        </div>
        <div class="form-group text-light">
            <label for="inputLogin1" class="w-25 p-1">login</label>
            <input type="text" name="login" class="form-control w-25 p-1" id="inputLogin1">
        </div>
        <div class="form-group text-light">
            <label for="exampleInputPassword1" class="w-25 p-1">Password</label>
            <input type="password" name="password" class="form-control w-25 p-1" id="exampleInputPassword1">
        </div>
       <div class="mb-3">
       </div>
        <button type="submit" class="btn btn-primary offset-sm-2">Submit</button>
   </form>

<style>
    body {
        background: url("https://i1.wallbox.ru/wallpapers/main/201134/2560h1600-tekstura-oboi-e710001.jpg")
    }
</style>

<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.1/dist/js/bootstrap.bundle.min.js" integrity="sha384-gtEjrD/SeCtmISkJkNUaaKMoLD0//ElJ19smozuHV6z3Iehds+3Ulb9Bn9Plx0x4" crossorigin="anonymous"></script>
</body>
</html>
