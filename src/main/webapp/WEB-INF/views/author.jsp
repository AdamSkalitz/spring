<%@ include file="common/header.jspf"%>
<%@ include file="common/nav.jspf"%>


<div class="container">
    <form:form method="post" commandName="author">
    <form:hidden path="businessEntityID"/>
			<fieldset class="form-group">
			<form:label path="firstname">First Name</form:label>
				<form:input path="firstname" type="text" class="form-control" required="required"/>
				<form:errors path="firstname" cssClass="text-warning" />
				<form:label path="surname">Last Name</form:label>
				<form:input path="surname" type="text" class="form-control" required="required"/>
				<form:errors path="surname" cssClass="text-warning" />
				<form:label path="gender">Gender</form:label>
				<form:input path="gender" type="text" step="0.01" class="form-control" required="required"/>
				<form:errors path="gender" cssClass="text-warning" />
				<form:label path="hiredate">Hire Date</form:label>
				<form:input path="hiredate" type="text" step="0.01" class="form-control" required="required"/>
				<form:errors path="hiredate" cssClass="text-warning" />
			</fieldset>
			<button type="submit" class="btn btn-success">Add</button>
		</form:form>
    
	</div>

<%@ include file="common/footer.jspf"%>