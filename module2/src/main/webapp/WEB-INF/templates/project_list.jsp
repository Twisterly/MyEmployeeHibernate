<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<jsp:include page="_header.jsp"/>
<h1>Projects</h1>

<table style="width:100%" class="table">
  <tr>
    <th>Project name</th>
    <th></th>
    <th></th>
  </tr>
  <c:forEach items="${projects}" var="project">
  <tr>
    <td><c:out value="${project.projectName}"/></td>
    <td>
      <button type="button" class="btn btn-light">
      <a href="/hibernate/update-project.html?id=${project.id}">Update</a>
      </button>
    </td>
    <td>
     <button type="button" class="btn btn-light">
     <a href="/hibernate/delete-project.html?id=${project.id}">Delete</a>
     </button>
     </td>
   </tr>
  </c:forEach>

</table>

<jsp:include page="_footer.jsp"/>