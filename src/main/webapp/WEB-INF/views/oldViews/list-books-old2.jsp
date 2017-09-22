<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<title>Books for author: ${user}</title>
</head>
<body>
<H1>Your Books: ${user}</H1>
 <div>
		<table>
			<caption>Your Books are</caption>

			<thead>
				<tr>
				<th>Title</th>
					<th>Description</th>
					<th>Price</th>
				</tr>
			</thead>

			<tbody>
				<c:forEach items="${books}" var="book">
					<tr>
						<td>${book.title}</td>
						<td>${book.description}</td>
						<td>${book.price}</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>
 <a class="button" href="/add-book">Add</a>
</body>
</html>