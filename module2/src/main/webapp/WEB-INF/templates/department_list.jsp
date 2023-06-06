<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<jsp:include page="_header.jsp"/>
<h1>Departments</h1>

<table style="width:100%" class="table">
  <tr>
    <th>Name</th>
    <th></th>
  </tr>
  <c:forEach items="${departments}" var="department">
  <tr>
    <td><c:out value="${department.departmentName}"/></td>
    <td>
    <button type="button" class="btn btn-light">
    <a href="/hibernate/department-info.html?id=${department.id}">Open</a>
    </button>
    </td>
      <td>
       <button type="button" class="btn btn-light">
        <a href="/hibernate/update-department.html?id=${department.id}">Edit</a>
         </button>
     <td>
        <button type="button" class="btn btn-light">
        <a href="/hibernate/delete-department.html?id=${department.id}">Delete</a>
        </button>
        </td>
  </tr>
  </c:forEach>
</table>

<jsp:include page="_footer.jsp"/>