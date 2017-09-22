<%@ include file="common/header.jspf"%>
<%@ include file="common/nav.jspf"%>


 <div class="container">
 	<h1>Your Books: ${user}</h1>
		<table class="table table-striped">
			<caption>Your Books are:</caption>

			<thead>
				<tr>
				<th>Title</th>
					<th>Description</th>
					<th>Price</th>
					<th></th>
				</tr>
			</thead>

			<tbody>
				<c:forEach items="${books}" var="book">
					<tr>
						<td>${book.title}</td>
						<td>${book.description}</td>
						<td>${book.price}</td>
						<td>
						<a type="button" class="btn btn-primary" 
								href="/update-book?id=${book.id}">Edit</a>
							<a type="button" class="btn btn-warning" 
								href="/delete-book?id=${book.id}">Delete</a>
								<a type="button" class="btn btn-warning" 
								href="/delete-book?id=${NObook.id}">Fake Error</a>
						</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
		<div>
 <a type="button" class="btn btn-success" href="/add-book">Add</a>
 </div>
 </div>
<%@ include file="common/footer.jspf"%>