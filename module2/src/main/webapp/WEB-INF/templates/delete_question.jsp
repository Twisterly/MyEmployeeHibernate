<jsp:include page="_header.jsp"/>
<h1>Are you sure?</h1>
<form method="post" action="/hibernate/delete-department.html">
<input name="id" id="id" value="${departmentId}" type="hidden">
  <button type="submit" class="btn btn-primary">YES</button>
</form>
<jsp:include page="_footer.jsp"/>