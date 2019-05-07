
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>


<h1>Employees page</h1>

<ul>
	<c:forEach items="${employee}" var="employee">
		<div>
			<table border="1">
				<tr>
					<th>Id </th>
					<th>dept Name</th>
					<th>Name</th>
				</tr>
				<tr>
					<td>${employee.id}</td> 
					<td>${employee.dept}</td>
					<td>${employee.name}</td> 
				</tr>
	</c:forEach>
	</table>
	</div>
</ul>

