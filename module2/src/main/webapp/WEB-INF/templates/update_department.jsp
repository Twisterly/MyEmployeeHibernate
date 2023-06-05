<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<jsp:include page="_header.jsp"/>
<h1>Update department</h1>

<form method="post" action="/hibernate/update-department.html?id=${department.id}" enctype="multipart/form-data">
  <!-- departmentName -->
   <div class="mb-3">
      <label for="departmentName" class="form-label">Department name</label>
      <input value="${department.departmentName}" type="text" name="departmentName" class="form-control" id="departmentName" aria-describedby="nameHelp">
      <div id="nameHelp" class="form-text">Enter department name</div>
   </div>

  <button type="submit" class="btn btn-primary">Submit</button>
</form>
<jsp:include page="_footer.jsp"/>