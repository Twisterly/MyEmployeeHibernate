<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<jsp:include page="_header.jsp"/>
<h1>Add project</h1>

<form method="post" action="/hibernate/add-project.html" enctype="multipart/form-data">
  <!-- projectName -->
  <div class="mb-3">
    <label for="projectName" class="form-label">Project Name</label>
    <input type="text" name="projectName" class="form-control" id="projectName" aria-describedby="nameHelp" required>
    <div id="nameHelp" class="form-text">Enter project name</div>
  </div>

  <button type="submit" class="btn btn-primary">Submit</button>
</form>
<jsp:include page="_footer.jsp"/>