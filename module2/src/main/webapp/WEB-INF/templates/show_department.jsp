<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<jsp:include page="_header.jsp"/>
<h1>Department</h1>

<table style="width:100%" class="table">
  <tr>
    <th>Name</th>
    <th>Employees</th>
  </tr>
  <tr>
  <td><c:out value="${department.departmentName}"/></td>
  <c:forEach items="${employees}" var="employee">
    <td><c:out value="${employee.firstName} ${employee.lastName}"/></td>
  </c:forEach>
   </tr>
</table>

<jsp:include page="_footer.jsp"/>