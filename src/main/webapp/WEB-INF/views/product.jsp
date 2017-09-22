<%@ include file="common/header.jspf"%>
<%@ include file="common/nav.jspf"%>


<div class="container">
    <form:form method="post" commandName="product">
    <form:hidden path="productID"/>
			<fieldset class="form-group">
			<form:label path="name">Name</form:label>
				<form:input path="name" type="text" class="form-control" required="required"/>
				<form:errors path="name" cssClass="text-warning" />
				<form:label path="colour">Colour</form:label>
				<form:input path="colour" type="text" class="form-control" required="required"/>
				<form:errors path="colour" cssClass="text-warning" />
				<form:label path="listPrice">List Price</form:label>
				<form:input path="listPrice" type="number" step="0.01" class="form-control" required="required"/>
				<form:errors path="listPrice" cssClass="text-warning" />
			</fieldset>
			<button type="submit" class="btn btn-success">Add</button>
		</form:form>
    
	</div>

<%@ include file="common/footer.jspf"%>