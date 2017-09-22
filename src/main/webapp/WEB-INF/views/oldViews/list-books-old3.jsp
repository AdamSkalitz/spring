<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<title>Books for author: ${user}</title>
<link href="webjars/bootstrap/3.3.6/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
<H1>Your Books: ${user}</H1>
 <div class="container">
		<table class="table table-striped">
			<caption>Your Books are</caption>

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
						</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>
	<div>
 <a type="button" class="btn btn-success" href="/add-book">Add</a>
 </div>
 <script src="webjars/jquery/1.9.1/jquery.min.js"></script>
    <script src="webjars/bootstrap/3.3.6/js/bootstrap.min.js"></script>
</body>
</html>