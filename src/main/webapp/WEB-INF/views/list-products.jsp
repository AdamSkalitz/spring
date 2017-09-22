<%@ include file="common/header.jspf"%>
<%@ include file="common/nav.jspf"%>


 <div class="container">
 	<h1>Your Products:</h1>
		<table class="table table-striped">
			<caption>Your Products are:</caption>

			<thead>
				<tr>
				<th>Name</th>
					<th>Colour</th>
					<th>List Price</th>
					<th></th>
				</tr>
			</thead>

			<tbody>
				<c:forEach items="${products}" var="product">
					<tr>
						<td>${product.name}</td>
						<td>${product.colour}</td>
						<td>${product.listPrice}</td>
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
 <a type="button" class="btn btn-success" href="/add-product">Add</a>
 </div>
 </div>
<%@ include file="common/footer.jspf"%>