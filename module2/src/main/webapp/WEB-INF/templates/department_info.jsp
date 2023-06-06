<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<jsp:include page="_header.jsp"/>
<h1>Department</h1>

<table style="width:100%" class="table">
  <tr>
    <th>ID</th>
    <th>Department name</th>
    <th>Employees</th>
  </tr>
  <tr>
      <td>${department.id}</td>
      <td>${department.departmentName}</td>
<td>
  <c:forEach items="${employees}" var="employee">
    <c:out value="${employee.firstName} ${employee.lastName}"/>
  </c:forEach>
</td>
   </tr>
</table>

<jsp:include page="_footer.jsp"/>