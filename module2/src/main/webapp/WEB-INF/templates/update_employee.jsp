<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<jsp:include page="_header.jsp"/>
<h1>Update employee</h1>

<form method="post" action="/hibernate/update-employee.html?id=${employee.id}" enctype="multipart/form-data">
  <!-- firstName -->
   <div class="mb-3">
      <label for="firstName" class="form-label">First name</label>
      <input value="${employee.firstName}" type="text" name="firstName" class="form-control" id="firstName" aria-describedby="nameHelp" required>
      <div id="nameHelp" class="form-text">Enter first name</div>
   </div>
  <!-- lastName -->
  <div class="mb-3">
      <label for="lastName" class="form-label">Last Name</label>
      <input value="${employee.lastName}" type="text" name="lastName" class="form-control" id="lastName" aria-describedby="nameHelp" required>
      <div id="nameHelp" class="form-text">Enter last name</div>
  </div>
   <!-- birthDate -->
    <div class="mb-3">
     <label for="birthDate" class="form-label">Birth Date</label>
     <input value="${employee.birthDate}" type="text" name="birthDate" class="form-control" id="birthDate" aria-describedby="nameHelp" required>
     <div id="nameHelp" class="form-text">Enter birthdate </div>
    </div>
    <!-- cellPhone -->
    <div class="mb-3">
    <label for="cellPhone" class="form-label">Cell phone</label>
    <input value="${employee.cellPhone}" type="text" name="cellPhone" class="form-control" id="cellPhone" aria-describedby="nameHelp" pattern="^\+\d{12}\$" required>
    <div id="nameHelp" class="form-text">Enter cell phone</div>
    </div>

<div class="mb-3">
   <label for="department.id">update department:</label>
      <select class="form-select" id="department.id" name="department.id">
       <c:forEach items="${departments}" var="department">
       <c:if test="${department.id == employee.department.id}">
       <option selected="selected" value="${department.id}">${department.departmentName}</option>
       </c:if>
       <c:if test="${department.id != employee.department.id}">
       <option value="${department.id}">${department.departmentName}</option>
       </c:if>
       </c:forEach>
      </select>
</div>


<div class = "mb-3">
  <select multiple name="projectsList">
      <c:forEach items="${projects}" var="project">
       <option value="${project.id}">${project.projectName}</option>
      </c:forEach>
  </select>
  </div>

  <button type="submit" class="btn btn-primary">Submit</button>
</form>
<jsp:include page="_footer.jsp"/>