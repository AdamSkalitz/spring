<%@ include file="common/header.jspf"%>
<%@ include file="common/nav.jspf"%>


<div class="container">
    <form:form method="post" commandName="book">
    <form:hidden path="id"/>
			<fieldset class="form-group">
			<form:label path="title">Title</form:label>
				<form:input path="title" type="text" class="form-control" required="required"/>
				<form:errors path="title" cssClass="text-warning" />
				<form:label path="description">Description</form:label>
				<form:input path="description" type="text" class="form-control" required="required"/>
				<form:errors path="description" cssClass="text-warning" />
				<form:label path="price">Price</form:label>
				<form:input path="price" type="number" step="0.01" class="form-control" required="required"/>
				<form:errors path="price" cssClass="text-warning" />
			</fieldset>
			<button type="submit" class="btn btn-success">Add</button>
		</form:form>
    
	</div>

<%@ include file="common/footer.jspf"%>