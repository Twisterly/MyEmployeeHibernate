<jsp:include page="_header.jsp"/>
<h1>Are you sure?</h1>
<form method="post" action="/hibernate/delete-employee.html">
<input name="id" id="id" value="${employeeId}" type="hidden">
  <button type="submit" class="btn btn-primary">YES</button>
</form>
<jsp:include page="_footer.jsp"/>