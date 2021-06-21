<html>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-+0n0xVW2eSR5OomGNYDnhzAbDsOXxcvSN1TPprVMTNDbiYZCxYbOOl7+AMvyTG2x" crossorigin="anonymous">

<body>

<p>
      <button class="btn btn-primary" type="button" data-bs-toggle="collapse" data-bs-target="#collapseExample" aria-expanded="false" aria-controls="collapseExample">
        Enter or Registration
    </button>
</p>
<div class="collapse" id="collapseExample">
    <div class="card card-body">
        <form class="px-4 py-3" action="/auth" method="post">
            <div class="mb-3">
                <label for="exampleDropdownFormLogin" class="form-label">Login</label>
                <input type="text" name="login" class="form-control w-25 p-1" id="exampleDropdownFormLogin" placeholder="Login">
            </div>
            <div class="mb-3">
                <label for="exampleDropdownFormPassword1" class="form-label">Password</label>
                <input type="password" name="password" class="form-control w-25 p-1" id="exampleDropdownFormPassword1" placeholder="Password">
            </div>
            <div class="mb-3">
            </div>
            <button type="submit" class="btn btn-primary">Sign in</button>
        </form>
        <div class="dropdown-divider"></div>
        <a class="dropdown-item" href="/reg">Registration</a>
        <a class="dropdown-item" href="#">Forgot password?</a>
    </div>
</div>


</div>




<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.1/dist/js/bootstrap.bundle.min.js" integrity="sha384-gtEjrD/SeCtmISkJkNUaaKMoLD0//ElJ19smozuHV6z3Iehds+3Ulb9Bn9Plx0x4" crossorigin="anonymous"></script>
</body>
</html>


