<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<jsp:include page="_header.jsp"/>
<h1>Employees</h1>

<table style="width:100%" class="table">
  <tr>
    <th>Id</th>
    <th>Name</th>
    <th>Birthdate</th>
    <th>Cell phone</th>
  </tr>
  <c:forEach items="${employees}" var="employee">
  <tr>
    <td><c:out value="${employee.id}"/></td>
    <td><c:out value="${employee.firstName} ${employee.lastName}"/></td>
    <td><c:out value="${employee.birthDate}"/></td>
    <td><c:out value="${employee.cellPhone}"/></td>
     <td>
        <button type="button" class="btn btn-light">
        <a href="/hibernate/employee-info.html?id=${employee.id}">Open</a>
        </button>
        </td>
    <td>
       <button type="button" class="btn btn-light">
       <a href="/hibernate/update-employee.html?id=${employee.id}">Edit</a>
       </button>
    </td>
     <td>
        <button type="button" class="btn btn-light">
        <a href="/hibernate/delete-employee.html?id=${employee.id}">Delete</a>
        </button>
      </td>
  </tr>
  </c:forEach>
</table>

<jsp:include page="_footer.jsp"/>