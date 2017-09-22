<%@ include file="common/header.jspf"%>
<%@ include file="common/nav.jspf"%>


<div class="container">
	<h1>Your Authors:</h1>
	<table class="table table-striped">
		<caption>Your Authors are:</caption>

		<thead>
			<tr>
				<th>First Name</th>
				<th>Last Name</th>
				<th>Gender</th>
				<th>Hire Date</th>
			</tr>
		</thead>

		<tbody>
			 <c:forEach items="${authors}" var="author">
				<tr>
					<td>${author.foreName}</td>
					<td>${author.surName}</td>
					<td>${author.gender}</td>
					<td>${author.hireDate}</td>
					 
					<td>
					 	<a type="button" class="btn btn-primary" 
								href="/update-product?id=${product.productID}">Edit</a>
							<a type="button" class="btn btn-warning" 
								href="/delete-product?id=${product.productID}">Delete</a>
								<a type="button" class="btn btn-warning" 
								href="/delete-product?id=${NOproduct.productID}">Fake Error</a>
					 			
						</td>
					
				</tr>
			</c:forEach> 
		</tbody>
	</table>
	
 	<div>
		<a type="button" class="btn btn-success" href="/add-author">Add</a>
	</div>
	 
</div>
<%@ include file="common/footer.jspf"%>