<!doctype html>
<html lang="en">
  <head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Web shop demo</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-rbsA2VBKQhggwzxH7pPCaAqO46MgnOM80zW1RWuH61DGLwZJEdK2Kadq2F9CUG65" crossorigin="anonymous">
  </head>
  <body>

<nav class="navbar navbar-expand-lg bg-light">
  <div class="container-fluid">
    <a class="navbar-brand" href="#">HR-Manager</a>
    <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
      <span class="navbar-toggler-icon"></span>
    </button>
    <div class="collapse navbar-collapse" id="navbarSupportedContent">
      <ul class="navbar-nav me-auto mb-2 mb-lg-0">
        <li class="nav-item">
          <a class="nav-link active" aria-current="page" href="/hibernate/index.html">Home</a>
        </li>
        <li class="nav-item dropdown">
          <a class="nav-link dropdown-toggle" href="#" role="button" data-bs-toggle="dropdown" aria-expanded="false">
            Views
          </a>
          <ul class="dropdown-menu">
            <li><a class="dropdown-item" href="/hibernate/employee-list.html">Show employees</a></li>
            <li><a class="dropdown-item" href="/hibernate/department-list.html">Show departments</a></li>
            <li><a class="dropdown-item" href="/hibernate/project-list.html">Show projects</a></li>
          </ul>
        </li>
        <li class="nav-item dropdown">
          <a class="nav-link dropdown-toggle" href="#" role="button" data-bs-toggle="dropdown" aria-expanded="false">
            To add
          </a>
          <ul class="dropdown-menu">
            <li><a class="dropdown-item" href="/hibernate/add-department.html">Add department</a></li>
            <li><a class="dropdown-item" href="/hibernate/add-employee.html">Add employee</a></li>
            <li><a class="dropdown-item" href="/hibernate/add-project.html">Add project</a></li>
          </ul>
        </li>
    </div>
  </div>
</nav>
