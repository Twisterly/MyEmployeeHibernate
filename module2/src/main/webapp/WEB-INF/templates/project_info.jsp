<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<jsp:include page="_header.jsp"/>
<h1>Project</h1>

<table style="width:100%" class="table">
  <tr>
    <th>ID</th>
    <th>Project name</th>
    <th>Employees</th>
  </tr>
  <tr>
      <td>${project.id}</td>
      <td>${project.projectName}</td>
<td>
  <c:forEach items="${employees}" var="employee">
    <c:out value="${employee.firstName} ${employee.lastName}"/>
  </c:forEach>
</td>
   </tr>
</table>

<jsp:include page="_footer.jsp"/>