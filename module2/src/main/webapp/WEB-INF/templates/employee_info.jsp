<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<jsp:include page="_header.jsp"/>
<h1>Employee</h1>

<table style="width:100%" class="table">
  <tr>
    <th>ID</th>
    <th>First name</th>
    <th>Last name</th>
    <th>Birth date</th>
    <th>Cell phone</th>
    <th>Department</th>
    <th>Projects</th>
  </tr>
  <tr>
      <td>${employee.id}</td>
      <td>${employee.firstName}</td>
      <td>${employee.lastName}</td>
      <td>${employee.birthDate}</td>
      <td>${employee.cellPhone}</td>
      <td>${employee.department.departmentName}</td>
<td>
  <c:forEach items="${projects}" var="project">
    <c:out value="${project.projectName}"/>
     <br>
  </c:forEach>
   </tr>
</table>

<jsp:include page="_footer.jsp"/>