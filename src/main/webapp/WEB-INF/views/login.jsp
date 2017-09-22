<%@ include file="common/header.jspf"%>
<%@ include file="common/nav.jspf"%>

<div class="container">
	<p>
		<font color="red">${errorMessage}</font>
	</p>
	<form action="/login" method="POST">
		<fieldset class="form-group">
			<label>Name</label> <input name="user" type="text" class="form-control" autofocus/>
		</fieldset>
		<fieldset class="form-group">
			<label>Password</label> <input name="password" type="password" class="form-control" />
		</fieldset>
		<button type="submit" class="btn btn-success">Login</button>
	</form>

</div>


<%@ include file="common/footer.jspf"%>